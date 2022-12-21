package cn.cxyfyf.base.test.testenum;

public interface ITest2 {

    String show(String id);

    /**
     * default method
     */
    default void showSec(){
        System.out.println("这就是个默认方法！");
    }
}
