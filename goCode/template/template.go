package template

import (
	"codeGenerator/types"
	"os"
	"path/filepath"
	"text/template"
)

// CreateFileFromTemplate generates a file from a template with provided data
func CreateFileFromTemplate(templatePath, outputPath string, data types.TemplateData) error {
	// Ensure the directory exists
	dir := filepath.Dir(outputPath)
	err := os.MkdirAll(dir, os.ModePerm)
	if err != nil {
		return err
	}

	funcMap := template.FuncMap{
		"lastIndex":               lastIndex,
		"lastPrimaryKeyIndex":     lastPrimaryKeyIndex,
		"firstPrimaryKeyIndex":    firstPrimaryKeyIndex,
		"firstNonPrimaryKeyIndex": firstNonPrimaryKeyIndex,
		"lastNonPrimaryKeyIndex":  lastNonPrimaryKeyIndex,
		"len":                     func(slice []types.Column) int { return len(slice) },
	}

	// Parse the template file
	tmpl, err := template.New(filepath.Base(templatePath)).Funcs(funcMap).ParseFiles(templatePath)
	if err != nil {
		return err
	}

	// Create the output file
	outputFile, err := os.Create(outputPath)
	if err != nil {
		return err
	}
	defer outputFile.Close()

	// Execute the template with the provided data
	err = tmpl.Execute(outputFile, data)
	if err != nil {
		return err
	}

	return nil
}

// lastIndex returns the last index of a slice
func lastIndex(slice []types.Column) int {
	return len(slice) - 1
}

func lastPrimaryKeyIndex(columns []types.Column) int {
	lastIndex := -1
	for i, col := range columns {
		if col.IsPrimaryKey {
			lastIndex = i
		}
	}
	return lastIndex
}

func firstPrimaryKeyIndex(columns []types.Column) int {
	firstIndex := -1
	for i, col := range columns {
		if col.IsPrimaryKey {
			if firstIndex == -1 {
				firstIndex = i
			}
		}
	}
	return firstIndex
}

func firstNonPrimaryKeyIndex(columns []types.Column) int {
	for i, col := range columns {
		if !col.IsPrimaryKey {
			return i
		}
	}
	return -1 // No non-primary key found
}

func lastNonPrimaryKeyIndex(columns []types.Column) int {
	lastIndex := -1
	for i, col := range columns {
		if !col.IsPrimaryKey {
			lastIndex = i
		}
	}
	return lastIndex
}
