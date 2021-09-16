package com.learn.sample;

public class OptimizeOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arrayA = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
		int[][] arrayB = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println(getMaxOutput(arrayA, arrayB));
		
		int[][] arrayA2 = {{1, 0, 1}};
		int[][] arrayB2 = {{2, 1, 0}};
		System.out.println(getMaxOutput(arrayA2, arrayB2));
	}

	public static int getMaxOutput(int[][] a, int[][] b) {
		int iMaxOutput = 0, iFactoryA =0, iFactoryB=0;
		//System.out.println("Inside getMaxOutput");
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				//System.out.print(a[i][j]);
				if(a[i][j] >= b[i][j]) {
					iFactoryA = iFactoryA+a[i][j];
				}else {
					iFactoryB = iFactoryB+b[i][j];
				}
			}
		}
		
		return iFactoryA+iFactoryB;	//iMaxOutput
	}
}
