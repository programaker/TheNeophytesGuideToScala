package part03

object PatternsInForComprehensions extends App {
  val bestPlayers1 = for {
    scores <- Players.scores
    (name, score) = scores
    if score > 9000
  } yield name

  println(">>> best players: " + bestPlayers1.mkString(", "))


  // more concise way
  val bestPlayers2 = for {
    (name, score) <- Players.scores
    if score > 9000
  } yield name

  println(">>> best players: " + bestPlayers2.mkString(", "))
}
