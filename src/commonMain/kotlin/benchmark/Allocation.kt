package benchmark

import kotlinx.benchmark.*

@State(Scope.Benchmark)
@OutputTimeUnit(BenchmarkTimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.Throughput)
class Allocation {
  @Param("10", "100", "1000")
  var count = 0

  @Benchmark
  fun allocate(): List<String> {
    val list = mutableListOf<String>()
    for (i in 0 until count) {
      list.add(i.toString())
    }
    return list
  }
}