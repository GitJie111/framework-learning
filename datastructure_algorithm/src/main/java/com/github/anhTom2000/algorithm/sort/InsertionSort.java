package com.github.anhTom2000.algorithm.sort;

import java.util.Arrays;

/**
 * @author guang19
 * @date 2020/5/1
 * @description  插入排序
 * @since 1.0.0
 */
public class InsertionSort
{
    public static void main(String[] args)
    {
        int[] arr = {3,5,0,-9,8,30,25,8,10};

        /**
         * 假设有序队列为{3},从5开始插入:
         * 第一次: 3,5,0,-9,8,30,25,8,10    有序队列{3}， 要插入的值: 5
         * 第二次: 0,3,5,-9,8,30,25,8,10    有序队列{3,5} 要插入的值: 0
         * 第三次: -9,0,3,5,8,30,25,8,10    有序队列{0,3,5} 要插入的值：-9
         * 第四次: -9,0,3,5,8,30,25,8,10    有序队列{-9,0,3,5} 要插入的值：8
         * 第五次: -9,0,3,5,8,30,25,8,10    有序队列{-9,0,3,5,8} 要插入的值: 30
         * 第六次： -9,0,3,5,8,25,30,8,10    有序队列{-9,0,3,5,8,30} 要插入的值: 25
         * 第七次： -9,0,3,5,8,8,25,30,10    有序队列{-9,0,3,5,8,25,30} 要插入的值: 8
         * 第八次： -9,0,3,5,8,8,10,25,30    有序队列{-9,0,3,5,8,8,25,30} 要插入的值: 10
         *
         *  可以看到，插入排序类似于把整个集合分为2个队列：一个有序队列，一个无序队列，每次将无序队列的第一个元素插入到
         *  有序队列合适的位置。
         *
         *  是否可以优化?
         *  我们发现: 当无序队列的第一个元素大于有序队列的最后一个元素的时候，是无需交换的，从这点来看是有优化空间的。
         *
         */
        //要插入的值
        int insertVal;
        //要插入的位置
        int insertIndex;
        //从第二个元素开始插入
        for (int i = 1; i < arr.length; ++i)
        {
            //要插入的值
            insertVal = arr[i];
            //从有序队列的右边开始遍历有序队列,如果要插入的值小于有序队列的某个值，那么就将要插入的值插入到有序队列的合适位置
            for (int j = insertIndex = i ; j > 0 && insertVal < arr[j - 1]; --j)
            {
                arr[j] = arr[j - 1];
                insertIndex = j - 1;
            }
            //判断要插入的值是否没变过，如没变过，就说明无序队列的第一个元素大于等于有序队列的最后一个元素,此时就不用交换
            if(insertIndex != i)
            {
                //插入
                arr[insertIndex] = insertVal;
            }
        }

        System.out.println("插入排序后的数组为: ");
        System.out.println(Arrays.toString(arr));
    }
}
