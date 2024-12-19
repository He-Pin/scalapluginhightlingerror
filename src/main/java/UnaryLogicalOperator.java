
public enum UnaryLogicalOperator {
    NOT {
        @Override
        public String toString() {
            return "!";
        }
    },
    NOOP {
        @Override
        public String toString() {
            return "";
        }
    }
}
