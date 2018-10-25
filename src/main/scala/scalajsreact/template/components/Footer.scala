package scalajsreact.template.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object Footer {

  val component = ScalaComponent.builder
    .static("footer")(
      <.footer(
        ^.textAlign.center,
        <.div(^.borderBottom := "1px solid grey", ^.padding := "0px"),
        <.p("StockNap is market Place of India's Top Technical Analyst\n- Somesh Nayak, Nidhi Nayak, Mukul Katare, Aswani Gujral. Our Advisors will give you paid support for your queries in timely manner. "),
        <.a(^.paddingTop := "5px", ^.cursor:="pointer", <.b("privacy policy|facebook|instagram|ContactUs|Google+"))
      )
    )
    .build

  def apply() = component()
}
