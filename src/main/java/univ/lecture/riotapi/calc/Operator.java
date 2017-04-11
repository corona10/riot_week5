package univ.lecture.riotapi.calc;

/**
 * Created by tchi on 2016. 12. 11..
 */
public enum Operator {
    ADD("+", 3) {
        @Override
        public double evaluate(double firstOperand, double secondOperand) {
            return firstOperand + secondOperand;
        }
    },
    SUB("-", 3) {
        @Override
        public double evaluate(double firstOperand, double secondOperand) {
            return firstOperand - secondOperand;
        }
    },
    MUL("*", 4) {
        @Override
        public double evaluate(double firstOperand, double secondOperand) {
            return firstOperand * secondOperand;
        }
    },
    DIV("/", 4) {
        @Override
        public double evaluate(double firstOperand, double secondOperand) {
            return firstOperand / secondOperand;
        }
    };

    private final String symbol;
    private final int precedence;

    Operator(String symbol, int precedence) {
        this.symbol = symbol;
        this.precedence = precedence;
    }

    public abstract double evaluate(double firstOperand, double secondOperand);

    public static Operator findOperator(String symbol) {
        for (Operator op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }

        return null;
    }

    public int getPrecedence() {
        return precedence;
    }

    public int compareTo(String op) {
        return this.getPrecedence() - Operator.findOperator(op).getPrecedence();
    }
}
