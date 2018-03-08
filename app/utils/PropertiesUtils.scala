package utils

import com.typesafe.config.ConfigFactory

import scala.util.Try

/**
  * Created by Shai Kalmanovich on 2/28/2018.
  */
object PropertiesUtils {

  lazy val username: String = load(Consts.USERNAME)
  lazy val password: String = load(Consts.PASSWORD)

  lazy val consumerKey: String = load(Consts.CONSUMER_KEY)
  lazy val consumerSecret: String = load(Consts.CONSUMER_SECRET)

  lazy val maxTimeToWait: Int = load(Consts.MAX_TIME_TO_WAIT).toInt


  /**
    * <i>load</i> - This method loads the properties from the applcation.conf file.
    * It can be controlled by VM property e.g. -Dconfig.file=src\test\resources\application-test.conf
    * @return - The string of the value of the property name.
    */
  def load(entry: String): String = {
    Try(ConfigFactory.load.getString(entry)).getOrElse(Consts.EMPTY_STRING)
  }
}