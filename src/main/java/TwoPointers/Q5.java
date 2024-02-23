package TwoPointers;
//Problem Challenge 1 - Quadruple Sum to Target
/*
* In general, the term "quadruplets" refers to a group or set of four
* individuals or objects. In the context of programming and algorithms,
* "quadruplets" often refers to finding sets of four elements or values
* that satisfy certain conditions, such as adding up to a specific target
* sum or fulfilling other criteria.
* */
import java.util.*;
public class Q5 {

    public static List<List<Integer>> findQuadruplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> quadruplets = new ArrayList<>();

        for(int i = 0; i < arr.length - 3; i++) {
            if(i > 0 && arr[i] == arr[i - 1]) {//i > 0 to avoid duplicate and not include i == 0
                //because we are starting from i = 0 and not i = 1
                continue;
            }
            System.out.println("i: "+i);
            for(int j = i + 1; j < arr.length - 2; j++) {
                if(j > i + 1 && arr[j] == arr[j - 1]) {///j > i + 1 to avoid duplicate and not include j == i + 1
                    //because we are starting from j = i + 1 and not j = 0
                    continue;
                }

                int left = j + 1;
                System.out.println("left: "+left);
                int right = arr.length - 1;
                System.out.println("right: "+right);

                while(left < right) {
                    int currSums = arr[i] + arr[j] + arr[left] + arr[right];
                    System.out.println("currSums: "+currSums);
                    if(currSums == target) {
                        quadruplets.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        left++;
                        right--;

                        while(left < right && arr[left] == arr[left - 1]) {
                            left++;
                        }
                        while(left < right && arr[right] == arr[right + 1]) {
                            right--;
                        }
                    } else if (currSums < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return quadruplets;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, -1, 1, -3};
        int target = 1;

        List<List<Integer>> quadruplets = findQuadruplets(arr, target);
        System.out.println("Quadruplets: ");
        for(List<Integer> quadruplet : quadruplets) {
            System.out.println(quadruplet);
        }
    }
}
