package main.java.com.jiangli.back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permutaionSolv(List<Integer> valList){
        perHelper(new ArrayList<>(), valList, 0);
        return result;
    }

    public void perHelper(List<Integer> temp,List<Integer> valList, int index){
        if(temp.size()==valList.size()){
            //add
            List<Integer> item = new ArrayList<>();
            for(Integer num:temp){
                item.add(num);
            }
            result.add(item);
            return;
        }
        for(int i=index;i<valList.size();i++){
            temp.add(i);
            perHelper(temp, valList, i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {

        for(List<Integer> item:new Permutation().permutaionSolv(Arrays.asList(1,2,3,4))){
            for(Integer i:item){
                System.out.print(i);
            }
            System.out.println("\n");
        }
//        for(List<Integer>)
    }
}
