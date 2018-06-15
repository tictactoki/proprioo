name := """proprioo"""

lazy val root = (project in file("."))

version := "1.0"

scalaVersion := "2.12.1"

scalacOptions in (Compile,run) ++= Seq("-deprecation")

libraryDependencies ++= Seq(
  "org.reactivemongo" %% "reactivemongo" % "0.12.1",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)