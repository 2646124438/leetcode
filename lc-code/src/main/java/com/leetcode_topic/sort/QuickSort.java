package com.leetcode_topic.sort;

import java.util.Arrays;

public class QuickSort {
   public int[] quickSort(int[] arr){
       quickSort(arr, 0, arr.length-1);
       return arr;
    }
    public void quickSort(int[] arr, int left, int right){
        if(left>=right){
            return;
        }
        int start = left;
        int end = right;
        int cur = left;
        int arrCurr = arr[cur];

        while(left<right){
            while(right>left&&arrCurr<=arr[right]){
                right--;
            }
            arr[left] = arr[right];
            while(left<right&&arrCurr>=arr[left]){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left]=arrCurr;
        quickSort(arr, start, left-1);
        quickSort(arr, left+1, end);
    }

    public void swap(int[] arr, int i, int j){
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,3,4,5,72,3,55};
        arr = new QuickSort().quickSort(arr);
        Arrays.stream(arr).forEach(i->{
            System.out.println(i+",");
        });
    }
}
