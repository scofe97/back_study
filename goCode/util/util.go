package util

import "strings"

func UpperCaseFirstLetter(s string) string {
	if len(s) == 0 {
		return s
	}
	return string(s[0]&^0x20) + s[1:]
}

func LowerCaseFirstLetter(s string) string {
	if len(s) == 0 {
		return s
	}
	return string(s[0]|0x20) + s[1:]
}

func ToCamelCase(s string) string {
	s = strings.ToLower(s)
	parts := strings.Split(s, "_")
	for i := 0; i < len(parts); i++ {
		parts[i] = strings.Title(parts[i])
	}
	return strings.Join(parts, "")
}
