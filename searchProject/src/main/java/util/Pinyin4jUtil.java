package util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pinyin4jUtil {
    private static final  String CHINESE_PATTREN = "[\\u4E00-\\u9FA5]";

    private static final HanyuPinyinOutputFormat FORMAT = new HanyuPinyinOutputFormat();

    static {
        FORMAT.setCaseType(HanyuPinyinCaseType.LOWERCASE);//设置拼音小写
        FORMAT.setToneType(HanyuPinyinToneType.WITHOUT_TONE);//设置不带音调
        FORMAT.setVCharType(HanyuPinyinVCharType.WITH_V);//设置带v字符
    }

    /**
     * 判断字符是否包含中文
     * @param str
     * @return
     */
    public static boolean containsChinese (String str) {
        return str.matches(".*" + CHINESE_PATTREN + ".*");
    }


    public static String[] get(String hanyu)  {
        String[] array = new String[2];
        // 全拼
        StringBuilder pinyin = new StringBuilder();
        //拼音首字母
        StringBuilder pinyin_first = new StringBuilder();
        for (int i = 0; i < hanyu.length(); i++) {
            try {
                String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(hanyu.charAt(i),FORMAT);

                // 中文字符返回的字符串数组，可能为null或长度为0
                // 返回原始的字符
                if(pinyins == null || pinyins.length == 0) {
                    pinyin.append(hanyu.charAt(i));
                    pinyin_first.append(hanyu.charAt(i));
                } else {
                    pinyin.append(pinyins[0]);
                    pinyin_first.append(pinyins[0].charAt(0));
                }
            } catch (Exception e) {
                //出现异常返回原始字符 例如 汉语字符为 0 ,字母
                pinyin.append(hanyu.charAt(i));
                pinyin_first.append(hanyu.charAt(i));
            }
        }
        array[0] = pinyin.toString();
        array[1] = pinyin_first.toString();
        return array;
    }


    /*
    //两两组合
    public static String[][] get1 (String hanyu,boolean fullSpell) {
        String[][] array = new String[hanyu.length()][];
        for (int i = 0; i < hanyu.length(); i++) {
            try {
                String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(hanyu.charAt(i), FORMAT);
                //中文字符返回的字符串数组，可能为null或0
                //返回原始字符
                if (pinyins == null || pinyins.length == 0) {
                    array[i] = new String[]{String.valueOf(hanyu.charAt(i))};
                } else {
                    //可以转换为拼音，只取第一个字符串作为拼音
                    array[i] = unique(pinyins,fullSpell);
                }
            } catch (Exception e) {
                //出现异常，返回原始字符
                array[i] = new String[]{String.valueOf(hanyu.charAt(i))};
            }
        }

        return array;
    }

    private static String[] unique(String[] pinyins,boolean fullSpell) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pinyins.length; i++) {
            if (fullSpell){
                set.add(pinyins[i]);
            } else {
                set.add(String.valueOf(pinyins[i].charAt(0)));
            }
        }
        return pinyins;
    }
    */

    public static void main(String[] args) {
        String[] s = get("中华人民共和国");
        System.out.println(Arrays.toString(s));


        System.out.println(containsChinese("abc"));
        System.out.println(containsChinese("a啊b"));
    }

}
