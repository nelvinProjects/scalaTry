import org.scalatest.FlatSpec

class FibonacciTest extends FlatSpec {
  "Given value 5" should "equal 5" in {
    assertResult(Fibonacci.fibonacci2(2)) {
      1
    }
  }

  "Given value 10" should "be 55" in {
    assertResult(Fibonacci.fibonacci2(10)) {
      55
    }
  }
}
