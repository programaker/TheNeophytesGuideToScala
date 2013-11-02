package part01extractors.simple

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