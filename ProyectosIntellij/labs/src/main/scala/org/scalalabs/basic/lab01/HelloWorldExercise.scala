package org.scalalabs.basic.lab01

/**
 * The goal of this exercise is to get familiar with the basic language constructs of Scala.
 *
 * Fix the code so that the unit test 'HelloWorldExerciseTest' passes.
 *
 */
object HelloWorld {


	val sayHello: String = "Hello from Scala"

	def echo(text: String): String = text
}


/*================================= Objects =====================================*/


object HelloWorldClassAndObject {
	def apply(initialText:String):HelloWorldClassAndObject = {
		new HelloWorldClassAndObject {
			val text=initialText
		}
	}
}

abstract class HelloWorldClassAndObject {
	val text:String
	def echo:String = text
}


/*================================= Traits =====================================*/

object HelloWorldWithTraits extends HelloTrait with WorldTrait {

 /**
 * Hint:
 * - combine the 'helloMethod' of HelloTrait and the 'worldMethod' of WorldTrait to create a new message
 * - just replacing the FixMe string would of course be cheating :)
 */
	def hello:String = helloMethod + worldMethod
}

trait HelloTrait {
	def helloMethod:String = "Hello "
}

trait WorldTrait {
	def worldMethod:String = "World"
}



