package com.mcma.actors

import akka.actor.{Actor, ActorLogging, Props}

object DeviceManager {
  def props: Props = Props[DeviceManager]

  final case class RequestTrackDevice(groupId: String, deviceId: String)
  final case object DeviceRegistered
}

class DeviceManager extends Actor with ActorLogging {
  override def receive: Receive = ???
}