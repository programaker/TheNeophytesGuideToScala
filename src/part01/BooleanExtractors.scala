package part01

import part01.multivalue.{FreeUser, Users, User}
import part01.bool.IsPremiumCandidate

object BooleanExtractors extends App {
  val initiateSpamProgram = (user: FreeUser) => println(s">>> Sending spam to ${user.name}...")
  val sendRegularNewsletter = (user: User) => println(s">>> Sending regular newsletter to ${user.name}...")

  Users.foreach {
    case freeUser @ IsPremiumCandidate() => initiateSpamProgram(freeUser)
    case otherUsers => sendRegularNewsletter(otherUsers)
  }
}


