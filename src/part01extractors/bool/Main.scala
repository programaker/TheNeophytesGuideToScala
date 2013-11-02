package part01extractors.bool

import part01extractors.multivalue.{FreeUser, Users, User}

object Main extends App {
  val initiateSpamProgram = (user: FreeUser) => println(s">>> Sending spam to ${user.name}...")
  val sendRegularNewsletter = (user: User) => println(s">>> Sending regular newsletter to ${user.name}...")

  Users.forEach {
    case freeUser @ IsPremiumCandidate() => initiateSpamProgram(freeUser)
    case otherUsers => sendRegularNewsletter(otherUsers)
  }
}


