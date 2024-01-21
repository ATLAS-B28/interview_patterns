package SlidingWindow;
//Fruits into Baskets

import java.util.HashMap;
public class Q4 {

    public static int totalFruit(int[] fruits) {
        int start = 0;
        int maxFruits = 0;
        HashMap<Integer,Integer> fruitFreqMap = new HashMap<>();

        for(int end = 0; end < fruits.length; end++){
            int right = fruits[end];
            fruitFreqMap.put(right, fruitFreqMap.getOrDefault(right,  0) + 1);

            while(fruitFreqMap.size() > 2) {//2 is the constraints
                int left = fruits[start];
                fruitFreqMap.put(left, fruitFreqMap.getOrDefault(left , 0) - 1);

                if(fruitFreqMap.get(left) == 0) {
                    fruitFreqMap.remove(left);
                }

                start++;
            }

            maxFruits = Math.max(maxFruits, end - start + 1);
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        int[] fruits = {1,2,1,3,2,4,1,2};
        System.out.println("Max. number of fruits:"+totalFruit(fruits));
    }
}
