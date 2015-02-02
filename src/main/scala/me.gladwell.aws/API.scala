package me.gladwell.aws

import unfiltered.request._
import unfiltered.response._
import util.Properties

class API extends unfiltered.filter.Plan {

  def intent = {
    case GET(_) => Ok ~> ResponseString("Unfiltered on Heroku!")
  }

}

object API {

  def main(args: Array[String]) {
    val port = Properties.envOrElse("PORT", "8080").toInt
    unfiltered.jetty.Http(port).filter(new API).run
  }

}
