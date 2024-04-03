package lang.string;

public class StringBuilder1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("A");
        sb.append("B");
        sb.append("C");
        sb.append("D");
        System.out.println("sb = " + sb);

        sb.insert(4, "Java"); // 추가
        System.out.println("insert = " + sb);

        sb.delete(4, 8); // 제거
        System.out.println("delete = " + sb);

        sb.reverse(); // 뒤집기
        System.out.println("reverse = " + sb);

        String string = sb.toString(); //StringBuilder -> String
        System.out.println("string = " + string);
    }
}
