package utils

import DomainObjects.Products
import org.kie.api.{KieBase, KieServices}
import org.kie.internal.command.CommandFactory;

/**
  * Created by 396885 on 07/04/2017.
  */
object DroolsDriver {

  //private lazy val kieServices: KieServices = KieServices.Factory.get()
  //private lazy val kContainer: KieContainer = kieServices.getKieClasspathContainer()

  //def kieBase: KieBase = kContainer.getKieBase

//  def newStatelessSession: StatelessKieSession = kContainer.newStatelessKieSession()

 // def executeStateless(facts: List[Any]) = newStatelessSession.execute(facts)

  //def newSEssion = kContainer.newKieSession

  def applyRules(base: KieBase, p : Products): Products = {
    val session = base.newStatelessKieSession()
    session.execute(CommandFactory.newInsert(p))
    p
  }

  def loadRules: KieBase = {
    val kieServices = KieServices.Factory.get
    val kieContainer = kieServices.getKieClasspathContainer
    kieContainer.getKieBase
  }

}
