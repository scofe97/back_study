package headfirst.practice.state;

public interface OrderState {
    OrderState next();

    void handle();

    String getStatusName();
}
