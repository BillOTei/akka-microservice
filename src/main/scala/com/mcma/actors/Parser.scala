package com.mcma.actors

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import com.mcma.actors.Forwarder.Result
import com.mcma.actors.Parser.Parse

object Parser {
  def props(forwarderActor: ActorRef): Props = Props(new Parser(forwarderActor))
  final case class Parse(file: String)
}

class Parser(forwarderActor: ActorRef) extends Actor with ActorLogging {
  def receive: PartialFunction[Any, Unit] = {
    case Parse(file) =>
      log.info(s"parsing file $file")
      forwarderActor ! Result(s"$file file was parsed")
  }
}