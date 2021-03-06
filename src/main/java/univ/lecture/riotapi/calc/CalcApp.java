package univ.lecture.riotapi.calc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Calculator application
 */
public class CalcApp {

    private Deque<String> stack;
    private ArrayList<String> postfix;


    public CalcApp() {
        this.postfix = new ArrayList<>();
        this.stack = new ArrayDeque<>();
    }

    public double calc(String[] tokens) {
        String[] pf = this.getPostFix(tokens);
        return this.calculatePostfix(pf);
    }

    private double calculatePostfix(String[] postfix) {
        this.stack.clear();

        for (String in : postfix) {
            if (Utility.isNumber(in)) {
                this.stack.push(in);
            } else if (Operator.isOperator(in)) {
                Operator operator = Operator.findOperator(in);
                double secondOperand = Double.parseDouble(this.stack.pop());
                double firstOperand = Double.parseDouble(this.stack.pop());
                this.stack.push(String.valueOf(operator.evaluate(firstOperand, secondOperand)));
            }
        }

        return Double.parseDouble(this.stack.pop());
    }

    private String[] getPostFix(String[] infix) {
        this.postfix.clear();
        this.stack.clear();

        for (String token : infix) {
            if (Utility.isNumber(token)) {
                this.postfix.add(token);
            } else if (Operator.isOperator(token)) {
                while (!stack.isEmpty() && Operator.isOperator(stack.peek())) {
                    String op2 = stack.peek();
                    if (Operator.findOperator(token).compareTo(op2) <= 0) {
                        this.stack.pop();
                        this.postfix.add(op2);
                    } else break;
                }
                stack.push(token);
            } else if ("(".equals(token)) {
                this.stack.push(token);
            } else if (")".equals(token)) {
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    String popOp = this.stack.pop();
                    this.postfix.add(popOp);
                }
                if (stack.isEmpty()) {
                    throw new RuntimeException("Parenthesis mismatch");
                }
                this.stack.pop();
            } else {
                throw new RuntimeException("Invalid token: " + token);
            }
        }

        while (!this.stack.isEmpty()) {
            if ("(".equals(stack.peek())) {
                throw new RuntimeException("Parenthesis mismatch");
            }
            this.postfix.add(this.stack.pop());
        }
        String[] result = new String[this.postfix.size()];
        this.postfix.toArray(result);
        return result;
    }

}
