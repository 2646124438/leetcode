package main.java.com.jiangli.double_pointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MaxArea {
    public int maxArea(int[] height){
        HashMap<Integer, Integer> areaMap = new HashMap<>();
        int maxArea = 0;
//        List<Integer> heightList = new ArrayList<Integer>();
        HashMap<Integer, Integer> heightMap = new HashMap<>();
        int maxItem = 0;
        for(int i=0,j=height.length-1;i<j;){
            maxItem =height[j]>=height[i]?
                    Math.max(height[i++]*(j-i),maxItem):Math.max(height[j--]*(j-i),maxItem);
        }
        return maxArea;
    }

}
