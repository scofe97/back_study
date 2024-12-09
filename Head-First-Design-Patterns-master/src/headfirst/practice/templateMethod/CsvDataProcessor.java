package headfirst.practice.templateMethod;

public class CsvDataProcessor extends DataProcessor{
    @Override
    protected void loadData() {
        System.out.println("Loading data from CSV file...");
    }

    @Override
    protected void transformData() {
        System.out.println("Transforming CSV data...");
    }

    @Override
    protected void saveData() {
        System.out.println("Saving transformed CSV data to database...");
    }
}
