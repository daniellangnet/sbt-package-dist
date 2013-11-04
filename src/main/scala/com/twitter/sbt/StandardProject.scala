package com.twitter.sbt

import sbt._
import Keys._

object StandardProject extends Plugin {
  val includes: Seq[Seq[Setting[_]]] = Seq(
    Defaults.defaultSettings,
    GitProject.gitSettings,
    PackageDist.packageDistSettings
  )

  val standardProjectSettings = includes.foldLeft(Seq[Setting[_]]()) { (s, a)  => s ++ a} ++ Seq(
    exportJars := true
  )
}
