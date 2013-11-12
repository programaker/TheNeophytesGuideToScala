package extra.contravariance

object Contravariance extends App {
  val cancer = new Cancer
  val pereba = new Pereba
  val virose = new Virose
  
  val cancerDoctor: Doctor[Cancer] = new Doctor[Cancer]
  val perebaDoctor: Doctor[Pereba] = new Doctor[Pereba]
  val viroseDoctor: Doctor[Virose] = new Doctor[Virose]
  val fullDoctor: Doctor[Disease] = new Doctor[Disease]
  
  cancerDoctor.treat(cancer)
  perebaDoctor.treat(pereba)
  viroseDoctor.treat(virose)
  
  //cancerDoctor.treat(pereba)
  //perebaDoctor.treat(virose)
  //viroseDoctor.treat(cancer)
  /* do not compile! */
  
  fullDoctor.treat(cancer)
  fullDoctor.treat(pereba)
  fullDoctor.treat(virose)
  //thanks to contravariance, a Doctor[Disease] is a Doctor[Cancer] or Doctor[Pereba] or Doctor[Virose]!
  //exactly the oposite of covariance!
}