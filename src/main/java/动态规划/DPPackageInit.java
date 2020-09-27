package 动态规划;

import java.io.File;

public class DPPackageInit {

    static String path = "D:\\IdeaProjects\\algorithm\\src\\main\\java";

    public static void main(String[] args) {
        genLinkedList(DPPackageInit.class);
    }


    public static void genLinkedList(Class clazz) {
        String prePath = genPath(clazz);

        String str = "P205\t用 1~n 生成二叉搜索树\tleetcode 95. lintcode 164.\t中\n" +
                "P149\t二叉搜索树的数量\tleetcode 96. lintcode 163.\t中\n" +
                "P118\t第 n 个斐波那契数\tleetcode 509. lintcode 366.\t易\n" +
                "P100\t有效括号的最大长度\tleetcode 32.\t难\n" +
                "P88\t解码方式\tleetcode 91. lintcode 512.\t中\n" +
                "P84\t硬币面值组合问题\tleetcode 518. lintcode 740.\t中\n" +
                "P79\t最长递增子序列的长度\tleetcode 300. lintcode 76.\t中\n" +
                "P78\t爬楼梯的最小代价\tleetcode 746. lintcode 1054.\t易\n" +
                "P77\t路径数量（含障碍物）\tleetcode 63. lintcode 115.\t中\n" +
                "P76\t路径数量\tleetcode 62. lintcode 114.\t中\n" +
                "P75\t连续子序列的最大乘积\tleetcode 152. lintcode 191.\t中\n" +
                "P72\t抢劫环形房子\tleetcode 213. lintcode 534.\t中\n" +
                "P71\t抢劫连排房子\tleetcode 198. lintcode 392.\t易\n" +
                "P51\t最小路径和\tleetcode 64. lintcode 110.\t中\n" +
                "P46\t买卖股票的最大利润\tleetcode 121. lintcode 149.\t易\n" +
                "P32\t爬楼梯方法数\tleetcode 70. lintcode 111.\t易\n" +
                "P30\t编辑距离\tleetcode 72. lintcode 119.\t难\n" +
                "P26\t最长回文子串\tleetcode 5. lintcode 200.\t中\n" +
                "P21\t连续子序列的最大和\tleetcode 53. lintcode 41.\t易\n" +
                "P12\t回文子串个数\tleetcode 647. lintcode 837.\t中\n" +
                "P231\t最长摆动子序列的长度\tleetcode 376. lintcode 1164.\t中\t\n" +
                "P220\t回文分割需要的最少分割次数\tleetcode 132. lintcode 108.\t难\t\n" +
                "P215\t不可变矩阵的部分和查询\tleetcode 304. lintcode 665.\t中\t\n" +
                "P214\t不可变数组的区间和查询\tleetcode 303. lintcode 943.\t易\t\n" +
                "P212\tK 种颜色粉刷房子\tleetcode 265. lintcode 516.\t难\t\n" +
                "P211\t粉刷房子\tleetcode 256. lintcode 515.\t中\t\n" +
                "P208\t三角形中的最小路径和\tleetcode 120. lintcode 109.\t中\t\n" +
                "P206\t字符串的交错合并\tleetcode 97. lintcode 29.\t难\t\n" +
                "P173\t通配符匹配\tleetcode 44. lintcode 192.\t难\t\n" +
                "P153\t最少完全平方数分解\tleetcode 279. lintcode 513.\t中\t\n" +
                "P152\t简易正则表达式匹配\tleetcode 10. lintcode 154.\t难\t\n" +
                "P148\t0/1 矩阵中的最大正方形\tleetcode 221. lintcode 436.\t中\t\n" +
                "P120\t连续自然数二进制中 1 的个数\tleetcode 338. lintcode 664.\t中\t\n" +
                "P99\t第 n 个丑数\tleetcode 264. lintcode 4.\t中\t\n" +
                "P98\t字符串分解\tleetcode 139. lintcode 107.\t中\t\n" +
                "P85\t最小硬币组合\tleetcode 322. lintcode 669.\t中"
                ;
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
