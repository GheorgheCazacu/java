package com.clyde.scala

object TypeMain extends App {

  // right!
//  private type FooParam = {
//    val baz: List[String => String]
//    def bar(a: Int, b: Int): String
//  }
//
//  def foo(a: FooParam) = println(a)
//
//  val a = new FooParam {
//    val baz = List()
//    def bar(a: Int, b: Int): String = ""
//  }
//  foo(a)
  // ======

  trait Drink
  trait SoftDrink extends Drink
  trait Juice extends Drink

  trait Cola extends SoftDrink
  trait TonicWater extends SoftDrink

  trait OrangeJuice extends Juice
  trait AppleJuice extends Juice

  class VendingMachine[+A] {
    // ... no implementation for now
  }

  def install(softDrinkVM: VendingMachine[SoftDrink]): Unit = {
    // Installs the soft drink vending machine
    // ... no implementation for now
    // just the relation between is important at this moment
  }

  // covariant subtyping
  install(new VendingMachine[Cola])
  install(new VendingMachine[TonicWater])
  // invariant
  install(new VendingMachine[SoftDrink])
//  install(new VendingMachine[Drink])
}
