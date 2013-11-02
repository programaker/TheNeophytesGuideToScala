package part02

object FixedSizeSequenceExtractors {
  def calculate(list: List[Int]) = list match {
    case List(a, b) => a * b
    case List(a, b, c) => a + b + c
    case _ => -1
  }

  def main(args: Array[String]) = {
    val l1 = Nil
    val l2 = List.empty[Int]
    val l3 = 1 :: Nil
    val l4 = 1 :: 2 :: Nil
    val l5 = 1 :: 2 :: 3 :: Nil
    val l6 = 1 :: 2 :: 3 :: 4 :: Nil
    
    println(">>> l1: " + calculate(l1))
    println(">>> l2: " + calculate(l2))
    println(">>> l3: " + calculate(l3))
    println(">>> l4: " + calculate(l4))
    println(">>> l5: " + calculate(l5))
    println(">>> l6: " + calculate(l6))
  }
}
