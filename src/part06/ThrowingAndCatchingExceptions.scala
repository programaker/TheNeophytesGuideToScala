package part06

import scala.util.Random

object ThrowingAndCatchingExceptions {
  def buyCigarettes(customer: Customer, amount: Int) = {
    if (customer.age < 18) {
      throw UnderAgeException("Too young to buy cigarettes")
    }
    
    new Cigarettes(amount)
  }
  
  def main(args: Array[String]) = {
    val random = new Random
    val range = 1 to 20
    
    Customers.foreach { customer =>
      try {
        println(s">>> ${customer.age} years old customer trying to buy cigarettes...")
        
        val amount = range(random.nextInt(range.length))
        val cigarettes = buyCigarettes(customer, amount)
        
        println(s">>> Bought $amount cigarettes")
      } catch {
        case UnderAgeException(message) => println(s">>> $message")
      }  
    }
  }
}