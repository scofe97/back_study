import java.net.http.HttpClient;

public class CustomerClassLoader {

    public static class SadClassLoader extends ClassLoader {
        public SadClassLoader() { super(SadClassLoader.class.getClassLoader()); }

        // findClass 메서드를 오버라이드하여 클래스 로딩 시 커스텀 메시지를 출력
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            System.out.println("커스텀 클래스로더에서 클래스를 찾는중입니다: " + name);
            throw new ClassNotFoundException(name); // 이 예제에서는 단순히 예외를 던짐
        }

        // loadClass 메서드를 오버라이드하여 클래스 로딩을 직접 처리
        @Override
        public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            try {
                // 부모 로더에게 먼저 로딩을 시도
                return super.loadClass(name, resolve);
            } catch (ClassNotFoundException e) {
                // 부모 로더가 못 찾으면 커스텀 로직으로 시도
                System.out.println(name + " :: 직접 로드 시도");
                Class<?> c = findClass(name); // 직접 로드 시도
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }
    }

    public static void main(String[] args)  {
        // 테스트할 클래스 이름 지정 - 로드할 클래스를 문자열로 지정
        String className = "MyProgram2"; // 존재하는 클래스 이름

        var loader = new SadClassLoader();

        try {
            // 커스텀 클래스 로더를 사용하여 클래스 로드 시도
            Class<?> clazz = loader.loadClass(className);
            System.out.println("클래스 찾음: " + clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // 클래스 로딩 실패 시 예외 출력
        }
    }
}
