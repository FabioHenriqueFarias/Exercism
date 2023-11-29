class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {

        if(operation == null){
            throw new IllegalArgumentException("Operation cannot be null");
        }

        if(operation.length() == 0){
            throw new IllegalArgumentException("Operation cannot be empty");
        }

        int resultadoDoCalculo = 0;

        switch (operation){
            case "+":
                resultadoDoCalculo = operand1 + operand2;
                break;
            case "-":
                resultadoDoCalculo = operand1 - operand2;
                break;
            case "*":
                resultadoDoCalculo = operand1 * operand2;
                break;
            case "/":
                if(operand2 == 0) throw new IllegalOperationException("Division by zero is not allowed", new ArithmeticException());
                resultadoDoCalculo = operand1 / operand2;
                break;
            default:
                throw new IllegalOperationException(String.format("Operation '%s' does not exist", operation));
        }

        return String.format("%d %s %d = %d", operand1, operation, operand2, resultadoDoCalculo);

    }
}
