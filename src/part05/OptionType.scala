package part05

object OptionType extends App {
  // option - java-like style
  val u1 = Users.byId(1)
  if (u1.isDefined) {
    println(s">>> user 1 is ${u1.get.firstName}")
  } else {
    println(s">>> user 1 is <null>")
  }

  val u666 = Users.byId(666)
  if (u666.isDefined) {
    println(s">>> user 666 is ${u666.get.firstName}")
  } else {
    println(s">>> user 666 is <null>")
  }


  // options - providing default value
  val u2 = Users.byId(2).get
  println(s">>> user 2 gender is " + u2.gender.getOrElse("<undefined>"))

  val u3 = Users.byId(3).get
  println(s">>> user 3 gender is " + u3.gender.getOrElse("<undefined>"))


  // options - pattern matching
  val u5 = Users.byId(5).get
  val u5g = u5.gender match {
    case Some(gender) => s"$gender"
    case None => "<undefined>"
  }
  println(s">>> user 5 gender is $u5g")

  val u4 = Users.byId(4).get
  val u4g = u4.gender match {
    case Some(gender) => s"$gender"
    case None => "<undefined>"
  }
  println(s">>> user 4 gender is $u4g")


  // options - collection style, recommended
  val u6 = Users.byId(6)
  u6.foreach(u => println(">>> user 6 is " + u.firstName))

  val u457 = Users.byId(457)
  u457.foreach(u => println(">>> user 457 is " + u.firstName)) //user doesn't exist; won't print anything!


  // options - mapping
  val u7 = Users.byId(7)

  val u7a1 = u7.map(_.age)
  println(s">>> user 7 is $u7a1 years old")
  u7a1.foreach(a => println(s">>> user 7 is $a years old"))

  val u7g1 = u7.map(_.gender)
  println(s">>> user 7 gender is $u7g1")

  val u7g2 = u7.flatMap(_.gender)
  println(s">>> user 7 gender is $u7g2")
  u7g2.foreach(g => println(s">>> user 7 gender is $g"))


  // options - filtering
  u7.filter(_.age > 20).foreach(u => println(">>> user 7 is older than 20")) //won't print anything; u7 is only 15

  val u8 = Users.byId(8)
  u8.filter(_.age > 20).foreach(u => println(">>> user 8 is older than 20"))


  // options - for comprehensions
  val u9g = for {
    user <- Users.byId(9)
    gender <- user.gender
  } yield gender

  println(">>> user 9 gender is " + u9g.getOrElse("<undefined>"))

  val u10g = for {
    User(_, _, _, _, Some(gender)) <- Users.byId(10) //don't do that with large constructors!
  } yield gender

  println(">>> user 10 gender is " + u10g.getOrElse("<undefined>"))


  // options - chaining
  val g1 = u9g orElse u10g
  g1.foreach(g => println(s">>> g1 is $g"))

  val g2 = u10g orElse u9g
  g2.foreach(g => println(s">>> g2 is $g"))
}
