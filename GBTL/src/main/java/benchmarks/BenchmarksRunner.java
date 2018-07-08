package benchmarks;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarksRunner
{
	public static void main(String[] args) throws RunnerException
	{
		Options options = new OptionsBuilder()
				.include(BenchmarksRunner.class.getSimpleName())
				.include(BenchmarkSorts.class.getSimpleName())
				.forks(1)
				.warmupIterations(10)
				.measurementIterations(10)
				.build();

		new Runner(options).run();
	}
}
