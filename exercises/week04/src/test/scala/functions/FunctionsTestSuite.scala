package functions

import functions.Funcs._
import list._
import org.scalatest.FunSuite

class FunctionsTestSuite extends FunSuite {
  // Basics
  test("Tail removes the first element") {
    assert(tail(List(1,2,3,4)) == List(2,3,4))
  }

  test("Tail throws exception on empty List") {
    intercept[IllegalArgumentException] {
      tail(List())
    }
  }

  test("Tail throws exception on Nil List") {
    intercept[IllegalArgumentException] {
      tail(Nil)
    }
  }

  test("setHead changes the first element of the list") {
    assert(setHead(List("A", "B", "C"), "0") == List("0", "B", "C"))
  }

  test("setHead with empty list returns a new list with one element") {
    assert(setHead(List(), "X") == List("X"))
  }

  test("drop removes N elements from the front of the list") {
    assert(drop(List(1, 2, 3), 2) == List(3))
  }

  test("drop removes no elements if count parameter is less than 1") {
    assert(drop(List(1, 2, 3), -2) == List(1, 2, 3))
  }

  test("drop returns empty list if count parameter is greater than or equal to list size") {
    assert(drop(List(1, 2, 3), 3) == List())
  }

  test("drop returns empty list if list is empty") {
    assert(drop(List(), 1) == List())
  }

  test("init removes the last element") {
    assert(init(List("A", "B", "C", "D")) == List("A", "B", "C"))
  }

  test("init throws if list is empty") {
    assertThrows[IllegalArgumentException] {
      init(List())
    }
  }

  test("init throws if parameter is Nil") {
    assertThrows[IllegalArgumentException] {
      init(Nil)
    }
  }

  // Folding
  test("foldLeft computes the correct value") {
    assert(foldLeft(List("H","e","l","l","o"), "")(_ + _) == "Hello")
  }

  test("foldLeft computes the correct value given an empty list") {
    assert(foldLeft(List(), "A")(_ + _) == "A")
  }

  test("foldLeft computes the correct value given a Nil list") {
    assert(foldLeft(Nil, "A")(_ + _) == "A")
  }

  test("sum produces the correct sum") {
    assert(sum(List(1.0, 2.0, 3.0, -3.0, -2.0, -1.0)) == 0.0)
  }

  test("sum produces the correct sum given an empty list") {
    assert(sum(List()) == 0.0)
  }

  test("sum produces the correct sum given Nil") {
    assert(sum(Nil) == 0.0)
  }

  test("product produces the correct product") {
    assert(product(List(1.0, 2.0, 3.0, 4.0, 5.0)) == 120.0)
  }

  test("given an empty list, product produces 0.0") {
    assert(product(List()) == 0.0)
  }

  test("given Nil, product produces 0.0") {
    assert(product(Nil) == 0.0)
  }

  test("given negative and positive input, produces the correct negative product") {
    assert(product(List(-3.0, 6.0, 3.0)) == -54.0)
  }

  test("given 0.0, product produces the correct product") {
    assert(product(List(0.0)) == 0.0)
  }

  test("length calculates the length") {
    assert(length(List("H","e","l","l","o")) == 5)
  }

  test("length of empty List is 0") {
    assert(length(List()) == 0)
  }

  test("length of Nil is 0") {
    assert(length(Nil) == 0)
  }

  test("length works on a mixed List") {
    assert(length(List("A", 1, "B")) == 3)
  }

  test("reverse reverses the list") {
    assert(reverse(List("H","e","l","l","o")) == List("o","l","l","e","H"))
  }

  test("reverse reverses the list of Ints") {
    assert(reverse(List(1,2,3,4,5,6)) == List(6, 5, 4, 3, 2, 1))
  }

  test("given an empty List, reverse returns an empty List") {
    assert(reverse(List()) == List())
  }

  test("given Nil, reverse returns an empty List") {
    assert(reverse(Nil) == List())
  }

  test("flatten flattens the nested list") {
    assert(flatten(List(List(1, 2, 3), List(4, 5, 6))) == List(1, 2, 3, 4, 5, 6))
  }

  test("flatten flattens the nested lists") {
    assert(flatten(List(List(), List(4, 5, 6))) == List(4, 5, 6))
  }

  // Map and Filter
  test("map creates a new list of the correct values") {
    assert(map(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))(_ + 1) == List(2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
  }

  test("map applies the function correctly") {
    assert(map(List("a","b","c"))(_.toUpperCase()) == List("A","B","C"))
  }

  test("filter filters the list") {
    assert(filter(List(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5))(_ > 0) == List(1, 2, 3, 4, 5))
  }

  test("flatMap maps and flattens") {
    assert(flatMap(List(1, 2, 3, 4, 5))(x => List(x, x + 20)) ==
      List(1, 21, 2, 22, 3, 23, 4, 24, 5, 25))
  }

  // Combined

  test("maxAverage calculates the max average") {
    val list = map(List(1.0, 2.0, 3.0, 4.0, 5.0))(x => (x, x + 10))
    assert(maxAverage(list) == 13.0)
  }

  test("maxAverage calculates the max average of negative and positive numbers") {
    val list = map(List(-4.0, -2.0, -16.0, -12.0))(x => (x, x + 10))
    assert(maxAverage(list) == 1.5)
  }

  // how would we test this sort of edge case given NaN != NaN
  ignore("maxAverage calculates the max average of an empty list (should be NaN)") {
    assert(maxAverage(List()) == Double.NaN)
  }

  test("variance calculates the correct variance") {
    val v = variance(List(1.0, 2.0, 3.0, 4.0, 5.0))
    assert(v == 2.0, "If you got 2.5, you divided by the wrong thing, probably.")
  }
}
