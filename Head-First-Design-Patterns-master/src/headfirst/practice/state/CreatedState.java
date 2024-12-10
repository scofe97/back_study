package headfirst.practice.state;

public class CreatedState implements OrderState {

    @Override
    public OrderState next() {
        // 주문 생성 상태에서 다음 상태는 결제 완료 상태라고 가정
        return new PaidState();
    }

    @Override
    public void handle() {
        // 상태 처리 로직: 예를 들어, 주문 생성 시 재고 확인 및 예약 로직
        System.out.println("주문 생성 처리 로직 실행");
    }

    @Override
    public String getStatusName() {
        return "CREATED";
    }
}
