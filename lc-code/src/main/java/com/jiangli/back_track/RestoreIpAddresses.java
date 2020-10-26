package main.java.com.jiangli.back_track;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    private List<String> result=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {

        for(int i=3;i>=1;i--) {
            List<String> item = new ArrayList<>();
//            item.add(s.substring(0, i));
            helper(s, 1, 0, i, item);
        }List<String> item = new ArrayList<>();
        return this.result;
    }

    public void helper(String s, int pos, int begin, int end, List<String> item){
        if(end>s.length()||begin>s.length()||(s.substring(begin, end).startsWith("0")&&end-begin>1)){
            return;
        }
        int num = Integer.parseInt(s.substring(begin, end));
        if(num>255){
            return ;
        }
        if(pos==4&&end==s.length()){
            item.add(s.substring(begin, end));
            if(!result.contains(String.join(".", item))) {
                result.add(String.join(".", item));
            }
            item.remove(item.size()-1);
            return ;
        }else if(pos==4&&end<s.length()){
            return;
        }else if((pos==3&&end+3<s.length())||(pos==2&&end+6<s.length())||(pos==1&&end+9<s.length())){
            return;
        }
        for(int i=pos;i<4;i++){
                item.add(s.substring(begin, end));
                helper(s, pos + 1, end, end + 3, item);
                item.remove(item.size()-1);
                item.add(s.substring(begin, end));
                helper(s, pos + 1, end, end + 2, item);
                item.remove(item.size()-1);
                item.add(s.substring(begin, end));
                helper(s, pos + 1, end, end + 1, item);
                item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        new RestoreIpAddresses().restoreIpAddresses("0000")
                .stream().forEach(i-> System.out.println(i));
    }

}
