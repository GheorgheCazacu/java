package com.clyde.scala.collections

object ListMain extends App {

  case class Person(name: String, age: Int)

  implicit val ordering: Ordering[Person] = Ordering.fromLessThan(_.name < _.name)


  val l: List[Person] = List(new Person("name", 30),
    Person("another", 29),
    Person("Stuff", 12)
  )

  print(l.sorted)

  Ordered

}
