package com.clyde.scala

object OptionMain extends App {

  val v: Option[Int] = Option.empty
  val vSome: Option[Int] = Some[Int](22)
  println(v)
  println(vSome)

}
