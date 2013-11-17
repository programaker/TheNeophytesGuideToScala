package part01

object BooleanExtractors extends App {

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
  
  object IsPremiumCandidate {
	def unapply(user: FreeUser): Boolean = user.upgradeProbability > 0.75
  }
  
  
  val initiateSpamProgram = (user: FreeUser) => println(s">>> Sending spam to ${user.name}...")
  val sendRegularNewsletter = (user: User) => println(s">>> Sending regular newsletter to ${user.name}...")

  Users.foreach {
    case freeUser @ IsPremiumCandidate() => initiateSpamProgram(freeUser)
    case otherUsers => sendRegularNewsletter(otherUsers)
  }

}


