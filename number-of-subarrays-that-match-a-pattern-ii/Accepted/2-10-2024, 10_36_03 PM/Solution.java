// https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-ii

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    int KMPSearch(String pat, String txt) 
	{ 
		int M = pat.length(); 
		int N = txt.length(); 
        
        int res = 0;
        
		// create lps[] that will hold the longest 
		// prefix suffix values for pattern 
		int lps[] = new int[M]; 
		int j = 0; // index for pat[] 

		// Preprocess the pattern (calculate lps[] 
		// array) 
		computeLPSArray(pat, M, lps); 

		int i = 0; // index for txt[] 
		while (i < N) { 
			if (pat.charAt(j) == txt.charAt(i)) { 
				j++; 
				i++; 
			} 
			if (j == M) { 
				// System.out.println("Found pattern "
				// 				+ "at index " + (i - j)); 
                res++;
				j = lps[j - 1]; 
			} 

			// mismatch after j matches 
			else if (i < N && pat.charAt(j) != txt.charAt(i)) { 
				// Do not match lps[0..lps[j-1]] characters, 
				// they will match anyway 
				if (j != 0) 
					j = lps[j - 1]; 
				else
					i = i + 1; 
			} 
		} 
        return res;
	} 

	void computeLPSArray(String pat, int M, int lps[]) 
	{ 
		// length of the previous longest prefix suffix 
		int len = 0; 
		int i = 1; 
		lps[0] = 0; // lps[0] is always 0 

		// the loop calculates lps[i] for i = 1 to M-1 
		while (i < M) { 
			if (pat.charAt(i) == pat.charAt(len)) { 
				len++; 
				lps[i] = len; 
				i++; 
			} 
			else // (pat[i] != pat[len]) 
			{ 
				// This is tricky. Consider the example. 
				// AAACAAAA and i = 7. The idea is similar 
				// to search step. 
				if (len != 0) { 
					len = lps[len - 1]; 

					// Also, note that we do not increment 
					// i here 
				} 
				else // if (len == 0) 
				{ 
					lps[i] = len; 
					i++; 
				} 
			} 
		} 
	} 
    
    public int countMatchingSubarrays(int[] nums, int[] pattern) {

        StringBuilder s = new StringBuilder();
        StringBuilder p = new StringBuilder();
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                nums[i] = 1;
            }else if(nums[i]>nums[i+1]){
                nums[i] = 2;
            }else{
                nums[i] = 0;
            }
            s.append(nums[i]);
        }
        s.append(9);
        
        int res = 0;
        
        for(int i=0;i<pattern.length;i++){
            if(pattern[i] == -1)
                pattern[i] = 2;
            p.append(pattern[i]);
        
        }
        
        String str = s.toString();
        String pat = p.toString(); 
        
//         System.out.println(str);
        // System.out.println(pat);
        
        res = KMPSearch(pat, str);
        // System.out.println();
        
//         Pattern pat = Pattern.compile(p.toString());
//         Matcher mat = pat.matcher(str);
        
//         int i = 0;
//         while (mat.find(i)) {
//             res++;
//             i = mat.start() + 1;
//         }
        
        
        
//         int lastIndex = 0;
        
//         while (lastIndex != -1 && lastIndex+pat.length()!=str.length()) {
            
//             lastIndex = str.indexOf(pat, lastIndex);

//             if (lastIndex != -1 && lastIndex+pat.length()!=str.length()) {
//                 res++;
//                 lastIndex++;
//             }
//         }
        
        return res;
    }
}