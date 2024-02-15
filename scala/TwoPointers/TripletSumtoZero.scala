//Triplet Sum to Zero

def tripletWithZeroSum(nums: Array[Int]): List[(Int, Int, Int)] = {
    if(nums.isEmpty || nums.length < 3) {
        return List.empty
    }

    val sortedNums = scala.util.Sorting.quickSort(nums)

    var triplets = scala.collection.mutable.ListBuffer[(Int, Int, Int)]()

    for(i <- 0 until sortedNums - 2) {
        if(i > 0 && sortedNums(i) == sortedNums(i - 1)) {
        
        }

        var left = i + 1
        var right = sortedNums.length - 1

        while(left < right) {
            val sum = sortedNums(i) + sortedNums(left) + sortedNums(right)
      }
    }
}