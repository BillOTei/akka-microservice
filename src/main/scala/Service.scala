import akka.actor.ActorSystem
import com.mcma.actors.Supervisor

import scala.io.StdIn

object Service extends App {
  implicit val system: ActorSystem = ActorSystem("test-job-system")

  try {
    // Create top level supervisor
    val supervisor = system.actorOf(Supervisor.props(), "jobSupervisor")
    supervisor ! "Job supervisor actor up and running"

    // Exit the system after ENTER is pressed
    StdIn.readLine()
  } finally {
    system.terminate()
  }
}