name := """play-java-seed"""
organization := "jp.co.sensemaking"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.8"

libraryDependencies += guice
libraryDependencies += "io.ebean" % "ebean" % "11.37.1"
libraryDependencies += "io.ebean.test" % "ebean-test-config" % "11.37.1"
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.15"
