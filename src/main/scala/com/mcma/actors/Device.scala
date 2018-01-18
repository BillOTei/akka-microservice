package com.mcma.actors

import akka.actor.{ Actor, ActorLogging, Props }

object Device {
  def props(groupId: String, deviceId: String): Props = Props(new Device(groupId, deviceId))

  final case class ReadConsumption(requestId: Long)
  final case class RespondConsumption(requestId: Long, value: Option[Double])

  final case class RecordConsumption(requestId: Long, value: Double)
  final case class ConsumptionRecorded(requestId: Long)
}

class Device(groupId: String, deviceId: String) extends Actor with ActorLogging {
  import Device._

  var lastConsumptionReading: Option[Double] = None

  override def preStart(): Unit = log.info("Device actor {}-{} started", groupId, deviceId)
  override def postStop(): Unit = log.info("Device actor {}-{} stopped", groupId, deviceId)

  override def receive: Receive = {
    case ReadConsumption(id) => sender() ! RespondConsumption(id, lastConsumptionReading)
    case RecordConsumption(id, c) =>
      log.info("Recording consumption value {} from request {}", c, id)
      lastConsumptionReading = Some(c)
      sender() ! ConsumptionRecorded(id)
  }

}