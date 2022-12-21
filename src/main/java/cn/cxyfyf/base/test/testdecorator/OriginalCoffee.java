package cn.cxyfyf.base.test.testdecorator;

public class OriginalCoffee implements ICoffee{
    @Override
    public void makeCoffee() {
        System.out.println("original coffee");
    }
}
