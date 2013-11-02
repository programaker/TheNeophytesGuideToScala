package part02.fullname

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
