package scalajsreact.template.components.items
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object CameraTest {

  val component =
    ScalaComponent.builder.static("User Camera")(<.div("TODO add camera selfi part ")).build

  def apply() = component().vdomElement

}