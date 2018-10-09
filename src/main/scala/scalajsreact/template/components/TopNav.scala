package scalajsreact.template.components

import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalajsreact.template.models.Menu
import scalajsreact.template.routes.AppRouter.AppPage
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom
import scalacss.internal.LengthUnit.px
import scalajsreact.template.css.GlobalStyle

import scala.scalajs.js
//import scalatags.JsDom.all._
import org.querki.jquery._

object TopNav {

  object Style extends StyleSheet.Inline {

    import dsl._

    val navMenu = style(display.flex,
                        alignItems.center,
                        backgroundColor(c"#F2706D"),
                        margin(0 px , auto ),
                        padding(15 px , 15 px),
                        flexWrap.wrap,
                        justifyContent.spaceBetween,
                        listStyle := "none")

    val menuItem = styleF.bool { selected =>
      styleS(
        padding(20.px),
        fontSize(1.5.em),
        cursor.pointer,
        color(c"rgb(244, 233, 233)"),
        mixinIfElse(selected)(backgroundColor(c"#E8433F"), fontWeight._500)(
          &.hover(backgroundColor(c"#B6413E")))
      )
    }

    val fa_home = style(
      color.black,
      fontSize(40.px),
      //backgroundColor.black,
      padding(15.px),
      fontFamily:="fontAwesome"
    )



  }

  case class Props(menus: Vector[Menu],
                   selectedPage: AppPage,
                   ctrl: RouterCtl[AppPage])

  implicit val currentPageReuse = Reusability.by_==[AppPage]
  implicit val propsReuse = Reusability.by((_: Props).selectedPage)

  /* old code
  val component = ScalaComponent
    .builder[Props]("TopNav")
    .render_P { P =>
      <.header(
        <.nav(
          <.ul(
            Style.navMenu,
            P.menus.toTagMod { item =>
              <.li(
                ^.key := item.name,
                Style.menuItem(item.route.getClass == P.selectedPage.getClass),
                item.name,
                P.ctrl setOnClick item.route
              )
            }
          )
        )
      )
    }
    .configure(Reusability.shouldComponentUpdate)
    .build

*/

  case class State(displaySidePanel: String)

  case class Backend($: BackendScope[Props, State]) {


    def TogleSidePanel(e:ReactEvent)={
      println("horizontal bar are clicked")
      println(e)
      dom.console.log("toggle state for nav bar, !use this for js facade printing")
      Callback.log("horizontal bar are clicked")
      //togle side panel
      $.modState(State => {
        if (State.displaySidePanel == "block"){
          State.copy("none")
        }
        else{
          State.copy("block")
        }
      })
    }


    def render(P: Props,S:State) = {
      // I can access P and event S here directly
     // val myVar = P.nameOfProperty + 10
      <.header()(
        <.nav(Style.navMenu)(
          <.div(GlobalStyle.logo)(
            <.img(^.src:=  "https://res.cloudinary.com/dq5pqcbnq/image/upload/v1538389452/logo.png",^.width:=50.px,^.height:=50.px )
          ),<.span(^.cls := "fa-home" , Style.fa_home),
          <.div(GlobalStyle.toggle, ^.onClick ==>TogleSidePanel)(
            <.a(^.href:="#", ^.cls:= "btn-toggle" )("☰")
          )
          ,<.ul(GlobalStyle.ul,^.display:=S.displaySidePanel,
            P.menus.toTagMod { item =>
              <.li(
                ^.key := item.name,
                Style.menuItem(item.route.getClass == P.selectedPage.getClass),
                item.name,
                P.ctrl setOnClick item.route
              )
            })
        )
      )
    }
  }





  val component = ScalaComponent
    .builder[Props]("TopNav")
    .initialState(State("block"))
    //.configure(Reusability.shouldComponentUpdate)
    .renderBackend[Backend]
    .build
  

  def apply(props: Props) = component(props)

}
