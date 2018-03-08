package utils

/**
  * Created by Shai Kalmanovich on 2/28/2018.
  */
object Consts {

  val USERNAME = "twitter.username"
  val PASSWORD = "twitter.password"

  val CONSUMER_KEY = "twitter.consumer.key"
  val CONSUMER_SECRET="twitter.consumer.secret"

  val MAX_TIME_TO_WAIT = "max.time.to.wait"

  //lazy val BASE_URL = s"http://${PropertiesUtils.serverHost}:${PropertiesUtils.serverPort}/DosServer"

  lazy val BASE_URL = "https://stream.twitter.com/1.1/statuses/filter.json"

  val EMPTY_STRING = ""

}
