package extra.contravariance

class Doctor[-D] {
  def treat(disease: D) = println(s">>> Treating $disease")
}