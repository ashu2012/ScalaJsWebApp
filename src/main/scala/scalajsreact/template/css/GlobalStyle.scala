package scalajsreact.template.css

import scalacss.Defaults._
import scalajsreact.template.components.TopNav.Style.style

object GlobalStyle extends StyleSheet.Inline {

  import dsl._

  style(
    unsafeRoot("body")(
      margin.`0`,
      padding.`0`,
      fontSize(14.px),
      fontFamily := "Roboto, sans-serif"
    )
  )
  val toggle = style(
    display.none,

    unsafeChild("a")(
      textDecoration:=none,
      color.white,
      display.block,
      fontSize(25.px)

    ),
    media.maxWidth(767.px)(
      alignItems.center,
      display.flex
    )
  )

  val
}
