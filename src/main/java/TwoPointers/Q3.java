package TwoPointers;
//Triplet Sum to Zero

import java.util.*;
public class Q3 {

    public static List<List<Integer>> findTriplets(int[] arr) {

        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {

            if(i > 0 && arr[i] == arr[i - 1]) {
                continue;//skip duplicated
            }
            System.out.println("--------");
            System.out.println("i: "+i);
            int left = i + 1;
            int right = arr.length - 1;
            System.out.println("left: "+left);
            System.out.println("right: "+right);

            while(left < right) {

                int currSum = arr[i] + arr[left] + arr[right];
                System.out.println("currSum: "+currSum);

                if(currSum == 0) {
                    System.out.println("triplets before addition: "+triplets);
                    triplets.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    System.out.println("triplets after addition: "+triplets);
                    left++;
                    right--;
                    System.out.println("left before detection: "+left);
                    System.out.println("right before detection: "+right);

                    System.out.println("left during duplication detection: "+left+" with arr[left]: "+arr[left]+" and left - 1: "+(left - 1)+" with arr[left - 1]: " + arr[left-1]);
                    while(left < right && arr[left] == arr[left - 1]) {
                        left++;
                    }
                    System.out.println("right during duplication detection: "+right+" with arr[right]: "+arr[right]+" and right + 1: "+(right + 1)+" with arr[right + 1]: " + arr[right+1]);
                    while(left < right && arr[right] == arr[right + 1]) {
                        right--;
                    }

                } else if (currSum < 0) {

                    left++;
                    System.out.println("left when currSum < 0: "+left);
                } else {

                    right--;
                    System.out.println("right when currSum > 0: "+right);
                }
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        int[] arr = {-3, -1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = findTriplets(arr);

        System.out.println("Triplets with sum zero: ");
        for(List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
    }
}
