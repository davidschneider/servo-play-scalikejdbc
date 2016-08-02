package controllers

import javax.inject.{Inject, Singleton}

import com.github.tototoshi.play2.json4s.native.Json4s
import models.AdFormat
import org.json4s._
import org.json4s.ext.JodaTimeSerializers
import play.api.mvc.{ Action, Controller }

@Singleton
class AdFormats @Inject() (json4s: Json4s) extends Controller {

  import json4s._
  implicit val formats = DefaultFormats ++ JodaTimeSerializers.all

  def all = Action {
    Ok(Extraction.decompose(AdFormat.findAll()))
  }

}