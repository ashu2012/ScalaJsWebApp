package scalajsreact.template.components.items

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._


//TODO add  react profile image upload
// and save it for user profile
object ItemsInfo {

  val component = ScalaComponent.builder
    .static("Profile")(<.div(" See your profile , TODO show default profile pic and user accounts details  "))
    .build

  def apply() = component().vdomElement
}
