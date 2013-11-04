package com.twitter.sbt

import sbt._
import Keys._
import sbt.ScriptedPlugin._

import java.io.{File, FileReader}
import java.util.Properties

object PackageDistPlugin extends Build {

  val SCALA_VERSION = "2.10.3"

  lazy val buildSettings = 
    Defaults.defaultSettings ++ scriptedSettings ++ 
    Seq[Setting[_]](
      sbtPlugin := true,
      organization := "com.twitter",
      name := "sbt-package-dist",
      version := "1.1.3"
    )

  lazy val root = Project(
    id = "sbt-package-dist",
    base = file("."),
    settings = buildSettings ++ 
      Seq(libraryDependencies ++= 
        Seq(
          "org.markdownj" % "markdownj" % "0.3.0-1.0.2b4",
          "org.freemarker" % "freemarker" % "2.3.16"
        )
      )
  )

}
