package cn.cxyfyf.base.test.testdecorator;

public class SugarDecorator extends CoffeeDecorator{

    public SugarDecorator(ICoffee iCoffee) {
        super(iCoffee);
    }

    @Override
    public void makeCoffee() {
        super.makeCoffee();
        addSugar();
    }

    private void addSugar() {
        System.out.println("Add Sugar");
    }
}
