package cn.cxyfyf.base.test.testenum;

public enum TestEnum implements ITest, ITest2{

    SPRING() {
        @Override
        public String show(String id) {
            return "SPRING" + id;
        }

        @Override
        public void describe() {
            System.out.println("春江水阿暖鸭先知");
        }

        @Override
        public void showSec() {
            System.out.println("这是修改后的默认方法！");
        }
    },
    SUMMER() {
        @Override
        public String show(String id) {
            return "SUMMER" + id;
        }

        @Override
        public void describe() {
            System.out.println("我爱山中夏，空冥花雨下。");
        }
    },
    AUTUMN(){
        @Override
        public String show(String id) {
            return "AUTUMN" + id;
        }

        @Override
        public void describe() {
            System.out.println("停车坐爱枫林晚，霜叶红于二月花。");
        }
    },
    WINTER() {
        @Override
        public String show(String id) {
            return "WINTER" + id;
        }

        @Override
        public void describe() {
            System.out.println("北国风光，千里冰封，万里雪飘。");
        }
    },
    ;

}
