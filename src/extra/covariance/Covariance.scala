package extra.covariance

object Covariance extends App {
  val zeDaSilva: Poor = new Poor
  val greycyKelly: Poor = new Poor
  
  val robertoJustus: Rich = new Rich
  val narcisaTamborindeguy: Rich = new Rich
  
  val bus: Vehicle[Poor] = new Vehicle[Poor](passengers = zeDaSilva, greycyKelly)
  val ferrari: Vehicle[Rich] = new Vehicle[Rich](passengers = robertoJustus, narcisaTamborindeguy)
  
  //val porsche: Vehicle[Rich] = new Vehicle[Rich](zeDaSilva, greycyKelly)
  /* does not compile!
  type mismatch; found : extra.covariance.Poor required: extra.covariance.Rich */
  
  //val superViaTrain: Vehicle[Poor] = new Vehicle[Poor](passengers = robertoJustus, narcisaTamborindeguy)
  /* does not compile!
  type mismatch; found : extra.covariance.Rich required: extra.covariance.Poor */
  
  val b: Vehicle[Passenger] = bus
  val f: Vehicle[Passenger] = ferrari
  val trafficJam: List[Vehicle[Passenger]] = b :: f :: Nil
  
  //a Poor is a Passenger
  //a Rich is a Passenger
  //and thanks to covariance, a Vehicle[Poor] and a Vehicle[Rich] are Vehicle[Passenger]!!!
}