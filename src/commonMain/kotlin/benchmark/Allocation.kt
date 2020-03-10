package benchmark

import kotlinx.benchmark.*

@State(Scope.Benchmark)
@OutputTimeUnit(BenchmarkTimeUnit.MILLISECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)
class Allocation {
  @Param("30", "60", "120")
  var fps = 0

  lateinit var data: CharArray

  @Setup
  fun setup() {
    // 1 kb of data
    data = CharArray(512) { '0' }
  }

  @Benchmark
  fun allocateAndKeep(): List<String> {
    val list = mutableListOf<String>()
    for (i in 0 until fps) {
      list.add(allocateData())
    }
    return list
  }

  @Benchmark
  fun allocateAndThrowAway(bh: Blackhole) {
    for (i in 0 until fps) {
      bh.consume(allocateData())
    }
  }

  private fun allocateData(): String {
    return String(data)
  }
}