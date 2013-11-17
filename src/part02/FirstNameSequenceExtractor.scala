package part02

object FirstNameSequenceExtractor {
  
  object Names {
    def unapplySeq(name: String): Option[Seq[String]] = {
      val nameParts = name.trim.split(" ")

      if (nameParts.forall(_.isEmpty)) {
        None
      } else {
        Some(nameParts)
      }
    }
  }
  
  def greet(name: String) = name match {
    case Names(firstName, _*) => s"Hello, $firstName!"
    case _ => "Who are you?"
  }

  def main(args: Array[String]) = {
    val n1 = ""
    val n2 = " "
    val n3 = "Jão"
    val n4 = "Paula Tejano"
    val n5 = "Jacinto Leite Aquino Rego"

    println(">>> " + greet(n1))
    println(">>> " + greet(n2))
    println(">>> " + greet(n3))
    println(">>> " + greet(n4))
    println(">>> " + greet(n5))
  }
  
}
