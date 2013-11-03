package part05

object Users {
  private val usersById = Map(
    1 -> User(id = 1, firstName = "Marcelo", lastName = "Gomes", age = 31, Some(Male)),
    2 -> User(id = 2, firstName = "Paula", lastName = "Tejano", age = 26, Some(Female)),
    3 -> User(id = 3, firstName = "Ariadna", lastName = "BBB", age = 26),
    4 -> User(id = 4, firstName = "Justin", lastName = "Bieber", age = 18),
    5 -> User(id = 5, firstName = "Tomás", lastName = "Turbano", age = 40, Some(Male)),
    6 -> User(id = 6, firstName = "Kellen", lastName = "Silva", age = 21, Some(Female)),
    7 -> User(id = 7, firstName = "Greicy", lastName = "Kelly", age = 15, Some(Female)),
    8 -> User(id = 8, firstName = "Gislayne", lastName = "Silva", age = 29, Some(Female)),
    9 -> User(id = 9, firstName = "Chuck", lastName = "Norris", age = 70, Some(Male)),
    10 -> User(id = 10, firstName = "Marco", lastName = "Feliciano", age = 41),
    11 -> User(id = 11, firstName = "Jean", lastName = "Willys", age = 35)
  )

  def byId(id: Int) = usersById.get(id)

  def foreach(function: User => Unit) = usersById.values.foreach(function)
}
