package list

import org.scalatest.FunSuite

/**
  * [[List]] tests
  */
class ListTest extends FunSuite {

  test("A list has a head and a tail") {
    val l = List(1,2,3)
    assert(l.head == 1)
    assert(l.tail == List(2,3))
  }

  test("An empty list is Nil") {
    assert(List() == Nil)
  }

  test("An empty list is empty") {
    assert(List().isEmpty)
  }

  test("A list containing elements is not empty") {
    assert(!List(1, 2, 3).isEmpty)
  }

  test("Accessing head on an empty list throws") {
    intercept[NoSuchElementException] {
      List().head
    }
  }

  test("Accessing tail on an empty list throws") {
    intercept[UnsupportedOperationException] {
      List().tail
    }
  }

  test("List.reverse reverses the list") {
    assert(List(1,2,3).reverse == List(3,2,1))
  }

  test(":: prepends an element") {
    assert(4 :: List(1,2,3) == List(4,1,2,3))
  }

  test(":: prepends a list") {
    assert(List(4) :: List(1,2,3) == List(List(4),1,2,3))
  }

  test("::: concatenates 2 lists") {
    assert(List(4,5,6) ::: List(1,2,3) == List(4,5,6,1,2,3))
  }
}
