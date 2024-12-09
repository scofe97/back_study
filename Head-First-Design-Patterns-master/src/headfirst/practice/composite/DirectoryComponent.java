package headfirst.practice.composite;

import java.util.List;

public record DirectoryComponent(
  String name,
  List<Component> children
) implements Component {

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory: " + name);
        for (Component c : children) {
            c.showDetails();
        }
    }
}
