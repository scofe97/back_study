package headfirst.practice.fsm;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class TurnstileFsm {
    private static class Transition {
        State nextState;
        Consumer<Void> action;

        Transition(State nextState, Consumer<Void> action) {
            this.nextState = nextState;
            this.action = action;
        }
    }

    private State currentState;

    private final Map<State, Map<Event, Transition>> transitionTable = new HashMap<>();

    public TurnstileFsm() {
        this.currentState = State.LOCKED;

        // LOCKED 상태에서의 전이 정의
        Map<Event, Transition> lockedTransitions = new HashMap<>();
        lockedTransitions.put(Event.COIN, new Transition(State.UNLOCKED, v -> System.out.println("동전 투입: 회전문이 열림")));
        lockedTransitions.put(Event.PUSH, new Transition(State.LOCKED, v -> System.out.println("밀었지만 열리지 않음")));

        // UNLOCKED 상태에서의 전이 정의
        Map<Event, Transition> unlockedTransitions = new HashMap<>();
        unlockedTransitions.put(Event.PUSH, new Transition(State.LOCKED, v -> System.out.println("밀었고 지나갑니다. 다시 문이 잠김")));
        unlockedTransitions.put(Event.COIN, new Transition(State.UNLOCKED, v -> System.out.println("이미 열려있습니다. 추가 동전은 쌓입니다.")));

        transitionTable.put(State.LOCKED, lockedTransitions);
        transitionTable.put(State.UNLOCKED, unlockedTransitions);
    }

    public void trigger(Event event) {
        Map<Event, Transition> transitions = transitionTable.get(currentState);
        if (transitions == null) {
            System.out.println("현재 상태에서 이벤트에 대한 전이 정의가 없습니다.");
            return;
        }

        Transition transition = transitions.get(event);
        if (transition == null) {
            System.out.println("해당 이벤트에 대한 전이 없음");
            return;
        }

        // 액션 수행
        transition.action.accept(null);

        // 다음 상태로 전이
        this.currentState = transition.nextState;
    }

    public State getCurrentState() {
        return currentState;
    }
}
