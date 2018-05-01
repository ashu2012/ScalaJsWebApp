package scalajsreact.template.components.items

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object Item2Data {

  val component =
    ScalaComponent.builder.static("Past Orders")(<.div("Loading Past orders ")).build

  def apply() = component().vdomElement
}
