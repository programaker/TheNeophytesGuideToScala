package extra.variancia

object Covariancia extends App {

  trait Passageiro
  class Pobre extends Passageiro
  class Rico extends Passageiro

  class Transporte[+P](_passageiros: P*) {
    def passageiros: Seq[P] = _passageiros
  }

  val zeDaSilva: Pobre = new Pobre
  val greycyKelly: Pobre = new Pobre

  val billGates: Rico = new Rico
  val parisHilton: Rico = new Rico

  /* funciona como o esperado! */
  val ferrari: Transporte[Rico] = new Transporte[Rico](billGates, parisHilton)
  val onibus: Transporte[Pobre] = new Transporte[Pobre](zeDaSilva, greycyKelly)

  /* agora funciona!
  Rico é Passageiro; Pobre é Passageiro
  e agora Transporte[Rico] e Transporte[Pobre] são também Transporte[Passageiro]
  graças à Covariância */
  val f: Transporte[Passageiro] = ferrari
  val o: Transporte[Passageiro] = onibus
  val engarrafamento: List[Transporte[Passageiro]] = List(ferrari, onibus)

}