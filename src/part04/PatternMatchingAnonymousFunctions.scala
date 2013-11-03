package part04

object PatternMatchingAnonymousFunctions extends App {
  val wordFrequencies =
    ("habitual", 6) ::
    ("and", 56) ::
    ("consuetudinary", 2) ::
    ("additionally", 27) ::
    ("homely", 5) ::
    ("society", 13) :: Nil


  // filter > map - bad style
  val wordsWithoutOutliers1 = wordFrequencies.filter(wf => wf._2 > 3 && wf._2 < 25).map(_._1)
  println(">>> wordsWithoutOutliers1 = " + wordsWithoutOutliers1.mkString(", "))


  // filter > map - pattern matching anonymous functions
  val wordsWithoutOutliers2 = wordFrequencies.filter { case (_, f) => f > 3 && f < 25 } map { case (w, _) => w }
  println(">>> wordsWithoutOutliers2 = " + wordsWithoutOutliers2.mkString(", "))


  // filter > map - anonymous functions in variables
  val predicate: ((String, Int)) => Boolean = { case (_, f) => f > 3 && f < 25 }
  val transformation: ((String, Int)) => String = { case (w, _) => w }
  val wordsWithoutOutliers3 = wordFrequencies.filter(predicate).map(transformation)
  println(">>> wordsWithoutOutliers3 = " + wordsWithoutOutliers3.mkString(", "))


  // filter and map at the same time - explicit Partial Function
  // partial functions shouldn't be used with map!
  // they possibly couldn't be defined for all cases because of the guard clause, causing MatchError at runtime
  // use collect instead!
  val pf1 = new PartialFunction[(String, Int), String] {
    def apply(wordFrequency: (String, Int)) = wordFrequency match {
      case (word, frequency) if frequency > 3 && frequency < 25 => word
    }

    def isDefinedAt(wordFrequency: (String, Int)) = wordFrequency match {
      case (word, frequency) if frequency > 3 && frequency < 25 => true
      case _ => false
    }
  }

  val wordsWithoutOutliers4 = wordFrequencies.collect(pf1)
  println(">>> wordsWithoutOutliers4 = " + wordsWithoutOutliers4.mkString(", "))


  // filter and map at the same time - anonymous Partial Function
  val wordsWithoutOutliers5 = wordFrequencies.collect { case (w, f) if f > 3 && f < 25 => w }
  println(">>> wordsWithoutOutliers5 = " + wordsWithoutOutliers5.mkString(", "))
}
