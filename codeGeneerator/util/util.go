package util

import "strings"

// LowerCaseFirstLetter converts the first letter of a string to lowercase
func LowerCaseFirstLetter(s string) string {
	if len(s) == 0 {
		return s
	}
	return string(s[0]|0x20) + s[1:]
}

// ToCamelCase converts snake_case to CamelCase
func ToCamelCase(s string) string {
	s = strings.ToLower(s)
	parts := strings.Split(s, "_")
	for i := 0; i < len(parts); i++ {
		parts[i] = strings.Title(parts[i])
	}
	return strings.Join(parts, "")
}
