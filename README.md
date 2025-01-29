# Infix to Postfix Converter and Postfix Evaluator

This Java program converts an infix expression to a postfix expression and evaluates a given postfix expression. It supports basic arithmetic operations: addition (`+`), subtraction (`-`), multiplication (`*`), division (`/`), and exponentiation (`^`).

---

## Features

- **Infix to Postfix Conversion**: Converts an infix expression (e.g., `4+(1-2*8)`) to a postfix expression (e.g., `4128*-+`).
- **Postfix Evaluation**: Evaluates a postfix expression (e.g., `3 2 * 4 - 7 /`) and returns the result.
- **Error Handling**: Handles invalid expressions, division by zero, and unsupported operators.

---

## The program will:

- Convert the infix expression 4+(1-2*8) to postfix and print the result.
- Evaluate the postfix expression 3 2 * 4 - 7 / and print the result.

---

## Code Structure

- priority(char operator): Determines the precedence of operators.
- operators(String operator): Maps operators to integers for evaluation.
- Is_operator(String operator): Checks if a string is a valid operator.
- convert(String infix): Converts an infix expression to postfix.
- Evaluatee(String postfix): Evaluates a postfix expression and returns the result.

---

## Inputs Example: 
- String s = "4+(1-2*8)"; // Infix expression
- String sq = "3 2 * 4 - 7 /"; // Postfix expression

---

## NOTES:

- Ensure proper spacing in the postfix expression for evaluation (e.g., 3 2 * 4 - 7 /).
- The program handles division by zero and invalid operators gracefully.

















