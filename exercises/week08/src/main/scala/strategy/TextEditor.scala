package strategy

/**
  * Week 08 strategy pattern exercise
  *
  * 1. Strategy pattern allows one to execute some algorithm or function
  *    in different ways without having to modify the executing class
  *    Given the TextEditor example, one could implement different String
  *    manipulations depending on requirements without surplus code in
  *    the TextEditor class
  * 2. It is appropriate any time some specific algorithmic/functional
  *    requirement may change at runtime
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
