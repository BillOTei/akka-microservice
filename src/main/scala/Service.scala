import akka.actor.ActorSystem
import com.mcma.actors.Supervisor

import scala.io.StdIn

object Service extends App {
//  val system: ActorSystem = ActorSystem("McmaAkka")
//
//  val forwarder: ActorRef = system.actorOf(Forwarder.props, "forwarderActor")
//  val parser: ActorRef = system.actorOf(Parser.props(forwarder), "parserActor")
//
//  parser ! Parse("testReleve.xls")
  val system = ActorSystem("service-system")

  try {
    // Create top level supervisor
    val supervisor = system.actorOf(Supervisor.props(), "service-supervisor")
    // Exit the system after ENTER is pressed
    StdIn.readLine()
  } finally {
    system.terminate()
  }
}