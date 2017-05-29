package scala.macros

import scala.macros.inputs._

private[scala] trait Universe extends scala.meta.Universe with Expansions {
  private[scala] type Abstracts <: TreeAbstracts with SemanticAbstracts with ExpansionAbstracts
  private[scala] def abstracts: Abstracts

  def expandee(implicit e: Expansion): Term = abstracts.expandee
  def abort(pos: Position, msg: String)(implicit e: Expansion): Nothing = abstracts.abort(pos, msg)
  def error(pos: Position, msg: String)(implicit e: Expansion): Unit = abstracts.error(pos, msg)
  def warning(pos: Position, msg: String)(implicit e: Expansion): Unit =
    abstracts.warning(pos, msg)
}
