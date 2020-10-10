package com.clyde.scala

object MonoidMain extends App {

  trait Monoid[A] {
    def op(a1: A, a2: A): A

    def zero: A
  }

  trait Mon[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]

    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

    def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] =
      flatMap(fa)(a => map(fb)(b => f(a, b)))
  }

}
