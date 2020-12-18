package main.java.com.jianshu;

public class 第K大的数 {
    public void quickSort(int[] nums, int K, int begin, int end){
        int low= begin;
        int high = end;
        int temp = nums[low];
        while(low<high){
            while(low<high&&nums[high]<=temp){
                high--;
            }
            nums[low] = nums[high];
            while(low<high&&nums[low]>=temp){
                low++;
            }
            nums[high] = nums[low];
        }
        nums[high] = temp;
        quickSort(nums, K, begin, high);
        quickSort(nums, K, high+1, end);
    }
}
