import java.util.Scanner;

public class BynaryGap {
    //A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
    //
    //For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
    //
    //Write a function:
    //
    //class Solution { public int solution(int N); }
    //
    //that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
    //
    //For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
    //
    //Write an efficient algorithm for the following assumptions:
    //
    //N is an integer within the range [1..2,147,483,647].
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        if(n>0 && n<2147483647){
            System.out.println(findMaxBynaryGap(n));
        }else{
            System.out.println("Incorrect input");
        }
    }

    private static int findMaxBynaryGap(int n) {
        String binaryNum = binaryRepresentation(n);
        int tempCounter = 0;
        int maxCounter = 0;
        boolean startCount=false;

        for (int i = 0; i <binaryNum.length()-1; i++) {
            if(binaryNum.charAt(i)=='1'){
                startCount=true;
            }
            if(startCount){
                if(binaryNum.charAt(i)=='0'){
                    tempCounter++;
                    if(binaryNum.charAt(i+1)=='1'){
                        if(maxCounter<tempCounter){
                            maxCounter=tempCounter;
                        }
                        tempCounter=0;
                    }
                }
            }
        }
        return maxCounter;
    }
    public static String binaryRepresentation(int n){
        StringBuilder resultStr=new StringBuilder();
        int remnance=0;
        while (n>0){
            remnance=n%2;
            resultStr.append(String.valueOf(remnance));
            n=n/2;
        }
        return resultStr.reverse().toString();
    }
}
