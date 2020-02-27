package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static int solution(int n, String s)
    {
        int ret = 0;
        String seatColumns = "ABCDEFGHJK";
        String[] reservedSeats = s.split(" ");
        List<List<Character>> availableSeats = new LinkedList<>(); // to keep track of available seats

        for(int i = 0; i < n; i++) // filling up the available seats list filtering out the reserved seats
        {
            List<Character> temp = new LinkedList<>();

            for(int j = 0; j < seatColumns.length(); j++)
            {
                String seatNumber = Integer.toString(i + 1);
                seatNumber += seatColumns.charAt(j);

                if(Arrays.asList(reservedSeats).contains(seatNumber)) // if seat exists in the reserved seat list, then dont add to the available seats list
                    continue;

                temp.add(seatNumber.charAt(1));
            }
            availableSeats.add(temp);
        }

        for(int i = 0; i < n; i++)
        {
            boolean leftOccupied = false;
            boolean middleOccupied = false;
            boolean rightOccupied = false;

            if(availableSeats.get(i).contains('B') && availableSeats.get(i).contains('C') && availableSeats.get(i).contains('D') && availableSeats.get(i).contains('E'))
            {
                if(!middleOccupied)
                {
                    leftOccupied = true;
                    ret++;
                }
            }

            if(availableSeats.get(i).contains('D') && availableSeats.get(i).contains('E') && availableSeats.get(i).contains('F') && availableSeats.get(i).contains('G'))
            {
                if(!leftOccupied && !rightOccupied)
                {
                    middleOccupied = true;
                    ret++;
                }
            }

            if(availableSeats.get(i).contains('F') && availableSeats.get(i).contains('G') && availableSeats.get(i).contains('H') && availableSeats.get(i).contains('J'))
            {
                if(!middleOccupied)
                {
                    rightOccupied = true;
                    ret++;
                }
            }
        }


        return ret;
    }

    public static void main(String[] args) {
        System.out.print(solution(2, "1A 2F 1C 1E 2C"));
    }
}
