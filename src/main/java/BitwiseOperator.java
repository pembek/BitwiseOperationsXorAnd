import java.util.List;

public abstract class BitwiseOperator {

    public int op(int a, int b){
        return a + b;
    }

    public int op(List<Integer> array){
        int resultInt = 0;
        for (Integer in: array){
            resultInt += in;
        }
        return resultInt;
    }
}
