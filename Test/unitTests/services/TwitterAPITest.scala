package unitTests.services

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import play.api.libs.ws.WSResponse

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success, Try}
//import ch.qos.logback.classic.Logger
import org.scalatest.FunSuite
import org.slf4j.{Logger, LoggerFactory}
import play.api.libs.ws.ahc.AhcWSClient
import services.TwitterAPI
import utils.PropertiesUtils

import scala.concurrent.ExecutionContext.Implicits._

class TwitterAPITest extends FunSuite {

  val log: Logger = LoggerFactory.getLogger(this.getClass)

  test("loading properties file is successful") {
    implicit val system = ActorSystem()
    implicit val materializer = ActorMaterializer()
    val wsClient = AhcWSClient()

    log.info("before")
    val twitterApi : TwitterAPI = new TwitterAPI(wsClient)
    val answer: Future[WSResponse] = twitterApi.getTweets()
    Try(Await.result(answer, 10 seconds)) match {
      case Success(extractedVal) => {
        println("Success Happened: " + extractedVal)
      }
      case Failure(_) => {
        println("Failure Happened")
      }
    }
    log.info("after")
    answer.onComplete {
      case Success(value) => log.info(value.body)
      case Failure(e) => log.error(e.getMessage)
    }

    //val serverHost: String = PropertiesUtils.serverHost
    //val serverPort: Int = PropertiesUtils.serverPort

    //assert(serverHost == "localhost")
    //assert(serverPort == 8080)

    wsClient.close()
  }

}
