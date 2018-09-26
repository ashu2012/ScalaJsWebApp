package scalajsreact.template.components.items

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom
import dom.MouseEvent
import japgolly.scalajs.react.extra.{EventListener, OnUnmount}
import org.scalajs.dom.html.Div

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, ScalaJSDefined}
import js.DynamicImplicits._
import scala.scalajs.js.Dynamic
import scalajsreact.template.components.FirebaseFacade
import scalajsreact.template.components.FirebaseFacade.firebase.Firebase

/*
@js.native
@JSGlobal("firebase")
object firebase extends js.Object{
  def initializeApp(config: js.Object): Unit = js.native
  def database():  js.Any = js.native
}

sealed trait credentials
case class firebaseApiCredentials(typeCredits:String , project_id :String, private_key_id:String ,private_key:String,client_email:String,client_id:String,auth_uri:String,token_uri:String,auth_provider_x509_cert_url:String,client_x509_cert_url:String) extends credentials

@js.native
class firebaseAppConfig(apiKey:String,authDomain:String, databaseURL:String) extends  js.Object

*/


case class State( loggedIn: Boolean,
                  currentState: String,
                  someInitialValue: String)

object Login  {


  def initializeApp()={


    /*
  var config = {
  apiKey: "apiKey",
  authDomain: "projectId.firebaseapp.com",
  databaseURL: "https://databaseName.firebaseio.com"
  };
  firebase.initializeApp(config);
  var rootRef = firebase.database().ref();

  "projectId" : "api-project-1021787054473",
  "storageBucket" : "api-project-1021787054473.appspot.com",
  "messagingSenderId" : "1021787054473"
  */
    val apiKey= "AIzaSyCT7g1W-EmqDTv2N-s-em1QTWvpfZH0seI"
    val authDomain=  "api-project-1021787054473.firebaseapp.com"
    val databaseURL ="https://api-project-1021787054473.firebaseio.com"
    val projectId = "api-project-1021787054473"
    val storageBucket = "api-project-1021787054473.appspot.com"
    val messagingSenderId = "1021787054473"
    var config = FirebaseFacade.firebase.FirebaseConfig(apiKey,authDomain,databaseURL,storageBucket,messagingSenderId)
    var fjs = FirebaseFacade.firebase.Firebase
    fjs.initializeApp(config)
    println(fjs.SDK_VERSION)
   // println(fjs.database().ref(databaseURL))
  }




  val component = {
    ScalaComponent
      .builder[Unit]("Login/SignUp")
      .initialState(State(false, "not logged in", "firebase not initialized"))
      .renderBackend[Backend]
      .build
  }



  class Backend($: BackendScope[Unit, State]) {

    def logEvent(desc: String)       = {
      println(desc)
      $.modState(state => State(false, "not logged in", "firebase intializing trying"))
    }
    def logMouseEnter(e: ReactMouseEventFromTextArea) = {
     // initializeApp()

      val apiKey= "AIzaSyCT7g1W-EmqDTv2N-s-em1QTWvpfZH0seI"
      val authDomain=  "api-project-1021787054473.firebaseapp.com"
      val databaseURL ="https://api-project-1021787054473.firebaseio.com"
      val projectId = "api-project-1021787054473"
      val storageBucket = "api-project-1021787054473.appspot.com"
      val messagingSenderId = "1021787054473"
      var config = FirebaseFacade.firebase.FirebaseConfig(apiKey,authDomain,databaseURL,storageBucket,messagingSenderId)
      var fjs = FirebaseFacade.firebase.Firebase
      fjs.initializeApp(config)
      println(fjs.SDK_VERSION)
      println("reading firebase data")
      var db= fjs.database()
      var dataSnapshot =  db.ref().child("user").
      db.ref("user/").once("value",( dataSnapshot:)={
        dataSnapshot.paren)

      })

      println(fjs.database().refFromURL(databaseURL))


      logEvent(s"Mouse enter @ ${e.pageX},${e.pageY}")
    }
    val logWindowClick               = logEvent("Window clicked.")
    val logLocalClick                = logEvent("Component clicked.")


    def render(state: State) = {

       <.div(
         ^.border  := "solid 1px black",
         ^.width   := "90ex",
         ^.height  := "20em",
         ^.padding := "2px 6px",
         <.textarea (
           ^.onClick  ==> logMouseEnter
         )

       )
    }

  }



  def apply() = component().vdomElement



}
