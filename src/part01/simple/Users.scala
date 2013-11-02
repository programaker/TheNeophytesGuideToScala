package part01.simple

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
