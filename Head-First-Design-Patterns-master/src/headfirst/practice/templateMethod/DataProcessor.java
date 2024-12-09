package headfirst.practice.templateMethod;

public abstract class DataProcessor {
    public final void process() {
        loadData();
        transformData();
        saveData();
    }

    protected abstract void loadData();
    protected abstract void transformData();
    protected abstract void saveData();
}
