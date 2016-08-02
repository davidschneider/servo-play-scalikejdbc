package models

case class User(id: Long, firstName: String, lastName: String, email: String, title: String, phoneNumber: String, isAdmin: Boolean, active: Boolean)