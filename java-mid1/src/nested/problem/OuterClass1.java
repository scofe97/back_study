package nested.problem;

public class OuterClass1 {

    static class NestedClass{
        public void hello(){
            System.out.println("hello");
        }
    }

    class InnerClass{
        public void hello(){
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {
        NestedClass nestedClass = new NestedClass();
        nestedClass.hello();

        InnerClass innerClass = new OuterClass1().new InnerClass();
        innerClass.hello();

        class LocalClass{
            public void hello(){
                System.out.println("hello");
            }
        }

        LocalClass localClass = new LocalClass();
        localClass.hello();

        Hello hello = new Hello() {
            @Override
            public void hello() {

            }
        };

        hello.hello();
    }
}
