package models

import scalikejdbc._
import org.joda.time.DateTime

case class AdFormat(id: Long, name: String, createdAt: DateTime, description: String, visible: Boolean, `type`: String, oldAdFormatId: Long, supportsHtml: Boolean, supportsJs: Boolean)

object AdFormat extends SQLSyntaxSupport[AdFormat] {

  val af = AdFormat.syntax("af")

  def apply(c: SyntaxProvider[AdFormat])(rs: WrappedResultSet): AdFormat = apply(c.resultName)(rs)
  def apply(c: ResultName[AdFormat])(rs: WrappedResultSet): AdFormat = new AdFormat(
    id = rs.get(c.id),
    name = rs.get(c.name), createdAt = rs.get(c.createdAt), description = rs.get(c.description), visible = rs.get(c.visible),
    `type` = rs.get(c.`type`), oldAdFormatId = rs.get(c.oldAdFormatId), supportsHtml = rs.get(c.supportsHtml), supportsJs = rs.get(c.supportsJs)
  )

  def findAll()(implicit session: DBSession = autoSession): List[AdFormat] = withSQL {
    select.from(AdFormat as af)
      .orderBy(af.id)
  }.map(AdFormat(af)).list.apply()

}