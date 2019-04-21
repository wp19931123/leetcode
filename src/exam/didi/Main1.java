package exam.didi;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            String[] strings=str.split(" ");
            int n=Integer.valueOf(strings[0]);
            int m=Integer.valueOf(strings[1]);
            int[] spellPower=new int[n];
            ArrayList<Integer> list=new ArrayList<>();
            for (int i=0;i<n;i++){
                spellPower[i]=sc.nextInt();
                list.add(spellPower[i]);
            }
            for(int j=0;j<m;j++) {

                int Min = Integer.MAX_VALUE, index = -1;
                for (int i = 0; i < n-j - 1; i++) {
                    if (Min > list.get(i)) {
                        Min = list.get(i);
                        index = i;
                    }
                }
                if(index==0){
//                    spellPower[index+1]+=spellPower[index];
                    list.add(index+1,list.get(index+1)+list.get(index));
                    list.remove(index);
                    list.remove(index+1);
                }else if(index==spellPower.length-1){
//                    spellPower[index-1]+=spellPower[index];
                    list.add(index-1,list.get(index-1)+list.get(index));
                    list.remove(index+1);
                    list.remove(index-1);
                }else {
                    if(list.get(index+1)>list.get(index-1)){
//                        spellPower[index-1]+=spellPower[index];
                        list.add(index-1,list.get(index-1)+list.get(index));

                        list.remove(index+1);
                        list.remove(index-1);
                    }else {
//                        spellPower[index+1]+=spellPower[index];
                        list.add(index+1,list.get(index+1)+list.get(index));
                        list.remove(index);
                        list.remove(index+1);
                    }
                }
            }
            int Min = Integer.MAX_VALUE, index = -1;
            for (int i = 0; i < list.size() - 1; i++) {
                if (Min > list.get(i)) {
                    Min = list.get(i);
                    index = i;
                }
            }
            System.out.println(Min);
        }
    }

}

//            System.out.println(" ");
//            for (int s:list
//                    ) {
//                System.out.println(s);
//            }
//            System.out.println(" ");

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a1 = sc.nextLine();
        String a2 = sc.nextLine();
        String[] s1 = a1.split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        String[] s2 = a2.split(" ");
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            list.add(Integer.parseInt(s2[i]));
        }
        for(int i = 0;i < m;i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int j = 0;j < list.size();j++) {
                if(min > list.get(j)) {
                    min = list.get(j);
                    index = j;
                }
            }
            n--;
            if(index - 1 >= 0 && index + 1 <= list.size()) {
                if(list.get(index-1) < list.get(index + 1)) {
                    int tmp = list.get(index-1) + list.get(index+1);
                    for(int k = 0;k < n;k++){
                        if(k == index-1) {
                            list.add(tmp);
                        }else{
                            list.add()
                        }

                    }
                }else{
                    int tmp = list.get(index+1) + list.get(index+1);
                }
            }
            list.remove(index);
        }
    }*/
