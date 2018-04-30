package com.sawyer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// just to test it works
        List <int[]> matrix5 = fiveByFiveMatrix();
        printMatrix(matrix5);
        rotateMatrixCC(matrix5);

        List <int[]> matrix6 = sixBySixMatrix();
        printMatrix(matrix6);
        rotateMatrixCC(matrix6);
    }


    public static void printMatrix(List<int[]> matrix){
        System.out.println("********************************");
        for (int row = 0; row < matrix.size(); row ++){
            for (int i = 0; i < matrix.get(row).length; i++){
                System.out.print(matrix.get(row)[i] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void rotateMatrixCC(List<int[]> matrix){
        int depth = 0;
        while ( depth < matrix.size()/2){
            rotateMatrixCC(matrix, depth);
            depth ++;
        }
        System.out.println("*****************");
        printMatrix(matrix);
    }


    public static void rotateMatrixCC(List<int[]> matrix, int depth){
        int i = depth;
        int L = matrix.size() -1 -depth;
        while (i < L){
            int temp = matrix.get(depth)[i];
            matrix.get(depth)[i] = matrix.get(i)[L];
            matrix.get(i)[L] = matrix.get(L)[L-i + depth];
            matrix.get(L)[L-i + depth] = matrix.get(L-i+depth)[depth];
            matrix.get(L-i+depth)[depth] = temp;
            i ++;
        }
    }

    public static  List <int[]> fiveByFiveMatrix(){
        List <int[]> matrix = new ArrayList();
        int[] row1 = new int[5];
        int[] row2 = new int[5];
        int[] row3 = new int[5];
        int[] row4 = new int[5];
        int[] row5 = new int[5];
        int i = 0;
        while (i < 5) {
            row1[i] = i;
            row2[i] = i + 5;
            row3[i] = i + 10;
            row4[i] = i + 15;
            row5[i] = i + 20;
            i++;
        }

        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);
        matrix.add(row4);
        matrix.add(row5);
        return matrix;
    }

    public static  List <int[]> sixBySixMatrix(){
        List <int[]> matrix = new ArrayList();
        int[] row1 = new int[6];
        int[] row2 = new int[6];
        int[] row3 = new int[6];
        int[] row4 = new int[6];
        int[] row5 = new int[6];
        int[] row6 = new int[6];
        int i = 0;
        while (i < 6) {
            row1[i] = i;
            row2[i] = i + 6;
            row3[i] = i + 12;
            row4[i] = i + 18;
            row5[i] = i + 24;
            row6[i] = i + 30;
            i++;
        }

        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);
        matrix.add(row4);
        matrix.add(row5);
        matrix.add(row6);
        return matrix;
    }



}
