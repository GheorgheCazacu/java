package com.clyde.scala

import java.util.Calendar

object ClosureMain extends App {

  // closure = a nested function +
  //           local variable to the outer scope

  /**
   * this method return a function
   * @param lang
   * @return
   */
  def greeting(lang: String) = {
    val currDate = Calendar.getInstance().getTime().toString
    lang match {
      case "English" => (x: String) => println("Hello, " + x + "! It is " + currDate)
      case "French" =>  (x: String) => println("Bonjour, " + x + "! It is " + currDate)
      case "Spanish" =>  (x: String) => println("Hola, " + x + "! It is " + currDate)
    }
  }

  val greetEnglish = greeting("English")
  greetEnglish("Clyde")

  val greetSpanish = greeting("Spanish")
  greetSpanish("Clyde")

  Thread.sleep(3_000)
  // the third line is going to have the same 'timestamp'
  // this means once the function become a closure it would carry around the env
  // but as it was at that time, it is not going to re-evaluate the currDate
  greetEnglish("Clyde")

}
