import java.util.List;

public class BitwiseOperatorXOR extends BitwiseOperator{

    @Override
    public int op(int a, int b) {
        return a ^ b;
    }

    public int op(List<Integer> array){
        int resultInt = array.get(0);
        for (int i = 0; i < array.size() - 1; i++) {
            resultInt = op(resultInt, array.get(i + 1));
        }
        return resultInt;
    }

    public int opArr(List<List<Integer>> arrays){
        int resultInt = 0;
        for (List<Integer> intArr: arrays){
            resultInt ^= op(intArr);
        }
        return resultInt;
    }

    //Before diving headfirst into the problem, let's start with some definitions.
    // The bitwise exclusive OR (⊕) is an operation that, bit by bit for two operands,
    // returns 1 if one and only one bit is 1, 0 otherwise (0 ⊕ 0 = 1 ⊕ 1 = 0, 1 ⊕ 0 = 0 ⊕ 1 = 1).
    // To sum up with an example,5 ⊕ 7 = 2, which is made clear by expressing the relationship
    // with binary representations:101 ⊕ 111 = 010, given that1 ⊕ 1 = 0, 0 ⊕ 1 = 1, 1 ⊕ 1 = 0.
    //When extending the bitwise OR operator to more than two operands, the result is obtained by
    // first computing ⊕ over the first two operands, then by computing ⊕ over that result and the
    // following operand, and so on. For instance,3 ⊕ 5 ⊕ 1 = (3 ⊕ 5) ⊕ 1 = 6 ⊕ 1 = 7.
    //Another concept that you'll need is the set of subarrays of an array, a subarray being any
    // contiguous set of elements taken from the initial array. For example, given an array[x0, x1, x2],
    // here is the set of all its subarrays:[x0], [x1], [x2], [x0, x1], [x1, x2], [x0, x1, x2].
    // As you can see, also the initial array belongs to the set.
    //Next, we define a functionf(X), where X is an array of N integer numbers,[x0, x1, ..., xN-1], as follows:
    //￼
    //In other words, functionf(X)computes first the bitwise exclusive OR over the elements of
    // all the contiguous subarrays of an array of length N, and then computes the bitwise exclusive OR
    // over the results. For example:
    //f([3, 5, 1]) = (3) ⊕ (5) ⊕ (1) ⊕ (3 ⊕ 5) ⊕ (5 ⊕ 1) ⊕ (3 ⊕ 5 ⊕ 1) = 3 ⊕ 5 ⊕ 1 ⊕ 6 ⊕ 4 ⊕ 7 = 2
    //Your goal is to come up with an algorithm to computef(X)for any array of integer numbers X.
    // The more efficient your solution, the better. The optimal solution has time complexityO(N)
    // and space complexityO(1).
    //To make your life easier:
    //* The bitwise XOR operator (⊕) is already implemented.z = x ⊕ ysimply works and does so
    // in constant time and space (magic!).
    //* You shouldn’t need to jump from and to integer and binary representations of numbers. So, if
    // you’re implementing an algorithm to do that, you’re probably on the wrong path.
    //
    //Focus on the core logic needed to solve the problem. If your algorithm is longer than 20 lines
    // you’re almost certainly not following the instructions.
    //Use the space available below to describe your solution in pseudocode, or any language of your
    // choice.Please, make sure to provide a description of your reasoning and complement your
    // code with very clear explanations of what each part does and why: if the reviewers can’t
    // understand your algorithm despite a reasonable effort, they’ll have to consider your solution as wrong.

    // My solution

    // To make things simple we can use those infos:
    //1) XOR operator does not care about order. The order of precedence is not important for XOR,
    // we can process our elements whichever order we like.
    //2) The same numbers clears the result to zero. 3 XOR 3 = 0 , 5 XOR 5 = 0. etc.
    //3) In this case we can eliminate the numbers that appear even times. Ex, when 3 appears 6 times,
    // it does not affect the result: 3 ⊕ 3 ⊕ 3 ⊕ 3 ⊕ 3 ⊕ 3 ⊕ 5 = 5. Or on the above example
    // (3) ⊕ (5) ⊕ (1) ⊕ (3 ⊕ 5) ⊕ (5 ⊕ 1) ⊕ (3 ⊕ 5 ⊕ 1), only 3 and 1 appears odd times,
    // the result can be summarized as 3 ⊕ 1 = 2. That means the numbers in our array,
    // we only care about the numbers appear an odd count times, e.g. 1,3,5,7,...
    //
    //In f(X) function: the element
    //x(0) appears N times,
    //x(1) appears N + (N - 2) times ,
    //x(2) appears N + (N - 2) + (N - 4) times,
    //x(3) appears N + (N - 2) + (N - 4) + (N - 6) times,
    //, .... ,
    //x(N-2) appears N + (N - 2) times,
    //and finally x(N-1) appears N times
    //
    //Those are all even numbers of times if N is even.
    //But if N is odd, only appearance of X(0), X(2), X(4), .... , and  X(N-1) are odd times. These are the only elements that affect the result, since all other will negate themselves to zero.
    //
    //With those in mind, the pseudocode of the solution is:
    //
    //-If N is an even number: result is always 0.
    //-If N is an odd number: result is x(0) XOR x(2) XOR x(4) XOR ... XOR ... X(N-1)
    //
    //Ex testcase:  with array of {3,8,10,5,1}, we have
    //x(0): 3, 5 times
    //x(1): 8, 8 times
    //x(2): 10, 9 times
    //x(3): 5, 8 times
    //x(4): 1, 5 times
    //F(X) equals to odd times appeared elements , = x(0) XOR x(2) XOR x(4) = 8
    //
    //    public void functionXOR() {
    //        ArrayList<Integer> arr = new ArrayList<>();
    //        arr.add(3);arr.add(3);arr.add(3);arr.add(3);arr.add(3);
    //        arr.add(8);arr.add(8);arr.add(8);arr.add(8);arr.add(8);arr.add(8);arr.add(8);arr.add(8);
    //        arr.add(10);arr.add(10);arr.add(10);arr.add(10);arr.add(10);arr.add(10);arr.add(10);arr.add(10);arr.add(10);
    //        arr.add(5);arr.add(5);arr.add(5);arr.add(5);arr.add(5);arr.add(5);arr.add(5);arr.add(5);
    //        arr.add(1);arr.add(1);arr.add(1);arr.add(1);arr.add(1);
    //        int result = 3;
    //        for (int idx = 0; idx < arr.size() - 1; idx++){
    //            result = result ^ (arr.get(idx+1));
    //        }
    //        assertEquals(8, result);
    //    }
}
