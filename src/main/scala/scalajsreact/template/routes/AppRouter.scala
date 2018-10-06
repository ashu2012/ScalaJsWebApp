package scalajsreact.template.routes

import japgolly.scalajs.react.Callback
import scalajsreact.template.components.{Footer, TopNav}
import scalajsreact.template.models.Menu
import scalajsreact.template.pages.HomePage
import japgolly.scalajs.react.extra.router.{Resolution, RouterConfigDsl, RouterCtl, _}
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom

object AppRouter {

  sealed trait AppPage

  case object Home extends AppPage
  case class Items(p: Item) extends AppPage

  val config = RouterConfigDsl[AppPage].buildConfig { dsl =>
    import dsl._
    val itemRoutes: Rule =
      Item.routes.prefixPath_/("#items").pmap[AppPage](Items) {
        case Items(p) => p
      }
    (trimSlashes
      | staticRoute(root, Home) ~> render(HomePage())
      | itemRoutes)
      .notFound(redirectToPage(Home)(Redirect.Replace))
      .renderWith(layout)
      .onPostRender((prev, cur) =>                          // ← available after .notFound()
        Callback.log(s"Page changing from $prev to $cur.")) // ← our callback

  }

  val mainMenu = Vector(
    Menu("StockNap", Home),
    Menu("Login", Items(Item.Info))
  )

  def layout(c: RouterCtl[AppPage], r: Resolution[AppPage]) =
    <.div(
      TopNav(TopNav.Props(mainMenu, r.page, c)),
      r.render(),
      Footer()
    )

  //val baseUrl = BaseUrl.fromWindowOrigin

  val baseUrl =
    dom.window.location.hostname match {
      case "localhost" | "127.0.0.1" | "0.0.0.0" =>
        BaseUrl.fromWindowUrl(_.takeWhile(_ != '#'))
      case _ =>
        BaseUrl.fromWindowOrigin / "stocknap/"
    }

  val router = Router(baseUrl, config.logToConsole)
}
