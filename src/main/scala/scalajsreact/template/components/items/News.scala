package scalajsreact.template.components.items


import japgolly.scalajs.react.{ScalaComponent, ScalaFnComponent}
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom._

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.dom

import scala.collection.Seq
import upickle.default._
import upickle.default.{macroRW, ReadWriter => RW}


case class Source(id : Option[String] , name : String )
case class NewsData(source: Source, author: String , title: String , description :String , url :String , urlToImage :String , publishedAt :String , content :String  )
case class NewsList( status : String  , totalResults :Int, articles : Seq[NewsData]  )

object Source{
  implicit def rw: RW[Source] = macroRW
}

object NewsData{
  //RW.merge(B.rw, macroRW[C.type])
  implicit def rw: RW[NewsData] =  macroRW
}



object NewsList{
  implicit def rw: RW[NewsList] = macroRW
}





object News {



/*
  object JsonTransformer{
    import upickle._

    val jsonTestData =
      """
        | {
        |	"status": "ok",
        |	"totalResults": 20,
        |	"articles": [{"source":{"id":null,"name": null},"author":"BusinessToday.In","title":"After BigBasket, Paytm in talks to buy Alibaba-owned UCWeb's India business for $500 million","description":"Paytm wants to buy Alibaba's UCWeb business to tap into a new user base, which will help it market products on a new built-up platform.","url":"https://www.businesstoday.in/current/corporate/bigbasket-paytm-in-talks-to-buy-alibaba-ucweb-india-business-dollar-500-million/story/284884.html","urlToImage":"https://smedia2.intoday.in/btmt/images/stories/vijay-shekhar-paytm-505_081918042334_101218010720.jpg","publishedAt":"2018-10-12T07:40:36Z","content":"Alibaba-backed online retail giant Paytm is in talks to buy UCWeb's India business for a deal pegged around $400-$500 million. UCWeb, which is the Chinese company's smartphone browser, claims to be the number one mobile browser in China as well as India, with… [+2430 chars]"}]
        |    }
      """.stripMargin


    val newsSampleData =
      """
        |{"source":{"id":null,"name": null}, "author": null,"title":"After BigBasket, Paytm in talks to buy Alibaba-owned UCWeb's India business for $500 million","description":"Paytm wants to buy Alibaba's UCWeb business to tap into a new user base, which will help it market products on a new built-up platform.","url":"https://www.businesstoday.in/current/corporate/bigbasket-paytm-in-talks-to-buy-alibaba-ucweb-india-business-dollar-500-million/story/284884.html","urlToImage":"https://smedia2.intoday.in/btmt/images/stories/vijay-shekhar-paytm-505_081918042334_101218010720.jpg","publishedAt":"2018-10-12T07:40:36Z","content":"Alibaba-backed online retail giant Paytm is in talks to buy UCWeb's India business for a deal pegged around $400-$500 million. UCWeb, which is the Chinese company's smartphone browser, claims to be the number one mobile browser in China as well as India, with… [+2430 chars]"}
      """.stripMargin

    val SourceData =
      """
        |{"id":null,"name":"Businesstoday.in"}
      """.stripMargin

    def printNewsList()={
      println(read[NewsList](jsonTestData))
    }

    def printNewsSampleData()={
      println(read[NewsData](newsSampleData))
    }

    def printSourceData()={
      println(read[Source](SourceData))
    }

    val newsData1 =
      """
        |{
        |"source":{"id":null,"name": null},
        |	"author": "BusinessToday.In",
        |	"title": "After BigBasket, Paytm in talks to buy Alibaba-owned UCWeb's India business for $500 million",
        |	"description": "Paytm wants to buy Alibaba's UCWeb business to tap into a new user base, which will help it market products on a new built-up platform.",
        |	"url": "https://www.businesstoday.in/current/corporate/bigbasket-paytm-in-talks-to-buy-alibaba-ucweb-india-business-dollar-500-million/story/284884.html",
        |	"urlToImage": "https://smedia2.intoday.in/btmt/images/stories/vijay-shekhar-paytm-505_081918042334_101218010720.jpg",
        |	"publishedAt": "2018-10-12T07:40:36Z",
        |	"content": "Alibaba-backed online retail giant Paytm is in talks to buy UCWeb's India business for a deal pegged around $400-$500 million. UCWeb, which is the Chinese company's smartphone browser, claims to be the number one mobile browser in China as well as India, with… [+2430 chars]"
        |}
      """.stripMargin

  }

*/

  case class Props(newsJsonData:String )



  val NewsListDom = ScalaFnComponent[Seq[NewsData]] { props =>
    def createItem(itemText: NewsData) = <.li(itemText.title)

    <.ul(props map createItem: _*)
  }

  val component = ScalaComponent.builder[Props]("TodoApp")
    .initialState()
    .render_P{P =>
      NewsListDom((read[NewsList](P.newsJsonData)).articles)
      }
    .build

  def apply(props:String) = component(Props(props)).vdomElement

}


/*
@react class SlinkyNewsRenderComponent extends StatelessComponent {
  case class Props(newsData: String)

  def render(): ReactElement = {
    News(props.newsData).toSlinky
  }
}
object SlinkyNewsRenderComponent{

}

*/