package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
       /* byte[][] a3 = new byte[][]{
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };*/
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };


        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
      /*  int count3 = getRectangleCount(a3);
        System.out.println("count = " + count3 + ". Должно быть 1");*/
        int count2 = getRectangleCount(a2);
       System.out.println("count = " + count2 + ". Должно быть 4");


    }

    public static int getRectangleCount(byte[][] a) {

        int x = 0;
        int y = 0;


        int count = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {

                if (a[i][j] == 1 )
                {x = i; y = j; i = a.length; count++; break;}

            }

        }


       // System.out.println(x + " " + y);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 1 && i == 0)
                {
                    if (j - y <= 1) {x = i; y = j; continue;}
                    else if (j - y > 1) {count++; x = i; y = j; continue;}
                }
                if (a[i][j] == 1 && i == a.length-1)
                {
                    if (j - y <= 1 && i - x <= 1) {x = i; y = j; continue;}
                    else if (j - y <= 1 && i - x > 1) {count++; x = i; y = j; continue;}
                    else if (j - y > 1 && i - x <= 1 && a[i-1][j] ==1) {x = i; y = j; continue;}
                    else if (j - y > 1 && i - x <= 1 && a[i-1][j] !=1) {count++; x = i; y = j; continue;}

                }
                if (a[i][j] == 1 && i != a.length-1 && i != 0)
                {
                    if (j - y <= 1 && i - x <= 1) {x = i; y = j; continue;}
                    else if (j - y <= 1 && i - x > 1) {count++; x = i; y = j; continue;}
                    else if (j - y > 1 && i - x <= 1 && a[i-1][j] ==1) {x = i; y = j; continue;}
                    else if (j - y > 1 && i - x <= 1 && a[i-1][j] !=1) {count++; x = i; y = j; continue;}
                }


            }

        }



        return count;

    }

}
