import java.util.List;

public class BitwiseOperatorAND extends BitwiseOperator{

    @Override
    public int op(int a, int b) {
        return a & b;
    }

    public int op(List<Integer> array){
        int resultInt = 0;
        for (Integer in: array){
            resultInt &= in;
        }
        return resultInt;
    }
    //I've written on my IDE the first thing came to my mind, and I have done some tests. So, a basic implementation would be the following, written in Java:
    //    public void functionC() {
    //        int a = 5, b = 7;
    //        int result = a;
    //        for (int i = a; i < b ; i++) {
    //            result = result & (i+1);
    //        }
    //        assertEquals(4, result);
    //    }
    //But unfortunately it's time complexity is O(M^2) at worst case
    //
    //I realized that:
    //* after the AND bitwise operations, if most significant bit 1 is not on the same slot in A and B arrays, the result is always 0.
    //* More generalized explanation: after those series of ANDs; only the identical most significant digit part can be copied to the result between a and b. The part that it starts to differentiate, clears to zero.
    //* Examples: 5(101) & 7(111) = 4(100) , their MSB(most significant bit) are equal. Result is not 0. But later bits start to differentiate. We have only bit number 3, result is 2^2 = 4.
    //* Examples: 5(101) & 8(1000) = 0 , their MSB(most significant bit) are not equal. Result is 0.
    //* Examples: 10(1010) & 11(1011) = 8(1010) , their longest matched part of MSB(most significant bit) is 101. We have bit 2^1 and 2^3. Result is 10.
    //* Examples: 1024(10000000000) * 1025(10000000001) their MSB(most significant bit) are equal. Result is not 0. We have only bit number 11, result is 2^10 = 1024.
    //
    //This can even be solved as a string match algorithm, since MAXINT is 2^32 and A and B arrays are accordingly size 32. But I will write a straightforward pseudocode that just scans A and B array once, and have O(M) complexity, to finalize my solution:
    //
    //* Obtain A[0] and B[0] represent the LSB
    //* Find their MSB that is '1'.
    //* If their order in the array is not equal, result is 0. break here.
    //* If their order are equal, continue, scan until the LSB while bits are going "exactly" equal
    //* get the equal part (100101...1), you already know the bit orders, and calculate the result
    //
    //LSB: least significant bit
    //MSB: most significant bit


}
