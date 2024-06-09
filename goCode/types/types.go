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
	ModelName             string
	Columns               []Column
	PrimaryKey            []Column
}

// Table represents a SQL table
type Table struct {
	Name        string
	Description string
	PrimaryKey  []Column
	Columns     []Column
}

// Column represents a column in a SQL table
type Column struct {
	Name          string
	UpperCaseName string
	LowerCaseName string
	Type          string
}

// Config holds the configuration data to be read from the external file
type Config struct {
	Domain      string `json:"domain"`
	BasePackage string `json:"basePackage"`
	TableName   string `json:"tableName"`
	Description string `json:"description"`
}
