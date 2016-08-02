package controllers

import javax.inject.{Inject, Singleton}

import com.github.tototoshi.play2.json4s.Json4s
import org.json4s._
import models.PublisherProperty
import org.json4s.{DefaultFormats, Extraction}
import org.json4s.ext.JodaTimeSerializers
import play.api.mvc.{Action, Controller}
import scalikejdbc.DB

@Singleton
class PublisherProperties @Inject()(json4s: Json4s) extends Controller {

  import json4s._

  implicit val formats = DefaultFormats ++ JodaTimeSerializers.all

  def findAllByPublisher(publisherId: Long) = Action {
    Ok(Extraction.decompose(PublisherProperty.findAllByPublisher(publisherId)))
  }

  def getPublisherPropertyById(publisherId: Long, propertyId: Long) = Action {
    PublisherProperty.findById(publisherId, propertyId).map(pp => Ok(Extraction.decompose(pp))).getOrElse(NotFound)
  }

  def deletePublisherProperty(publisherId: Long, propertyId: Long) = Action {
    if(DB.localTx(implicit session => PublisherProperty.deleteById(publisherId, propertyId)) > 0) NoContent
    else NotFound
  }

  def createPublisherProperty(publisherId: Long) = Action(json) {
    implicit request =>
      val pp = request.body.extractOpt[PublisherProperty]
      pp match {
        case Some(ppp) => Ok(Extraction.decompose(ppp.copy(id = Some(DB.localTx(implicit session => PublisherProperty.createPublisherProperty(ppp, publisherId))))))
        case _ => BadRequest
      }
  }

  def updatePublisherProperty(publisherId: Long, propertyId: Long) = Action(json) {
    implicit request =>
      val pp = request.body.extract[PublisherProperty]
      DB.localTx {
        implicit session =>
          if(PublisherProperty.updatePublisherProperty(pp, publisherId) > 0) NoContent else NotFound
      }
  }

}