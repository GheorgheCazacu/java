package com.clyde.scala

object RangeMain extends App {

  val rangeFromTo = 1 to 10
  println(rangeFromTo)
  rangeFromTo.foreach(a => print(s"$a, "))
  println

  val rangeFromUntil = 1 until 10
  println(rangeFromUntil)
  rangeFromUntil.foreach(a => print(s"$a, "))
  println

  val rangeFromToBy2 = 0 to 10 by 2
  println(rangeFromToBy2)
  rangeFromToBy2.foreach(a => print(s"$a, "))
  println

  // we can force the type of range
  val rangeLong = 0L to 10L by 2
  println(rangeLong)
  rangeLong.foreach(a => print(s"$a, "))
  println


}
