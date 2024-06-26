// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side

class Solution {
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length-1];
        arr[arr.length-1] = -1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>max){
                int temp = arr[i];
                arr[i] = max;
                max = temp;
            }else{
                arr[i] = max;
            }
        }
        return arr;
    }
}