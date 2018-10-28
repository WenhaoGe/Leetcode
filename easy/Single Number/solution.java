class Solution {
    public int singleNumber(int[] nums) {
    /*HashSet<Integer> set = new HashSet<Integer>();
	for (int n : nums) {
		if (!set.add(n))
			set.remove(n);
	}
	Iterator<Integer> it = set.iterator();
	return it.next();*/
        int result=-1;
        Set<Integer> set = new HashSet();
        for(int num:nums){
            if(set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }
        for(Integer em:set){
            result = em;
        }
        return result;
    }
}