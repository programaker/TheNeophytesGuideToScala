package extra.invariance

trait Person {
  def name: String
}

case class Man(name: String) extends Person
case class Woman(name: String) extends Person