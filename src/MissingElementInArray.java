import java.util.HashMap;
import java.util.Map;


public class MissingElementInArray {
    public static void main(String[] args) {
        int[]arr={2};
        System.out.println(solution(arr));
    }

    public static int solution(int[] A) {
        int N = A.length;
        int missing = 0;
        Map<Integer, Integer> map = generateMap(A);
        if(A.length==0){
            return 1;
        }else {
            if ( map.keySet().size() == A.length) {

                for (int i = 0; i <= map.keySet().size(); i++) {
                    if ((map.containsKey(1) && map.keySet().size() == 1) || !map.containsKey(i + 1)) {
                        missing = i + 1;
                    }
                }
            }
        }
        return missing;
    }

    public static Map<Integer, Integer> generateMap(int[] arr) {
        Map<Integer, Integer> inputMap = new HashMap<>();
        int N = arr.length;
        if ( N <= 100000) {
            if (N != 0) {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] >=1 && arr[i] <= N + 1) {
                        if ( !inputMap.containsKey(arr[i])) {
                            inputMap.put(arr[i], 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return inputMap;
    }

}


