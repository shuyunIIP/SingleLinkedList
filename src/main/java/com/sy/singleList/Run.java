package com.sy.singleList;

import java.util.Scanner;

/**
 * @ClassName RunTest
 * @Description TODO
 * @Author DengShuyun BG401274
 * @Date 2019/10/23 18:56
 **/
public class Run {
    public static void main(String[] args) {
        SingleRankList singleRankList=new SingleRankList();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("各路英雄请抱拳！哈！\n迎面走来的英雄是：");
            String name = scanner.next();
            boolean flag=true;
            while(flag) {
                System.out.println("\n"+name+"即将要：\n0.结束操作;\t 1.争当擂主; \t2.挑战排位; \t 3.默默吃瓜\n" +
                        "4.退赛; \t5.查看擂主; \t6.查看排名第n位的英雄;\n7.查看榜单; \t8.换马甲");
                int option = scanner.nextInt();
                switch (option) {
                    case 0:
                        flag=false;
                        break;
                    case 1:
                        singleRankList.beFirst(name);
                        singleRankList.showRank();
                        break;
                    case 2:
                        System.out.println(name+"要挑战的排位是：");
                        int rank=scanner.nextInt();
                        singleRankList.challenge(name,rank);
                        singleRankList.showRank();
                        break;
                    case 3:
                        singleRankList.beLast(name);
                        singleRankList.showRank();
                        break;
                    case 4:
                        singleRankList.exist(name);
                        singleRankList.showRank();
                        break;
                    case 5:
                        singleRankList.checkFirst();
                        break;
                    case 6:
                        System.out.println(name+"要查看的排位位置为：");
                        int address=scanner.nextInt();
                        singleRankList.getHero(address);
                        break;
                    case 7:
                        singleRankList.showRank();
                        break;
                    case 8:
                        System.out.println("请输入新名字：");
                        singleRankList.updateName(name,scanner.next());
                        singleRankList.showRank();
                        break;
                }
            }
        }
    }
}
