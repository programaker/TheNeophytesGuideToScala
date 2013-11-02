package part03

object PatternMatchingExpressions {
  def messageTo(player: Player) = player match {
    case Player(name, score) if score > 9000 => s"Wow! $name's score is over 9000!"
    case Player(name, _) => s"Welcome back, $name"
  }

  def main(args: Array[String]) = {
    Players.foreach { player => println(">>> " + messageTo(player)) }
  }
}
