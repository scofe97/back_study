package ch05;

public class StringStack {
    private String[] values = new String[16];
    private int current = 0;

    public synchronized boolean push(String s) {
        if (current < values.length) {
            values[current] = s;
            current++;
            return true;
        }
        return false;
    }

    public String pop() {
        if (current == 0) {
            return null;
        }
        current--;
        return values[current];
    }
}