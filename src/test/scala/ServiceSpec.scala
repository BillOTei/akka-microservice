import akka.actor.{ActorRef, ActorSystem}
import akka.testkit.{TestKit, TestProbe}
import com.mcma.actors.Forwarder.Result
import com.mcma.actors.Parser
import com.mcma.actors.Parser.Parse
import org.scalatest.{BeforeAndAfterAll, FlatSpecLike, Matchers}

import scala.concurrent.duration._

class ServiceSpec(_system: ActorSystem)
  extends TestKit(_system)
    with Matchers
    with FlatSpecLike
    with BeforeAndAfterAll {

  def this() = this(ActorSystem("McmaAkkaSpec"))

  override def afterAll: Unit = {
    shutdown(system)
  }

//  "A Parser Actor" should "pass on a result message when instructed to" in {
//    val testProbe = TestProbe()
//    val parser: ActorRef = system.actorOf(Parser.props(testProbe.ref), "parserActor")
//    val fileName = "testFile"
//
//    parser ! Parse(fileName)
//    testProbe.expectMsg(500 millis, Result(s"$fileName file was parsed"))
//  }
}