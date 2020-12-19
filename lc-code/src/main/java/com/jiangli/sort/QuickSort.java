package main.java.com.jiangli.sort;

public class QuickSort {
    public int[] quicksortSolu(int[] nums){
        return  null;
    }

    public void quickSort(int[] nums, int low, int high){
        if(low>high) return;

        int i=low;
        int j=high;
        int temp = nums[low];
        while(i<j){
            while(temp<=nums[j]&&i<j){
                j--;
            }
            while(temp>=nums[i]&&i<j){
                i++;
            }
            if(i<j){}
        }
    }
}
