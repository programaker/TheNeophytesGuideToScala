package part05

sealed trait Gender
case object Male extends Gender
case object Female extends Gender

case class User(
  id: Int,
  firstName: String,
  lastName: String,
  age: Int,
  gender: Option[Gender] = None
)