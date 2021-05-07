package katisProblemB;


import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Scanner;
public class KatisProblemB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Instant start = Instant.now();
		Scanner scanner = new Scanner(System.in);
		int numberOfBattries = 2;
		boolean loop = true;
		while(loop) {
				String line = scanner.next();
				int inputs = Integer.parseInt(line);
				
				if(inputs == 0) {
					loop = false;
					break;
				}
					
				int worstCase = computeWorstCase(numberOfBattries,inputs);
			
			
			System.out.println(worstCase);
		}
		scanner.close();
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toSeconds();
		System.out.println();
		//System.out.println(timeElapsed);
	}
	
	
	
	static int computeWorstCase(int k, int n) {
		final int results[][] = new int[n + 1][k + 1];
		for (int i = 0; i < n+1 ; i++) {
			
		    results[i][1] = i;
		    
		}
		
		for (int i = 2; i < n + 1; i++) {
		    for (int j = 2; j < k + 1; j++) {
		        results[i][j] = 4711;
		        for (int x = 1; x < i; x++) {
		            final int explodedBatteryResult = results[x - 1][j - 1];
		            final int intactBatteryResult = results[i - x][j];
		            int temp = Math.max(explodedBatteryResult, intactBatteryResult) + 1;
		            if (temp < results[i][j]) {
		                results[i][j] = temp;
		            }
		        }
		    }
		}
		//for (final int[] a : results) {
		    //System.out.println(Arrays.toString(a));
		//}
		return results[n][k];
	}

}
