// https://leetcode.com/problems/range-sum-query-mutable

class NumArray {
    int[] tree;
    int n;
    
    void buildTree(int[] nums) {
        for (int i = 0; i < n; i++) {
            tree[n + i] = nums[i];
        }
        for (int i = n - 1; i > 0; --i) {
            tree[i] = tree[2*i] + tree[2*i + 1];
        }
    }    

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[2*n];
        buildTree(nums);
    }
    
    public void update(int index, int val) {
        index += n;
        tree[index] = val;
        while (index > 0) {
            int left = index;
            int right = index;
            if (index % 2 == 0) {
                right = index + 1;
            } else {
                left = index - 1;
            }
            tree[index / 2] = tree[left] + tree[right];
            index /= 2;
        }
    }
    
    public int sumRange(int left, int right) {
        left += n;
        right += n;
        int sum = 0;
        while (left <= right) {
            if (left % 2 == 1) {
                sum += tree[left];
                left++;
            }
            if (right % 2 == 0) {
                sum += tree[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */