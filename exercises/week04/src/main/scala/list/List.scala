package list

import scala.annotation.tailrec

/**
  * Credit where it's due
  * sources for this partial implementation of a List
  *
  * Scala source code: https://github.com/scala/scala
  * FP in Scala https://github.com/fpinscala/fpinscala
  * Module slides (Moodle)
  */

/**
  * List containing elements of type A (covariant)
  *
  * A List contains a head element, and a tail which is itself a List
  * containing a head and a tail. An empty list is handled by [[Nil]],
  * defined below
  */
sealed trait List[+A] {
  def head: A
  def tail: List[A]
  def isEmpty: Boolean

  /**
    * Prepends an element to this List
    * @param x The element to prepend
    * @return A new List with the element prepended
    */
  final def ::[B >: A](x : B): List[B] = Cons(x, this)

  /**
    * Prepends elements of a list in front of this list
    * @param prefix The list to add
    * @return A new List with the other List prepended
    */
  final def :::[B >: A](prefix : List[B]): List[B] = {
    @tailrec
    def helper(acc : List[B], other : List[B]) : List[B] = other match {
      case hd :: tl => helper(hd :: acc, tl)
      case Nil => acc
    }

    if (isEmpty) prefix
    if (prefix.isEmpty) this
    helper(this, prefix.reverse())
  }

  /**
    * Reverses the elements in a List
    * @return List with the elements in reverse order
    */
  final def reverse[B >: A] (): List[B] =  {
    var result: List[A] = Nil
    var current = this
    while (!current.isEmpty) {
      result = current.head :: result
      current = current.tail
    }
    result
  }
}

/**
  * An Empty List
  */
case object Nil extends List[Nothing] {
  override def head: Nothing =
    throw new NoSuchElementException("Trying to access head of an empty List")

  override def tail: List[Nothing] =
    throw new UnsupportedOperationException("Trying to access tail of an empty List")

  override def isEmpty: Boolean = true
}

/**
  * List container, ie
  * List(1,2,3) =
  * Cons(1, Cons(2, Cons(3, Nil)))
  * @param head The first element in the List
  * @param tail The remaining elements in the List
  */
final case class Cons[+A] (head: A, tail: List[A]) extends List[A] {
  override def isEmpty: Boolean = false
}

object List {
  /**
    * Construct a List containing all the arguments as elements
    * @param el Any number of arguments
    * @return List containing the elements
    */
  final def apply[A] (el: A*): List[A] =
    if (el.isEmpty) Nil
    else Cons(el.head, apply(el.tail: _*))
}

object :: {
  /**
    * Deconstruct a list into a Tuple where
    * the first element is the head of this List
    * and the second element is the tail of this List
    *
    * @param a List to deconstruct
    * @return Tuple(head, tail)
    */
  final def unapply[A] (a: List[A]): Option[(A, List[A])] = a match {
    case Cons(hd, tl) => Some(hd -> tl)
    case Nil => None
  }
}
