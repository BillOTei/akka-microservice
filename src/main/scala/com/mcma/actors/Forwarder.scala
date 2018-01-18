package com.mcma.actors

import akka.actor.{Actor, ActorLogging, Props}
import com.mcma.actors.Forwarder.Result

object Forwarder {
  def props: Props = Props[Forwarder]
  final case class Result(msg: String)
}

class Forwarder extends Actor with ActorLogging {
  def receive: PartialFunction[Any, Unit] = {
    case Result(msg) => log.info(s"Forwarder received (from ${sender()}): $msg")
  }
}