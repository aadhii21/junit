package com.adhi;

import org.jspecify.annotations.NonNull;

public class reverseString {
    public String reverseString1(@NonNull String str){
        //String str1="lalith";
        char[] arr= str.toCharArray();
        int left=0;
        int right=arr.length-1;
        while (left<right){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;

        }
        System.out.println(arr);
        return new String(arr);
    }
}
