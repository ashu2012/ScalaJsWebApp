package scalajsreact.template

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import scalajsreact.template.css.AppCSS
import scalajsreact.template.routes.AppRouter

import org.scalajs.dom

object ReactApp extends JSApp {

  @JSExport
  override def main(): Unit = {
    AppCSS.load
    dom.console.info("Router logging is enabled. Enjoy!")
    AppRouter.router().renderIntoDOM(dom.document.body)
  }

}
