package scalajsreact.template.components

import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalajsreact.template.models.Menu
import scalajsreact.template.routes.AppRouter.AppPage
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.internal.LengthUnit.px

import scala.scalajs.js
//import scalatags.JsDom.all._


object TopNav {

  object Style extends StyleSheet.Inline {

    import dsl._

    val navMenu = style(display.flex,
                        alignItems.center,
                        backgroundColor(c"#F2706D"),
                        margin.`0`,
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


    /* toggle
     .toggle{
      display: none;
      a{
        text-decoration: none;
        color: white;
        display: block;
        font-size: 25px;
      }
      @media (max-width: 767px){
        align-items: center;
        display: flex;
      }
    }

    */




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

  val component = ScalaComponent
    .builder[Props]("TopNav")
    .render_P { P =>
      <.header()(
          <.nav()(
            <.div(^.`class`:= "container-nav")(
              <.div(^.cls:= "logo")(
                <.img(^.src:=  "http://pre07.deviantart.net/a18f/th/pre/i/2014/115/1/6/pez_del_infierno_01_by_camusjpc-d7fy0rk.png",^.width:=50.px,^.height:=50.px )
              ),
              <.div(^.cls:="toggle",Style.toggle)(
                <.a(^.href:="#", ^.cls:= "btn-toggle", ^.onClick(^.))("☰")
              )
            )
        ,<.ul(Style.navMenu,^.cls:="toggle-nav",
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
    .configure(Reusability.shouldComponentUpdate)
    .build
  

  def apply(props: Props) = component(props)

}
