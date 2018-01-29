package com.mcma.actors

import akka.actor.{Actor, ActorLogging, Props}

object Supervisor {
  def props(): Props = Props(new Supervisor)

  final case class TestRemote(msg: String)
}

class Supervisor extends Actor with ActorLogging {
  override def preStart(): Unit = log.info("Test job application started")

  override def postStop(): Unit = log.info("Test job application stopped")

  override def receive: Receive = {
    case msg: String => log.info("Got message: {}", msg)

    case _ => log.warning("Got unhandled message")
  }
}