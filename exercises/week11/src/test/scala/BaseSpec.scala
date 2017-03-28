package test
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FunSpec, GivenWhenThen, Matchers}

/**
  * @author lmignot
  */
trait BaseSpec extends FunSpec with Matchers with GivenWhenThen with MockitoSugar
