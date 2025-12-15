import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        long max = A >= B ? A : B;
        long min = A >= B ? B : A;
        
        long gcb = 0;
        for (long i=min; i>=1; i--) {
            if (min%i == 0 && max%i == 0) {
                gcb = i;
                break;
            }
        }
        
        if (gcb != 0)
            System.out.println((A*B)/gcb);
        else
            System.out.println(A*B);
    }
}