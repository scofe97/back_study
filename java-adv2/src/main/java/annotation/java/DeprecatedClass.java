package annotation.java;

public class DeprecatedClass {
    
    public void call1() {
        System.out.println("DeprecatedClass.call");
    }

    @Deprecated
    public void call2() {
        System.out.println("DeprecatedClass.call");
    }

    @Deprecated(since = "2.4", forRemoval = true)
    public void call3() {
        System.out.println("DeprecatedClass.call");
    }
}
