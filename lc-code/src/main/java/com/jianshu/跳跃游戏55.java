package main.java.com.jianshu;

public class 跳跃游戏55 {
    public boolean canJump(int[] nums) {
        boolean[] canJumpArr = new boolean[nums.length];
        for(int i=0;i<nums.length-1;i++){
            for(int j=1;j<nums[i];j++){
                if(i+j>=canJumpArr.length){
                    break;
                }
                canJumpArr[i+j] = true;
            }
        }

        int rightmost  = 0;
        for(int i=0;i<nums.length;i++){
            if(i<=rightmost){
                rightmost = Math.max(rightmost, i+nums[i]);
            }
        }
        return rightmost>nums.length-1;
//        return canJumpArr[nums.length];
    }

    public static void main(String[] args) {
//        new 跳跃游戏55().canJump();
    }
}
