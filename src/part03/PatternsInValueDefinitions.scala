package part03

object PatternsInValueDefinitions extends App {
  // traditional
  val bestPlayer = Players.bestPlayer
  println(s">>> The best player is ${bestPlayer.name}")

  // destructuring
  val Player(bestPlayerName, _) = Players.bestPlayer
  println(s">>> The best player is ${bestPlayerName}")

  // tuples - bad style
  val bestScore = Players.bestScore
  println(s">>> Best score: ${bestScore._1} with ${bestScore._2} points")

  // tuples - good style
  val (name, score) = Players.bestScore
  println(s">>> Best score: $name with $score points")
}
