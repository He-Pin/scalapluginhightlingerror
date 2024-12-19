import Expression.LogicalExpression
import Expression.LogicalExpression.{ExistenceLogicalExpression, FunctionLogicalExpression, UnaryLogicalExpression}

import scala.annotation.switch

//show highlighting error
object Parser {

  import fastparse.MultiLineWhitespace._
  import fastparse._

  private def isFunctionNameFirstAcceptable(c: Char): Boolean = 'a' <= c && c <= 'z'

  private def `logical-function-expr`[_: P]: P[FunctionLogicalExpression] = ???

  private def `test-expr`[_: P]: P[LogicalExpression] =
    P(Index.flatMapX(offset => {
      SingleChar.flatMapX { c =>
        (c: @switch) match {
          case '!' =>
            Pass./ ~ `test-expr`.map(new UnaryLogicalExpression(_, UnaryLogicalOperator.NOT))
          case '@' | '$' =>
            P.current.index = offset
            Pass.map(_ => new ExistenceLogicalExpression("jsonpath"))
          case c if isFunctionNameFirstAcceptable(c) =>
            P.current.index = offset
            Pass ~ `logical-function-expr`
          case _ => Fail.opaque("Invalid test-expr")
        }
      }
    }))

}
