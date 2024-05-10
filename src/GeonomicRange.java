import java.util.Arrays;

public class GeonomicRange {

    public static void main(String[] args) {


        String S = "CAGCCTA";
        int[] P = {0, 5, 2};
        int[] Q = {6, 5, 4};
        int[] result = solution(S, P, Q);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];
        if (S.length() == 0 || S.length() > 100000 || P.length == 0 || P.length > 50000) {
            return result;
        }

        int[][] impactFactor = new int[S.length()][4];
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int a = (ch == 'A') ? 1 : 0;
            int c = (ch == 'C') ? 1 : 0;
            int g = (ch == 'G') ? 1 : 0;
            int t = (ch == 'T') ? 1 : 0;
            if (i > 0) {
                a += impactFactor[i - 1][0];
                c += impactFactor[i - 1][1];
                g += impactFactor[i - 1][2];
                t += impactFactor[i - 1][3];
            }
            impactFactor[i][0] = a;
            impactFactor[i][1] = c;
            impactFactor[i][2] = g;
            impactFactor[i][3] = t;
            System.out.println(Arrays.toString(impactFactor[i]));
        }

        for (int i = 0; i < P.length; i++) {
            int tempMin=Integer.MAX_VALUE;
            int start=P[i];
            int end=Q[i];
            for (int j = 0; j < 4; j++) {
                if(impactFactor[end][j]!=0) {
                    if (start == 0) {
                        if(tempMin>j+1){
                            tempMin=j+1;
                        }
                    }else {
                        int num=impactFactor[end][j]-impactFactor[start-1][j];
                        if(num>0){
                            if(tempMin>j+1){
                                tempMin=j+1;
                            }
                        }
                    }
                }
                result[i]=tempMin;
            }

        }
        return result;
    }
}
