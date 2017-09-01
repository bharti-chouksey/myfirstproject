package com.aartek.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Testclass {
	
	
    public int alladd(List<Integer> arr) {
    	int sum =0;
        for(int i:arr)
        {
        
        			sum +=i;
        }
                    return sum;
        
    }


    public int findMax(int[] arr)
    {
    	int max =arr[0];
    	 for(int i=1;i<arr.length;i++){  
             if(max<arr[i])  
                 max=arr[i];  
         }  
         return max;
    	
    }
    public int cube(int n)
    {
    	return n*n*n;
    }
    
   
}
