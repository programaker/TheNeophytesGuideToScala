package part06

import scala.util.Try
import java.net.URL
import scala.io.Source
import scala.util.Success
import scala.util.Failure
import java.net.MalformedURLException

object ErrorHandlingTheFunctionalWay {
  def parseUrl(url: String): Try[URL] = Try(new URL(url))
  
  def main(args: Array[String]): Unit = {
    //Success[T] or Failure
    val us1 = "http://www.facebook.com/"
    val url1 = parseUrl(us1)
    println(">>> url1 = " + url1)
    
    val us2 = "gluglu.piupiu.iéié"
    val url2 = parseUrl(us2)
    println(">>> url2 = " + url2)
    
    
    //working with Try values
    val url3 = parseUrl(us1) getOrElse new URL("http://www.google.com/")
    println(">>> url3 = " + url3)
    
    val url4 = parseUrl(us2) getOrElse new URL("http://www.google.com/")
    println(">>> url4 = " + url4)
    
    
    //try - mapping and flat-mapping
    val p1 = parseUrl(us1).map(_.getProtocol)
    println(s">>> '$us1' protocol = $p1")
    
    val p2 = parseUrl(us2).map(_.getProtocol)
    println(s">>> '$us2' protocol = $p2")
    
    val is1 = parseUrl(us1).map(u => Try(u.openConnection).map(connection => Try(connection.getInputStream)))
    println(s">>> InputStream1 for '$us1' = $is1")
    
    val is2 = parseUrl(us2).map(u => Try(u.openConnection).map(connection => Try(connection.getInputStream)))
    println(s">>> InputStream2 for '$us2' = $is2")
    
    val is3 = parseUrl(us1).flatMap(u => Try(u.openConnection).flatMap(connection => Try(connection.getInputStream)))
    println(s">>> InputStream3 for '$us1' = $is3")
    
    val is4 = parseUrl(us2).flatMap(u => Try(u.openConnection).flatMap(connection => Try(connection.getInputStream)))
    println(s">>> InputStream4 for '$us2' = $is4")
    
    
    //filter and for-each
    val url5 = parseUrl(us1).filter(_.getProtocol == "http")
    println(">>> url5 = " + url5)
    
    val us3 = "ftp://mirror.netcologne.de/apache.org"
    val url6 = parseUrl(us3).filter(_.getProtocol == "http")
    println(">>> url6 = " + url6)
    
    parseUrl(us3).foreach(url7 => println(s">>> url7 = $url7"))
    
    
    //for comprehensions
    val c1 = for {
      url <- parseUrl(us1)
      connection <- Try(url.openConnection)
      is <- Try(connection.getInputStream)
      source = Source.fromInputStream(is)
    } yield source.getLines
    
    println(s">>> contents of '$us1' = $c1")
    
    val c2 = for {
      url <- parseUrl(us2)
      connection <- Try(url.openConnection)
      is <- Try(connection.getInputStream)
      source = Source.fromInputStream(is)
    } yield source.getLines
    
    println(s">>> contents of '$us2' = $c2")
    
    
    //pattern matching
    val c3 = for {
      url <- parseUrl(us1)
	  connection <- Try(url.openConnection)
	  is <- Try(connection.getInputStream)
	  source = Source.fromInputStream(is)
    } yield source.getLines
    
    c3 match {
      case Success(lines) => lines.foreach(println) //empty iterator; won't print anything, but was a success anyway...
      case Failure(e) => println(s"Problem rendering URL content: ${e.getMessage}")
    }
    
    val c4 = for {
      url <- parseUrl(us2)
	  connection <- Try(url.openConnection)
	  is <- Try(connection.getInputStream)
	  source = Source.fromInputStream(is)
    } yield source.getLines
    
    c4 match {
      case Success(lines) => lines.foreach(println)
      case Failure(e) => println(s"Problem rendering URL content: ${e.getMessage}")
    }
    
    
    //recovering from a failure
    val fetchContent = (url: String) => for {
      url <- parseUrl(us2)
	  connection <- Try(url.openConnection)
	  is <- Try(connection.getInputStream)
	  source = Source.fromInputStream(is)
    } yield source.getLines
    
    val c5 = fetchContent(us2) recover {
      case e: MalformedURLException => Iterator("Please make sure to enter a valid URL")
      case _ => Iterator("An unexpected error has occurred. We are so sorry!")
    }
    
    c5.foreach(_.foreach(println))
  }
}