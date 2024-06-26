// https://leetcode.com/problems/count-submatrices-with-all-ones

class Solution {
    public int numSubmat(int[][] mat) {
        int res = 0;
		int m = mat.length;
		int n = mat[0].length;
		
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = mat[i][j] == 1 ? mat[i - 1][j] + 1 : 0;
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] != 0) {
					int min = mat[i][j];
					res += min;
					for (int k = j + 1; k < n && mat[i][k] != 0; k++) {
						min = Math.min (min, mat[i][k]);
						res += min;
					}
				}
			}
		}
		
		return res;
    }
}