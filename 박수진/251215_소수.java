import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        
        int sum = 0;
        int min = -1;
        for (int i=M; i<=N; i++) {
            if (isPrime(i)) {
                sum += i;
                if (min == -1)
                    min = i;
            }
        }

        if (min == -1) {
            System.out.println(min);
            return;
        }
        System.out.println(sum);
        System.out.println(min);
    }
    
    static boolean isPrime(int num) {
        if (num<2)
            return false;
        for (int i=2; i<=(int)Math.sqrt(num); i++) {
            if (num%i == 0)
                return false;
        }
        return true;
    }
}