package benchmark

import kotlinx.benchmark.*

@State(Scope.Benchmark)
@OutputTimeUnit(BenchmarkTimeUnit.MILLISECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)
class SimpleOps {
  @Param("30", "60", "120")
  var fps = 0

  var a = 0
  var b = 0

  @Setup
  fun setup() {
    a = 10
    b = 20
  }

  @Benchmark
  fun add(bh: Blackhole) {
    repeat(fps) {
      bh.consume(a + b)
    }
  }

  @Benchmark
  fun sub(bh: Blackhole) {
    repeat(fps) {
      bh.consume(a - b)
    }
  }

  @Benchmark
  fun mul(bh: Blackhole) {
    repeat(fps) {
      bh.consume(a * b)
    }
  }

  @Benchmark
  fun div(bh: Blackhole) {
    repeat(fps) {
      bh.consume(a / b)
    }
  }

  private inline fun repeat(count: Int, cb: () -> Unit) {
    for (i in 0 until count) {
      cb()
    }
  }
}