package extra

object Contravariancia extends App {

  trait Tarefa
  class TarefaFrontEnd extends Tarefa
  class TarefaBackEnd extends Tarefa

  class Desenvolvedor[-T] {
    def resolveTarefa(tarefa: T): Unit = println("Tá pronto, só falta testar...")
  }
  
  object Gerente {
    def atribuiTarefaFrontEnd(tarefaFrontEnd: TarefaFrontEnd, desenvolvedorFrontEnd: Desenvolvedor[TarefaFrontEnd]) = {
      desenvolvedorFrontEnd.resolveTarefa(tarefaFrontEnd)
    }
    
    def atribuiTarefaBackEnd(tarefaBackEnd: TarefaBackEnd, desenvolvedorBackEnd: Desenvolvedor[TarefaBackEnd]) = {
      desenvolvedorBackEnd.resolveTarefa(tarefaBackEnd)
    }
  }

  val tornarSiteResponsivo: TarefaFrontEnd = new TarefaFrontEnd
  val mexerNoCSS: TarefaFrontEnd = new TarefaFrontEnd
  val otimizarSQL: TarefaBackEnd = new TarefaBackEnd
  val refatorarControllers: TarefaBackEnd = new TarefaBackEnd

  val desenvolvedorFrontEnd: Desenvolvedor[TarefaFrontEnd] = new Desenvolvedor[TarefaFrontEnd]
  val desenvolvedorBackEnd: Desenvolvedor[TarefaBackEnd] = new Desenvolvedor[TarefaBackEnd]
  val desenvolvedorGeneralista: Desenvolvedor[Tarefa] = new Desenvolvedor[Tarefa]

  Gerente.atribuiTarefaFrontEnd(tornarSiteResponsivo, desenvolvedorFrontEnd)
  Gerente.atribuiTarefaBackEnd(otimizarSQL, desenvolvedorBackEnd)

  Gerente.atribuiTarefaFrontEnd(mexerNoCSS, desenvolvedorGeneralista)
  Gerente.atribuiTarefaBackEnd(refatorarControllers, desenvolvedorGeneralista)

}
