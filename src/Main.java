public class Main {
    ///////////////////////--PRIORITY OPERATORS--////////////////////
    private static int priority(char operator) {
        if (operator == '+' || operator == '_')
            return 1;
        else if (operator == '*' || operator == '/')
            return 2;
        else if (operator == '^')
            return 3;
        else
            return -1;
    }
    ///////////////////////--CHECK WHAT THE OPERATOR--////////////////////
    private static int operators(String operator) {
        if (operator.equals("+"))
            return 1;
        else if (operator.equals("-"))
            return 2;
        else if (operator.equals("*"))
            return 3;
        else if (operator.equals("/"))
            return 4;
        else if (operator.equals("^"))
            return 5;
        else
            return -1;
    }

    ///////////////////////--CHECK IF THE OPERATOR EXIST--////////////////////
    private static boolean Is_operator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }
    ///////////////////////--METHOD FOR CONVERT INFIX TO POSTFIX EXPRESSION--////////////////////
    static String convert(String infix) {
        String postfix = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (Character.isLetterOrDigit(ch)) {//CHECK IF IT IS LETTER OR DIGIT TO CONCATENATED WITH THE POSTFIX VARIABLE
                postfix += ch;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {//IT WILL POP THE OPERATORS IN STACK UNTIL FOUND THE CLOSE BRACKET
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == '(') {//POP THE CLOSE BRACKET BUT NOT CONCATENATED WITH THE POSTFIX VARIABLE
                    stack.pop();
                }
            } else {//CHECK IF THE NEW OPERATOR IS LESS THAN OR EQUAL TO POP THE CURRENT OPERATOR AND PUSH THE NEW ELSE IT HIGHER THAN
                while (!stack.isEmpty() && priority(ch) < priority(stack.peek())) {
                    postfix += stack.pop();
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {//IF THE STACK CONTAIN ANY OPERATORS
            postfix += stack.pop();
        }
        return postfix.toString();//RETURN THE POSTFIX EXPRESSION
    }
    ///////////////////////-- METHOD FOR EVALUATE THE POSTFIX EXPRESSION --///////////////////////
    static String Evaluatee(String postfix) {
        Stack<String> stack = new Stack<>();
        postfix = postfix.trim();
        String[] arr = postfix.split(" ");//CUT THE STRING INTO CHARACTER AND PUT EACH CHARACTER IN A CELL && THE WHITE SPACE CONDITION IS USELESS
        double result = 0;
        String result$;//FOR COVERT THE FINAL RESULT FROM INT TO STRING
        if (postfix.isEmpty() || postfix.isBlank()) {
            System.out.println("the string is empty");
            System.exit(1);
        } else {
            for (int i = 0; i < arr.length; i++) {
                String c = arr[i];
                if (!Is_operator(c)) {//CHECK IF THE FIRST CHAR IS DIGIT OR NOT,IF NOT IT WILL CHECK IF IT OPERATOR ,IF NOT IT WILL BE WRONG
                    stack.push(c);
                } else if (Is_operator(c)) {
                    if (stack.isEmpty() || stack.top <= 0) {//STACK IS EMPTY OR HAS ONE NUMBER
                        System.out.println("the expression is wrong");
                        System.exit(1);
                    } else {//STACK CONTAIN OPERANDS ,POP THE LASTED TWO VALUE IN TOP AND STORE THEM IN VARIABLES
                        double x = Double.parseDouble(stack.pop());
                        double y = Double.parseDouble(stack.pop());
                        if (operators(c) == 1) {//CHECK WHAT THIS OPERATOR??
                            result = x + y;
                        } else if (operators(c) == 2) {
                            result = x - y;
                        } else if (operators(c) == 3) {
                            result = x * y;
                        } else if (operators(c) == 4) {
                            if (y != 0) {//CHECK IF THE SECOND OPERAND IS EQUAL ZERO
                                result = x / y;
                            } else {
                                System.out.println("Can not divided by zero!!!");
                                System.exit(1);
                            }
                        } else if (operators(c) == 5) {
                            result = Math.pow(x, y);
                        } else {
                            System.out.println("Wrong Operator !!!");
                            System.exit(1);
                        }
                        //CONVERT THE FINAL RESULT FROM DOUBLE TO STRING TO CAN PUSH AND POP IT IN STACK
                        result$ = Double.toString(result);
                        stack.push(result$);


                    }

                } else {//IF THERE IS NOT AN OPERATORS OR DIGIT
                    continue;
                }

            }
        }//RETURN THE TOP
        String top = stack.pop();
        return top;
    }

    public static void main(String[] args) {
        String s = "4+(1-2*8) ";//3*(5+4)-6/(1+2)
        String sq = "3 2 * 4 - 7 / ";
        System.out.println(convert(s));
        System.out.println(Evaluatee(sq));

    }
}
//c.matches ( "[+-]?\\d+(\\.\\d+)?" )
