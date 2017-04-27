package tests

import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FunSpec, GivenWhenThen, Matchers}

/**
  * @author lmignot
  */
trait BaseTest extends FunSpec with Matchers with GivenWhenThen
