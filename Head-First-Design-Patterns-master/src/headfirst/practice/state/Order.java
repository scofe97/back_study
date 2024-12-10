package headfirst.practice.state;

public class Order {
    private Long id;
    private OrderState state;

    public Order(Long id) {
        this.id = id;
        this.state = new CreatedState(); // 초기 상태를 CREATED로 가정
    }

    public void proceed() {
        // 현재 상태 로직 수행
        state.handle();
        // 다음 상태로 전이
        OrderState nextState = state.next();
        if (nextState != null) {
            this.state = nextState;
        }
    }

    public String getCurrentStatus() {
        return state.getStatusName();
    }

    public Long getId() {
        return id;
    }
}