import org.scalatest.FlatSpec

class BasicExerciseTests extends FlatSpec {
  "Given value" should "be returned" in {
    assertResult(BasicExercises.inputString("Hey")) {
      "Hey"
    }
  }

  "Given word and int" should "return end characters" in {
    assertResult(BasicExercises.endOfString("Hey", 2)) {
      "ey"
    }
  }

  "Sum function" should "add" in {
    assertResult(BasicExercises.sum(2, 3, true)) {
      5
    }
  }

  "Given two numbers" should "multiply" in {
    assertResult(BasicExercises.sum(2, 3, false)) {
      6
    }
  }

  "Give 1 value" should "return value not 0" in {
    assertResult(BasicExercises.sum(2, 0, true)) {
      2
    }
  }

  "Only 1 value" should "return value not 0" in {
    assertResult(BasicExercises.sum(0, 3, true)) {
      3
    }
  }

  "Input 0" should "return 0" in {
    assertResult(BasicExercises.sum(0, 0, true)) {
      0
    }
  }

  "Black jack 0 inputs" should "be 0" in {
    assertResult(BasicExercises.blackJack(0, 0)) {
      0
    }
  }
  "Black jack more than 21" should "be 0" in {
    assertResult(BasicExercises.blackJack(22, 22)) {
      0
    }
  }
  "Black jack input 1 less than 21" should "be 21" in {
    assertResult(BasicExercises.blackJack(5, 22)) {
      5
    }
  }
  "Black jack input 2 less than 21" should "be 21" in {
    assertResult(BasicExercises.blackJack(22, 20)) {
      20
    }
  }

  "Add all values" should "sum" in {
    assertResult(BasicExercises.uniqueSum(1, 2, 3)) {
      6
    }
  }

  "Given two same value" should "return other value" in {
    assertResult(BasicExercises.uniqueSum(1, 1, 3)) {
      3
    }
  }
  "Given two and third same value" should "return other value" in {
    assertResult(BasicExercises.uniqueSum(2, 1, 1)) {
      2
    }
  }
  "Given value" should "return other value" in {
    assertResult(BasicExercises.uniqueSum(3, 1, 3)) {
      1
    }
  }
  "Given same value" should "return other value" in {
    assertResult(BasicExercises.uniqueSum(1, 1, 1)) {
      0
    }
  }

  "TooHot is summer and temp 65" should "be true" in {
    assertResult(BasicExercises.tooHot(65, true)) {
      true
    }
  }
  "TooHot temp 85" should "be true" in {
    assertResult(BasicExercises.tooHot(95, true)) {
      true
    }
  }
  "TooHot is not summer and temp 91" should "be false" in {
    assertResult(BasicExercises.tooHot(91, false)) {
      false
    }
  }
  "TooHot is summer and temp 95" should "be false" in {
    assertResult(BasicExercises.tooHot(95, true)) {
      true
    }
  }
}
