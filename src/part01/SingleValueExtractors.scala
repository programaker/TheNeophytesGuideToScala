package part01

object SingleValueExtractors extends App {
  
  trait User {
    def name: String
  }

  class FreeUser(val name: String) extends User
  object FreeUser {
    def unapply(user: FreeUser): Option[String] = Some(user.name)
  }

  class PremiumUser(val name: String) extends User
  object PremiumUser {
    def unapply(user: PremiumUser): Option[String] = Some(user.name)
  }
  
  object Users {
    private val all = List(
      new FreeUser("Paula Tejano"),
      new FreeUser("Tomas Turbano"),
      new PremiumUser("Marcelo Gomes"),
      new PremiumUser("Hector Bonilha"),
      new FreeUser("Jacinto Leite Aquino Rego"),
      new FreeUser("Deuzarina Camurujipe")
    )

    def foreach(function: User => Unit) = all.foreach(function)
  }
  
  
  Users.foreach { user =>
    val greeting = user match {
      case FreeUser(name) => s"Hi, $name..."
      case PremiumUser(name) => s"Hail, almighty $name, lord of this app!"
    }

    println(s">>> $greeting")
  }
  
}
