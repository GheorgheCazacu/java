package com.clyde.scala

object CompanionMain extends App {

  // object is having as default val on parameters
  // still you can add a var with ease 
  class Person(val name: String, var age: Int)

  val p = new Person("Name", 20)
  p.age = 2
  //  p.name = "Gigi"



  class UserAccount {
  }

  object UserAccount {
    private val userName = "clyde"
    private val password = "clyde-password"

    def apply(): UserAccount = new UserAccount()
  }

  val u: UserAccount = UserAccount()


}
