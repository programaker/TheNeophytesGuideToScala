package extra

object Monoids extends App {

  trait Monoid[T] {
    def identity: T
    def append(v1: T, v2: T): T
  }
  
  
  def checkIdentity[T](value: T, monoid: Monoid[T]) = {
    val expected = value
    val actual1 = monoid.append(value, monoid.identity)
    val actual2 = monoid.append(monoid.identity, value)
    
    val result = if ((expected == actual1) && (expected == actual2)) {
      s">>> Monoid identity working for $value"
    } else {
      s">>> expected: $expected. got: $actual1, $actual2"
    }
    
    println(result)
  }
  
  def checkAssociativity[T](v1: T, v2: T, v3: T, monoid: Monoid[T]) = {
    val r1 = monoid.append(v1, monoid.append(v2, v3))
    val r2 = monoid.append(monoid.append(v1, v2), v3)
    
    val result = if (r1 == r2) {
      s">>> Monoid associativity working for $v1, $v2, $v3"
    } else {
      ">>> expected: true. got: false"
    }
    
    println(result)
  }
  
  def reduce[T](list: List[T], monoid: Monoid[T]): T = list match {
    case Nil => monoid.identity
    case head :: tail => monoid.append(head, reduce(tail, monoid))
  }
  
  
  val stringMonoid = new Monoid[String] {
    def identity: String = ""
    def append(v1: String, v2: String): String = v1 + v2
  }
  
  val intAdditionMonoid = new Monoid[Int] {
    def identity: Int = 0
    def append(v1: Int, v2: Int): Int = v1 + v2
  }
  
  val intMultiplicationMonoid = new Monoid[Int] {
    def identity: Int = 1
    def append(v1: Int, v2: Int): Int = v1 * v2
  }
  
  checkIdentity("frunfles", stringMonoid)
  checkIdentity(666, intAdditionMonoid)
  checkIdentity(666, intMultiplicationMonoid)
  
  checkAssociativity("mocha", "coffee", "tall", stringMonoid)
  checkAssociativity(1, 2, 3, intAdditionMonoid)
  checkAssociativity(1, 2, 3, intMultiplicationMonoid)
  
  val strings = List("c", "o", "f", "f", "e", "e")
  val ints = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  println(reduce(strings, stringMonoid))
  println(reduce(ints, intAdditionMonoid))
  println(reduce(ints, intMultiplicationMonoid))

}