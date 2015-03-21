package org.scalalabs.basic.lab03
import sys._
/**
 * This exercise introduces you to the powerful pattern matching features of Scala.
 *
 * Pattern matching can in its essence be compared to Java's 'switch' statement,
 * even though it provides many more possibilites. Whereas the Java switch statmenet
 * lets you 'match' primitive types up to int's, Scala's pattern matching goes much
 * further. Practically everything from all types of objects and Collections
 * can be matched, not forgetting xml and a special type of class called case classes.
 *
 * Pattern matching is also often used in combination with recursive algorithms.
 *
 * For this exercise exclusively use pattern matching constructs in order to make the
 * corresponding unit test work.
 *
 * Reference material to solve these exercises can be found here:
 * Pattern matching in general: http://programming-scala.labs.oreilly.com/ch03.html#PatternMatching
 * Pattern matching in combination with partial functions: http://programming-scala.labs.oreilly.com/ch08.html#PartialFunctions
 */

object PatternMatchingExercise {

  /*************************************************************************
   *  pattern matching exercises
   * For expected solution see unittest @PatternMatchingExerciseTest
   *************************************************************************/

  def describeLanguage(s: String) = s match{
    case "Java" => "OOP"
    case "Smalltalk" => "OOP"
    case "Clojure" => "Functional"
    case "Haskell" => "Functional"
    case "Scala" => "Hybrid"
    case "C" => "Procedural"
    case "Oz" => "Unknown"

  }

  def matchOnInputType(in: Any) = in match{

    case x :String => "A string with length 8"
    case x: Int => "A positive integer"
    case Person("Jack", 39) =>  "A person with name: Jack"
   // case Seq(a,b, rest @ _ *) => "Seq with more than 10 elements"
    //case "Seq(\"first\", \"second\", \"third\", \"fourth\")" => "first: first, second: second, rest: List(third, fourth)"
    case Some(x) =>   "A Scala Option subtype"
    case None => "A Scala Option subtype"
    //case Class => "Some Scala class"
    case null => "A null value"


  }

  def older(p: Person): Option[String] =
  {
    p.age match {
      case x if x >= 18  => Some(p.name)
      case _ => None
  }


  }

  /*************************************************************************
   * Pattern matching with partial functions
   * For expected solution see @PatternMatchingExerciseTest
   *************************************************************************/

  val pf1: PartialFunction[String, String] = {

    case _ => error("fix me")

  }

  val pf2: PartialFunction[String, String] = {
    case _ => error("fix me")
  }

  val pf3:PartialFunction[String, String] = {
    case _ => error("fix me")
  }

}

case class Person(name: String, age: Int)