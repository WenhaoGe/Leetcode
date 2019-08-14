/**
 * 把所有的年龄都放到一个array 里，array的长度为121，记录每一个年龄有多少人
 * 在循环里，找出所有的满足条件的年龄组合，每个年龄出现的次数乘以另外一个年龄出现的次数
 * 要避免自己于自己握手
 */

class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        int ans = 0;
        for (int age : ages) {
            count[age]++;
        }
        for (int ageA = 0; ageA <= 120; ageA++) {
            for (int ageB = 0; ageB <= 120; ageB++) {
                if (ageA * 0.5 + 7 >= ageB) {
                    continue;
                }
                if (ageB > ageA) {
                    continue;
                }
                if (ageB > 100 && ageA < 100) {
                    continue;
                }
                ans += count[ageA] * count[ageB];
                if (ageA == ageB) {
                    ans -= count[ageA];
                }
            }
        }
        return ans;
    }
}