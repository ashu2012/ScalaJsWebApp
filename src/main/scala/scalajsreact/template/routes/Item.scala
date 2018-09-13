package scalajsreact.template.routes

import scalajsreact.template.components.items.{CallbackTest, Item1Data, Item2Data, ItemsInfo, CameraTest,Login}
import scalajsreact.template.pages.ItemsPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import japgolly.scalajs.react.vdom.VdomElement

sealed abstract class Item(val title: String,
                           val routerPath: String,
                           val render: () => VdomElement)

object Item {

  case object Info extends Item("Info", "info", () => ItemsInfo())

  case object Item1 extends Item("Item1", "item1", () => Item1Data())

  case object Item2 extends Item("Item2", "item2", () => Item2Data())

  case object CallbackTestMenuItem extends Item("CallbackTest", "CallbackTest", () => CallbackTest())


  case object LoginMenuItem extends Item("Login", "Login", () => Login())


  case object CameraTestMenuItem extends Item("Camera", "CameraTest", () => CameraTest())

  val menu = Vector(Info, Item1, Item2,CallbackTestMenuItem ,LoginMenuItem, CameraTestMenuItem)

  val routes = RouterConfigDsl[Item].buildRule { dsl =>
    import dsl._
    menu
      .map { i =>
        staticRoute(i.routerPath, i) ~> renderR(
          r => ItemsPage(ItemsPage.Props(i, r)))
      }
      .reduce(_ | _)
  }
}
