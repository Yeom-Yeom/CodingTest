import java.util.Scanner;

public class SWEA10993 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc<=T; tc++){
            int n = sc.nextInt();
            Country[] cList = new Country[n];
            double[] maxPower = new double[n];
            int[] status = new int[n];
            for(int i=0; i<n; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                double power = sc.nextDouble();
                cList[i] = new Country(x,y,power);
                status[i] = i;
            }
            for(int i=0; i<n; i++){
                Country a = cList[i];
                for(int j=i+1; j<n; j++){
                    Country b = cList[j];
                    if(a.power == b.power) continue;
                    double path = a.checkPath(b);
                    double powerA = a.power/path;
                    double powerB = b.power/path;
                    if(a.power<powerB){
                        if(maxPower[i] == powerB){
                            status[i] = -1;
                        }
                        if(maxPower[i] < powerB){
                            maxPower[i] = powerB;
                            status[i] = j;
                        }
                    }
                    if(b.power < powerA){
                        if (maxPower[j] == powerA) {
                            status[j] =-1;
                        }
                        if(maxPower[j] < powerA){
                            maxPower[j] = powerA;
                            status[j] = i;
                        }
                    }
                }
            }
            System.out.printf("#%d",tc);
            for(int i=0; i<n; i++){
                String ans="K";
                if(status[i] != i && status[i] != -1){
                    int target =status[i];
                    while(status[target]!= target){
                        target=status[target];
                    }
                    ans = Integer.toString(target+1);
                }
                if(status[i] == -1){
                    ans = "D";
                }
                System.out.printf(" %s",ans);
            }
            System.out.println();
        }
    }
    static class Country{
        int x;
        int y;
        double power;
        Country(int x, int y, double power){
            this.x = x;
            this.y = y;
            this.power = power;
        }
        public double checkPath(Country c){
            return Math.pow(x-c.x,2)+Math.pow(y-c.y,2);
        }
    }
}

