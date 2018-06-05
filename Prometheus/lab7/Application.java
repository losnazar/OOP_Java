package Labs_OOP.prometheus._week7;
import java.util.LinkedList;

public class Application {
        public static double parse(String rpnString) {
            if (rpnString.isEmpty()) throw new RPNParserException();
            String[] args = rpnString.split(" ");
            LinkedList<Double> stack = new LinkedList<>();
            double tmp1, tmp2;
            for (String arg : args) {
                if (arg.equals("NaN")) throw new ArithmeticException();
                if (arg.equals("+") || arg.equals("-") || arg.equals("*") || arg.equals("/")) {
                    if (stack.size() < 2) throw new RPNParserException();
                    tmp1 = stack.pop();
                    tmp2 = stack.pop();
                    switch (arg) {
                        case "+": {
                            stack.push(tmp2 + tmp1);
                            break;
                        }
                        case "-": {
                            stack.push(tmp2 - tmp1);
                            break;
                        }
                        case "*": {
                            stack.push(tmp2 * tmp1);
                            break;
                        }
                        case "/": {
                            if (tmp1==0) throw new ArithmeticException();
                            stack.push(tmp2 / tmp1);
                            break;
                        }
                    }
                }
                else {
                    try {
                        stack.push(Double.parseDouble(arg));
                    } catch (NumberFormatException e) {
                        throw new RPNParserException();
                    }
                }
            }
            if (stack.size() != 1) throw new RPNParserException();
            return stack.pop();
        }

        public static void main(String[] args) {
            if (args.length==1 && args[0]!=null)
                System.out.println(parse(args[0]));
        }
}
