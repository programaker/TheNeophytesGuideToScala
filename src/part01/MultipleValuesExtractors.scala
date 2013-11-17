package part01

object MultipleValuesExtractors extends App {
  
  trait User {
    def name: String
    def score: Int
  }

  class FreeUser(val name: String, val score: Int, val upgradeProbability: Double) extends User
  object FreeUser {
    def unapply(user: FreeUser): Option[(String, Int, Double)] = Some((user.name, user.score, user.upgradeProbability))
  }

  class PremiumUser(val name: String, val score: Int) extends User
  object PremiumUser {
    def unapply(user: PremiumUser): Option[(String, Int)] = Some((user.name, user.score))
  }
  
  object Users {
    private val all = List(
      new FreeUser("Paula Tejano", 10, 0.99),
      new FreeUser("Tomas Turbano", 2, 0.4),
      new PremiumUser("Marcelo Gomes", 10),
      new PremiumUser("Hector Bonilha", 8),
      new FreeUser("Jacinto Leite Aquino Rego", 8, 0.75),
      new FreeUser("Deuzarina Camurujipe", 3, 0.35)
    )

    def foreach(function: User => Unit) = all.foreach(function)
  }

  
  Users.foreach { user =>
    val greeting = user match {
      case FreeUser(name, _, upgradeProbability) =>
        if (upgradeProbability > 0.75)
          s"$name, what can we do for you today?"
        else
          s"Hi, $name..."
      case PremiumUser(name, _) =>
        s"Hail, almighty $name, lord of this app!"
    }

    println(s">>> $greeting")
  }

}