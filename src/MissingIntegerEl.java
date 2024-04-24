import java.util.HashMap;
import java.util.Map;

public class MissingIntegerEl {



        public static void main(String[] args) {
            int[]arr={-20,-100};
            int smalestPositive=solution(arr);
            System.out.println(smalestPositive);
        }
        public static int solution(int[]A){
            if(A.length>0 && A.length<=100000){
            int maxEl=A[0];
            int minPosNum=1;
            boolean validElement=true;

            for (int i = 0; i < A.length; i++) {
                if(A[i]>=-1000000 && A[i]<=1000000){
                    if(A[i]>maxEl){
                        maxEl=A[i];
                    }
                }else {
                    validElement=false;
                    break;
                }
            }

//            System.out.println("max "+maxEl);
            if(validElement){
                HashMap<Integer,Integer>map=new HashMap<>();
                for (int i = 0; i < A.length; i++) {
                    if (A[i]>0 && !map.containsKey(A[i])) {
                        System.out.println(A[i]);
                        map.put(A[i],A[i]);
                    }
                }
//                printMap(map);
                if(!map.isEmpty()) {
                    for (int i = 1; i <= maxEl + 1; i++) {
                        if (!map.containsKey(i)) {
                            minPosNum = i;
                            break;
                        }
                    }
                }
            }
            return minPosNum;
            }else {
                return 0;
            }
        }
    public static void printMap(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }
    }
    }


