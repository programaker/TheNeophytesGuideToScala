package part03

object Players {
  private val all = List(
    Player("programaker", 100),
    Player("evil_hacker", 4250900),
    Player("gatinh@17", 2715),
    Player("kazaar", 9000),
    Player("dharkan-the-impaler", 10000),
    Player("whey_protein", 50)
  )

  def foreach(function: Player => Unit) = all.foreach(function)

  def bestPlayer = all.maxBy(_.score)

  def scores = all.map(p => (p.name, p.score))

  def bestScore = scores.sortBy { case (_, score) => score } .last //pattern matching in anonymous function! =D
}
