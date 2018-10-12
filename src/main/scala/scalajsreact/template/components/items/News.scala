package scalajsreact.template.components.items


package scalajsreact.template.components.items


import google.maps.Data.Feature
import google.maps.LatLng
import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom._

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.dom



object News {

  case class Props(isDispalyed:Boolean , name:String,author:String, title:String, description:String, url:String, urlToImage:String, publishedAt:String, content:String )




  val component = ScalaComponent.builder
    .static("News")(<.div(" See your profile , TODO show default profile pic and user accounts details  "))
    .build

  def apply() = component().vdomElement

}
