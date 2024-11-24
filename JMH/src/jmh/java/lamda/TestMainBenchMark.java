package lamda;

import org.example.lamda.TestMain;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class TestMainBenchMark {

    @Benchmark
    public void benchmarkTestMain8_1()  {
        TestMain testMain = new TestMain();
        try {
            testMain.benchmarkTestMain8_1();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    public void benchmarkTestMain8_2()  {
        TestMain testMain = new TestMain();
        try {
            testMain.benchmarkTestMain8_2();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
