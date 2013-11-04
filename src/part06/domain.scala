package part06


case class Cigarettes(amount: Int)
case class Customer(age: Int)
case class UnderAgeException(message: String) extends Exception

object Customers {
  private val allCustomers = List(
	Customer(18),
	Customer(31),
	Customer(40),
	Customer(17),
	Customer(15),
	Customer(30)
  )
  
  def foreach(function: Customer => Unit) = allCustomers.foreach(function)
}