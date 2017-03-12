package tests

import composite.{HtmlElement, HtmlParentElement}

/**
  * @author lmignot
  */
class CompositeTest extends BaseTest {
  val Tag = "<html>"
  val StartTag = "<html>"
  val EndTag = "</html>"
  val BodyTag = "<body>"
  val StartBodyTag = "<body>"
  val EndBodyTag = "</body>"
  val PTag = "<p>"
  val StartPTag = "<p>"
  val EndPTag = "</p>"
  val PBody = "Testing html tag library"

  describe("HtmlElement") {

    it("should have a start and end tag and body") {
      val expected = s"$StartPTag$PBody$EndPTag"
      val el = HtmlElement(PTag)
      el.setStartTag(StartPTag)
      el.setEndTag(EndPTag)
      el.setTagBody(PBody)
      el.generateHtml should be (expected)
    }

    it("parent element should take a child element") {
      val expected = s"$StartBodyTag\n$StartPTag$PBody$EndPTag\n$EndBodyTag"
      val el = HtmlElement(PTag)
      el.setStartTag(StartPTag)
      el.setEndTag(EndPTag)
      el.setTagBody(PBody)
      val parent = HtmlParentElement(BodyTag)
      parent.setStartTag(StartBodyTag)
      parent.setEndTag(EndBodyTag)
      parent.addChildTag(el)

      parent.getChildren.head should be (el)
      parent.generateHtml should be (expected)
    }

    it("parent element without child element should generate expected html") {
      val expected = s"$StartBodyTag$EndBodyTag"
      val parent = HtmlParentElement(BodyTag)
      parent.setStartTag(StartBodyTag)
      parent.setEndTag(EndBodyTag)

      parent.generateHtml should be (expected)
      parent.getChildren should be (List())
    }

    it("parent element can contain child parent element") {
      val expected = s"$Tag\n$StartBodyTag\n$StartPTag$PBody$EndPTag\n$EndBodyTag\n$EndTag"
      val el = HtmlElement(PTag)
      el.setStartTag(StartPTag)
      el.setEndTag(EndPTag)
      el.setTagBody(PBody)
      val parent = HtmlParentElement(BodyTag)
      parent.setStartTag(StartBodyTag)
      parent.setEndTag(EndBodyTag)
      parent.addChildTag(el)
      val root = HtmlParentElement(Tag)
      root.setStartTag(StartTag)
      root.setEndTag(EndTag)
      root.addChildTag(parent)

      root.getChildren.head should be (parent)
      parent.getChildren.head should be (el)
      root.generateHtml should be (expected)
    }

    it("parent element with child should have no child once it's been removed") {
      val expected = s"$StartBodyTag$EndBodyTag"
      val el = HtmlElement(PTag)
      el.setStartTag(StartPTag)
      el.setEndTag(EndPTag)
      el.setTagBody(PBody)
      val parent = HtmlParentElement(BodyTag)
      parent.setStartTag(StartBodyTag)
      parent.setEndTag(EndBodyTag)
      parent.addChildTag(el)

      parent.getChildren.head should be (el)

      parent.removeChildTag(el)

      parent.getChildren.isEmpty should be (true)
      parent.generateHtml should be (expected)
    }

  }
}
