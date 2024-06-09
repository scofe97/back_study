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
		"lastIndex":       lastIndex,
		"primaryKeyCount": primaryKeyCount,
		"len":             func(slice []types.Column) int { return len(slice) },
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

// primaryKeyCount returns the count of primary keys in a slice
func primaryKeyCount(columns []types.Column) int {
	count := 0
	for _, col := range columns {
		if col.IsPrimaryKey {
			count++
		}
	}
	return count - 1
}
