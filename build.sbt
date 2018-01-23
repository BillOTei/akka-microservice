name := "akka-microservice"

version := "1.0"

scalaVersion := "2.12.4"

lazy val akkaVersion = "2.5.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "io.sentry" % "sentry-logback" % "1.6.4",
  "org.codehaus.janino" % "janino" % "2.7.8"
)