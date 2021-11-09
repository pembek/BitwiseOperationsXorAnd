import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComplexBitwiseOperations {

    @Autowired
    BitwiseOperatorAND and;
    BitwiseOperatorXOR xor;

    public ComplexBitwiseOperations(BitwiseOperatorAND and, BitwiseOperatorXOR xor){
        this.and = and;
        this.xor = xor;
    }

    public List<List<Integer>> createContiguousSubarrays(ArrayList<Integer> integerList){
        ArrayList<Integer> tempArr = new ArrayList<>();
        List<List<Integer>> contList = new ArrayList<>();

        // 3, 5, 1 - 35, 51 - 351
        for (int i = 0; i < integerList.size(); i++){
            for (int j = 0; j < integerList.size() - i; j++){
                tempArr.clear();
                for(int z = 0; z < i + 1; z++){
                    tempArr.add(integerList.get(j + z));
                }
                contList.add(new ArrayList<>(tempArr));
            }
        }
        return contList;
    }

    public int xorOp(List<Integer> array){
        return xor.op(array);
    }

    public int xorOpArr(List<List<Integer>> arrays){
        return xor.opArr(arrays);
    }

    List<Integer> listFromPrimitiveArray(int [] arr){
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public int andOp(List<Integer> array){
        return xor.op(array);
    }
}
