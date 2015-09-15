package org.wangbin.datastructure._360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test1 {
    private static String[][] str0 = new String[][] { {" ", "-", " "}, {"|", " ", "|"}, {"", " ", ""}, {"|", " ", "|"}, {" ", "-", " "}};
    private static String[][] str1 = new String[][] { {" ", " ", " "}, {" ", "|", " "}, {" ", "", " "}, {" ", "|", " "}, {" ", " ", " "}};
    private static String[][] str2 = new String[][] { {" ", "-", ""}, {" ", " ", "|"}, {" ", "-", " "}, {"|", " ", " "}, {" ", "-", " "}};
    private static String[][] str3 = new String[][] { {" ", "-", " "}, {" ", " ", "|"}, {" ", "-", " "}, {" ", "", " |"}, {" ", "-", " "}};
    private static String[][] str4 = new String[][] { {" ", " ", " "}, {"|", " ", "|"}, {" ", "-", " "}, {" ", " ", "|"}, {" ", " ", ""}};
    private static String[][] str5 = new String[][] { {" ", "-", " "}, {"|", " ", " "}, {" ", "-", " "}, {" ", " ", "|"}, {" ", "-", " "}};
    private static String[][] str6 = new String[][] { {" ", "-", " "}, {"|", " ", " "}, {" ", "-", " "}, {"|", " ", "|"}, {" ", "-", " "}};
    private static String[][] str7 = new String[][] { {" ", "_", " "}, {" ", " ", "|"}, {" ", " ", " "}, {" ", " ", "|"}, {" ", " ", " "}};
    private static String[][] str8 = new String[][] { {" ", "-", " "}, {"|", " ", "|"}, {" ", "-", " "}, {"|", " ", "|"}, {" ", "-", " "}};
    private static String[][] str9 = new String[][] { {" ", "-", " "}, {"|", " ", "|"}, {" ", "-", " "}, {" ", " ", "|"}, {" ", "-", " "}};
    private static List<String[][]> ls = new ArrayList<String[][]>(10);
    static {
        ls.add(str0);
        ls.add(str1);
        ls.add(str2);
        ls.add(str3);
        ls.add(str4);
        ls.add(str5);
        ls.add(str6);
        ls.add(str7);
        ls.add(str8);
        ls.add(str9);
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int number=in.nextInt();
        if(number <= 9){
            showResult(ls.get(number));
            return;
        }
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
        int raw = result.size()-1 + result.size()*3;//列数
        String [][]resultStr = new String[5][raw];//固定5行
        int count = 0;
        for(int m = 0;m <5;m++){
            for(int n = 0; n< raw;n++){
                if(n!=0&&n%4==0){
                    count++;//result中第几个
                }
                if(n!=0&&n%4==0){//要放入*
                    if(n!=raw-1){//最后不放
                        if(m==2){
                            resultStr[m][n] = "*";
                        }else{
                            resultStr[m][n] = " ";
                        }
                    }else{
                        resultStr[m][n] = " ";
                    }
                }else{
                    if(n%4 ==3){
                        resultStr[m][n] = " ";
                    }else{
                        String [][]temp = ls.get(Integer.valueOf(result.get(count)));
//                        showResult(temp);
                        resultStr[m][n] = ls.get(Integer.valueOf(result.get(count)))[m][n%4];
                    }
                    
                }
            }
            count=0;
        }
        showResult(resultStr);
        return;
    }

    private static void showResult(String[][] strings) {
        // TODO Auto-generated method stub
        for(String []strs:strings){
            for(String s:strs){
                System.out.print(s);
            }
            System.out.println();
        }
    }
    
   

}
