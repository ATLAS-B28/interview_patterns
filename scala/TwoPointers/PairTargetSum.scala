import scala.collection.mutable

def pairWithTargetSumTwoPointers(nums: Array[Int], target: Int): 
 Option[(Int, Int)]/*Represents optional values. Instances of Option are either an instance of scala.Some or the object None.*/ 
 = {
    if(nums.isEmpty || nums.length < 2) {
        return None
    }

    scala.util.Sorting.quickSort(nums)

    var left = 0
    var right = nums.length - 1

    while(left < right) {
        val currSum = nums(left) + nums(right)

        if(currSum == target) {
            return Some((left,right))
        } else if(currSum < target) {
            left += 1
        } else {
            right -= 1
        }
    }
    None
}

def main(args: Array[String]): Unit = {
    val nums = Array(1, 2, 3, 4, 6)
    val target = 6
    println(pairWithTargetSumTwoPointers(nums, target))
}
