package headfirst.practice.state;

public class StateMain {
    public static void main(String[] args) {
        Order order = new Order(1L);

        System.out.println("초기 상태 " + order.getCurrentStatus());

        order.proceed();
        System.out.println("현재 상태 " + order.getCurrentStatus());

        order.proceed();
        System.out.println("현재 상태 " + order.getCurrentStatus());

        order.proceed();
        System.out.println("현재 상태 " + order.getCurrentStatus());

        order.proceed();
        System.out.println("현재 상태 " + order.getCurrentStatus());

        order.proceed();
        System.out.println("현재 상태 " + order.getCurrentStatus());
    }
}
