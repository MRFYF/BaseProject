package cn.cxyfyf.base.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
//        String str = "";
//        String[] split = str.split(",");
//        for (String s : split) {
//            System.out.println(s);
//        }
//        String clientId = "18315600755";
//        String date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
//        String raw = MD5Util.encrypt(clientId + date);
//        String pwd = new BCryptPasswordEncoder().encode(raw);
//        System.out.println(pwd);
//
//        StringBuilder builder = new StringBuilder();
//        builder.append("c3ab8gfngb1sh").append(System.currentTimeMillis() / 1000).append("#YunQue#").append("be54ce3ad2b60dcac1d31c0a1aa36999").toString();

//        HashSet<TestEnum> testEnums = Sets.newHashSet(TestEnum.AUTUMN, TestEnum.SPRING, TestEnum.AUTUMN);
//        System.out.println(testEnums);
//        Class<?> userClass = Class.forName("SysUser");
//        Field[] declaredFields = userClass.getDeclaredFields();
//        for (Field field : declaredFields) {
//            field.setAccessible(true);
//            log.info(field.getName());
//            Annotation[] annotations = field.getAnnotations();
//            if (Lists.newArrayList(field.getAnnotations()).contains(JsonFormat.class)) log.info(field.getName() + "JsonFormat");
//        }
//        System.out.println(new BigDecimal("2").compareTo(BigDecimal.ZERO));
//        System.out.println(new BigDecimal("200.31").negate());
//        System.out.println(BigDecimal.ZERO.negate());
        for (String s : "s,2".split(",")) {
            System.out.println(s);
        }

    }
}
