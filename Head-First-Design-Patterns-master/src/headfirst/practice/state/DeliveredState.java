package headfirst.practice.state;

public class DeliveredState implements OrderState {

    @Override
    public OrderState next() {
        // 배송 완료 상태는 최종 상태로 더 이상 전이가 없다고 가정(여기서는 null 반환)
        return null;
    }

    @Override
    public void handle() {
        // 상태 처리 로직: 고객에게 배송 완료 알림, 리뷰 요청
        System.out.println("배송 완료 처리 로직 실행");
    }

    @Override
    public String getStatusName() {
        return "DELIVERED";
    }
}
