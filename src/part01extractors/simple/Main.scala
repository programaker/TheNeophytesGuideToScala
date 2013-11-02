package part01extractors.simple

object Main extends App {
  Users.forEach { user =>
    val greeting = user match {
      case FreeUser(name) => s"Hi, $name..."
      case PremiumUser(name) => s"Hail, almighty $name, lord of this app!"
    }

    println(s">>> $greeting")
  }
}
