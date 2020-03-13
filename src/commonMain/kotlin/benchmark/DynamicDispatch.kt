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

  private lateinit var actualProvider: ZeroProvider
  private lateinit var baseProvider: Provider
  private lateinit var anyProvider: Any

  @Setup
  fun setup() {
    actualProvider = ZeroProvider()
    baseProvider = actualProvider
    anyProvider = baseProvider
  }

  @Benchmark
  fun actual(): Int {
    return actualProvider.get()
  }

  @Benchmark
  fun base(): Int {
    return baseProvider.get()
  }

  @Benchmark
  fun any(): Int {
    if (anyProvider is Provider) {
      return (anyProvider as Provider).get()
    }
    return 0
  }
}