package cn.cxyfyf.base.test.testenum;

/**
 * 枚举单例
 */
public enum SingletonEnum {

    INSTANCE;

    private final NewInstance newInstance;

    SingletonEnum() {
        this.newInstance = new NewInstance();
    }

    public NewInstance getInstance() {
        return newInstance;
    }

}

/**
 * instance
 */
class NewInstance {
    public NewInstance() {
        System.out.println("-------------- New Instance -------------");
    }

    public void doSomething(){
        System.out.println("单例调用方法的具体逻辑！！");
    }
}
