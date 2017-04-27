package tests
import chain._

/**
  * @author lmignot
  */
class ChainOfResponsibilityTest extends BaseTest {

  private lazy val AudioHandlerName = "Audio Handler"
  private lazy val DocHandlerName = "Doc Handler"
  private lazy val ExcelHandlerName = "Excel Handler"
  private lazy val ImageHandlerName = "Image Handler"
  private lazy val VideoHandlerName = "Video Handler"
  private lazy val TextHandlerName = "Text Handler"

  private lazy val AudioFilePath = "/home/myhome/music"
  private lazy val AudioFileName = "Boop.mp3"
  private lazy val AudioFileType = "mp3"

  private lazy val ErrorMessage = "File not supported"
  private lazy val ErrorPath = "/home/some/stuff"
  private lazy val ErrorFileName = "Suspicious.cmd"
  private lazy val ErrorFileType = "cmd"


  var file: File = _
  val imageHandler = ImageFileHandler(ImageHandlerName)
  val videoHandler = VideoFileHandler(VideoHandlerName, imageHandler)
  val audioHandler = AudioFileHandler(AudioHandlerName, videoHandler)
  val excelHandler = ExcelFileHandler(ExcelHandlerName, audioHandler)
  val docHandler = DocFileHandler(DocHandlerName, excelHandler)
  val textHandler = TextFileHandler(TextHandlerName, docHandler)

  describe("A file handler") {
    it("Should pass the file along the chain until it has been processed") {
      Given("An Audio File")
      file = File(AudioFileName, AudioFileType, AudioFilePath)

      When("It is processed by a non-audio Handler")
      val result = textHandler.process(file)

      Then("It should be passed along until the correct Handler has processed it")
      result should be (s"Process and saving $AudioFileType file... by $AudioHandlerName")
    }

    it("Should provide an error message when an unsupported file type is processed") {
      Given("Some File")
      file = File(ErrorFileName, ErrorFileType, ErrorPath)

      When("It is processed by any Handler")
      val result = textHandler.process(file)

      Then("It should be passed along and an error message shown")
      result should be (ErrorMessage)
    }
  }

}
