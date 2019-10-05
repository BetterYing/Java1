//实现加减乘除四种运算
public class Calculator {
    private double num1;
    private double num2;

    public double add(double num1,double num2){
        this.num1 = num1;
        this.num2 = num2;
        return this.num1 + this.num2;
    }
    public double sub(double num1,double num2){
        this.num1 = num1;
        this.num2 = num2;
        return this.num1 - this.num2;
    }
    public double mul(double num1,double num2){
        this.num1 = num1;
        this.num2 = num2;
        return this.num1 * this.num2;
    }
    public double div(double num1,double num2){
        this.num1 = num1;
        this.num2 = num2;
        return this.num1 / this.num2;
    }
}

