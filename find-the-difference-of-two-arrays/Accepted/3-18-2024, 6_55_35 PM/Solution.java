// https://leetcode.com/problems/find-the-difference-of-two-arrays

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>(2);

        Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        for (Iterator<Integer> i = s1.iterator(); i.hasNext();) {
            Integer num = i.next();
            if (s2.contains(num)) {
                s2.remove(num);
                i.remove();
            }
        }

        res.add(new ArrayList<>(s1));
        res.add(new ArrayList<>(s2));

        return res;
    }
}