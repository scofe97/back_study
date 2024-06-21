package types

type TemplateData struct {
	PackageName           string
	ApplicationPackage    string
	DomainPackage         string
	InfrastructurePackage string
	Table                 string
	DomainUpperCase       string
	DomainLowerCase       string
	Description           string
	ModelUpperCase        string
	ModelLowerCase        string
	Columns               []Column
}

type Table struct {
	Name        string
	Description string
	Columns     []Column
}

type Column struct {
	Name          string
	UpperCaseName string
	LowerCaseName string
	Type          string
	Comment       string
	IsPrimaryKey  bool
	IsDefault     bool
	IsNull        bool
}

// Config holds the configuration data to be read from the external file
type Config struct {
	Domain      string `json:"domain"`
	BasePackage string `json:"basePackage"`
	TableName   string `json:"tableName"`
	Description string `json:"description"`
}
