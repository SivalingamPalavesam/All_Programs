package com.java.string;

public class MatrixProgram {

	public static void main(String[] args) {

		int frsMatrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int secMatrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int trdMatrix[][] = new int[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					trdMatrix[i][j] += frsMatrix[i][k] * secMatrix[k][j];
				}
				System.out.print(trdMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
