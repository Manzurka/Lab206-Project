class Calculator implements java.io.Serializable {

    private double operandOne;
    private Character operation;
    private double operandTwo;
    
    public Calculator() {
    }
    public Calculator(double number, double number2) {
        this.operandOne = number;
        this.operation = '+';
        this.operandTwo = number2;
    }
    public Calculator(double number, Character o, double number2) {
        this.operandOne = number;
        this.operation = o;
        this.operandTwo = number2;
    }
    public double getResults() {
        double number = this.getOperandOne();
        Character o = this.getOperation();
        double number2 = this.getOperandTwo();
        double results = 0.00;

        if (o == '+') {
            results = number + number2;
        } else if (o == '-') {
            results = number - number2;
        } else if (o == '*') {
            results = number * number2;
        } else if (o == '/') {
            results = number / number2;
        }
        return results;
    }
    public double getOperandOne() {
        return operandOne;
    }
    public Character getOperation() {
        return operation;
    }
    public double getOperandTwo() {
        return operandTwo;
    }
    public void setOperandOne(double operandOne) {
        this.operandOne = operandOne; 
    }
    public void setOperation(Character operation) {
        this.operation = operation;
    }
    public void setOperandTwo(double operandTwo) {
        this.operandTwo = operandTwo;
    }
}
