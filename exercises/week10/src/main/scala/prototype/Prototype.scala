package prototype

/**
  * Scala's case classes come with a copy method
  * which creates a "new" copy of the object.
  * Using java's Cloneable interface and the clone() method is
  * thus unnecessary
  *
  * This trait is then simply a marker
  */
trait Prototype {}