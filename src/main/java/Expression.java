import java.util.List;


public sealed interface Expression extends JsonPathAST {

    sealed interface LogicalExpression extends Expression, FilterExpression {
        record UnaryLogicalExpression(LogicalExpression expression,
                                      UnaryLogicalOperator operator) implements LogicalExpression {
        }

        record ExistenceLogicalExpression(String jsonpath) implements LogicalExpression {
        }

        record FunctionLogicalExpression(String function,
                                         List<String> parameters) implements LogicalExpression {

        }
    }
}
