package headfirst.practice.composite;

import java.util.ArrayList;

public class CompositeMain {
    public static void main(String[] args) {
        Component file1 = new FileComponent("file1.txt", 100);
        Component file2 = new FileComponent("file2.txt", 200);

        DirectoryComponent dir1 = new DirectoryComponent("dir1", new ArrayList<>());
        dir1.add(file1);
        dir1.add(file2);


        Component file3 = new FileComponent("file3.txt", 300);

        DirectoryComponent root = new DirectoryComponent("root", new ArrayList<>());
        root.add(dir1);
        root.add(file3);

        root.showDetails();
    }
}
