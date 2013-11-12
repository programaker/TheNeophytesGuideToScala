package extra.invariance

object Invariance extends App {
  val ze: Man = Man("Zé")
  val kellen: Woman = Woman("Kellen")
  
  val femaleBathroom: Bathroom[Woman] = new Bathroom[Woman]
  val maleBathroom: Bathroom[Man] = new Bathroom[Man]
  
  femaleBathroom.allow(kellen)
  maleBathroom.allow(ze)
  
  //femaleBathroom.allow(ze)
  /* does not compile!
  type mismatch; found : extra.invariance.Man required: extra.invariance.Woman */
  
  //maleBathroom.allow(kellen)
  /* does not compile!
  type mismatch; found : extra.invariance.Woman required: extra.invariance.Man */
  
  //val flexMaleBathroom: Bathroom[Person] = new Bathroom[Man]
  /* does not compile!
  type mismatch; found : extra.invariance.Bathroom[extra.invariance.Man] 
  required: extra.invariance.Bathroom[extra.invariance.Person] 
  Note: extra.invariance.Man <: extra.invariance.Person, but class Bathroom is invariant in type P. 
  You may wish to define P as +P instead. (SLS 4.5) */
  
  //a Man is a Person
  //a Woman is a Person
  //but neither Bathroom[Man] nor Bathroom[Woman] are Bathroom[Person]! 
  //this is the Invariance!
}