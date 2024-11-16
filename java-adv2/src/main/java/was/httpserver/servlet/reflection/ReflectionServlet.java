package was.httpserver.servlet.reflection;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.HttpServlet;
import was.httpserver.PageNotFoundException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ReflectionServlet implements HttpServlet {

    private final List<Object> controller;

    public ReflectionServlet(List<Object> controller) {
        this.controller = controller;
    }

    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        String path = request.getPath();

        // SiteControllerV6, SearchControllerV6
        for (Object controller : controller) {
            Class<?> aClass = controller.getClass();
            Method[] methods = aClass.getDeclaredMethods();

            // site1, site2
            for (Method method : methods) {
                String methodName = method.getName();
                if (path.equals("/" + methodName)) { // site1.equals(/site1)
                    invoke(controller, method, request, response);
                    return;
                }
            }

            throw new PageNotFoundException("request = " + path);
        }
    }

    private static void invoke(Object controller, Method method, HttpRequest request, HttpResponse response) {
        try {
            method.invoke(controller, request, response);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
