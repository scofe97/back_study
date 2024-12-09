package headfirst.practice.templateMethod;

public class ApiDataProcessor extends DataProcessor {
    @Override
    protected void loadData() {
        System.out.println("Fetching data from remote API...");
    }

    @Override
    protected void transformData() {
        System.out.println("Transforming API data...");
    }

    @Override
    protected void saveData() {
        System.out.println("Saving transformed API data to a file...");
    }
}
