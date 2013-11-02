package part01extractors.multivalue

object Main extends App {
  Users.forEach { user =>
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