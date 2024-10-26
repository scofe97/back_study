package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMain2 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {
        System.out.println("=== 영문 ASCII 인코딩 ===");
        test("A", US_ASCII, US_ASCII);
        test("A", US_ASCII, ISO_8859_1); // ASCII 확장
        test("A", US_ASCII, EUC_KR); // ASCII 확장
        test("A", US_ASCII, MS_949); // ASCII 확장
        test("A", US_ASCII, UTF_8); // ASCII 확장
        test("A", US_ASCII, UTF_16BE); // UTF_16 디코딩 실패

        System.out.println("=== 한글 인코딩 ===");
        test("가", US_ASCII, US_ASCII); // X
        test("가", ISO_8859_1, US_ASCII); // X
        test("가", EUC_KR, EUC_KR);
        test("가", MS_949, MS_949);
        test("가", UTF_8, UTF_8);
        test("가", UTF_16, UTF_16);

        System.out.println("=== 한글 인코딩 - 복잡한 인코딩 ===");
        test("뷁", EUC_KR, EUC_KR); // ?
        test("뷁", MS_949, MS_949);
        test("뷁", UTF_8, UTF_8);
        test("뷁", UTF_16, UTF_16);

        // UTF-8(3byte), EUC-KR, MS949, UTF-16(2byte) 사용으로 호환안됨
        System.out.println("=== 한글 인코딩 - 디코딩이 다른 경우 ===");
        test("뷁", EUC_KR, MS_949); // ?(ASCII 63 - 모르는 문자라는 의미)
        test("뷁", MS_949, EUC_KR); // 인코딩 가능, 디코딩 불가능
        test("가", EUC_KR, UTF_8); // X
        test("가", MS_949, UTF_8); // X
        test("가", UTF_8, MS_949); // X

        System.out.println("=== 영문 인코딩 - 디코딩이 다른 경우 ===");
        test("A", EUC_KR, UTF_8);
        test("A", MS_949, UTF_8);
        test("A", UTF_8, MS_949);
        test("A", UTF_8, UTF_16);

    }

    private static void test(String text, Charset encodingCharset, Charset decodingCharset) {
        byte[] encoded = text.getBytes(encodingCharset);
        String decoded = new String(encoded, decodingCharset);
        System.out.printf("%s -> [%s] 인코딩 -> %s %byte -> [%s] 디코딩 -> %s \n",
                text, encodingCharset, Arrays.toString(encoded), encoded.length, decodingCharset, decoded);

    }
}