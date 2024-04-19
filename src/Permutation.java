import java.util.HashMap;
import java.util.Map;

public class Permutation {
    public static void main(String[] args) {
        int[]A={220000000,220};
        int permutation=solution(A);
        System.out.println(permutation);
    }
    public static int solution(int[] A) {

        int perm=1;
        boolean validInput=true;
        if(A.length>0 && A.length<=100000) {
            HashMap<Integer,Integer>map=new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                if(A[i]>0 && A[i]<=1000000000){
                    if(! map.containsKey(A[i])){
                        map.put(A[i],1);
                    }else {
                        int value=map.get(A[i]);
                        value++;
                        map.put(A[i],value);
                    }
                }
                else {
                    validInput=false;
                    break;
                }
            }
            if(validInput) {
                if (!map.keySet().isEmpty()) {
//                    printMap(map);
                    for (int i = 0; i < map.keySet().size(); i++) {
                        if (!map.containsKey(i + 1)) {
                            perm = 0;
                            return perm;
                        } else {
                            if (map.get(i + 1) != 1) {
                                return 0;
                            }
                        }
                    }
                } else {
                    return 0;
                }
            }else {
                return 0;
            }
        }
        return perm;
    }
    public static void printMap(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }
    }
}

