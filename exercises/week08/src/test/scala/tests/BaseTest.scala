package tests

import org.scalamock.scalatest.MockFactory
import org.scalatest.{FunSpec, GivenWhenThen, Matchers}

/**
  * @author lmignot
  */
trait BaseTest extends FunSpec with Matchers with GivenWhenThen with MockFactory
