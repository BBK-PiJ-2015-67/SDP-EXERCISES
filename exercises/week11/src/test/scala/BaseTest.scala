package test
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FunSpec, GivenWhenThen, Matchers}

trait BaseTest extends FunSpec with Matchers with GivenWhenThen
