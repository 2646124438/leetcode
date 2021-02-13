package com.leetcode_topic.sort;

import java.util.Arrays;

public class MergeSort{
    public int[] mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
        return arr;
    }
    public void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left<right){
            int mid = left+(right-left)/2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid+1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }
    public void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i=left;
        int j = mid+1;
        int t = 0;
        while(i<=mid&&j<=right){
            if(arr[i]>arr[j]){
                temp[t] = arr[j];
                j++;
            }else{
                temp[t] = arr[i];
                i++;
            }
            t++;
        }
        while(i<=mid){
            temp[t] = arr[i];
            i++;
            t++;
        }
        while(j<=right){
            temp[t] = arr[j];
            j++;
            t++;
        }
        t=0;
        while(left<=right){
            arr[left] = temp[t++];
            left++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,3,4,5,72,3,55};
        new MergeSort().mergeSort(arr);
        Arrays.stream(arr).forEach(i->{
            System.out.println(i+",");
        });
    }
}
