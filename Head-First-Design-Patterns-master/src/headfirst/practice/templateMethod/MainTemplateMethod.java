package headfirst.practice.templateMethod;

public class MainTemplateMethod {
    public static void main(String[] args) {
        CsvDataProcessor csvDataProcessor = new CsvDataProcessor();
        ApiDataProcessor apiDataProcessor = new ApiDataProcessor();
        csvDataProcessor.process();
        apiDataProcessor.process();
    }
}
