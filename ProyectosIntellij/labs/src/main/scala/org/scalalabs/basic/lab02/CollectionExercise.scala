package org.scalalabs.basic.lab02
/**
 * This Lab contains exercises where the usage of
 * higher order collection methods can be rehearsed.
 */

import scala.collection.immutable.IndexedSeq
import sys._

object CollectionExercise01 {

  /**
   * Taken from: <a href="http://code.google.com/codejam/contest/1460488/dashboard">Problem A. Speaking in Tongues</a>
   *
   * Problem
   * The aim of this task is to translate a language into a new language called Googlerese.
   * To translate we take any message and replace each English letter with another English letter.
   * This mapping is one-to-one and onto, which means that the same input letter always gets replaced
   * with the same output letter, and different input letters always get replaced with different output letters.
   * A letter may be replaced by itself. Spaces are left as-is.
   *
   * For example (and here is a hint!), the translation algorithm includes the following three mappings:
   * 'a' -> 'y', 'o' -> 'e', and 'z' -> 'q'. This means that "a zoo" will become "y qee".
   *
   * Sample Input/Output
   * Input:
   * Case 1: ejp mysljylc kd kxveddknmc re jsicpdrysi
   * Case 2: rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd
   * Case 3: de kr kd eoya kw aej tysr re ujdr lkgc jv
   *
   * Output:
   * Case 1: our language is impossible to understand
   * Case 2: there are twenty six factorial possibilities
   * Case 3: so it is okay if you want to just give up
   *
   */

  def convert (word: String) = {
    val array: Array[Char] = word.toCharArray
    println("before: " + array.mkString)
    var result = ""

    result
  }
  def googleCodeJamGooglerese(lines: String*): Seq[String] = {
   var resultSeq:Seq[String] = Seq()
   for(line <- lines){
     resultSeq = resultSeq :+ convert(line)
   }
    resultSeq
  }
}
/*========================================================== */

object CollectionExercise02 {

  class Person(val age: Int, val name: String)

  /**
   * Take a look at the java class: {@link ImperativeSample}. The
   * groupAdultsPerAgeGroup is implemented using an imperative programming
   * style.
   * Rewrite the method groupAdultsPerAgeGroup in the ImperativeSample java class
   * using a functional approach.
   */
  def groupAdultsPerAgeGroup(persons: Seq[Person]): Map[Int, Seq[Person]] = {
    val adults: Seq[Person] = persons.filter( person => person.age >= 18)
    val grouping: Map[Int, Seq[Person]] =  adults.groupBy( person => person.age/10*10)
    grouping
  }
}

/*========================================================== */

object CollectionExercise03 {
  /**
   * Create a method that checks that each subsequent value is greater than
   * the previous one.
   * E.g.:
   * checkValuesIncrease(Seq(1,2,3)) == true
   * checkValuesIncrease(Seq(1,2,2)) == false
   */
  /*
  def checkValuesIncrease(seq: Seq[Int]): Boolean ={
  var flag = true
    val a: Int = seq.foldLeft(0)((acc,c) => if(c >= acc) {
      acc + c
    } else {
      flag = false
      acc + c
    })
  flag

  }*/

  def checkValuesIncrease(se: Seq[Int]):Boolean = {
    if(se.size == 1) true
    else (checkValuesIncrease(se.tail) &  se.head < se.tail.head)



  }



}
/*========================================================== */

object CollectionExercise04 {
  /**
   * Calculate the length of the longest word in a list of sentences.
   * To keep it simple it's ok to use String.split to extract all words of a sentence.
   * List("Who","is","longest?").foldLeft((0,""))((i,s) =>
     |   if (i._1 < s.length) (s.length,s)
     |   else i
     | )
scala> List("How","long","is","longest?").foldLeft(0)((i,s) => i max s.length)
res3: Int = 8

scala> List("How","long","is","everyone?").foldLeft(0)((i,s) => i + s.length)
res4: Int = 18
   */

  def calcLengthLongestWord(lines: String*): Int = {

    val line: Seq[Array[String]] = lines.map((l => l.split(" ")))
    val aux: Seq[String] = line.flatten
    //Otra opcion
    //aux.map(l => l.length).max

    aux.foldLeft(0)((acc,c)=> { acc max c.length })
  }
}

/*========================================================== */

object CollectionExercise05 {
  /**
   * Filter all even numbers of the given sequence using foldLeft.
   * E.g. Seq(1,2,3) is Seq(2)
   */

  def filterWithFoldLeft(seq: Seq[Int]): Seq[Int] = {

    seq.foldLeft(Seq.empty[Int])((acc,c) => if(c%2 == 0) (acc :+ c) else acc)
  }

  /**
   * Group all numbers based on whether they are even or odd using foldLeft.
   * For even use 'true' for odd use 'false'.
   * E.g: Seq(1,2,3) is Map(0 -> Seq(2), 1 -> Seq(1,3))
   */
  def groupByWithFoldLeft(seq: Seq[Int]): Map[Boolean, Seq[Int]] = {

    val aux = Map(false-> Seq(1, 2))
    val a: Seq[Int] = filterWithFoldLeft(seq)

    val ac: Map[Boolean, Seq[Int]] = seq.foldLeft(Map.empty[Boolean, Seq[Int]]) ((acc, c) =>  )

    ac
  }
}




