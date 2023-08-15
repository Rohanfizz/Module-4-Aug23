import java.io.*;
import java.util.*;

class Solution {

	public boolean isValid(HashMap<Character,Integer> ideal,HashMap<Character,Integer> curr){
		for(char c: ideal.keySet()){
			if(!curr.containsKey(c)) return false;
			if(curr.get(c) < ideal.get(c)) return false;
		}
		return true;
	}
	
    public String minWindow(String s, String t) {
		// write code here

		HashMap<Character,Integer> ideal = new HashMap<>();// t
		HashMap<Character,Integer> curr = new HashMap<>();//curr window

		for(char c: t.toCharArray()){
			ideal.put(c, ideal.getOrDefault(c,0) + 1 );
		}

		int sp = 0;
		int ep = 0;

		int ansLen = Integer.MAX_VALUE;
		String ans = "";

		while(ep<s.length()){
			//introduce
			char sep = s.charAt(ep);
			curr.put( sep , curr.getOrDefault(sep,0) + 1);

			//update and shrink till its valid
			while(isValid(ideal,curr)){
				//update
				if(ansLen > ep-sp+1){
					ansLen = ep-sp+1;
					ans = s.substring(sp,ep+1);
				}

				//shrink
				char ssp = s.charAt(sp);
				curr.put(ssp,curr.get(ssp) - 1);
				sp++;
			}

			//expand
			ep++;
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,t;
        s = sc.next();
		t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s,t));
    }
}