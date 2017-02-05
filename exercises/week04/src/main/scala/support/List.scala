package support

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def apply[A] (el: A*): List[A] =
    if (el.isEmpty) Nil
    else Cons(el.head, apply(el.tail: _*))

}