package scalajsreact.template.components.items

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object Item1Data {

  val component =
    ScalaComponent.builder.static("User credits/wallet")(<.div("TODO add paytm add credits ")).build

  def apply() = component().vdomElement
}
