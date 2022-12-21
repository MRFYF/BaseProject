package cn.cxyfyf.base.test.testenum;

public class Test {
    public static void main(String[] args) {
        // 枚举单例的使用
        NewInstance instance = SingletonEnum.INSTANCE.getInstance();
        instance.doSomething();

        // 对于默认方法的调用和重写调用
        TestEnum.SPRING.showSec();
        TestEnum.WINTER.showSec();

        // 通过枚举name调用方法
        String name = TestEnum.SUMMER.name();
        TestEnum.valueOf(name).describe();
    }
}
