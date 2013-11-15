package extra.variancia

object Invariancia extends App {

  trait Passageiro
  class Pobre extends Passageiro
  class Rico extends Passageiro

  class Transporte[P](_passageiros: P*) {
    def passageiros: Seq[P] = _passageiros
  }

  object Engarrafamento {
    def prende(transporte: Transporte[Passageiro]): Unit = println("%$#@* de trânsito!")
  }

  val zeDaSilva: Pobre = new Pobre
  val greycyKelly: Pobre = new Pobre

  val billGates: Rico = new Rico
  val parisHilton: Rico = new Rico

  /* funciona como o esperado! */
  val ferrari: Transporte[Rico] = new Transporte[Rico](billGates, parisHilton)
  val onibus: Transporte[Pobre] = new Transporte[Pobre](zeDaSilva, greycyKelly)

  /* nem compila!
  Rico é Passageiro; Pobre é Passageiro
  mas Transporte[Rico] e Transporte[Pobre] não são Transporte[Passageiro]
  isso é a Invariância! */
  //Engarrafamento.prende(ferrari)
  //Engarrafamento.prende(onibus)

}