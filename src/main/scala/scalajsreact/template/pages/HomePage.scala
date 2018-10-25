package scalajsreact.template.pages

import scalajsreact.template.components.items.{NewsTrending, ProductListingBanner}
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalatags.text
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._


// TODO page bacground to have image
// and boots trapo css wirth MAterial UI design for both browser and
// mobile
object HomePage {

  object Style extends StyleSheet.Inline {
    import dsl._
    val content = style(textAlign.center,
                        fontSize(30.px),
                        minHeight(450.px),
                        paddingTop(40.px),
      display.flex,
      flexWrap.wrap,
      flexDirection.column
    )
  }

  val component =
    ScalaComponent.builder
      .static("HomePage")(<.div(Style.content)( ProductListingBanner(ProductListingBanner.Props(true)),
       NewsTrending(NewsTrending.Props("no data"))))
      .build

  def apply() = component()
}
