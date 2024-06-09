package ddl

import (
	"bufio"
	"os"
	"strings"

	"codeGenerator/types"
	"codeGenerator/util"
)

// ParseDDLFile SQL 파일을 읽어서 Table 구조체를 반환합니다.
func ParseDDLFile(filePath string) (types.Table, error) {
	// 파일 read
	file, err := os.Open(filePath)
	if err != nil {
		return types.Table{}, err
	}
	defer file.Close()

	// 파일 읽기(Line 단위)
	var ddlLines []string
	scanner := bufio.NewScanner(file)

	for scanner.Scan() {
		ddlLines = append(ddlLines, scanner.Text())
	}

	if err := scanner.Err(); err != nil {
		return types.Table{}, err
	}
	ddl := strings.Join(ddlLines, "\n")

	// DDL 파싱
	return ParseDDL(ddl), nil
}

// ParseDDL SQL의 문자열을 읽어서 테이블 구조체를 반환합니다.
func ParseDDL(ddl string) types.Table {

	// 줄바꿈을 기준으로 배열생성
	lines := strings.Split(ddl, "\n")

	// Table 생성
	var table types.Table
	for _, line := range lines {
		line = strings.TrimSpace(line) // 양 끝의 공백제거

		if strings.HasPrefix(line, "create table") {
			// CREATE TABLE이 있는 경우, table.name 초기화
			table.Name = strings.Fields(line)[2]

		} else if strings.HasPrefix(line, "comment") {
			// comment가 있는 경우 테이블의 한글이름으로 판단한다.
			table.Description = strings.Trim(strings.Split(line, "")[1], "")

		} else if strings.HasPrefix(line, "PRIMARY KEY") {
			// PRIMARY KEY가 있는경우 PK값이라고 판단한다.
			primaryKeyLine := strings.Trim(strings.Split(line, "(")[1], ")")
			primaryKeys := strings.Split(primaryKeyLine, ",")
			for _, key := range primaryKeys {
				columnName := strings.TrimSpace(key)
				column := types.Column{
					Name:          columnName,
					LowerCaseName: util.LowerCaseFirstLetter(util.ToCamelCase(columnName)),
					UpperCaseName: util.UpperCaseFirstLetter(util.ToCamelCase(columnName)),
				}
				table.PrimaryKey = append(table.PrimaryKey, column)
			}

		} else if strings.HasPrefix(line, "(") || strings.HasPrefix(line, ")") || line == "" {
			// "(", ")", ""의 경우 넘어간다.
			continue

		} else {
			// 공백기준 분리
			// parts = ["COMPN_SN", "int", "not", "null", "comment", "'콤포넌트일련번호'", "primary", "key,"]
			parts := strings.Fields(line)
			columnName := strings.TrimRight(parts[0], ",")

			// 컬럼 이름 추출
			column := types.Column{
				Name:          columnName,
				UpperCaseName: util.UpperCaseFirstLetter(util.ToCamelCase(columnName)),
				LowerCaseName: util.LowerCaseFirstLetter(util.ToCamelCase(columnName)),
				Type:          mapType(parts[1]),
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
