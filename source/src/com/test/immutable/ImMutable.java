package com.test.immutable;

public class ImMutable {
	
	public static void main(String[] args) {
		System.out.println(countPossibleTriangles(12,16,5));
	}
	
	
	
	static int countPossibleTriangles(int A, int P, int a) {
        /*
         * Write your code here.
         */
        int sumOfOtherTwoSides= P-a ;
        int maxOneSide =-1;
        if(sumOfOtherTwoSides%2 == 0 ){
            maxOneSide =sumOfOtherTwoSides>>1;
        }else{
            maxOneSide = (sumOfOtherTwoSides >> 1 );
        }
        int ceilingIndex= findCeilIng(a ,A , maxOneSide, sumOfOtherTwoSides ,sumOfOtherTwoSides ,P);    
        return ceilingIndex -maxOneSide +1;
    }
    //Apply Devide and Conqur
    public static int findCeilIng(int a , int A , int maxOneSide , int sumOfOtherTwoSides,int sumOfOtherTwoSides1 , int P){
    	if(maxOneSide>sumOfOtherTwoSides)
    		return -1;
        if(maxOneSide==sumOfOtherTwoSides)
            return maxOneSide;
        else{
            int mid =maxOneSide + (sumOfOtherTwoSides-maxOneSide)/2;
            if(mid == maxOneSide )
            	return mid;
            if(isTringle(a , mid ,sumOfOtherTwoSides1- mid,A , P)){
                return  findCeilIng(a, A, mid, sumOfOtherTwoSides,sumOfOtherTwoSides1 ,P);  
            }else{
                return findCeilIng(a, A, maxOneSide, mid, sumOfOtherTwoSides1 ,P) ; 
            }
        }    
    }

    public static boolean isTringle(int a , int b , int c , int A , int P ){
        if(!(a+b >c && a+c >b && b+c >a))
            return false;
        int s = P>>1;
        return   Math.sqrt(s*(s-a)*(s-b)*(s-c)) >=A ;
    }
}
