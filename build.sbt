name := "aSync"
version := "1.0"
scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "org.yaml"                   %  "snakeyaml"       % "1.18",
  "org.typelevel"              %  "spire_2.11"      % "0.14.1",
  "ch.qos.logback"             %  "logback-classic" % "1.1.7",
  "com.typesafe.scala-logging" %% "scala-logging"   % "3.5.0"
)