import strategy.TextEditor
import test.BaseSpec

/**
  * AbstractFactory tests
  *
  * @author lmignot
  */
class TextFormatterSpec extends BaseSpec {
  private val TextA = "Testing text in caps formatter"
  private val TextAUC = TextA.toUpperCase
  private val TextALC = TextA.toLowerCase

  describe("A text editor") {
    it("format() should format the text according to the provided formatter") {
      def formatter(s:String): String = s.toUpperCase
      val editor: TextEditor = TextEditor(formatter)
      val res = editor.publishText(TextA)
      res should be (TextAUC)
    }

    it("format() should format the text according to any valid strategy") {
      val editor: TextEditor = TextEditor(_.toLowerCase)
      val res = editor.publishText(TextA)
      res should be (TextALC)
    }
    
  }
}