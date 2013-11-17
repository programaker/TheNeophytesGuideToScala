package part02

object FullNameSequenceExtractor {
  
  object Names {
    def unapplySeq(name: String): Option[(String, String, Seq[String])] = {
      val nameParts = name.trim.split(" ")

      if (nameParts.size < 2) {
        None
      } else {
        Some((nameParts.head, nameParts.last, nameParts.drop(1).dropRight(1)))
      }
    }
  }
  
  def greet(name: String) = name match {
    case Names(firstName, lastName, _*) => s"Hello, $firstName $lastName!"
    case _ => "You don't have a family"
  }

  def main(args: Array[String]) = {
    val n1 = ""
    val n2 = " "
    val n3 = "Jão"
    val n4 = "Paula Tejano"
    val n5 = "Jacinto Leite Aquino Rego"
    val n6 = "Marcelo da Silva Gomes"

    println(">>> " + greet(n1))
    println(">>> " + greet(n2))
    println(">>> " + greet(n3))
    println(">>> " + greet(n4))
    println(">>> " + greet(n5))
    println(">>> " + greet(n6))
  }
  
}
