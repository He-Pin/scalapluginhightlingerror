ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.15"

lazy val root = (project in file("."))
  .settings(
    name := "scalaHightlight"
  )

// https://mvnrepository.com/artifact/com.lihaoyi/fastparse
libraryDependencies += "com.lihaoyi" %% "fastparse" % "3.1.1"
