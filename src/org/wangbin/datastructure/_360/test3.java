package org.wangbin.datastructure._360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("输入一个数：");
        int number=in.nextInt();
        System.out.print(number + "=");
        int i = 1;
        List<String> result = new ArrayList<String>();
        while (i < number) {
            if (number % i == 0 && i == 1){
                if(i!=1){
                    result.add(String.valueOf(i));
                }
                number /=i;
                
            }else if (number % i == 0 && i != 1) {
                if(i!=1){
                    result.add(String.valueOf(i));
                }
                number /=i;
                continue;
            }
            i++;
        }
        result.add(String.valueOf(i));
        System.out.println();
        for(String str :result){
            System.out.println(str);
        }
    }
}
