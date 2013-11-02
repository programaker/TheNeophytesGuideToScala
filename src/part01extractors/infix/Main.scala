package part01extractors.infix

object Main {
  def sumFirstTwoOfThree(s: Stream[Int]) = s match {
    case first #:: second #:: _ => first + second
    case _ => -1
  }

  def main(args: Array[String]) = {
    val s1 = 58 #:: 43 #:: 93 #:: Stream.empty[Int]
    val s2 = 2 #:: Stream.empty[Int]
    val s3 = Stream.empty[Int]

    println(">>> s1: " + sumFirstTwoOfThree(s1))
    println(">>> s2: " + sumFirstTwoOfThree(s2))
    println(">>> s3: " + sumFirstTwoOfThree(s3))
  }
}
