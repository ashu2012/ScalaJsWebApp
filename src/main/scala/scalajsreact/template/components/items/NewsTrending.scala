package scalajsreact.template.components.items
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.raw.SyntheticEvent
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom
import scalacss.internal.StyleF.P
import scalajsreact.template.routes.Item

import scala.language.postfixOps
import org.scalajs.dom.ext.Ajax
import org.scalajs.dom.raw.XMLHttpRequest

object NewsTrending {

  implicit val currentPageReuse = Reusability.by_==[Item]
  implicit val propsReuse = Reusability.by((_: Props).isDispalyed)

  case class Props(isDispalyed:Boolean )
  case class State(newsData: String)

  object style extends StyleSheet.Inline {
    import dsl._
    val bannerItem =style(
      cursor.default,
      width(100 %%),
      height(100 %%)

    )
  }

  val component = ScalaComponent
    .builder[Props]("Trending News")
    .render_P{
      P =>  <.div( <.h1("Trending Bussiness News"), <.div(^.onClick ==> ajaxRequest)(<.button("click here to simulate ajax request")))
    }
    .configure(Reusability.shouldComponentUpdate)
    .build



  def ajaxRequest(syntheticEvent: ReactMouseEvent) = {
    val contentType = ("Content-Type" -> "application/json")
    var url = "https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=aea30ab672ab45f28de1236014d6b1aa"
    import scala.concurrent.ExecutionContext.Implicits.global
    val request = Ajax.get(url, responseType="text")


    var responseText = ""
    request.map(xhr => println(xhr.responseText))
    request.onComplete {
      case xhr => {
        println("response text: " + xhr.get.responseText)
        responseText= xhr.get.responseText
        }
    }

    NewsTrending.State(newsData = responseText )
    dom.console.log(responseText)
    Callback.log(responseText)
  }

  def apply(props:Props) = component(props)


}
