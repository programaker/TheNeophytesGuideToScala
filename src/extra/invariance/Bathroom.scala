package extra.invariance

class Bathroom[P] {
  def allow(person: P) = println(s"$person allowed in this bathroom")
}