public class Calculator {
    public double num1;
    public double num2;

    public double add(double num1,double num2) {
        return num1 + num2;
    }
    public double sub(double num1,double num2) {
        if (num1 > num2) {
            return num1 - num2;
        } else {
            return num2 - num1;
        }
    }
    public double mul(double num1,double num2){
        return num1 * num2;
    }
    public double div(double num1,double num2){
        return num1 / num2;
    }
}
