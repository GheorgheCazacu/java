package com.clyde.scala

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration._

object FutureMain extends App {
  for(i <- 1 to 30){
    Future{
      print("World ")
    }
    print("Hello ")
  }

  def calculate: Future[Int] = {
    val future1 = Future(1 + 2)
    val future2 = Future(3 + 4)
    for {
      result1 <- future1
      result2 <- future2
    } yield result1 + result2
  }
  println()
  calculate.onComplete(x => println(x))

  Await.result(calculate, Duration.Inf)

}
