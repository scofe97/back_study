package enumeration;

public class HttpStatusMain {
    public static void main(String[] args) {
        int httpCodeInput = 200;
        HttpStatus status = HttpStatus.findByCode(httpCodeInput);

        if (status == null) {
            System.out.println("정의되지 않은 코드");
        } else {
            System.out.println(status.getCode() + " " + status.getMessage());
            System.out.println("isSuccess = " + status.isSuccess());
        }
    }
}
