package list

import scala.annotation.tailrec

sealed trait List[+A] {
  final def ::[B >: A](x : B): List[B] = Cons(x, this)

  final def :::[B >: A](prefix : List[B]): List[B] = {
    @tailrec
    def helper(acc : List[B], other : List[B]) : List[B] = other match {
      case hd :: tl => helper(hd :: acc, tl)
      case Nil => acc
    }
    helper(this, prefix.reverse())
  }

  final def reverse[B >: A] (): List[B] = this match {
    case hd :: tl => tl.reverse() ::: List(hd)
    case Nil => Nil
  }
}
case object Nil extends List[Nothing]
case class Cons[+A] (head: A, tail: List[A]) extends List[A]

object List {
  final def apply[A] (el: A*): List[A] =
    if (el.isEmpty) Nil
    else Cons(el.head, apply(el.tail: _*))
}

object :: {
  final def unapply[A] (a: List[A]): Option[(A, List[A])] = a match {
    case Cons(hd, tl) => Some(hd -> tl)
    case Nil => None
  }
}
