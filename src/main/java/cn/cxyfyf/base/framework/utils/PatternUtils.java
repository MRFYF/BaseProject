package cn.cxyfyf.base.framework.utils;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @Date: Created in 2021/10/21 9:34
 * @Description: 正则匹配
 */
public class PatternUtils implements Serializable {
    private static final long serialVersionUID = -2026987668783348845L;

    /**
     * ^ 匹配输入字符串开始的位置
     * \d 匹配一个或多个数字，其中 \ 要转义，所以是 \\d
     * $ 匹配输入字符串结尾的位置
     */
    private static final Pattern HK_PATTERN = Pattern.compile("^(5|6|8|9)\\d{7}$");
    private static final Pattern CHINA_PATTERN = Pattern.compile("^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$");
    private static final Pattern NUM_PATTERN = Pattern.compile("[0-9]+");
    //小写字母
    private static final Pattern CHAR_LOW_PATTERN = Pattern.compile("[a-z]*");
    //大写字母
    private static final Pattern CHAR_UP_PATTERN = Pattern.compile("[A-Z]*");
    //特殊字符
    private static final String specialCharacter =  ".*[`~!@#$%^&*()+=|{}';',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\\\\]+.*";
    private static final Pattern SPECIAL_CHARACTER_PATTERN=Pattern.compile(specialCharacter);

    /**
     * 大陆号码或香港号码均可
     */
    public static boolean isPhoneLegal(String str) throws PatternSyntaxException {
        return isChinaPhoneLegal(str) || isHKPhoneLegal(str);
    }

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 145,147,149
     * 15+除4的任意数(不要写^4，这样的话字母也会被认为是正确的)
     * 166
     * 17+3,5,6,7,8
     * 18+任意数
     * 198,199
     */
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        Matcher m = CHINA_PATTERN.matcher(str);
        return m.matches();
    }

    /**
     * 香港手机号码8位数，5|6|8|9开头+7位任意数
     */
    public static boolean isHKPhoneLegal(String str) throws PatternSyntaxException {

        Matcher m = HK_PATTERN.matcher(str);
        return m.matches();
    }

    /**
     * 判断是否是正整数的方法
     */
    public static boolean isNumeric(String string) {
        return NUM_PATTERN.matcher(string).matches();
    }

    /**
     * 是否是身份证
     * @return
     */
    public static Boolean isPatternIdCard(String idCard){
        if (StringUtils.isEmpty(idCard)){
            return Boolean.FALSE;
        }
        //15位
        int length = idCard.length();
        if (length==15){
            return isNumeric(idCard);
        }
        //18位
        if (length==18){
            if (isNumeric(idCard)){
                return Boolean.TRUE;
            }
            String start = idCard.substring(0, length - 1);
            String end = idCard.substring(length - 1);

//            Matcher matcherLow = CHAR_LOW_PATTERN.matcher(end);
//            Matcher matcherUp = CHAR_UP_PATTERN.matcher(end);
            if ("X".equals(end.toUpperCase())&&isNumeric(start)){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 判断是否为特殊字符
     * @param param
     * @return
     */
    public static Boolean isScPattern(String param){
        Matcher matcher = SPECIAL_CHARACTER_PATTERN.matcher(param);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String idCard="37292919960624151;";
        Boolean patternIdCard = isPatternIdCard(idCard);
        System.out.println(patternIdCard);
    }
}
