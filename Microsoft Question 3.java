package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static int solution(List<Integer> A, List<Integer> B, int N)
    {
        int ret = 0;
        int city1 = 2;
        int city2 = 3;

        for(int i = 0; i < N; i++)
        {
            if((A.get(i) == city1 || A.get(i) == city2 || B.get(i) == city1 || B.get(i) == city2))
                ret++;

        }
        return ret;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(3);

        list2.add(4);
        list2.add(3);
        list2.add(1);
        list2.add(4);
        System.out.print(solution(list1, list2, 4));
    }

}
