package models

import scalikejdbc._

case class Publisher(id: Long, name: String, properties: List[PublisherProperty] = Nil)

object Publisher extends SQLSyntaxSupport[Publisher] {

  val (p, pp) = (Publisher.syntax("p"), PublisherProperty.syntax("pp"))

  def apply(c: SyntaxProvider[Publisher])(rs: WrappedResultSet): Publisher = apply(c.resultName)(rs)

  def apply(c: ResultName[Publisher])(rs: WrappedResultSet): Publisher = new Publisher(
    id = rs.get(c.id),
    name = rs.get(c.name)
  )

  def findAll()(implicit session: DBSession = autoSession): List[Publisher] = withSQL {
    select.from[Publisher](Publisher as p)
      .leftJoin(PublisherProperty as pp).on(p.id, pp.publisherId)
      .orderBy(p.id)
  }.one(Publisher(p))
    .toMany(PublisherProperty.opt(pp))
    .map((publisher, properties) => publisher.copy(properties = properties.toList))
    .list.apply()

}