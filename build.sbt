name := "akka-microservice"

version := "1.0"

scalaVersion := "2.12.4"

lazy val akkaVersion = "2.5.3"
lazy val playWSVersion = "1.1.3"

libraryDependencies ++= Seq(
  // Akka dependencies
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "com.typesafe.akka" %% "akka-remote" % akkaVersion,
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",

  // Log dependencies
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "io.sentry" % "sentry-logback" % "1.6.4",
  "org.codehaus.janino" % "janino" % "2.7.8",

  // Http client, json and xml parsing
  "com.typesafe.play" %% "play-ahc-ws-standalone" % playWSVersion,
  "com.typesafe.play" %% "play-ws-standalone-xml" % playWSVersion,
  "com.typesafe.play" %% "play-ws-standalone-json" % playWSVersion
)
