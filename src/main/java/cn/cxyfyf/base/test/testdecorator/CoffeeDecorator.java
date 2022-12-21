package cn.cxyfyf.base.test.testdecorator;

public abstract class CoffeeDecorator implements ICoffee{
    private final ICoffee iCoffee;

    public CoffeeDecorator(ICoffee iCoffee) {
        this.iCoffee = iCoffee;
    }

    @Override
    public void makeCoffee() {
        iCoffee.makeCoffee();
    }
}
