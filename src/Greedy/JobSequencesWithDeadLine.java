package Greedy;

import java.util.*;

class Job {
    char id;
    int profit, deadline;

    Job() {
    }

    Job(char id, int profit, int deadline) {
        this.id = id;
        this.profit = profit;
        this.deadline = deadline;
    }
}

public class JobSequencesWithDeadLine {

    public static void maxProfit(ArrayList<Job> jobs) {
        long mp = 0;
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);
        int md = Integer.MIN_VALUE;

        for (Job j : jobs) {
            if (j.deadline > md) {
                md = j.deadline;
            }
        }
        System.out.println("Max_Deadline: "+md);
        char[] order = new char[md + 1]; // Fix array size
        Arrays.fill(order, '\u0000'); // Initialize the array

        int size = jobs.size();

        for (int i = 0; i < size; i++) {
            int k = jobs.get(i).deadline;

            while (k > 0) { // Fix loop condition
                if (order[k] == '\u0000') {
                    order[k] = jobs.get(i).id;
                    mp += jobs.get(i).profit;
                    break; // Break the loop after assigning the job
                } else {
                    k--;
                }
            }
        }

        for (int i=1;i<order.length;i++) {
            System.out.print(order[i]+ " ");
        }
        System.out.println();

        System.out.println("max Profit:" + mp);
    }

    public static void main(String[] args) {
        ArrayList<Job> jobs = new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no of jobs :");
        int n=sc.nextInt();
        sc.nextLine();
        System.out.println("enter the job details : ");
        for(int i=0;i<n;i++) {
        	String s=sc.nextLine();
        	String[] str=s.split(" ");
        	jobs.add(new Job(str[0].charAt(0), Integer.parseInt(str[1]), Integer.parseInt(str[2])));
        }
        
        /*jobs.add(new Job('a', 2, 2));
        jobs.add(new Job('b', 4, 3));
        jobs.add(new Job('c', 3, 3));
        jobs.add(new Job('d', 1, 4));
        jobs.add(new Job('e', 10, 4));*/

        maxProfit(jobs);
    }
}

