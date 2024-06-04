package config

// Config holds the configuration data to be read from the external file
type Config struct {
	Domain      string `json:"domain"`
	BasePackage string `json:"basePackage"`
	TableName   string `json:"tableName"`
	Description string `json:"description"`
}
