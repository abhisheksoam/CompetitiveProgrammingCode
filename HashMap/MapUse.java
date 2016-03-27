package maps;

import java.util.HashMap;
import java.util.Hashtable;

import linked_list.Node;

public class MapUse {

	public static int anagramSubstrings(String s, String t) {
		Map<Character, Integer> countMap = new Map<>();
		int remaining = 0;
		int ans = 0;
		for (int i = 0; i < t.length(); i++) {
			if (countMap.constainKey(t.charAt(i))) {
				countMap.put(t.charAt(i), countMap.get(t.charAt(i)) + 1);
			} else {
				countMap.put(t.charAt(i), 1);
				remaining++;
			}
		}
		
		for (int i = 0; i < t.length(); i++) {
			char cc = s.charAt(i);
			if (countMap.constainKey(cc)) {
				countMap.put(cc, countMap.get(cc) - 1);
				if (countMap.get(cc) == 0) {
					remaining--;
				}
			}
		}
		
		if (remaining == 0) 
			ans++;
		for (int i = t.length(); i < s.length(); i++) {
			char newc = s.charAt(i);
			char oldc = s.charAt(i - t.length());
			if (countMap.constainKey(oldc)) {
				countMap.put(oldc, countMap.get(oldc) + 1);
				if (countMap.get(oldc) == 1) {
					remaining++;
				}
			}
			
			if (countMap.constainKey(newc)) {
				countMap.put(newc, countMap.get(newc) - 1);
				if (countMap.get(newc) == 0) {
					remaining--;
				}
			}
			
			if (remaining == 0)
				ans++;
		}
		return ans;
	}
	
	public static void removeDups(int[] input) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		int nextNonDuplicateIndex = 0;
		for (int a: input) {
			if (!map.containsKey(a)) {
				input[nextNonDuplicateIndex] = a;
				nextNonDuplicateIndex++;
			}
			map.put(a, true);
		}
		for (; nextNonDuplicateIndex < input.length;nextNonDuplicateIndex++) {
			input[nextNonDuplicateIndex] = 0;
		}
		
	}
	
	public static void intersection2(int[] input1, int[] input2) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i: input1) {
			map.put(i, true);
		}
		
		for (int j: input2) {
			if (map.get(j) != null) {
				System.out.println(j);
			}
 		}
		
	}
	
	
	public static void intersectionDup(int[] input1, int[] input2) {
		Map<Integer, Integer> map = new Map<>();
		for (int i: input1) {
			if (map.get(i) == null) {
				map.put(i, 1);
			} else {
				int count = map.get(i);
				map.put(i, count + 1);
			}
			
		}
		
		for (int j: input2) {
			if (map.get(j) != null) {
				int count = map.get(j);
				if (count > 0) {
					System.out.println(j);
					map.put(j, count - 1);
				}
			}
 		}
		
	}
	
	public static void intersection(int[] input1, int[] input2) {
		Map<Integer, Boolean> map = new Map<>();
		for (int i: input1) {
			map.put(i, true);
		}
		
		for (int j: input2) {
			if (map.get(j) != null) {
				System.out.println(j);
			}
 		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a1 = {10, 9,8,10,9,7};
		int[] b = {9,9,8,9,10,10,7,9,9,9,9};
		//intersectionDup(a1, b);	
		
		System.out.println(anagramSubstrings("testtest", "test"));
		System.out.println(anagramSubstrings("thisisinput", "is"));
		System.out.println(anagramSubstrings("ttttst", "ts"));
		System.out.println(anagramSubstrings("ttts", "ts"));
		System.out.println(anagramSubstrings("output", "u"));
	}

}
