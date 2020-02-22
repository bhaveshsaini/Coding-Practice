import java.util.LinkedList;
import java.util.List;

public class Main {

    public static int convertTime(String time) // remove colon from time and return it as an integer
    {
        String ret = "";
        String[] tempArr =  time.split(":");
        for(String tempp : tempArr)
            ret += tempp;
        return Integer.parseInt(ret); //returning as an integer
    }

    public static List<List<String>> combinedList(List<List<String>> list1, List<List<String>> list2) // will return a list with combined times from both persons
    {
        /*
            this function combines the two persons' meetings into one list in ascending order
         */

        List<List<String>> ret = new LinkedList<>(); //results
        int p1Count = 0;
        int p2Count = 0;
        while((p1Count < list1.size()) && (p2Count < list2.size())) // iterating over the two lists
        {
            /*
                if person 1 meeting start time is before person 2 meeting start time then it will
                add person 1 meeting before person 2 in the combined list.
             */
            if(convertTime(list1.get(p1Count).get(0)) < convertTime(list2.get(p2Count).get(0)))
                ret.add(list1.get(p1Count++));

            /*
                if both persons have the same meeting start time then compare the end times to see which
                person's meeting to add first.
             */
            else if(convertTime(list1.get(p1Count).get(0)) == convertTime(list2.get(p2Count).get(0)))
            {
                if(convertTime(list1.get(p1Count).get(1)) <= convertTime(list2.get(p2Count).get(1)))
                    ret.add(list1.get(p1Count++));

                else if(convertTime(list1.get(p1Count).get(1)) > convertTime(list2.get(p2Count).get(1)))
                    ret.add(list2.get(p2Count++));
            }

            /*
                if both of the above cases are false, then obviously the person 2 meeting starts before person 1 meeting
                so add person 2 meeting to the combined list.
             */
            else
                ret.add(list2.get(p2Count++));
        }

        /*
            after the while loop exits, the below if statements are to check if we have any elements left in the
            two persons' lists that we haven't added to the combined list yet.
         */
        if(p1Count < list1.size())
        {
            while(p1Count < list1.size())
                ret.add(list1.get(p1Count++));
        }

        if(p2Count < list2.size())
        {
            while(p2Count < list2.size())
                ret.add(list2.get(p2Count++));
        }

        return ret;
    }

    public static List<List<String>> times(List<List<String>> person1, List<String> person_1_Availability, List<List<String>> person2, List<String> person_2_Availability)
    {
        /*
            this function is the main algorithm to find out the free times to set up meetings. It takes in 2 lists of
            both persons' times as input and also their availability times.

            Will return the available times that meetings can be scheduled between.
         */

        List<List<String>> combined = new LinkedList<>();
        combined = combinedList(person1, person2); // combined list of two persons' times from the other function
        List<List<String>> shortList = new LinkedList<>(); // to combine times and shorten the combined list
        List<List<String>> ret = new LinkedList<>(); // results
        int counter = -1; // using this variable to keep track of the last element that was put in the final ret list so if an element needs to be updated, it can be done.

        /*
            earliest and latest meetings can be scheduled.
         */
        int earliest = 0;
        int latest = 0;

        if(convertTime(person_1_Availability.get(0)) < convertTime(person_2_Availability.get(0)))
            earliest = convertTime(person_2_Availability.get(0));
        else
        {
            earliest = convertTime(person_1_Availability.get(0));
        }

        if(convertTime(person_1_Availability.get(1)) < convertTime(person_2_Availability.get(1)))
            latest = convertTime(person_1_Availability.get(1));
        else
        {
            latest = convertTime(person_2_Availability.get(1));
        }

        /*
            checking if the combined list has any overlapping timings and if it does then
            combine it to make one big time because no meetings can be scheduled between those times.

            example: [10:00 - 12:00] and [11:00 - 14:00] = [10:00 - 14:00]
         */
        for(int i = 0; i < combined.size() - 1; i++) // making the list shorter
        {
            List<String> toAdd1 = new LinkedList<>();
            if(convertTime(combined.get(i).get(1)) > convertTime(combined.get(i + 1).get(0)))
            {
                toAdd1.add(combined.get(i).get(0));
                toAdd1.add(combined.get(i + 1).get(1));
                shortList.add(toAdd1);
                counter++;
            }

            else if(convertTime(combined.get(i).get(1)) == convertTime(combined.get(i + 1).get(0)))
            {
                toAdd1.add(shortList.get(counter).get(0));
                toAdd1.add(combined.get(i + 1).get(1));
                shortList.set(counter, toAdd1);
            }
        }

        /*
            the below if statement checks if a meeting can be scheduled before the first meetings of the persons for the day
            but after the time they start working.
         */
        if(earliest < convertTime(shortList.get(0).get(0))) // to figure out if a meeting can be set up before the scheduled meetings
        {
            List<String> toAdd = new LinkedList<>();
            if(convertTime(person_1_Availability.get(0)) > convertTime(person_2_Availability.get(0)))
            {
                toAdd.add(person_1_Availability.get(0));
                toAdd.add(shortList.get(0).get(0));
            }
            else if(convertTime(person_1_Availability.get(0)) < convertTime(person_2_Availability.get(0)))
            {
                toAdd.add(person_2_Availability.get(0));
                toAdd.add(shortList.get(0).get(0));
            }
            else
            {
                toAdd.add(person_1_Availability.get(0));
                toAdd.add(shortList.get(0).get(0));
            }
            ret.add(toAdd);
        }


        /*
            the below for loop checks if a meeting can be scheduled between the already scheduled meetings during the day
         */
        for(int i = 0; i < shortList.size() - 1; i++) // figuring out the meetings in the middle of day
        {
            List<String> toAdd = new LinkedList<>();// temp list
            toAdd.add(shortList.get(i).get(1));
            toAdd.add(shortList.get(i + 1).get(0));
            ret.add(toAdd);
        }

        /*
            the below if statement checks if a meeting can be scheduled after the last meetings of the persons for the day
            but before the time they stop working.
         */
        if(latest > convertTime(shortList.get(shortList.size() - 1).get(1))) // to figure out if a meeting can be set up after the scheduled meetings at the end of the day
        {
            List<String> toAdd = new LinkedList<>();
            if(convertTime(person_1_Availability.get(1)) < convertTime(person_2_Availability.get(1)))
            {
                toAdd.add(shortList.get(shortList.size() - 1).get(1));
                toAdd.add(person_1_Availability.get(1));
            }
            else if(convertTime(person_1_Availability.get(1)) > convertTime(person_2_Availability.get(1)))
            {
                toAdd.add(shortList.get(shortList.size() - 1).get(1));
                toAdd.add(person_2_Availability.get(1));
            }
            else
            {
                toAdd.add(shortList.get(shortList.size() - 1).get(1));
                toAdd.add(person_1_Availability.get(1));
            }
            ret.add(toAdd);
        }

        //returning the final list
        return ret;
    }

    public static void main(String[] args)
    {
        //two lists for persons' timings
        List<List<String>> list_1 = new LinkedList<>();
        List<List<String>> list_2 = new LinkedList<>();

        //two lists for both persons' availability
        List<String> p1Avail = new LinkedList<>();
        List<String> p2Avail = new LinkedList<>();

        List<String> tempList = new LinkedList<>();

        p1Avail.add("7:00");
        p1Avail.add("23:00");
        p2Avail.add("8:00");
        p2Avail.add("23:30");


        tempList.add("9:00");
        tempList.add("10:30");
        list_1.add(tempList);


        List<String> tempList1 = new LinkedList<>();
        tempList1.add("12:00");
        tempList1.add("13:00");
        list_1.add(tempList1);

        List<String> tempList2 = new LinkedList<>();
        tempList2.add("16:00");
        tempList2.add("18:00");
        list_1.add(tempList2);

        List<String> tempList3 = new LinkedList<>();
        tempList3.add("10:00");
        tempList3.add("11:30");
        list_2.add(tempList3);

        List<String> tempList4 = new LinkedList<>();
        tempList4.add("12:30");
        tempList4.add("14:30");
        list_2.add(tempList4);

        List<String> tempList5 = new LinkedList<>();
        tempList5.add("14:30");
        tempList5.add("15:00");
        list_2.add(tempList5);

        List<String> tempList6 = new LinkedList<>();
        tempList6.add("16:00");
        tempList6.add("17:00");
        list_2.add(tempList6);

        //calling the function and storing the return value into the result variable
        List<List<String>> result = times(list_1, p1Avail, list_2, p2Avail);
        for(List<String> l : result)
        {
            System.out.print(l.get(0) + " " + l.get(1) + "   ");
        }
    }
}
