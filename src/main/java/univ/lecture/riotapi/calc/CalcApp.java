package univ.lecture.riotapi.calc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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
            } else if (Utility.isOperator(in)) {
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

        for (String in : infix) {
            if (Utility.isOperator(in)) {
                if (")".equals(in)) {
                    while (!this.stack.isEmpty() && !"(".equals(this.stack.peek())) {
                        String popOp = this.stack.pop();
                        this.postfix.add(popOp);
                    }

                    if (!this.stack.isEmpty() && "(".equals(this.stack.peek())) {
                        this.stack.pop();
                    }
                } else {
                    while (!this.stack.isEmpty()
                            && !Utility.isHigherPrirorty(in, stack.peek())) {
                        String compareOp = this.stack.pop();
                        if (!"(".equals(in)) {
                            postfix.add(compareOp);
                        } else {
                            in = compareOp;
                        }
                    }
                    this.stack.push(in);
                }
            } else if (Utility.isNumber(in)) {
                this.postfix.add(in);
            }
        }

        while (!this.stack.isEmpty()) {
            this.postfix.add(this.stack.pop());
        }
        String[] result = new String[this.postfix.size()];
        this.postfix.toArray(result);
        return result;
    }

}
