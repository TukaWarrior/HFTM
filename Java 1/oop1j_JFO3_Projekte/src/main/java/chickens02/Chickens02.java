// Calculate the totalEggs collected on the days from Monday to Wednesday. 
// How many eggs are the dailyAverge?
// How many eggs are the monthlyAverge, when a month has 30 days?
// What is the monthlyProfit, if an egg costs 0.18Fr.?

package chickens02;

public class Chickens02 {
    public static void main(String[] args) {

        int totalEggs = 100+121+117; 
        double dailyAverage = (100 + 121 + 117)/3.0;
        double monthlyAverage = dailyAverage * 30;
        double monthlyProfit = monthlyAverage * 0.18;
        System.out.println("Eggs from Monday to Wednesday:   " +totalEggs);
        System.out.println("Daily Average:   " +dailyAverage);
        System.out.println("Monthly Average: " +monthlyAverage);
        System.out.println("Monthly Profit:  Fr." +monthlyProfit);
    }
}