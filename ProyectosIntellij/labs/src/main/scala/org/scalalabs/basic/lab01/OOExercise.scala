package org.scalalabs.basic.lab01
import scala.language.implicitConversions
/**
 * The goal of this exercise is to get familiar basic OO constructs in scala
 *
 * Fix the code so that the unit test 'CurrencyExerciseTest' passes.
 *
 * In order for the tests to pass you need to do the following:
 * 




 */

/* Exercise 1:
* - Create a class Euro
* - Provide it with two constructor parameters: euro:Int, cents:Int
* - Provide the cents field with default value: 0
* - Provide an immutable field named: inCents that converts euro + cents into cents.
* - Create an object Euro with a factory method named: fromCents that creates an Euro based on cents.
* - Create a method named: + to the Euro class that adds another Euro
* - Create a method named: * to the Euro class that multiplies an Euro
*/

class Euro(val euro: Int,  val cents: Int = 0) extends Currency("EUR") with Ordered[Euro]{

  val inCents: Int = euro*100 + cents
  def + (euro :Euro):Euro = Euro(((euro.inCents+this.inCents)/100),((euro.inCents+this.inCents)%100))
  def * (factor :Int):Euro = Euro(inCents*factor/100, inCents*factor%100)

  override def toString: String ={
    if (cents > 0) symbol  +": "+ euro + ","+ cents
    else symbol  +": "+ euro + ","+ "--"
  }
  override def compare(that: Euro) ={
    this.inCents - that.inCents
  }

}
object Euro {

  def apply(euro: Int, cents: Int ) =  new Euro(euro,cents)
  def fromCents(cents: Int):Euro = {
    var centsAux = cents
    var eurosAux = 0
    if(cents > 100 ) {
      eurosAux = cents/100
      centsAux = cents%100
    }
    else{
      Euro(0,cents)
    }
    Euro(eurosAux,centsAux)
  }


}

/*
 * Exercise 2:
 * - Create an abstract class Currency
 * - Provide it with one constructor parameter: symbol:String
 * - Extend the previously created Euro class from Currency
 * - Override the toString method of Euro to represent the following String:
 *   -> symbol + ': ' + euro + ',' + cents.  E.g: EUR 200,05
 * - In case the cents are 0 use this representation:
 *   -> symbol + ': ' + euro + ',--. E.g.: EUR 200.--

*/

abstract class Currency(val symbol: String){

}

/*
 *
 * Exercise 3: DONE
 * - Mix the Ordered trait in Euro
 * - Implement the compare method
 *
 */


/*
 * Exercise 4:
 * - Provide an implicit class that adds a *(euro:Euro) method to Int
 * - Create a new currency Dollar
 * - Provide a implicit conversion method that converts from Euro to Dollar using the
 *   [[org.scalalabs.basic.lab01.DefaultCurrencyConverter]]
 *
 */


/*
 * Exercise 5:
 * - Extend the conversion method from Euro to Dollar with an implicit parameter
 *   of type [[org.scalalabs.basic.lab01.CurrencyConverter]]
 * - Use the implicit CurrencyConverter to do the conversion.
 */


