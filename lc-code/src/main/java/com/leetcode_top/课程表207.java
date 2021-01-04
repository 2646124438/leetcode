package com.leetcode_top;

import java.util.*;

public class 课程表207 {
    private Map<Integer, List<Integer>> courseMap = new HashMap<Integer, List<Integer>>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] statusCouress = new boolean[numCourses];

        for(int i=0;i<prerequisites.length;i++){
            int targetcourse = prerequisites[i][0];
            int needCourse = prerequisites[i][1];
            if(!courseMap.containsKey(targetcourse)){
                List<Integer> needList = new ArrayList<>();
                needList.add(needCourse);
                courseMap.put(targetcourse, needList);
            }else{
                courseMap.get(targetcourse).add(needCourse);
            }
        }
        for(int i=0;i<prerequisites.length;i++){
//            int[] needCoursesIndex = prerequisites[i];
            Arrays.fill(statusCouress, false);
            int courseIndex = prerequisites[i][0];
            List<Integer> needCourses = courseMap.get(courseIndex);
            if(!checkFinish(statusCouress, courseIndex, needCourses, courseMap)){
                return false;
            }
        }
        return true;
    }

    public  boolean checkFinish(boolean[] statusCourses, int targetCourse, List<Integer> needCourses, Map<Integer, List<Integer>> coursesMap){
        if(statusCourses[targetCourse]){
            return false;
        }
        statusCourses[targetCourse] = true;
        for(int i=0; i<needCourses.size();i++){
            if(!coursesMap.containsKey(needCourses.get(i))){
                statusCourses[needCourses.get(i)] = true;
                continue;
            }
            if(!checkFinish(statusCourses, needCourses.get(i), coursesMap.get(needCourses.get(i)), coursesMap)){
                return false;
            }
            statusCourses[needCourses.get(i)] = false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] course = new int[2][2];
        course[0] = new int[]{1,0};
//        course[1] = new int[]{1,2};
        course[1] = new int[]{0,1};
        new 课程表207().canFinish(2, course);
    }
}
