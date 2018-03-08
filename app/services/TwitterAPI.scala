package services

import javax.inject.Inject

import play.api.libs.ws.{WSClient, WSRequest, WSResponse}
import play.api.mvc._
import play.libs.ws._
import utils.{Consts, PropertiesUtils}

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits._

class TwitterAPI @Inject() (ws: WSClient) {

  val headers: (String, String) = ???

  def getTweets() : Future[WSResponse] = {
    val request: WSRequest = ws.url(Consts.BASE_URL)
                               //.withAuth(PropertiesUtils.username, PropertiesUtils.password, play.api.libs.ws.WSAuthScheme.DIGEST)
                              .addHttpHeaders("oauth_consumer_key"-> PropertiesUtils.consumerKey)
                              .addHttpHeaders("oauth_consumer_key"-> PropertiesUtils.consumerKey)
                              .withQueryStringParameters("track"->"twitter")
    val futureResponse: Future[WSResponse] = request.get()
    //val answer: Future[String] = futureResponse.map { test: WSResponse =>

      //case Success(v) => v.body
      //case Failure(e) => e.getMessage
    //}
    futureResponse
  }
}
