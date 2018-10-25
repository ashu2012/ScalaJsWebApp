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
import scalajsreact.template.components.items.News._

import scala.scalajs.js

object NewsTrending {

  implicit val currentPageReuse = Reusability.by_==[Item]
  implicit val propsReuse = Reusability.by((_: Props).receivedData)
  implicit val statReuse = Reusability.by((_: State).newsData)

  case class Props(receivedData:String )
  case class State(newsData: String, secondsElapsed :Int)

  object style extends StyleSheet.Inline {
    import dsl._
    val bannerItem =style(
      cursor.default,
      width(100 %%),
      height(100 %%)

    )
  }

  val jsonTestData =
    """
      | {
      |	"status": "ok",
      |	"totalResults": 20,
      |	"articles": [{"source":{"id":null,"name": null},"author":"BusinessToday.In","title":"After BigBasket, Paytm in talks to buy Alibaba-owned UCWeb's India business for $500 million","description":"Paytm wants to buy Alibaba's UCWeb business to tap into a new user base, which will help it market products on a new built-up platform.","url":"https://www.businesstoday.in/current/corporate/bigbasket-paytm-in-talks-to-buy-alibaba-ucweb-india-business-dollar-500-million/story/284884.html","urlToImage":"https://smedia2.intoday.in/btmt/images/stories/vijay-shekhar-paytm-505_081918042334_101218010720.jpg","publishedAt":"2018-10-12T07:40:36Z","content":"Alibaba-backed online retail giant Paytm is in talks to buy UCWeb's India business for a deal pegged around $400-$500 million. UCWeb, which is the Chinese company's smartphone browser, claims to be the number one mobile browser in China as well as India, with… [+2430 chars]"}]
      |    }
    """.stripMargin

  val component = ScalaComponent
    .builder[Props]("Trending News")
    .initialState(State(jsonTestData, 0))
    .renderBackend[Backend]
    .componentDidMount(_.backend.start)
    .componentWillUnmount(_.backend.clear)
    .build

    /*
    .render_S{
      s =>  <.div( <.h1("Trending Bussiness News"), <.p(s.newsData),<.div(^.onClick ==> ajaxRequest)(<.button("click here to simulate ajax request")))
    }
    .configure(Reusability.shouldComponentUpdate)
    .componentWillMount(S => CallbackTo(makeApiCall).runNow())
    .componentWillReceiveProps(P => CallbackTo(UpdateApiData(P.nextProps)))
    .build
    */


  class Backend($: BackendScope[Props, State]) {
    var interval: js.UndefOr[js.timers.SetIntervalHandle] =
      js.undefined

    def tick =
      $.modState(s => State(s.newsData,s.secondsElapsed + 1))

    def start = Callback {
      //interval = js.timers.setInterval(1000)(tick.runNow())
      tick.runNow()
      makeApiCall().runNow()
    }

    def clear = Callback {
      interval foreach js.timers.clearInterval
      interval = js.undefined
      makeApiCall().runNow()
    }

    def render(s: State) = <.div( <.h5("Trending Bussiness News"), News(s.newsData) ,<.div(^.onClick ==> ajaxRequest)(<.button("Get latest News")),<.div("Seconds elapsed: ", s.secondsElapsed))


    def UpdateApiData(props: Props): Unit ={
      println("UpdateApiData callback")
      Callback.log("UpdateApiData callback")
      Callback.alert("UpdateApiData callback")
      makeApiCall()

    }

    def ajaxRequest(syntheticEvent: ReactMouseEvent) = {
      makeApiCall()
    }

    def makeApiCall()={
      val contentType = ("Content-Type" -> "application/json")
      var url = "https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=aea30ab672ab45f28de1236014d6b1aa"
      import scala.concurrent.ExecutionContext.Implicits.global
      val request = Ajax.get(url, responseType="text")


      var responseText = ""
      //request.map(xhr => println(xhr.responseText))
      Callback {
        request.onComplete {
          case xhr => {
            // println("response text: " + xhr.get.responseText)
            responseText = xhr.get.responseText
            $.modState(s => State(responseText, s.secondsElapsed + 1)).runNow()
            Callback.log("got data from api")
          }
        }
      }
      //NewsTrending.State.apply(responseText,s.secondsElapsed)

     // Callback(this.Props(receivedData = "got new data" )).runNow()
     // Callback(this.State(newsData = responseText )).runNow()
      //dom.console.log(responseText)
      //Callback.log(responseText)
      //Callback.log("got data from api")
    }
  }




  def apply(props:Props) = component(props)


}
