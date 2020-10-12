package com.huan.parsearray;


/**
 * 总结
 *
 * 0. 稀疏数组是一个 sum+1 行 3 列的二维数组
 *
 * <p>
 * 1. java 创建的二维数组， int 类型的默认值是 0 ,String 类型默认值为 null
 * <p>
 * 2. java 自带打印信息  System.out.printf("%d",数值一) 其中 %d 为占位符  \t(表示空格) \n (表示换行)
 */


/**
 * @author mubaisama
 */
public class ParseArray {
    public static void main(String[] args) {
        //  初始化二维数组
        int[][] parseArr = new int[11][11];
        parseArr[1][2] = 1;
        parseArr[2][3] = 2;
        parseArr[3][4] = 2;
        for (int[] arr : parseArr) {
            for (Integer index : arr) {
                System.out.printf("%d\t", index);
            }
            System.out.printf("\n");
        }

        // 将二位数组转化为稀疏数组
        // 1. 获取二维数组中有效值总数
        int sum = 0;
        for (int[] arr : parseArr) {
            for (Integer index : arr) {
                if (index != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum :" + sum);
        // 2. 创建 稀疏数组
        int[][] parseArray = new int[sum + 1][3];
        parseArray[0][0] = 11;
        parseArray[0][1] = 11;
        parseArray[0][2] = sum;
        //3. 遍历二维数组将有信息的值存入稀疏数组中
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (parseArr[i][j] != 0) {
                    count++;
                    parseArray[count][0] = i;
                    parseArray[count][1] = j;
                    parseArray[count][2] = parseArr[i][j];
                }
            }
        }
        //4打印稀疏数组
        for (int i = 0; i < sum + 1; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d\t", parseArray[i][j]);
            }
            System.out.println();
        }

        // 将稀疏数组 转换为普通二维数组

        // 1. 根据稀疏数组 第一行内容还原 二维数组
        int[][] array = new int[parseArray[0][0]][parseArray[0][1]];
        // 2. 从第二行起遍历稀疏数组
        for (int i = 1; i < sum + 1; i++) {
            array[parseArray[i][0]][parseArray[i][1]] = parseArray[i][2];
        }
        // 3. 打印还原回的 二维数组
        for (int[] index : array) {
            for (int data : index) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


    }
}
