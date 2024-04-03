package lang.string;

public class LoopStringMain {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String result = "";

        for (int i = 0; i < 100000; i++) {
            result += "Hello Java ";
        }

        for (int i = 0; i < 100000; i++) {
            result = new StringBuilder().append(result).append("Hello Java ").toString();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("Hello Java ");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("result = " + result);
        System.out.println("time = " + (endTime - startTime) + "ms");
    }
}
