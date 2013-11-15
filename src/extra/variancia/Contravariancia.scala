package extra.variancia

object Contravariancia {

  trait Geral
  class FrontEnd extends Geral
  class BackEnd extends Geral

  class Desenvolvedor[-T] {
    def resolveTarefa(tarefa: T): Unit = println("Tá pronto, só falta testar...")
  }
  
  object Gerente {
    def atribuiTarefaFrontEnd(tarefaFrontEnd: FrontEnd, desenvolvedorFrontEnd: Desenvolvedor[FrontEnd]) = { 
      desenvolvedorFrontEnd.resolveTarefa(tarefaFrontEnd)
    }
    
    def atribuiTarefaBackEnd(tarefaBackEnd: BackEnd, desenvolvedorBackEnd: Desenvolvedor[BackEnd]) = {
      desenvolvedorBackEnd.resolveTarefa(tarefaBackEnd)
    }
  }

  val tornarSiteResponsivo: FrontEnd = new FrontEnd
  val mexerNoCSS: FrontEnd = new FrontEnd
  val otimizarSQL: BackEnd = new BackEnd
  val refatorarControllers: BackEnd = new BackEnd

  val desenvolvedorFrontEnd: Desenvolvedor[FrontEnd] = new Desenvolvedor[FrontEnd]
  val desenvolvedorBackEnd: Desenvolvedor[BackEnd] = new Desenvolvedor[BackEnd]
  val desenvolvedorGeneralista: Desenvolvedor[Geral] = new Desenvolvedor[Geral]

  Gerente.atribuiTarefaFrontEnd(tornarSiteResponsivo, desenvolvedorFrontEnd)
  Gerente.atribuiTarefaBackEnd(otimizarSQL, desenvolvedorBackEnd)

  Gerente.atribuiTarefaFrontEnd(mexerNoCSS, desenvolvedorGeneralista)
  Gerente.atribuiTarefaBackEnd(refatorarControllers, desenvolvedorGeneralista)

}
