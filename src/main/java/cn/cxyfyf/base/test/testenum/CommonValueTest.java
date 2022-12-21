package cn.cxyfyf.base.test.testenum;

import cn.cxyfyf.base.controller.ExampleDTO;
import cn.cxyfyf.base.test.CommonValueProcessor;
import com.alibaba.fastjson.JSON;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述
 *
 * @author fengyingfeng
 * Create by 2022/12/9 15:49
 */

public class CommonValueTest {

    /**
     * 初始化CommonValueProcessor
     * 在实际项目中可以通过注入使用
     * 例：
     * @Autowired
     * CommonValueProcessor<ExampleDTO> processor;
     */
    CommonValueProcessor<ExampleDTO> processor = new CommonValueProcessor<>();

    public static void main(String[] args) {
        CommonValueTest test = new CommonValueTest();
        test.test01();
//        test.test02();
//        test.test03();
//        test.test04();
    }

    /**
     * 处理单个实体类全部参数
     */
    private void test01() {
        ExampleDTO vo = new ExampleDTO();
        vo.setDictCode("item001");
        vo.setCityCode("370100");
        vo.setUserId("user001");
        vo.setCreateDate(new Date());
        vo.setStartDate(LocalDateTime.now());
        processor.dealWithData(vo);
        System.out.println(JSON.toJSONString(vo));
    }
    /**
     * 处理单个实体类部分参数
     */
    private void test02() {
        ExampleDTO vo = new ExampleDTO();
        vo.setDictCode("item001");
        vo.setCityCode("370100");
        vo.setUserId("user001");
        processor.dealWithData(vo, "userId,cityCode"); // 只处理用户、城市
        System.out.println(JSON.toJSONString(vo));
    }
    /**
     * 处理列表全部参数
     */
    private void test03() {
        List<ExampleDTO> list = new ArrayList<>();
        ExampleDTO vo = new ExampleDTO();
        vo.setDictCode("item001");
        vo.setCityCode("370100");
        vo.setUserId("user001");
        list.add(vo);
        ExampleDTO vo2 = new ExampleDTO();
        vo2.setDictCode("item002");
        vo2.setCityCode("370200");
        vo2.setUserId("user002");
        list.add(vo2);
        processor.dealWithListData(list);
        System.out.println(JSON.toJSONString(list));
    }
    /**
     * 处理列表部分参数
     */
    private void test04() {
        List<ExampleDTO> list = new ArrayList<>();
        ExampleDTO vo = new ExampleDTO();
        vo.setDictCode("item001");
        vo.setCityCode("370100");
        vo.setUserId("user001");
        list.add(vo);
        ExampleDTO vo2 = new ExampleDTO();
        vo2.setDictCode("item002");
        vo2.setCityCode("370200");
        vo2.setUserId("user002");
        list.add(vo2);
        processor.dealWithListData(list, "userId,cityCode");
        System.out.println(JSON.toJSONString(list));
    }



}
