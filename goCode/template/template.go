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

	// Parse the template file
	tmpl, err := template.ParseFiles(templatePath)
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
