package benchmark

import kotlinx.benchmark.*

@State(Scope.Benchmark)
@OutputTimeUnit(BenchmarkTimeUnit.MILLISECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)
class DynamicDispatch {
  interface Provider {
    fun get(): Int
  }

  class ZeroProvider: Provider {
    private var value = 0
    override fun get(): Int {
      return value
    }
  }

  private lateinit var provider: Any

  @Setup
  fun setup() {
    provider = ZeroProvider()
  }

  @Benchmark
  fun call(): Int {
    if (provider is Provider) {
      return (provider as Provider).get()
    }
    return 0
  }
}