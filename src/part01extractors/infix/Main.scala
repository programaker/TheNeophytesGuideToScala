package part01extractors.infix

object Main {
  def sumFirstTwo(s: Stream[Int]) = s match {
    case first #:: second #:: _ => first + second
    case _ => -1
  }

  def main(args: Array[String]) = {
    val s1 = Stream.empty[Int]
    val s2 = 58 #:: Stream.empty[Int]
    val s3 = 58 #:: 43 #:: Stream.empty[Int]
    val s4 = 58 #:: 43 #:: 93 #:: Stream.empty[Int]
    val s5 = 58 #:: 43 #:: 93 #:: 104 #:: 666 #:: Stream.empty[Int]

    println(">>> s1: " + sumFirstTwo(s1))
    println(">>> s2: " + sumFirstTwo(s2))
    println(">>> s3: " + sumFirstTwo(s3))
    println(">>> s4: " + sumFirstTwo(s4))
    println(">>> s5: " + sumFirstTwo(s5))
  }
}
