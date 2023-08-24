import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class Main {
    
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        Item arr[] = new Item[n];
        for(int i=0;i<n;i++) {
            int value = sc.nextInt();
            arr[i] = new Item(value,0);
        }
        for(int i=0;i<n;i++) {
            arr[i].weight = sc.nextInt();
        }
        double ans = (new Solution()).fractionalKnapsack(w,arr,n);
        System.out.println(String.format("%.2f",ans));
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/


class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int cap, Item arr[], int n) {
       // Write your code here
		//Step1: sort all the items in desc order on the basis
		// of their cost of 1 unit

		Arrays.sort(arr,(a,b)->{
			//cost of 1 unit of A
			double costA = 1.0* (a.value / (1.0*a.weight));
			double costB = 1.0* (b.value / (1.0*b.weight));

			//return costB - costA; // in lambda function, im  only allowed to return int
			//behaviour of java
			// a<b = -ve, a>b=+ve
			//i want desc, fool java
			// a<b = +ve, a>b = -ve
			return (costA >= costB)?-1:1;
		});

		double totalProfit = 0.0;

		for(Item i: arr){
			if(cap > i.weight){
				totalProfit+=i.value;
				cap -= i.weight;
			}else{
				//i cannot completely keep this item
				//i have to break this item
				double costOf1Unit = 1.0* (i.value/(1.0*i.weight));
				//i can fit remaining cap amount of this item
				double profitFromBrokenItem = costOf1Unit * cap;
				cap =0;
				totalProfit+=profitFromBrokenItem;
				break;
			}
		}
		return totalProfit;
    }
	
}









