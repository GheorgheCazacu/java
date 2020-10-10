package com.clyde.scala.old

//trait Node[A] {
//  val value: A
//  val left: Node[A]
//  val right: Node[A]
//}

trait NodeTrait[+A]
case class Node[+A](value: A, left: Node[A], right: Node[A]) extends NodeTrait[A]

class Tree[+A](root: Node[A]) extends NodeTrait[A] {
  val _root: Node[A] = root
  override def toString = s"Tree(), root ${_root}"
}

object TreeApp extends App {

  val tree: Tree[String] = new Tree[String](
    new Node[String]("Root",
    new Node[String]("left", null, null),
    new Node[String]("right", null, null)))


  println(tree)
}

object Trees extends App {

  val people = Set(
    "Alice",
    "Bob",
    "Charlie",
    "Derek",
    "Edith",
    "Fred")
  val ages = Map( "Alice" -> 20, "Bob" -> 30, "Charlie" -> 50, "Derek" -> 40, "Edith" -> 10, "Fred" -> 60)
  val favoriteColors = Map( "Bob" -> "green", "Derek" -> "magenta", "Fred" -> "yellow")
  val favoriteLolcats = Map( "Alice" -> "Long Cat", "Charlie" -> "Ceiling Cat", "Edith" -> "Cloud Cat")

  def getFavoriteColor(name: String): String = favoriteColors.getOrElse(name, "beige")

  def printColors(fc: Map[String, String]): String =
    fc.foldRight("")((current, next) => {current + " | " + next})

  def printColors2(): Set[String] = {
    people.map(p => s"the favorit color of $p is ${favoriteColors.get(p)}")
  }

//  println(printColors(favoriteColors))
//  printColors2.foreach(println)

  def getFromMap[A](name: String, values: Map[String, A]): Option[A] = values get name
  println(getFromMap[String]("Bob", favoriteColors))
  println(getFromMap[Int]("Bob", ages))


}