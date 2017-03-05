package strategy

/**
  * Week 08 strategy pattern exercise
  *
  * Q1. Strategy pattern allows one to execute some algorithm or function
  *    in different ways without having to modify the object's behaviour.
  *    It also allows one to change the object's behaviour dynamically -
  *    by just providing a new "strategy" to the object
  *    Given the TextEditor example, one could implement different String
  *    manipulations depending on requirements without surplus code in
  *    the TextEditor class
  *
  * Q2. It is appropriate any time some algorithmic/functional
  *    requirement may change at runtime, or if we would otherwise have to
  *    add behaviour to a parent class that is not relevant to some of
  *    its sub-classes
  *
*/

/**
  * A TextEditor
  * This class takes a function in its constructor that is used to
  * manipulate the text
  *
  * @param f Any function that takes a String and returns a String
  */
case class TextEditor(f: String => String) {
  def publishText(s: String): String = f(s)
}
