import java.net.http.HttpClient;

public class ClassLoading {
    public static void main(String[] args)  {

        var classLoaderThis = ClassLoading.class.getClassLoader();
        var classLoaderObj = Object.class.getClassLoader();
        var classLoaderHttp = HttpClient.class.getClassLoader();

        System.out.println("classLoaderThis = " + classLoaderThis);
        System.out.println("classLoaderObj = " + classLoaderObj);
        System.out.println("classLoaderHttp = " + classLoaderHttp);

        var module = String.class.getModule();
        var descriptor = module.getDescriptor();
        System.out.println("descriptor = " + descriptor);
    }
}
