package com.kostenko.calcengine;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        performCalculations();
//
//        Divider divider = new Divider();
//        doCalculation(divider, 100.0, 50.0);
//
//        Adder adder = new Adder();
//        doCalculation(adder, 25.0, 92.0);

//        performMoreCalculations();
//        executeInteractively();
        dynamicInteractivity();
    }

    private static void dynamicInteractivity() {
        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new PowerOf()
        });
        System.out.println("Enter an operation and two numbers: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        helper.process(userInput);
    }

    static void executeInteractively(){
        System.out.println("Enter an operation and two numbers: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
        double leftVal = Double.parseDouble(parts[1]);
        double rightVal = Double.parseDouble(parts[2]);
        CalculateBase calculation = createCalculation(operation, leftVal, rightVal);
        calculation.calculate();
        System.out.println("Operation performed: " + operation);
        System.out.println(calculation.getResult());
    }

    private static CalculateBase createCalculation(MathOperation operation, double leftVal, double rightVal) {
        CalculateBase calculation = null;
        switch (operation) {
            case ADD: calculation = new Adder(leftVal, rightVal);
            break;
            case DIVIDE: calculation = new Divider(leftVal, rightVal);
            break;
            case MULTIPLY: calculation = new Multiplier(leftVal, rightVal);
            break;
            case SUBTRACT: calculation = new Subtractor(leftVal, rightVal);
            break;
        }
        return calculation;
    }
    private static void performMoreCalculations() {
        CalculateBase[] calculations = {
                new Divider(100d, 25d),
                new Adder(92d, 27d),
                new Subtractor(225d, 17d),
                new Multiplier(11d, 3d)
        };
        System.out.println();
        System.out.println("Array calculations");

        for(CalculateBase calculation : calculations){
           calculation.calculate();
            System.out.println("result = " + calculation.getResult());
        }
    }

    public static void doCalculation(CalculateBase calculation, double leftVal, double rightVal) {

        calculation.setLeftVal(leftVal);
        calculation.setRightVal(rightVal);
        calculation.calculate();
        System.out.println("Calculation result " + calculation.getResult());

    }
    public static void performCalculations() {

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation(100.0d, 50.0d, 'd');
        equations[1] = new MathEquation(25.0d, 92.0d, 'a');
        equations[2] = new MathEquation(225.0d, 17.0d, 's');
        equations[3] = new MathEquation(11.0d, 3.0d, 'm');

        for (MathEquation equation : equations){
            equation.execute();
            System.out.println("result = " + equation.result);
        }

        System.out.println("Average result = " + MathEquation.getAverageResult());

        System.out.println();
        System.out.println("Using execute overloads");
        System.out.println();

        MathEquation equationOverload = new MathEquation('d');
        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        equationOverload.execute(leftDouble, rightDouble);
        System.out.println("Overload result with doubles: " + equationOverload.getResult());

        int leftInt = 9;
        int rightInt = 4;

        equationOverload.execute(leftInt, rightInt);
        System.out.println("Overload result with int: " + equationOverload.getResult());
    }

}
