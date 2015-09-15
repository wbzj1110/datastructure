package org.wangbin.datastructure._360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String numberStr = in.nextLine();
        Integer number = Integer.parseInt(numberStr);
        List<String> str = new ArrayList<String>(number);
        for (int i = 0; i < number; i++) {
            String temp = in.nextLine();
            String[] strs = temp.split(" ");
            Integer result = isValid(strs);
            if(result ==1){
                str.add("Fail");
            }else if(result == 2){
                str.add("Zifei");
            }else if(result==3){
                str.add("Gongfei");
            }
        }
        for(String s :str){
            System.out.println(s);
        }

    }

    private static Integer isValid(String[] strs) {
        // TODO Auto-generated method stub
        Integer score0 = Integer.parseInt(strs[0]);
        if (score0 < 60) {
            return 1;// ´íÎó
        }
        Integer score1 = Integer.parseInt(strs[1]);
        if (score1 < 60) {
            return 1;// ´íÎó
        }
        Integer score2 = Integer.parseInt(strs[2]);
        if (score2 < 90) {
            return 1;// ´íÎó
        }
        Integer score3 = Integer.parseInt(strs[3]);
        if (score3 < 90) {
            return 1;// ´íÎó
        }
        Integer total = score0+score1+score2+score3;
        if(total < 310){
            return 1;
        }else if(total <349){
            return 2;
        }else if(total <= 500){
            return 3;
        }else{
            return 1;
        }
        
    }
}
