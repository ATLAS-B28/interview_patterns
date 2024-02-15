file:///C:/Users/abhij/Desktop/Interview_Pattern/scala/TwoPointers/TripletSumtoZero.scala
### java.lang.AssertionError: NoDenotation.owner

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.1\scala3-library_3-3.3.1.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.10\scala-library-2.13.10.jar [exists ]
Options:



action parameters:
offset: 618
uri: file:///C:/Users/abhij/Desktop/Interview_Pattern/scala/TwoPointers/TripletSumtoZero.scala
text:
```scala
//Triplet Sum to Zero

def tripletWithZeroSum(nums: Array[Int]): Option[(Int, Int, Int)] = {
    if(nums.isEmpty || nums.length < 3) {
        return None
    }

    scala.util.Sorting.quickSort(nums)

    for(i <- 0 until nums.length - 2) {
        //skip duplicate values
        if(i > 0 && nums(i) == nums(i - 1)) {
            continue
        }

        var left  = i + 1
        var right = nums.length - 1

        while(left < right) {
            val currSum = nums(i) + nums(left) + nums(right)

            if(currSum == 0) {
                return Some((nums(i), nums(left), nums(right)))
            } el@@
        }
    }
}

```



#### Error stacktrace:

```
dotty.tools.dotc.core.SymDenotations$NoDenotation$.owner(SymDenotations.scala:2582)
	dotty.tools.dotc.util.Signatures$.applyCallInfo(Signatures.scala:181)
	dotty.tools.dotc.util.Signatures$.computeSignatureHelp(Signatures.scala:94)
	dotty.tools.dotc.util.Signatures$.signatureHelp(Signatures.scala:63)
	scala.meta.internal.pc.MetalsSignatures$.signatures(MetalsSignatures.scala:17)
	scala.meta.internal.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:51)
	scala.meta.internal.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:398)
```
#### Short summary: 

java.lang.AssertionError: NoDenotation.owner