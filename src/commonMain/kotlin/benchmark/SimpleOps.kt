package benchmark

import kotlinx.benchmark.*

@State(Scope.Benchmark)
@OutputTimeUnit(BenchmarkTimeUnit.MILLISECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)
class SimpleOps {
  private var a = 0
  private var b = 0

  @Setup
  fun setup() {
    a = 10
    b = 20
  }

  @Benchmark
  fun add(): Int {
    return a + b
  }

  @Benchmark
  fun sub(): Int {
    return a - b
  }

  @Benchmark
  fun mul(): Int {
    return a * b
  }

  @Benchmark
  fun div(): Int {
    return a / b
  }
}