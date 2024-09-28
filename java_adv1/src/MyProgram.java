public class MyProgram {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    private void test() {
        System.out.println("test");
    }

    private int i;

    public MyProgram() {
        this.i = 0;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
