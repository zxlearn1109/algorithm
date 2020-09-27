package 链表;

import java.io.File;

public class LinkedListPackageInit {
    public static void main(String[] args) {
        String path = "D:\\Projects\\algorithm\\src\\main\\java\\链表";
        String str = "P210\t两两交换链表中的节点\tleetcode 24. lintcode 451.\t中\n" +
                "P195\t链表加一\tleetcode 369. lintcode 904.\t中\n" +
                "P187\t奇偶链表\tleetcode 328. lintcode 1292.\t中\n" +
                "P182\t单链表插入排序\tleetcode 147. lintcode 173.\t中\n" +
                "P126\t删除链表节点\tleetcode 237. lintcode 372.\t易\n" +
                "P111\t旋转单链表\tleetcode 61. lintcode 170.\t中\n" +
                "P104\t链表划分\tleetcode 86. lintcode 96.\t中\n" +
                "P102\t含随机指针的链表拷贝\tleetcode 138. lintcode 105.\t中\n" +
                "P101\t单链表中间节点\tleetcode 876. lintcode 228.\t易\n" +
                "P96\t单链表排序\tleetcode 148. lintcode 98.\t中\n" +
                "P94\t单链表中圆环的开始节点\tleetcode 142. lintcode 103.\t中\n" +
                "P90\t合并 K 个有序链表\tleetcode 23. lintcode 104.\t难\n" +
                "P74\t有序链表删除重复节点\tleetcode 82. lintcode 113.\t中\n" +
                "P73\t有序链表去重\tleetcode 83. lintcode 112.\t易\n" +
                "P52\t移除单链表倒数第 n 个节点\tleetcode 19. lintcode 174.\t中\n" +
                "P48\t单链表删除数字\tleetcode 203. lintcode 452.\t易\n" +
                "P40\t求两个单链表之和\tleetcode 2. lintcode 167.\t中\n" +
                "P28\t链表的相交节点\tleetcode 160. lintcode 380.\t易\n" +
                "P27\t判断单链表是否有环\tleetcode 141. lintcode 102.\t易\n" +
                "P18\t合并两个有序链表\tleetcode 21. lintcode 165.\t易\n" +
                "P14\t判断单链表是否为回文链表\tleetcode 234. lintcode 223.\t易\n" +
                "P9\t反转单链表\tleetcode 206. lintcode 35.\t易";
        String[] rowArr = str.split("\n");
        for (String row : rowArr) {
            String[] strs = row.split("\t");
            String name = strs[1];
            String num = strs[2].split("\\.")[0].split(" ")[1];

            String newPath = path + "\\" + name + "_" + num;
            File file = new File(newPath);
            if (!file.exists()) file.mkdirs();
        }
    }


}
