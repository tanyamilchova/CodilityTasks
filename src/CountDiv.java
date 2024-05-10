public class CountDiv {
    //Write a function:
    //
    //class Solution { public int solution(int A, int B, int K); }
    //
    //that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
    //
    //{ i : A ≤ i ≤ B, i mod K = 0 }
    //
    //For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
    //
    //Write an efficient algorithm for the following assumptions:
    //
    //A and B are integers within the range [0..2,000,000,000];
    //K is an integer within the range [1..2,000,000,000];
    //A ≤ B.
    public static void main(String[] args) {
        int A=0;
        int B=0;
        int K=11;
        System.out.println(countDivistion(A,B,K));

    }

    public static int countDivistion(int A, int B, int K) {
        if(A >= 0 && B <= 2000000000 && A <= B && K > 0 && K <= 2000000000) {
            int countDivs = 0;

            int start=A%K==0 ? A:(A+K-(A%K));
            int end=B-(B%K);
//            if(start==0 && end<=1){
//                countDivs=1;
//            }
            countDivs=((end-start)/K)+1;
            return  countDivs;
        }
        return 0;
    }
}
