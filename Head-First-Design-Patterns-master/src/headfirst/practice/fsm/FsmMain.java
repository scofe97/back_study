package headfirst.practice.fsm;

public class FsmMain {
    public static void main(String[] args) {
        TurnstileFsm fsm = new TurnstileFsm();

        System.out.println("초기 상태: " + fsm.getCurrentState());

        // LOCKED 상태에서 PUSH
        fsm.trigger(Event.PUSH);  // "밀었지만 잠겨있습니다. '삑'!"
        System.out.println("현재 상태: " + fsm.getCurrentState());

        // LOCKED 상태에서 COIN
        fsm.trigger(Event.COIN);  // "동전 투입: 회전문이 열렸습니다."
        System.out.println("현재 상태: " + fsm.getCurrentState());

        // UNLOCKED 상태에서 COIN
        fsm.trigger(Event.COIN);  // "이미 열려있습니다. 추가 동전은 쌓입니다."
        System.out.println("현재 상태: " + fsm.getCurrentState());

        // UNLOCKED 상태에서 PUSH
        fsm.trigger(Event.PUSH);  // "밀었고 지나갑니다. 다시 문이 잠김"
        System.out.println("현재 상태: " + fsm.getCurrentState());
    }
}
