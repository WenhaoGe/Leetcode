import java.util.Random;
class Solution {

    int[] sums;
    int cumulative;
    public Solution(int[] w) {
        sums = new int[w.length]; 
        int sum = 0;
        for(int i= 0; i < w.length; i++) {
            sum += w[i];
            sums[i] = sum;
        }
        cumulative = sum;
        
    }
    
    public int pickIndex() {
        int max = cumulative;
        Random rand = new Random();
        int n = rand.nextInt(max) + 1;
        int l = 0, r = sums.length - 1;
        while(l + 1 < r) {
            int mid = l + (r - l) / 2;
            if(sums[mid] == n) {
                return mid;
            } else if(sums[mid] < n) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if(sums[l] == n) {
            return l;
        } else {
            return r;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */