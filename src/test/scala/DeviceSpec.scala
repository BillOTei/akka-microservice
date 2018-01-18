import akka.actor.ActorSystem
import akka.testkit.{TestKit, TestProbe}
import com.mcma.actors.Device
import org.scalatest.{BeforeAndAfterAll, FlatSpecLike, Matchers}

class DeviceSpec(_system: ActorSystem)
  extends TestKit(_system)
    with Matchers
    with FlatSpecLike
    with BeforeAndAfterAll {

  def this() = this(ActorSystem("McmaAkkaSpec"))

  override def afterAll: Unit = {
    shutdown(system)
  }

  "A Device Actor" should "reply with empty reading if no consumption is known" in {
    val probe = TestProbe()
    val deviceActor = system.actorOf(Device.props("group", "device"))

    deviceActor.tell(Device.ReadConsumption(requestId = 42), probe.ref)
    val response = probe.expectMsgType[Device.RespondConsumption]
    response.requestId should ===(42)
    response.value should ===(None)
  }

  "A Device Actor" should "reply with last consumption reading" in {
    val probe = TestProbe()
    val deviceActor = system.actorOf(Device.props("group", "device"))

    deviceActor.tell(Device.RecordConsumption(666, 10.1), probe.ref)
    val response = probe.expectMsgType[Device.ConsumptionRecorded]
    response.requestId should ===(666)

    deviceActor.tell(Device.ReadConsumption(requestId = 42), probe.ref)
    val response2 = probe.expectMsgType[Device.RespondConsumption]
    response2.requestId should ===(42)
    response2.value should ===(Some(10.1))
  }
}