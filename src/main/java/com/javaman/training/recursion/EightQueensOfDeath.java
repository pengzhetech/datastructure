package com.javaman.training.recursion;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pengzhe
 * @date 2020/5/23 22:03
 * @description 八皇后问题 回溯
 */
@Slf4j
public class EightQueensOfDeath {

    //先定义一个max表示共有多少个皇后
    int max = 8;
    //定义一个数组,保存皇后放置位置的结果 arr={0,4,7,5,2,6,1,3}
    int[] array = new int[max];

    static int count = 0;

    public static void main(String[] args) {
        EightQueensOfDeath eightQueensOfDeath = new EightQueensOfDeath();
        eightQueensOfDeath.check(0);
        log.info("一共有{}中解法", count);
    }

    //编写一个方法,放置第n个皇后
    //注意:check是每次递归时,进入到check中都有一套for循环,因此会有回溯

    private void check(int n) {
        //如果
        if (n == max) {//n=8,其实8个皇后就已然放好
            print();
            return;
        }
        //依次放入皇后,并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前的皇后n,放到该行的第1列
            array[n] = i;
            //判断当放置第n个皇后到i列时,是否冲突
            if (judge(n)) {//不冲突
                //接着放n+1个皇后,即开始递归
                check(n + 1);
            }
            //如果冲突,就继续执行array[n]=i;即将第n个皇后放置在本行的后移的一个位置
        }
    }


    //查看当我们放置第N个皇后时,就去检测该皇后是否和前面已经摆放的皇后冲突
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            /**
             * array[i] == array[n] 表示第N个皇后是否和前面的n-1个皇后在同一列
             * Math.abs(n - 1) == Math.abs(array[n] - array[i])
             * 表示第N个皇后是否和第i个皇后是否在同一斜线
             * 没有必要判断是否在同一行,n每次都在递增
             */
            if (array[i] == array[n] || Math.abs(n - 1) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //写一个方法,将皇后摆放的位置输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
