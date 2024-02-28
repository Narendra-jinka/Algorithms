package Greedy;

import java.util.*;
public class Fractional_Knapsack {
	public static double cal_Max_profit(int n,int m, List<ArrayList<Integer>> items) {
		double maxProfit=0.0;
		 Collections.sort(items, (item1, item2) -> {
	            double ratio1 = (double) item1.get(0) / item1.get(1); // profit / weight
	            double ratio2 = (double) item2.get(0) / item2.get(1);
	            return Double.compare(ratio2, ratio1); // Sort in descending order
	      });
		 for(ArrayList<Integer> arr:items) {
			 int profit=arr.get(0);
			 int weight=arr.get(1);
			 if(m>=weight) {
				 maxProfit+= profit;
				 m-=weight; 
			 }
			 else if(m<weight) {
				 double ratio=(double) m / (double) weight;
				 maxProfit+= (ratio * profit);
				 break;
			 } 
		 }
		return maxProfit;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		List<ArrayList<Integer>> items=new ArrayList<>();
		System.out.println("Enter the no of Items : ");
		int n=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the MAX Weight: ");
		int m=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++) {
			String line=sc.nextLine();
			String[] str=line.split(" ");
			ArrayList<Integer> arr=new ArrayList<>();
			for(String s:str) {
				arr.add(Integer.parseInt(s));
			}
			items.add(arr);
		}
		System.out.print("Max profit is : ");
		System.out.println(cal_Max_profit(n,m,items));
		
		
		

	}

}
