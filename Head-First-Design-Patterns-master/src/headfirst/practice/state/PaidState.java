package headfirst.practice.state;

public class PaidState implements OrderState {

    @Override
    public OrderState next() {
        // 결제 완료 후 다음 상태는 배송 중 상태
        return new ShippedState();
    }

    @Override
    public void handle() {
        // 상태 처리 로직: 결제 확인 및 영수증 발행, 포장 준비
        System.out.println("결제 완료 처리 로직 실행");
    }

    @Override
    public String getStatusName() {
        return "PAID";
    }
}
