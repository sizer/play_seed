name := """play-java-seed"""
organization := "jp.co.sensemaking"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.8"

libraryDependencies += guice
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18"
libraryDependencies += "org.projectlombok" % "lombok"% "1.18.16"
