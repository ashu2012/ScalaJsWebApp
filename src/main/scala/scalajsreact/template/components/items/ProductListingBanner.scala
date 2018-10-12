package scalajsreact.template.components.items
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.internal.StyleF.P
import scalajsreact.template.routes.Item
import scala.language.postfixOps


object ProductListingBanner {

  implicit val currentPageReuse = Reusability.by_==[Item]
  implicit val propsReuse = Reusability.by((_: Props).isDispalyed)

  case class Props(isDispalyed:Boolean)


  val component = ScalaComponent
      .builder[Props]("Banner")
      .render_P{
        P => <.div( <.h1 ("India's Leading Investment Advisor platform "), <.img(^.src:="images/banner/flipkartvsamazonvssnapdeal.jpg",^.cursor.pointer ,^.width:= "100%" , ^.height:="100%")
        )
      }
      .configure(Reusability.shouldComponentUpdate)
      .build



  def apply(props:Props) = component(props)


}
