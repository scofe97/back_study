package generic.ex1;

public class RowTypeMain {

    public static void main(String[] args) {
        GenericBox integerBox = new GenericBox();
        integerBox.setValue(10);
        Integer result = (Integer) integerBox.getValue();
        System.out.println("result = " + result);
    }
}
