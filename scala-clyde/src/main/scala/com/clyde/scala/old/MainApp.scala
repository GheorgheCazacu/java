package com.clyde.scala.old

object MainApp extends App {
  println(new Owl)

  val list: List[Int] = List(10, 20, 30, 40, 50)

  val sum = (a: Int, b: Int) => a + b
  val result = list.foldLeft(0)(sum(_, _))

  println(result)

}
