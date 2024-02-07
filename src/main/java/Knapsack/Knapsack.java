package Knapsack;

public class Knapsack {

    public int knapSack(int W, int wt[], int val[], int n) {

        int i, w;
        int K[][] = new int[n+1][W+1];//<-- n+1 rows and W+1 columns

        for(i = 0; i <= n; i++) {
            for(w = 0; w <= W; w++) {//w - indiviual weight, W - weight capacity
                System.out.println("--------");
                System.out.println("i = " + i + " w = " + w);
                if(i == 0 || w == 0) {
                    K[i][w] = 0;
                    System.out.println("K[" + i + "][" + w + "] = " + K[i][w]);
                } else if(wt[i - 1] <= w) {
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                    System.out.println("K[" + i + "][" + w + "] = " + K[i][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                    System.out.println("K[" + i + "][" + w + "] = " + K[i][w]);
                }
            }
        }

        return K[n][W];
    }

    public static void main(String[] args) {
        
        Knapsack ks = new Knapsack();
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println("Knapsack Problem: "+ks.knapSack(W, wt, val, n));
    }
}

