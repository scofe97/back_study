package lang.string;

import java.util.Arrays;

public class StringMethod {

    public static void main(String[] args) {
        String str = "Hello World";
        String anotherStr = "hello world";
        String emptyStr = "";
        String whitespaceStr = "   ";

        // 문자열 정보 조회
        System.out.println("Length " + str.length());
        System.out.println("isEmpty " + emptyStr.isEmpty());
        System.out.println("isBlank " + whitespaceStr.isBlank()); // java 11
        System.out.println("charAt " + str.charAt(1));


        // 문자열 비교
        System.out.println("equals " + str.equals(anotherStr));
        System.out.println("equalsIgnoreCase " + str.equalsIgnoreCase(anotherStr));
        System.out.println("compareTo " + str.compareTo(anotherStr));
        System.out.println("compareToIgnoreCase " + str.compareToIgnoreCase(anotherStr));
        System.out.println("startWith " + str.startsWith("Hell"));
        System.out.println("endsWith " + str.endsWith("orld"));


        // 문자열 검색
        System.out.println("contains " + str.contains("World"));
        System.out.println("indexOf " + str.indexOf("o"));
        System.out.println("lastIndexOf " + str.lastIndexOf("o"));


        // 문자열 조작 및 변환
        System.out.println("substring " + str.substring(6));
        System.out.println("concat " + str.concat(" Again"));
        System.out.println("replace " + str.replace("World", "Java"));
        System.out.println("replaceAll " + str.replaceAll("o", "O"));
        System.out.println("replaceFirst" + str.replaceAll("o", "O"));
        System.out.println("toLowerCase " + str.toLowerCase());
        System.out.println("toUpperCase " + str.toUpperCase());
        System.out.println("trim " + whitespaceStr.trim());
        System.out.println("strip " + whitespaceStr.strip()); // java 11


        // 문자열 분할 및 조합
        String[] parts = str.split(" ");
        for (String part : parts) {
            System.out.println("split " + part);
        }
        System.out.println("join " + String.join("-", "2024", "03", "31"));
        System.out.println("join " + String.join(" ", parts));


        // 기타 유틸리티
        System.out.println("valueOf " + String.valueOf(123));
        char[] charArray = str.toCharArray();
        System.out.println("toCharArray " + Arrays.toString(charArray));
        System.out.println("format: " + String.format("Name: %s, Age: %d", "Alice", 30));
        System.out.println("matcher " + "12345".matches("\\d+")); // 정규표현식 일치확인
    }
}
