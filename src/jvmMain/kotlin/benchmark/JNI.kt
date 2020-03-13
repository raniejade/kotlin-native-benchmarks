package benchmark

import kotlinx.benchmark.*

object External {
  init {
    System.loadLibrary("jni")
  }
  external fun str(): String
  external fun int(): Int
}

@State(Scope.Benchmark)
@OutputTimeUnit(BenchmarkTimeUnit.MILLISECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)
class JNI {
  @Benchmark
  fun str(): String {
    return External.str()
  }

  @Benchmark
  fun integer(): Int {
    return External.int()
  }
}