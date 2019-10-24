package com.hackerearth.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given a number N, find the minimum number of primatic numbers which sum upto N.
 * A primatic number refers to a number which is either a prime number or can be 
 * expressed as power of prime number to itself i.e. primeprime e.g. 4, 27, etc.
 * Note: 8, 32, etc are not primatic numbers.
 * 
 * Input Format:
 * The first line will contain two integers: T, the number of test cases.
 * Each test case consists of a single integer N.
 * 
 * Output Format:
 * For each query output the minimum number of primatic numbers which can sum upto N.
 * 
 * SAMPLE INPUT 			SAMPLE OUTPUT 
 * 2							2
 * 6							1
 * 3
 * 
 */
public class PrimeNumsAgain {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iTestCases = Integer.valueOf(br.readLine());
		int i=0;
		for(;i<iTestCases; i++) {
			System.out.println(checkMinPrimaticNum(Integer.valueOf(br.readLine())));
		}
	}
	
	public static int checkMinPrimaticNum(int iNum) {
		
		int iMin = 0, temp =0;
		// Check if it Prime
		if(isPrimeNum(iNum))
			return 1;
		temp = iNum-1;
		
		while(temp > 1) {
			
			// Check if temp is Prime
			if(isPrimeNum(temp)) {
				
				// If differece is 1, don't considet the Prime
				if((iNum - temp)==1) {
					temp--;
					continue;
				}
				
				// Check If power matched
				if(iNum%(Math.pow(temp, temp)) == 0)
					return iMin+1;
				if(iNum%temp == 0)
					return iMin+(iNum/temp);
				
				temp = iNum - temp;
				iNum = temp;
				iMin++;
			}else {			// If not prime, decrease temp value
			temp--;
			}
		}
		
		return iMin;
	}

	public static boolean isPrimeNum(int num) { 
		
		if(num ==2 || num ==3)
			return true;
		if(num%2==0)
			return false;
		int sqrt = (int) (Math.sqrt(num)+1);
		for(int i=3; i<sqrt; i += 2) {
			if(num%i == 0)
				return false;
		}
		return true;
	}
}
