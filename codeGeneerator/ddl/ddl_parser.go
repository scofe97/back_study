package ddl

import (
	"bufio"
	"os"
	"strings"
)

// Table represents a SQL table
type Table struct {
	Name    string
	Columns []Column
}

// Column represents a column in a SQL table
type Column struct {
	Name string
	Type string
}

// ParseDDLFile reads a SQL DDL file and returns a Table struct
func ParseDDLFile(filePath string) (Table, error) {
	file, err := os.Open(filePath)
	if err != nil {
		return Table{}, err
	}
	defer file.Close()

	var ddlLines []string
	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		ddlLines = append(ddlLines, scanner.Text())
	}
	if err := scanner.Err(); err != nil {
		return Table{}, err
	}
	ddl := strings.Join(ddlLines, "\n")

	// DDL 파싱
	return ParseDDL(ddl), nil
}

// ParseDDL parses a SQL DDL string and returns a Table struct
func ParseDDL(ddl string) Table {
	lines := strings.Split(ddl, "\n")
	var table Table
	for _, line := range lines {
		line = strings.TrimSpace(line)
		if strings.HasPrefix(line, "CREATE TABLE") {
			table.Name = strings.Fields(line)[2]
		} else if strings.HasPrefix(line, "(") || strings.HasPrefix(line, ");") || line == "" {
			continue
		} else {
			parts := strings.Fields(line)
			column := Column{
				Name: toCamelCase(strings.TrimRight(parts[0], ",")),
				Type: mapType(parts[1]),
			}
			table.Columns = append(table.Columns, column)
		}
	}
	return table
}

// mapType maps SQL types to Java types
func mapType(sqlType string) string {
	switch strings.ToLower(sqlType) {
	case "int":
		return "Integer"
	case "varchar", "char":
		return "String"
	case "datetime":
		return "LocalDateTime"
	default:
		return "String"
	}
}

// toCamelCase converts snake_case to camelCase
func toCamelCase(s string) string {
	s = strings.ToLower(s)
	parts := strings.Split(s, "_")
	for i := 1; i < len(parts); i++ {
		parts[i] = strings.Title(parts[i])
	}
	return strings.Join(parts, "")
}
