package dfs;

import java.io.File;

public class DfsPackageInit {

    static String path = "D:\\IdeaProjects\\algorithm\\src\\main\\java";

    public static void main(String[] args) {
        genLinkedList(DfsPackageInit.class);
    }


    public static void genLinkedList(Class clazz) {
        String prePath = genPath(clazz);

        String str = "P227\t第一个出错的版本\tleetcode 278. lintcode 74.\t易\n" +
                "P197\t行列递增矩阵中第 K 小的元素\tleetcode 378. lintcode 1272.\t中\n" +
                "P175\t查找数组的波峰\tleetcode 162. lintcode 75.\t中\n" +
                "P174\t验证完全平方数\tleetcode 367. lintcode 777.\t易\n" +
                "P157\t查找重复数字\tleetcode 287. lintcode 633.\t中\n" +
                "P127\t旋转有序数组的最小值\tleetcode 153. lintcode 159.\t中\n" +
                "P109\t有序数组中查找数字的开始和结束下标\tleetcode 34. lintcode 61.\t中\n" +
                "P91\t旋转有序数组的搜索\tleetcode 33. lintcode 62.\t中\n" +
                "P79\t最长递增子序列的长度\tleetcode 300. lintcode 76.\t中\n" +
                "P56\t有序数组中的单身数字\tleetcode 540. lintcode 1183.\t中\n" +
                "P54\t实现平方根函数\tleetcode 69. lintcode 141.\t易\n" +
                "P38\t二维数组的二分搜索\tleetcode 74. lintcode 28.\t中\n" +
                "P37\t二分搜索插入位置\tleetcode 35. lintcode 60.\t易\n" +
                "P36\t二分搜索\tleetcode 704. lintcode 457.\t易\n" +
                "P20\t求两个有序数组的中位数\tleetcode 4. lintcode 65.\t难\n" +
                "P10\t数值的 n 次方\tleetcode 50. lintcode 428.\t中\n" +
                "P7\t行列递增的二维数组搜索\tleetcode 240. lintcode 38.\t中\n" +
                "P3\t有序数组中求和为给定值的两个数\tleetcode 167. lintcode 608.\t易";

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
