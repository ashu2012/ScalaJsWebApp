package scalajsreact.template.components

import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalajsreact.template.models.Menu
import scalajsreact.template.routes.AppRouter.AppPage

import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._



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
  }

  case class Props(menus: Vector[Menu],
                   selectedPage: AppPage,
                   ctrl: RouterCtl[AppPage])

  implicit val currentPageReuse = Reusability.by_==[AppPage]
  implicit val propsReuse = Reusability.by((_: Props).selectedPage)

  
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

  

  //TODO to add Material Ui component
  //below for frontEnd Layout
/*
  val component = ScalaComponent
    .builder[Props]("TopNav")
    .render { _ =>
      <.div(
        
          MuiAppBar(
            title = js.defined("Title"),
            onLeftIconButtonClick = CallbackDebug.f1("onLeftIconButtonClick"),
            onRightIconButtonClick = CallbackDebug.f1("onRightIconButtonClick"),
            onTitleClick = CallbackDebug.f1("onTitleClick"),
            showMenuIconButton = true
          )()

          MuiTabs()(
            MuiTab(key = "tab1", label = js.defined("Flat Buttons"))(
              <.div(
                Style.content,
                MuiFlatButton(
                  key = "flat1",
                  label = "Default",
                  onBlur = CallbackDebug.f1("onBlur"),
                  onFocus = CallbackDebug.f1("onFocus"),
                  onKeyboardFocus = CallbackDebug.f2("onKeyboardFocus"),
                  onKeyDown = CallbackDebug.f1("onKeyDown"),
                  onKeyUp = CallbackDebug.f1("onKeyUp"),
                  onClick = CallbackDebug.f1("onClick"),
                  onMouseLeave = CallbackDebug.f1("onMouseLeave"),
                  onTouchStart = CallbackDebug.f1("onTouchStart"),
                  onMouseEnter = CallbackDebug.f1("onMouseEnter")
                )(),
                MuiFlatButton(key = "flat2", label = "Primary", primary = true)(),
                MuiFlatButton(key = "flat3", label = "Secondary", secondary = true)(),
                MuiFlatButton(key = "flat4", label = "Disabled", disabled = true)()
              )
            ),
            MuiTab(key = "tab2", label = js.defined("Raised Buttons"))(
              <.div(
                Style.content,
                MuiRaisedButton(key = "raised1", label = "Default")(),
                MuiRaisedButton(key = "raised2", label = "Primary", primary = true)(),
                MuiRaisedButton(key = "raised3", label = "Secondary", secondary = true)(),
                MuiRaisedButton(key = "raised4", label = "Disabled", disabled = true)()
              )
            ),
            MuiTab(key = "tab3", label = js.defined("Floating Action Buttons"))(
              <.div(
                Style.content,
                MuiFloatingActionButton(key = "floating1")(ActionGrade()()),
                MuiFloatingActionButton(key = "floating2", mini = true)(ActionGrade()()),
                MuiFloatingActionButton(key = "floating3", secondary = true)(ActionGrade()()),
                MuiFloatingActionButton(key = "floating4", secondary = true, mini = true)(
                  ActionGrade()())
              )
            ),
            MuiTab(key = "tab4", label = js.defined("Icon Buttons"))(
              <.div(
                Style.content,
                MuiIconButton(onClick = CallbackDebug.f1("onClick"))(ActionGrade()())
              )
            )
          )
          
        )
      
    }
    .build
*/




  def apply(props: Props) = component(props)

}
