package headfirst.practice.composite;

public record FileComponent(
        String name,
        long size
) implements Component {

    @Override
    public void showDetails() {
        System.out.println("File: " + name + " (" + size + " bytes)");
    }
}
