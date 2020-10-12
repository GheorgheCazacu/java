package com.clyde.scala

object PartialFunctionMain extends App {

  val squareRoot: PartialFunction[Int, Double] = {
    case a if a >= 0 => Math.sqrt(a)
  }

  println(squareRoot.isDefinedAt(-1))

  println(squareRoot(4))
  println(squareRoot(-1))

  /**
   * we can implement our self the methods and that is
   */
  val partialFunction: PartialFunction[Int, Double] = new PartialFunction[Int, Double](){
    def isDefinedAt(v1: Int): Boolean = v1 != 2
    override def apply(v1: Int): Double = v1
  }

}
