package headfirst.practice.state;

public class ShippedState implements OrderState {

    @Override
    public OrderState next() {
        // 배송 중 상태에서 다음은 배송 완료 상태
        return new DeliveredState();
    }

    @Override
    public void handle() {
        // 상태 처리 로직: 배송 API 호출, 트래킹 번호 업데이트
        System.out.println("배송 중 처리 로직 실행");
    }

    @Override
    public String getStatusName() {
        return "SHIPPED";
    }
}
