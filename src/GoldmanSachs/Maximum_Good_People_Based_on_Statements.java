package GoldmanSachs;

public class Maximum_Good_People_Based_on_Statements {
    public static void main(String[] args) {
        int[] good = {1,1,0,0};
        int[] bad = {0,1,1,1};
        int[] res = {3,12,11,10};
        System.out.println(maxGood(good, bad, res));
    }

    public static int maxGood(int[] good, int[] bad, int[] res){
        int count = 0;
        for(int i = 0; i < good.length; i++){
            if(good[i] == 1){
                count++;
            }
        }
        int max = count;
        for(int i = 0; i < res.length; i++){
            if(good[i] == 1){
                count--;
            }
            if(bad[i] == 1){
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

}
