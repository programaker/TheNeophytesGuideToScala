package part01.multivalue

object Users {
  private val all = List(
    new FreeUser("Paula Tejano", 10, 0.99),
    new FreeUser("Tomas Turbano", 2, 0.4),
    new PremiumUser("Marcelo Gomes", 10),
    new PremiumUser("Hector Bonilha", 8),
    new FreeUser("Jacinto Leite Aquino Rego", 8, 0.75),
    new FreeUser("Deuzarina Camurujipe", 3, 0.35)
  )

  def foreach(block: User => Unit) = all.foreach(block)
}
