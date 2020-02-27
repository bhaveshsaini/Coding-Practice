package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static int solution(List<Integer> A)
    {
        int ret = -1;
        List<Integer> digitsSum = new LinkedList<>(); // to store the sum of digits for every number in list A
        for(int a : A) // add sum of digits to the digitsSum list
        {
            int sum = a % 10;
            int temp = (a - sum) / 10;
            sum += temp;
            digitsSum.add(sum);
        }

        for(int i = 0; i < digitsSum.size() - 1; i++)
        {
            for(int j = i + 1; j < digitsSum.size(); j++)
            {
                if(digitsSum.get(i) == digitsSum.get(j))
                    if( (A.get(i) + A.get(j)) > ret)
                        ret =  A.get(i) + A.get(j);
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        List<Integer> A = new LinkedList<>();
        A.add(51);
        A.add(32);
        A.add(43);
        System.out.print(solution(A));
    }

}
