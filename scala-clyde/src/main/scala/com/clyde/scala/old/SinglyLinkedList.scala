package com.clyde.scala.old

object SinglyLinkedList extends App {

  sealed trait List[+A]

  case object Nil extends List[Nothing]

  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List {

    def tail[A](xs: List[A]): List[A] = xs match {
      case Nil => Nil
      case Cons(x, xs) => xs
    }

    def sum(ints: List[Int]): Int = ints match {
      case Nil => 0
      case Cons(x, xs) => x + sum(xs)
    }

    def sum(ints: List[String]): String = ints match {
      case Nil => ""
      case Cons(x, xs) => x + sum(xs)
    }

    def product(ds: List[Double]): Double = ds match {
      case Nil => 1
      case Cons(0.0, _) => 0.0
      case Cons(x, xs) => x * product(xs)
    }

    def apply[A](as: A*): List[A] =
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))

    def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B =
      as match {
        case Nil => z
        case Cons(x, xs) => f(x, foldRight(xs, z)(f))
      }

    def sum2(as: List[Int]): Int = foldRight(as, 0)((x, y) => (x + y))


  }

  val ex1: List[Double] = Nil
  val ex2: List[Int] = Cons(1, Cons(10, Nil))
  val ex3: List[String] = Cons("a", Cons("b", Nil))
//
//  println(sum(ex2))
//  println(sum(ex3))
//
//  println(tail(ex2))
//  println(sum2(ex2))

}
