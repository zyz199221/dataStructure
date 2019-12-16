package com.example.datastructure.sparsearray;

/**
 * 文件名：SparsrArray
 * 作 者：Miles zhu
 * 时 间：2019/12/12 22:32
 * -------------------------
 * 功能和描述：
 **/
public class SparsrArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组 11*11
        //0：表示没有棋子，1：黑子，2：篮子
        int cow = 11;
        int col = 11;
        int chessArr[][] = new int[cow][col];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                System.out.printf("%s\t", anInt);
            }
            System.out.println();
        }

        int sum = 0;
        //计算原始数组一共有多少个数据
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                if (0 != anInt) {
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);
        System.out.println();

        //根据原始数组创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //先将稀疏数组的第一行赋值--->分别为原始的二维数组的 【行】 【列】 【有效数据个数】
        sparseArr[0][0] = cow;
        sparseArr[0][1] = col;
        sparseArr[0][2] = sum;

        int couneCow = 0;
        //将原始数组中的值存放到稀疏数组中
        System.out.println("将原始的二维数组转成稀疏数组......");
        for (int i = 0; i < cow; i++) {
            for (int j = 0; j < col; j++) {
                if (0 != chessArr[i][j]) {
                    couneCow++;
                    sparseArr[couneCow][0] = i;
                    sparseArr[couneCow][1] = j;
                    sparseArr[couneCow][2] = chessArr[i][j];
                }
            }
        }

        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.printf("%s\t", anInt);
            }
            System.out.println();
        }

        //将稀疏数组恢复成二维数组“
        System.out.println("将稀疏数组恢复成二维数组");
        int[][] chessArrNew = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArrNew[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //恢复后的二维数组为
        for (int[] ints : chessArrNew) {
            for (int anInt : ints) {
                System.out.printf("%s\t", anInt);
            }
            System.out.println();
        }

    }
}
