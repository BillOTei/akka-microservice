package com.mcma.actors

import akka.actor.{ Actor, ActorLogging, Props }

object Supervisor {
  def props(): Props = Props(new Supervisor)
}

class Supervisor extends Actor with ActorLogging {
  override def preStart(): Unit = {
    log.info("Service application started")
    throw new Exception("test sentry")
  }
  override def postStop(): Unit = log.info("Service application stopped")

  // No need to handle any messages
  override def receive: Actor.emptyBehavior.type = Actor.emptyBehavior
}