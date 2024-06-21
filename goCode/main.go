package main

import (
	"encoding/json"
	"fmt"
	"os"

	"codeGenerator/ddl"
	"codeGenerator/template"
	"codeGenerator/types"
	"codeGenerator/util"
)

func main() {
	// 외부에서 입력받을 Config 파일 경로
	configFilePath := "data.json"

	// Config 파일 읽기
	file, err := os.Open(configFilePath)
	if err != nil {
		fmt.Println("Error opening config file:", err)
		return
	}
	defer file.Close()

	var configData types.Config
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
	lowerDomain := util.LowerCaseFirstLetter(domain)
	generatorApplicationPackage := basePackage + ".application." + lowerDomain
	generatorDomainPackage := basePackage + ".domain." + lowerDomain
	generatorInfrastructurePackage := basePackage + ".infrastructure.persistence"

	createPackage := "generator"
	createApplicationPackage := createPackage + "/application/" + lowerDomain
	createDomainPackage := createPackage + "/domain/" + lowerDomain
	createInfrastructurePackage := createPackage + "/infrastructure/persistence"
	createMapperPackage := createPackage + "/mapper"

	data := types.TemplateData{
		PackageName:           basePackage,
		ApplicationPackage:    generatorApplicationPackage,
		DomainPackage:         generatorDomainPackage,
		InfrastructurePackage: generatorInfrastructurePackage,
		Table:                 table.Name,
		DomainUpperCase:       domain,
		DomainLowerCase:       lowerDomain,
		Description:           table.Description,
		ModelUpperCase:        util.UpperCaseFirstLetter(util.ToCamelCase(table.Name)),
		ModelLowerCase:        util.LowerCaseFirstLetter(util.ToCamelCase(table.Name)),
		Columns:               table.Columns,
	}

	// Define the templates and corresponding output paths
	files := map[string]string{
		// application
		"./template/application/CommandControllerTemplate.java.tmpl": createApplicationPackage + "/controller/" + data.DomainUpperCase + "CommandController.java",
		"./template/application/QueryControllerTemplate.java.tmpl":   createApplicationPackage + "/controller/" + data.DomainUpperCase + "QueryController.java",
		"./template/application/CreateRequestTemplate.java.tmpl":     createApplicationPackage + "/dto/request/" + data.DomainUpperCase + "CreateRequest.java",
		"./template/application/SelectRequestTemplate.java.tmpl":     createApplicationPackage + "/dto/request/" + data.DomainUpperCase + "SelectRequest.java",
		"./template/application/UpdateRequestTemplate.java.tmpl":     createApplicationPackage + "/dto/request/" + data.DomainUpperCase + "UpdateRequest.java",
		"./template/application/ResponseTemplate.java.tmpl":          createApplicationPackage + "/dto/response/" + data.DomainUpperCase + "Response.java",

		// Domain
		"./template/domain/CommandServiceImplTemplate.java.tmpl": createDomainPackage + "/impl/" + data.DomainUpperCase + "CommandServiceImpl.java",
		"./template/domain/QueryServiceImplTemplate.java.tmpl":   createDomainPackage + "/impl/" + data.DomainUpperCase + "QueryServiceImpl.java",
		"./template/domain/CommandServiceTemplate.java.tmpl":     createDomainPackage + "/" + data.DomainUpperCase + "CommandService.java",
		"./template/domain/QueryServiceTemplate.java.tmpl":       createDomainPackage + "/" + data.DomainUpperCase + "QueryService.java",

		// infrastructure
		"./template/infrastructure/QueryMapperTemplate.java.tmpl":    createInfrastructurePackage + "/mapper/" + data.ModelUpperCase + "QueryMapper.java",
		"./template/infrastructure/CommandMapperTemplate.java.tmpl":  createInfrastructurePackage + "/mapper/" + data.ModelUpperCase + "CommandMapper.java",
		"./template/infrastructure/QueryServiceTemplate.java.tmpl":   createInfrastructurePackage + "/dao/" + data.ModelUpperCase + "QueryService.java",
		"./template/infrastructure/CommandServiceTemplate.java.tmpl": createInfrastructurePackage + "/dao/" + data.ModelUpperCase + "CommandService.java",
		"./template/infrastructure/ModelTemplate.java.tmpl":          createInfrastructurePackage + "/model/" + data.ModelUpperCase + ".java",

		// mapper
		"./template/mapper/QueryMapperTemplate.xml.tmpl":   createMapperPackage + "/" + data.ModelUpperCase + "QueryMapper.xml",
		"./template/mapper/CommandMapperTemplate.xml.tmpl": createMapperPackage + "/" + data.ModelUpperCase + "CommandMapper.xml",
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
