package scalajsreact.template.components.items


import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom._

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.dom


object ordertracking {

  val component = ScalaComponent.builder
    .static("Current Order")(<.div(" See Live order tracking below:-   "))
    .build

  def apply() = component().vdomElement



}
