package 双指针;

import java.io.File;

public class TwoPointerPackageInit {

    static String path = "D:\\IdeaProjects\\algorithm\\src\\main\\java";

    public static void main(String[] args) {
        genLinkedList(TwoPointerPackageInit.class);
    }


    public static void genLinkedList(Class clazz) {
        String prePath = genPath(clazz);

        String str = "P221\t旋转字符串\tleetcode 796.\t易\n" +
                "P217\t移除数组中指定数字\tleetcode 27. lintcode 172.\t易\n" +
                "P180\t快乐数\tleetcode 202. lintcode 488.\t易\n" +
                "P176\t两个数组的交集\tleetcode 350. lintcode 548.\t易\n" +
                "P171\t两个完全平方数的和\tleetcode 633. lintcode 697.\t易\n" +
                "P168\t移除有序数组中的重复元素\tleetcode 26. lintcode 100.\t易\n" +
                "P165\t相加等于目标值的四个数\tleetcode 18. lintcode 58.\t中\n" +
                "P164\t求和最接近目标值的三个数\tleetcode 16. lintcode 59.\t中\n" +
                "P157\t查找重复数字\tleetcode 287. lintcode 633.\t中\n" +
                "P111\t旋转单链表\tleetcode 61. lintcode 170.\t中\n" +
                "P108\t雨后盛水量\tleetcode 42. lintcode 363.\t难\n" +
                "P104\t链表划分\tleetcode 86. lintcode 96.\t中\n" +
                "P103\t包含给定字符的最短子串\tleetcode 76. lintcode 32.\t难\n" +
                "P94\t单链表中圆环的开始节点\tleetcode 142. lintcode 103.\t中\n" +
                "P86\t荷兰国旗问题\tleetcode 75. lintcode 148.\t中\n" +
                "P81\t反转字符串\tleetcode 344. lintcode 1283.\t易\n" +
                "P80\t向后移动 0\tleetcode 283. lintcode 539.\t易\n" +
                "P53\t相加等于 0 的三个数\tleetcode 15. lintcode 57.\t中\n" +
                "P52\t移除单链表倒数第 n 个节点\tleetcode 19. lintcode 174.\t中\n" +
                "P43\t实现 strstr\tleetcode 28. lintcode 13.\t易\n" +
                "P31\t容纳最多水的凹槽容量\tleetcode 11. lintcode 383.\t中\n" +
                "P27\t判断单链表是否有环\tleetcode 141. lintcode 102.\t易\n" +
                "P25\t没有重复字符的最长子串长度\tleetcode 3. lintcode 384.\t中\n" +
                "P19\t合并两个有序数组\tleetcode 88. lintcode 64.\t易\n" +
                "P14\t判断单链表是否为回文链表\tleetcode 234. lintcode 223.\t易\n" +
                "P3\t有序数组中求和为给定值的两个数\tleetcode 167. lintcode 608.\t易\n" +
                "P1\t回文字符串判断\tleetcode 125. lintcode 415.\t易";
        String[] rowArr = str.split("\n");
        for (String row : rowArr) {
            String[] strs = row.split("\t");
            String name = strs[1];
            String num = strs[2].split("\\.")[0].split(" ")[1];

            String newPath = prePath + "\\" + name + "_" + num;
            File file = new File(newPath);
            if (!file.exists()) file.mkdirs();
        }
    }

    private static String genPath(Class clazz) {
        String fp = path;
        String replace = clazz.getName().
                replace("." + clazz.getSimpleName(), "");
        String[] split = replace.split("\\.");
        for (String s : split) {
            fp += "\\" + s;
        }
        return fp;
    }
}
