package cn.cxyfyf.base.test.testdecorator;

public class Test {

    public static void main(String[] args) {
        // 原味
        ICoffee iCoffee = new OriginalCoffee();
        iCoffee.makeCoffee();
        System.out.println("\n");

        // 加奶
        ICoffee iCoffee2 = new MilkDecorator(iCoffee);
        iCoffee2.makeCoffee();
        System.out.println("\n");

        // 加奶加糖
        ICoffee iCoffee3 = new SugarDecorator(iCoffee2);
        iCoffee3.makeCoffee();
        System.out.println("\n");

        // 加糖加奶
        ICoffee iCoffee4 = new MilkDecorator(new SugarDecorator(iCoffee));
        iCoffee4.makeCoffee();
        System.out.println("\n");
    }
}
