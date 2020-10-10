package com.clyde.scala

object ParametersMain extends App {


  def sayHelloToClyde(name: String): Unit = {
    println(s"Hello, Clyde from $name!")
    name
  }

  sayHelloToClyde("Gigi")
  println("========")

  def sayHelloToClydeByName(name: => String): String = {
    println("Hello, Clyde!")
    println(s"$name")
    name
  }

  val nameVal = {
    println("nameVal function");
    "Gigi"
  }
  def nameDef = {
    println("nameDef function");
    "Gigi"
  }

  sayHelloToClydeByName(nameVal)
  println("========")
  sayHelloToClydeByName(nameDef)

}
