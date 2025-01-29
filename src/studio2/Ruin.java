package studio2;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int startAmount = 2;
		double winChance = 0.7;
		int winLimit = 10;
		int totalSimulations = 500;
		
		int currentAmount = startAmount;
		int currentWins = 0;
		double randChance = Math.random();
		int playCounter = 0;
		int dayCounter = 0;
		int winCounter = 0;
		int lossCounter = 0;
		double expectedRuinRate;
		double a = 0;
		
		boolean going = true;
		
		for(int i = 0; i < totalSimulations; i++) {
			playCounter = 0;
			currentAmount = startAmount;
			going = true;
			
			while(going == true) {
				randChance = Math.random();
				if(randChance <= winChance) {
					currentWins ++;
					currentAmount += 1;
				}
				else {
					currentAmount -= 1;
				}
				
				if(currentAmount == 0 || currentAmount == winLimit) {
					going = false;
				}
				playCounter += 1;
			}
			System.out.print("simulation " + (i + 1) + ": ");
			System.out.print(playCounter + " ");
			if(currentAmount == 0) {
				System.out.println("You lost");
				lossCounter ++;
			}
			else {
				System.out.println("You won");
				winCounter ++;
			}
		}
		double ruinRate = ((double) lossCounter / (double) totalSimulations) * 100;
		if(winChance == 0.5) {
			expectedRuinRate = (1-(startAmount/winLimit));
		}
		else {
			a = ((1 - (double) winChance) / (double) winChance);
			expectedRuinRate = ((Math.pow(a, (double) startAmount)) - Math.pow(a, (double) winLimit))/(1 - Math.pow(a, (double) winLimit)) * 100;
		}
		
		System.out.println("ruin rate from simulation: " + ruinRate + "%");
		System.out.println("expected ruin rate: " + expectedRuinRate + "%");
		System.out.println(lossCounter);
		System.out.println(a);
		
	}

}
