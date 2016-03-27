package maps;

import java.util.Scanner;

public class Main {
	
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
	
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			String in1 = s.nextLine();
			String in2 = s.nextLine();
			System.out.println(anagramSubstrings(in1, in2));
		}
		s.close();
	}
}
