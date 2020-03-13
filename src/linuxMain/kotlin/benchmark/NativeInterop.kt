package benchmark

import kotlinx.benchmark.*
import nativelib.*

@State(Scope.Benchmark)
@OutputTimeUnit(BenchmarkTimeUnit.MILLISECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)
class NativeInterop {

  @Benchmark
  fun integer() = native_integer()

  @Benchmark
  fun string() = native_string()
}