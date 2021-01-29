package com.leetcode_topic.bi_search;

public class 寻找两个正序数组的中位数4 {
    // 两个升序数组，找到这两个数组的中位数
    // 方法：划分数组法．
    // 首先保证传入方法的两个数组，第一个长度短第二个长度长．
    // k = (m+n+1)/2
    // left = 0, right = nums1.length-1; i = left+(right-left)/2
    // j = k-i;
    // be
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2){
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0;
        int right = n1;
        int k = (n1+n2+1)/2;
        int left_max = 0;
        int right_min = 0;
        while(left<=right){
            int mid_i = left+(right-left)/2;
            int j = k-mid_i;
            int n1_i = mid_i==n1?Integer.MAX_VALUE:nums1[mid_i];
            int n1_im = mid_i==0?Integer.MIN_VALUE:nums1[mid_i-1];
            int n2_j = j==n2?Integer.MAX_VALUE:nums2[j];
            int n2_jm = j==0?Integer.MIN_VALUE:nums2[j-1];
            if(n1_im<=n2_j){
                left_max = Math.max(n1_im, n2_jm);
                right_min = Math.min(n1_i, n2_j);
                left = mid_i-1;
            }else{
                right = mid_i+1;
            }
        }
        if((n1+n2)%2==0){
            return (left_max+right_min)/2.0;
        }else{
            return left_max;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{2};
        double result = new 寻找两个正序数组的中位数4().findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}
