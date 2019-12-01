class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {

        List<Integer> list = new ArrayList<>();
        if (tomatoSlices == 0 && cheeseSlices == 0) {
            list.add(0);
            list.add(0);
            return list;
        }
        int count = 0;
        while (true) {
            int copy1 = tomatoSlices;
            int copy2 = cheeseSlices;
            copy1 -= count * 4;
            copy2 -= count * 1;
            if (copy1 < 0 || copy2 < 0) {
                return list;
            }
            if (copy1 % 2 == 0 && copy2 == copy1 / 2) {
                list.add(count);
                list.add(copy1 / 2);
                return list;
            }
            count++;
        }

    }
}