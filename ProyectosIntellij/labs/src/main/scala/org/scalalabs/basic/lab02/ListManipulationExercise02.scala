package org.scalalabs.basic.lab02

import scala.collection.mutable.ListBuffer
 import sys._


object ListManipulationExercise02 {

  /**
   * Find the maximum element in a list, e.g. maxElementInList(List(1,9,3,5)) == 9
   * As usual, various ways exist: pattern matching, folding, ...
   */
  def maxElementInList(l: List[Int]): Int = {
    l.max
  }

  /**
   * Calculate the sum of the equally position elements
   * of the two list
   */
  def sumOfTwo(l1: List[Int], l2: List[Int]): List[Int] = {

    if (l1.isEmpty) l2
    else if (l2.isEmpty) l1
    else {
      l1.zip(l2).map {
        case (x, y) => x + y
      }
    }

  }

  /**
   * For this exercise preferably make use of the sumOfTwo
   * method above
   */
  def sumOfMany(l: List[Int]*): List[Int] = {

    /*
    println(l.size)
    var aux = sumOfTwo(l(0), l(1))
    aux = sumOfTwo(aux, l(2))
   */
    var aux: List[Int] = sumOfTwo(l(0), l(1))
    for (i <- 2 to l.size - 1) {
      aux = sumOfTwo(aux, l(i))
    }
    aux
  }

  case class Person(age: Int, firstName: String, lastName: String)

  /**
   * The following method is implemented in the most in-elegant way we could think of.
   * The idea is to re-write the method into more functional style. In the end, you
   * may be able to achieve the same functionality as implemented below
   * in a one-liner.
   */
  def separateTheMenFromTheBoys(persons: List[Person]): List[List[String]] = {
    /*
    var boys: ListBuffer[Person] = new ListBuffer[Person]()
    var men: ListBuffer[Person] = new ListBuffer[Person]()
    var validBoyNames: ListBuffer[String] = new ListBuffer[String]()
    var validMenNames: ListBuffer[String] = new ListBuffer[String]()

    for (person <- persons) {
        if (person.age < 18) {
          boys += person
        } else {
          men += person
        }
    }

    var sortedBoys = boys.toList.sortBy(_.age)
    var sortedMen = men.toList.sortBy(_.age)

    for (boy <- sortedBoys) {
      validBoyNames += boy.firstName
    }
    for (man <- sortedMen) {
      validMenNames += man.firstName
    }
    List(validBoyNames.toList, validMenNames.toList)
  }*/

    /* 1ra opcions
    val men: List[Person] = persons.filter(person => person.age >= 18)
    var sortedMen = men.toList.sortBy(_.age)
    val menName = for (person <- sortedMen) yield person.firstName

    val boys = persons.filter(person => person.age < 18)
    var sortedBoys = boys.toList.sortBy(_.age)
    val boysNames = for (person <- sortedBoys) yield person.firstName


*/
    val partition: (List[Person], List[Person]) = persons.partition(person => person.age >=18)

    val sortedMen = partition._1.sortBy(_.age)
    val menName = for (person <- sortedMen) yield person.firstName

    val sortedBoys = partition._2.toList.sortBy(_.age)
    val boysNames = for (person <- sortedBoys) yield person.firstName

    val result: List[List[String]] = List(boysNames, menName)
    result
  }
}