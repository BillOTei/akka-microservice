package com.mcma.actors

import akka.actor.{Actor, ActorLogging, ActorSelection, Props}
import com.mcma.actors.Supervisor.TestRemote

object Supervisor {
  def props(): Props = Props(new Supervisor)

  final case class TestRemote(msg: String)
}

class Supervisor extends Actor with ActorLogging {
  override def preStart(): Unit = {
    log.info("Service application started")
  }
  override def postStop(): Unit = log.info("Service application stopped")

  val remote: ActorSelection = context.actorSelection("toreplace")

  override def receive: Receive = {
    case TestRemote(m) =>
      log.info("Testing remote actor with msg: {}", m)
      remote ! m
  }
}