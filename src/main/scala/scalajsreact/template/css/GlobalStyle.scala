package scalajsreact.template.css

import scala.language.postfixOps
import scalacss.Defaults._
import scalajsreact.template.components.TopNav.Style.{&, style}

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
      color.black,
      display.block,
      fontSize(50.px)

    ),
    media.maxWidth(2000.px)(
      alignItems.center,
      display.flex
    )
  )
/*
https://codepen.io/AleGonzalez/pen/YWxXaj
 */

  /*
  .logo{
  display: flex;
  img{
    width: 50px;
    height: 50px;
  }
}
   */
  val logo = style(
    display.flex,
    backgroundColor.black,
    unsafeChild("img")(
      width(60.px),
      height(60.px)
    )
  )

  /*
  ul{
  list-style-type: none;
  padding: 0;
  display: flex;
  align-items: center;
  @media (max-width: 767px){
    align-items: center;
    position: absolute;
    flex-direction: column;
    top: 0;
    left: -250px;
    transition: 0.3s;
    background-color: #7f8c8d;
    width: 250px;
    height: 100%;

  }
}
ul li{
   margin: 0 10px;
  color: #fff;
  font-family: verdana;
  @media (max-width: 767px){
    margin: 15px 10px;
  }
  a{
    text-decoration: none;
    color: #fff;
  }
}
   */


  val ul = style(
    listStyleType:= none,
    //padding(0.px),
    display.flex,
    alignItems.center,
    padding(20.px),
    fontSize(0.5.em),
    cursor.pointer,
    color(c"rgb(244, 233, 233)"),
    //backgroundColor(c"#E8433F"),

    media.maxWidth(2000.px)(
      alignItems.center,
      //position.absolute,
      flexDirection.column,
      position.absolute,
      top(105.px),
      left(0.px),
      transition:=  "0.3 seconds",
      backgroundColor(Color("#F2706D")),
      //width(87.px),
      height(100.%%),
      justifyContent.flexStart,
      alignItems.center,
      display.block
    ),

    unsafeChild("li")(
      margin(0 px , 10 px),
      backgroundColor(Color("#0C0101")),
      alignItems.center,
      justifyContent.spaceBetween,
      media.maxWidth(2000.px)(
        margin(15 px , 10 px)
      ) ,
      unsafeChild("a")(
        textDecoration:= none,
        color:= "#E8433F"
      )
    )
  )




}
