package com.clyde.scala.old

object ClydeClass extends App {

  // Note that `=>` associates to the right, so we could
  // write the return type as `A => B => C`
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = a => b => f(a, b)

  println(curry((a: String, b: String) => a + b)("A")("B"))

  def compose[A, B, C](f: B => C, g: A => B): A => C = a => f(g(a))

  println(compose((b: String) => (b + "Gigi-f |"), (a: String) => (a + "Gigi-g |"))("Start-"))


}
