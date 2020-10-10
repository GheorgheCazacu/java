package com.clyde.scala.old

object FunObjectMain extends App {

  trait Notifier {
    val notificationMessage: String

    def printNotification(): Unit = {
      println(notificationMessage)
    }

    def clear()
  }

  class NotifierImpl(val notificationMessage: String) extends Notifier {
    override def clear(): Unit = System.out.println("cleared")
  }

  val ni: NotifierImpl = new NotifierImpl("message")

  ni.printNotification()

  object WeekDay extends Enumeration {
    type WeekDay = Value
    val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
  }

  println(s"Monday is ${WeekDay.Mon.id}")

  println(WeekDay.Fri.id)


  trait Monoid[A] {
    def combine(x: A, y: A): A

    def empty: A
  }

  def associativeLaw[A](x: A, y: A, z: A)(implicit m: Monoid[A]): Boolean = {
    m.combine(x, m.combine(y, z)) == m.combine(m.combine(x, y), z)
  }

  def identityLaw[A](x: A)(implicit m: Monoid[A]): Boolean = {
    (m.combine(x, m.empty) == x) && (m.combine(m.empty, x) == x)
  }

  val l: List[String] = List("Gigi", "este", "destept")

  val monoid = new Monoid[String] {
    override def combine(x: String, y: String): String = x.concat(" ").concat(y)

    override def empty: String = ""
  }

  println(l.foldLeft(monoid.empty)(monoid.combine))

  val result: Integer = 22
  println(s"this is the result $result")
  println(s"this is the result ${result}")


  def processCall(call: String) = {
    def processParameter(parameter: String) = {
      // local function
    }

    for (i <- 1 to 10) {
      processParameter("strin_" + i)
    }
  }

  def myMethod(x: Int): Int = x + 1

  val myFunction = (x: Int) => x + 1

  println(myFunction)
  println(myFunction(2))


  val list: List[Int] = List(1, 5, 6, 7)
  println(list.filter(_ > 5))

  trait Semigroup[A] {
    def combine(x: A, y: A): A
  }

  trait MonoidDoi[A] extends Semigroup[A] {
    def empty: A
  }

  val f = (_: Int) + (_: Int)

  println(f.apply(20, 33))
  println(f(20, 33))

  val catsMonoid = new cats.Monoid[String] {
    override def empty: String = ???

    override def combine(x: String, y: String): String = ???
  }


  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  val listFunctor = new Functor[List] {
    override def map[A, B](as: List[A])(f: A => B): List[B] = as map f
  }

  /**
   * These are not partially defined functions!
   */
  object PartiallyAppliedFunctions {

    val greaterOrEqual = (a: Int, b: Int) => a >= b
    val lessOrEqual = (a: Int, b: Int) => a <= b

    def greaterOrEqualCurried(b: Int)(a: Int) = a >= b

    def lessOrEqualCurried(b: Int)(a: Int) = a <= b

    val greaterOrEqualCurriedVal: (Int) => (Int) => Boolean = b => a => a >= b
    val lessOrEqualCurriedVal: (Int) => (Int) => Boolean = b => a => a <= b
  }


  val squareRoot: PartialFunction[Int, Double] = {
    case a if a >= 0 => Math.sqrt(a)
  }

  println(squareRoot.isDefinedAt(-1))

  println(squareRoot(4))
  println(squareRoot(-1))


  def callSpeak[A <: {def speak(): Unit}](obj: A) {
    // code here ...
    obj.speak()
  }

  class Dog {
    def speak() {
      println("woof")
    }
  }

  class Klingon {
    def speak() {
      println("Qapla!")
    }
  }

  object DuckTyping extends App {
    def callSpeak[A <: {def speak(): Unit}](obj: A) {
      obj.speak()
    }

    callSpeak(new Dog)
    callSpeak(new Klingon)
  }

  val valueLeft: Either[String, Int] = Left("This is an error")
  val valueRight: Either[String, Int] = Right(10)


}
