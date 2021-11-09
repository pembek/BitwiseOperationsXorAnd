import java.util.ArrayList;
import java.util.List;

public class SeeMySolutions {

    public static void main(String [] args){

        BitwiseOperatorAND bitwiseOperatorAND = new BitwiseOperatorAND();
        BitwiseOperatorXOR bitwiseOperatorXOR = new BitwiseOperatorXOR();

        ComplexBitwiseOperations complexBitwiseOperations = new ComplexBitwiseOperations(bitwiseOperatorAND, bitwiseOperatorXOR);

        int [] arrayInt = {3,5,1};
        ArrayList<Integer> arr = (ArrayList<Integer>) complexBitwiseOperations.listFromPrimitiveArray(arrayInt);

        List<List<Integer>> arrays = complexBitwiseOperations.createContiguousSubarrays(arr);
        int res = complexBitwiseOperations.xorOpArr(arrays);
        System.out.println(res);
    }
}
