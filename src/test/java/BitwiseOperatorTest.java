
import static junit.framework.TestCase.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BitwiseOperatorTest{

    private static ComplexBitwiseOperations complexBitwiseOperations;

    @BeforeClass
    public static void instantiate() {
        BitwiseOperatorAND and = new BitwiseOperatorAND();
        BitwiseOperatorXOR xor = new BitwiseOperatorXOR();
        complexBitwiseOperations = new ComplexBitwiseOperations(and, xor);
    }

    @Test
    public void _01_getcontiguosArrayCount() {
        int [] arrayInt = {3,5,1};
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrayInt.length; i++){
            arr.add(arrayInt[i]);
        }

        assertEquals(6, complexBitwiseOperations.createContiguousSubarrays(arr).size());
    }

    @Test
    public void _02_getcontiguosArrayCount() {
        int [] arrayInt = {3,5,1,2};
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrayInt.length; i++){
            arr.add(arrayInt[i]);
        }

        assertEquals(10, complexBitwiseOperations.createContiguousSubarrays(arr).size());
    }

    @Test
    public void _03_xorRepeatedNumberEffect() {
        int [] arrayInt = {3,3,3,3,3,3,3,3,5};
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrayInt.length; i++){
            arr.add(arrayInt[i]);
        }

        assertEquals(5, complexBitwiseOperations.xorOp(arr));
    }

    @Test
    public void _04_xorRepeatedNumberEffect() {
        int [] arrayInt = {3,3,3,3,3,3,3,3};
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrayInt.length; i++){
            arr.add(arrayInt[i]);
        }

        assertEquals(0, complexBitwiseOperations.xorOp(arr));
    }
}