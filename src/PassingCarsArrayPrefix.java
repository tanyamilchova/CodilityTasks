package Array;

public class PassingCarsArrayPrefix {
    public static void main(String[] args) {
        int[]arr={0,1,0,1,1,1,1,1,0,1};
        System.out.println(Solution.solution(arr));
    }
}
class Solution {
    public static int solution(int[] A){
        if(A.length>0 && A.length<=100000) {
            int[] prefArr = new int[A.length];
            long sum = 0;
            int mlt = 0;
            if(A[0]==0){
                mlt=1;
            }

            for (int i = 1; i < A.length; i++) {
                if(A[i]==0 || A[i]==1) {
                    prefArr[i] = A[i] + prefArr[i - 1];
                    if (A[i] == 0) {
                        mlt++;
                        sum -= prefArr[i];
                    }
                }else {
                    return 0;
                }
            }
            sum = sum + (long) mlt * prefArr[prefArr.length - 1];
            if(sum>1000000000){
                return -1;
            }
            return (int)sum;
        }
       return 0;
    }
}
