package com.clyde.scala.collections

object TuplesMain extends App {
  val dogInfo = ("Clyde", 17, 15)
  // name, weight, age

  val weightMap = "Clyde" -> 17

  dogInfo.productIterator.foreach(x => println(x))
  dogInfo.productIterator.foreach(println)

}
