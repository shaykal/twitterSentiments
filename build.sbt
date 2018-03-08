name := "twitterSentiments"
 
version := "1.0" 
      
lazy val `twittersentiments` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.2"

libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice,
  "com.typesafe" % "config" % "1.2.1",
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "ch.qos.logback" % "logback-core" % "1.1.3",
  "commons-io" % "commons-io" % "2.6",
  "org.apache.httpcomponents" % "httpclient" % "4.5.4",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.mockito" % "mockito-core" % "2.10.0" % "test")


unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      