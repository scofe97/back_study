import java.util.Objects;

public class DefaultClass {

    private final int data;

    public DefaultClass(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultClass that = (DefaultClass) o;
        return data == that.data;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }
}
