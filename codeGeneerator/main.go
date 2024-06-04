package main

import (
	"encoding/json"
	"fmt"
	"os"

	"codeGenerator/config"
	"codeGenerator/ddl"
	"codeGenerator/template"
	"codeGenerator/util"
)

func main() {
	// 외부에서 입력받을 Config 파일 경로
	configFilePath := "config.json"

	// Config 파일 읽기
	file, err := os.Open(configFilePath)
	if err != nil {
		fmt.Println("Error opening config file:", err)
		return
	}
	defer file.Close()

	var configData config.Config
	decoder := json.NewDecoder(file)
	if err := decoder.Decode(&configData); err != nil {
		fmt.Println("Error decoding config:", err)
		return
	}

	// SQL DDL 파일 경로
	ddlFilePath := "table.sql"

	// SQL DDL 파싱 및 데이터 준비
	table, err := ddl.ParseDDLFile(ddlFilePath)
	if err != nil {
		fmt.Println("Error parsing DDL file:", err)
		return
	}

	// Define the minimal data to replace in the template
	basePackage := configData.BasePackage
	domain := configData.Domain
	generatorApplicationPackage := basePackage + "application." + domain
	generatorDomainPackage := basePackage + "domain." + domain
	generatorInfrastructurePackage := basePackage + "infrastructure.persistence"

	data := template.TemplateData{
		PackageName:           basePackage,
		ApplicationPackage:    generatorApplicationPackage,
		DomainPackage:         generatorDomainPackage,
		InfrastructurePackage: generatorInfrastructurePackage,
		Table:                 configData.TableName,
		DomainUpperCase:       domain,
		DomainLowerCase:       util.LowerCaseFirstLetter(domain),
		Description:           configData.Description,
		ModelName:             util.ToCamelCase(domain),
		Columns:               table.Columns,
	}

	// Define the templates and corresponding output paths
	files := map[string]string{
		"./template/application/CommandControllerTemplate.java.tmpl": generatorApplicationPackage + "/controller/" + data.DomainUpperCase + "CommandController.java",
		"./template/application/QueryControllerTemplate.java.tmpl":   generatorApplicationPackage + "/controller/" + data.DomainUpperCase + "QueryController.java",
		"./template/application/CreateRequestTemplate.java.tmpl":     generatorApplicationPackage + "/dto/request/" + data.DomainUpperCase + "CreateRequest.java",
		"./template/application/SelectRequestTemplate.java.tmpl":     generatorApplicationPackage + "/dto/request/" + data.DomainUpperCase + "SelectRequest.java",
		"./template/application/UpdateRequestTemplate.java.tmpl":     generatorApplicationPackage + "/dto/request/" + data.DomainUpperCase + "UpdateRequest.java",
		"./template/application/ResponseTemplate.java.tmpl":          generatorApplicationPackage + "/dto/response/" + data.DomainUpperCase + "Response.java",
		"./template/infrastructure/QueryMapperTemplate.java.tmpl":    generatorInfrastructurePackage + "/mapper/" + data.ModelName + "QueryMapper.java",
		"./template/infrastructure/CommandMapperTemplate.java.tmpl":  generatorInfrastructurePackage + "/mapper/" + data.ModelName + "CommandMapper.java",
		"./template/infrastructure/QueryServiceTemplate.java.tmpl":   generatorInfrastructurePackage + "/dao/" + data.ModelName + "QueryService.java",
		"./template/infrastructure/CommandServiceTemplate.java.tmpl": generatorInfrastructurePackage + "/dao/" + data.ModelName + "CommandService.java",
		"./template/domain/CommandServiceImplTemplate.java.tmpl":     generatorDomainPackage + "/impl/" + data.DomainUpperCase + "CommandServiceImpl.java",
		"./template/domain/QueryServiceImplTemplate.java.tmpl":       generatorDomainPackage + "/impl/" + data.DomainUpperCase + "QueryServiceImpl.java",
		"./template/domain/CommandServiceTemplate.java.tmpl":         generatorDomainPackage + "/" + data.DomainUpperCase + "CommandService.java",
		"./template/domain/QueryServiceTemplate.java.tmpl":           generatorDomainPackage + "/" + data.DomainUpperCase + "QueryService.java",
	}

	// Create each file from the corresponding template
	for templatePath, outputPath := range files {
		err := template.CreateFileFromTemplate(templatePath, outputPath, data)
		if err != nil {
			fmt.Println("Error creating file:", err)
		} else {
			fmt.Println("File created successfully:", outputPath)
		}
	}
}
