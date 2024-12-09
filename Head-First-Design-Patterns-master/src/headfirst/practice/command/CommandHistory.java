package headfirst.practice.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class CommandHistory {
    private final Deque<Command> history = new ArrayDeque<>();

    public void push(Command cmd) {
        history.push(cmd);
    }

    public Command pop() {
        return history.isEmpty() ? null : history.pop();
    }

    public Command peek() {
        return history.peek();
    }

    public void print() {
        System.out.println("Command history 가장 최근 데이터");

    }

}
