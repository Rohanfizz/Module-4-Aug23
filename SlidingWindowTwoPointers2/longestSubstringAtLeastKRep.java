import java.util.*;

class Solution {

	public int longestSubstringXuniqueAtLeastK(String s,int unique,int k){
		int sp = 0;
		int ep = 0;
		int ans = 0;

		int noUnique = 0;
		int noRepk = 0;

		HashMap<Character,Integer> hm = new HashMap<>();
		
		while(ep<s.length()){
			//introduce
			char sep = s.charAt(ep);
			hm.put(sep, hm.getOrDefault(sep,0) + 1 );//increment the freq of this person in hashmap
			if(hm.get(sep) == 1) noUnique++;
			if(hm.get(sep) == k) noRepk++;

			//shrink if im having extra chars
			while(noUnique > unique){
				char ssp = s.charAt(sp);
				hm.put(ssp,hm.get(ssp) - 1);

				if(hm.get(ssp) == 0) noUnique--;
				if(hm.get(ssp) == k-1) noRepk--;

				sp++;
			}

			//update answer
			if(noUnique == unique && noRepk == noUnique) ans = Math.max(ans,ep-sp+1);

			//expand
			ep++;
		}
		return ans;
	}
	
    public int longestSubstring(String s, int k) {
        // write code here
		int ans = 0;
		for(int unique = 1;unique<=26;unique++){
			ans = Math.max(ans,longestSubstringXuniqueAtLeastK(s,unique,k));
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubstring(str,k));
    }
}
