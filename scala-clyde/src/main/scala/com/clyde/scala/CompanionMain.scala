package com.clyde.scala

object CompanionMain extends App {

  class UserAccount {
  }

  object UserAccount {
    private val userName = "clyde"
    private val password = "clyde-password"

    def apply(): UserAccount = new UserAccount()
  }

  val u: UserAccount = UserAccount()


}
