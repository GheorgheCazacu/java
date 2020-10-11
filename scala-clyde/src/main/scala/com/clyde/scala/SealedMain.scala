package com.clyde.scala

object SealedMain extends App {

  sealed trait Answer
  case object Yes extends Answer
  case object No extends Answer

  println(No)

  sealed trait Contents
  case class Water(purity: Int) extends Contents
  case class Whiskey(label: String) extends Contents

  sealed trait Container[C] {def contents: C}
  case class Glass[C] (contents: C) extends Container[C]
  case class Jar[C] (contents: C) extends Container[C]

  sealed trait Filler[C <: Contents, CC <: Container[C]] {
    def fill(c: C): CC
  }

  class FillerJarWithWhisky extends Filler[Whiskey, Jar[Whiskey]] {
    override def fill(c: Whiskey): Jar[Whiskey] = ???
  }

}
