package com.kostenko.calcengine;

public class MathEquation {
    double leftVal;
    double rightVal;
    char opCode;
    double result;

    private static int numberOfCalculations;
    private static double sumOfResults;

    public MathEquation(){}

    public MathEquation(char opCode){
        this.opCode = opCode;
    }

    public MathEquation(double leftVal, double rightVal, char opCode){
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public void execute() {
        switch (opCode){
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = rightVal != 0? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
                break;
        }

        numberOfCalculations++;
        sumOfResults += result;

    }

    public void execute(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;

        execute();
    }

    public void execute(int leftVal, int rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
        result = (int)result;
    }

    public static double getAverageResult(){
        return sumOfResults / numberOfCalculations;
    }

    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }
    public double getLeftVal() {return leftVal;}

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }
    public double getRightVal(){return rightVal;}

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }
    public char getOpCode() {return opCode;}

    public double getResult() {
        return result;
    }
}
