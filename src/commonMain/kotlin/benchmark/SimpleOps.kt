package benchmark

import kotlinx.benchmark.*

@State(Scope.Benchmark)
@OutputTimeUnit(BenchmarkTimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.Throughput)
class SimpleOps {
  private var a = 10
  private var b = 20

  @Benchmark
  fun sum(): Int {
    var sum = 0
    for (i in 0 until b) {
      sum += a
    }
    return sum
  }
}