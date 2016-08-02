package models

import org.joda.time.DateTime
import scalikejdbc._

case class PublisherProperty(id: Option[Long], name: String, publisherId: Long, deletedAt: Option[DateTime])

object PublisherProperty extends SQLSyntaxSupport[PublisherProperty] {

  val pp = PublisherProperty.syntax("pp")

  def apply(c: SyntaxProvider[PublisherProperty])(rs: WrappedResultSet): PublisherProperty = apply(c.resultName)(rs)

  def apply(c: ResultName[PublisherProperty])(rs: WrappedResultSet): PublisherProperty = new PublisherProperty(
    id = rs.get(c.id), name = rs.get(c.name), publisherId = rs.get(c.publisherId), deletedAt = rs.get(c.deletedAt)
  )

  def opt(m: SyntaxProvider[PublisherProperty])(rs: WrappedResultSet): Option[PublisherProperty] =
    rs.longOpt(m.resultName.id).map(_ => PublisherProperty(m)(rs))

  def findAllByPublisher(publisherId: Long)(implicit session: DBSession = autoSession): List[PublisherProperty] = withSQL {
    select.from(PublisherProperty as pp)
      .where.eq(pp.publisherId, publisherId).and.isNull(pp.deletedAt)
      .orderBy(pp.id)
  }.map(PublisherProperty(pp)).list.apply()

  def findById(publisherId: Long, propertyId: Long)(implicit session: DBSession = autoSession): Option[PublisherProperty] = withSQL {
    select.from(PublisherProperty as pp)
      .where.eq(pp.publisherId, publisherId).and.eq(pp.id, propertyId).and.isNull(pp.deletedAt)
  }.map(PublisherProperty(pp)).headOption().apply()

  def createPublisherProperty(pp: PublisherProperty, publisherId: Long)(implicit session: DBSession = autoSession): Long = withSQL {
    insert.into(PublisherProperty)
      .namedValues(column.publisherId -> publisherId, column.name -> pp.name)
  }.updateAndReturnGeneratedKey().apply()

  def updatePublisherProperty(pp: PublisherProperty, publisherId: Long)(implicit session: DBSession = autoSession): Int = withSQL {
    update(PublisherProperty)
      .set(column.name -> pp.name)
      .where.eq(column.publisherId, publisherId).and.eq(column.id, pp.id).and.isNull(column.deletedAt)
  }.update.apply()

  def deleteById(publisherId: Long, propertyId: Long)(implicit session: DBSession = autoSession): Int = withSQL {
    update(PublisherProperty)
      .set(column.deletedAt -> sqls.currentTimestamp)
      .where.eq(column.publisherId, publisherId).and.eq(column.id, propertyId).and.isNull(column.deletedAt)
  }.update.apply()

}