package iterator

import java.util.Iterator

class ShapeIterator(private var shapes: Array[Shape]) extends Iterator[Shape] {

  private var iterator = shapes.iterator

  override def hasNext: Boolean = iterator.hasNext

  override def next(): Shape = iterator.next()

  override def remove(): Unit = iterator = iterator.drop(1)
}