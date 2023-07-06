package com.example.StudentRegisteration.services;


import java.util.ArrayList;
import java.util.Arrays;

public class Calculate {

    public static void main(String[] args) {
        String[] AA={"a","b","c"};
        String[] BB={"x","y","z"};
        String[] CC={"1","2","3"};
        String[] DD={"7","8","9"};
        String[] EE={"d","e","f"};

        String[] names={"AA","BB","CC","DD","EE"};


        ArrayList<String[]> lists = new ArrayList<String[]>();

        lists.add(AA);
        lists.add(BB);
        lists.add(CC);
        lists.add(DD);
        lists.add(EE);
        System.out.println("List Size -->"+lists.size());



        String[] finalRes={};



        System.out.println("--------------Final-------------------");


        for(int i=0;i< lists.size()-1;i++){
            int num=i;
            num+=2;
            int count;
            if(i==0){
                finalRes=cal(lists.get(i),lists.get(i+1),1,names[i],names[i+1]);
                count=finalRes.length;
            }
            else{
                finalRes=cal(finalRes,lists.get(i+1),2,names[i],names[i+1]);
                count=finalRes.length;
            }
            for(int e=0;e< finalRes.length;e++){
                System.out.println(finalRes[e]);

            }System.out.println("--------------  number "+num+" Count "+count+"-------------------");


        }


    }



     static String[] cal(String[] parent,String[] child,int counter,String host,String tree){
        String[] result={};

        for(int i=0;i<parent.length;i++){
           for(int j=0;j<child.length;j++){
               result = Arrays.copyOf(result, result.length + 1);
               if(counter==1){
                   result[result.length - 1] = parent[i]+" from "+host+" and "+child[j]+" from "+ tree;
               }else {
                   result[result.length - 1] = parent[i]+" and "+child[j]+" from "+tree;

               }

           }
        }

        return result;
    }



}
