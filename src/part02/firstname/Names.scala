package part02.firstname

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
