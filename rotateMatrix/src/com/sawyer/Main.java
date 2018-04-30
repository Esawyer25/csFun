package com.sawyer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    //TO-DO: add input validations.
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

    // depth == 0 when rotating the outer perimeter, then 1 when moving in one row, then 2... ex for this matrix
    // Length = the largest index of a row that we are currently working with.
    // 1  2  3  4  5
    // 6  7  8  9 10
    // 11 12 13 14 15
    // 16 17 18 19 20
    // 21 22 23 24 25
    //
    // depth = 0
    // matrixLength = 5-1 = 4 (ints are in indexes depth to matrix length, or 0 to 4)
    // 1  2  3  4  5
    // 6           10
    // 11          15
    // 16          20
    // 21 22 23 24 25
    //
    // depth = 1
    // matrixLength = 5 - 1 - 1 = 3 (ints are in indexes depth to matrix length, or 1 to 3)
    //  7  8  9
    //  12    14
    //  17 18 19
    //

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
        int matrixLength = matrix.size() - 1 -depth;

        while (i < matrixLength){
            int temp = matrix.get(depth)[i];
            matrix.get(depth)[i] = matrix.get(i)[matrixLength];
            matrix.get(i)[matrixLength] = matrix.get(matrixLength)[matrixLength-i + depth];
            matrix.get(matrixLength)[matrixLength-i + depth] = matrix.get(matrixLength-i+depth)[depth];
            matrix.get(matrixLength-i+depth)[depth] = temp;
            i ++;
        }
    }

    //really inefficeint way to make a matrix:
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
