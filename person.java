import java.util.Scanner;

public class Person {
	private String name;
	private int points; 
	private Neighborhood n;
	
	public Person(String name) {
		this.name = name;
		assignNeighborhood();
	}

	public int getPoints() {
		return points;
	}
	
	public void assignNeighborhood() {
		Scanner scan = new Scanner(System.in);
		String c = "";
		
		System.out.println("Choose a number between 1 and 10: ");
		int number = scan.nextInt();
		if(number == 1 || number == 3 || number == 4 || number == 7 || number == 9) {
			c = "green";
			points = 50;
			System.out.println("You have been placed in Skystead");
			System.out.println("Welcome to the Skystead neighborhood! Skystead is located in Piedmont, CA. "
					+ "\nPopulation: 50,000. Murder rate: 1%. You live in a mansion with a private pool and a view of the sunset that people would die for. "
					+ "\nHowever, your neighbors don’t seem to like you. Don’t worry! The people here are just known for being snobby so I’m sure it's nothing personal. "
					+ "\nAt least the neighborhood is safe and clean.");
		}
		else if(number == 2 || number == 5 || number == 6 || number == 8 || number == 10) {
			c = "red";
			points = 50;
			System.out.println("You have been placed in Oldham");
			System.out.println("Oldham is located in Oakland CA. Population: 100,000. Murder rate: 40%. "
					+ "\nYou live in an apartment that has no hot water and rats in the window. "
					+ "\nHope you do not mind the grafiti on the outside! Your neighbors are very kind and caring (when they are not serial killers). "
					+ "\nDespite that, the people who grew up in these communites are very proud to be living here. This is their home");
		}
		System.out.println();
		n = new Neighborhood(c);
	}
	
	public void playGame() {
		
		System.out.println("You start with 50 points");
		System.out.println("Please pick one of the options!");
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to start (Yes or yes)");
		String ans = scan.nextLine();
		if(ans.equalsIgnoreCase("Yes")) {
			int day = 1;
			boolean x = true;
			
			while(x && day <= 4) {
				System.out.println("Day " + day + "\n");
				if(day == 1) {
					this.Task1();
				}
				if(day == 2) {
					this.Task2();
				}
				if(day == 3) {
					this.Task3();
				}
				if(day == 4) {
					this.Task4();
					System.out.println("");
					if(points > 0) {
						System.out.println("You survived! Did you cook or did you cook"); 
						System.out.println("Since you won, heres a million points!");
						points += 1000000;
						System.out.println("Total points: " + points);
					}
					else {
						System.out.println("Sorry, you lost all your points and are homeless...Better luck next time!");
					}
					System.out.println("Would you like to play again? Yes or no"); 
					String str = scan.nextLine();
					if(str.equalsIgnoreCase("Yes")) {
						this.assignNeighborhood();
					}
					else if(str.equalsIgnoreCase("No")) {
						x = false;
					}
					

				}
				
				System.out.println("You have " + points + " points");
				if(points <= 0) {
					System.out.println("\n");
					System.out.println("Would you like to play again? Yes or no"); 
					String str = scan.nextLine();
					if(str.equalsIgnoreCase("Yes")) {
						this.assignNeighborhood();
					}
					else if(str.equalsIgnoreCase("No")) {
						x = false;
					}
				}
				if(day >= 4) {
					day = 1;
					points = 50;
				}
				else {
					day++;
				}
				System.out.println("");
				System.out.println("");
			}
		}
		
}
	
	public void Task1() {
		Scanner scan = new Scanner(System.in);
		if(n.getColor().equals("red")) { //rent price increase
			System.out.println("You wake up in your new apartment to the sound of yelling. "
					+ "You ignore it and go take a cold shower. You come out to find that a letter has been slipped under your door. "
					+ "\nIt’s from your landlord saying that he will be increasing rent from $1000/month to $2000/month. "
					+ "\nThis is crazy! You can’t afford this!!\n");
			System.out.println("What do you do? 1) Storm into your landlord’s office and demand a lower rent. 2) Walk into your landlord’s office and guilt trip him by telling him a story about your sick grandma. "
					+ "\n3) Ignore it and don’t pay rent.");
			int result = scan.nextInt();
			if(result == 1) {
				System.out.println("Your landlord calls the cops who charge you with assault. You spend two nights in jail because you can’t afford bail. -20pts");
				points -= 20;
			}
			else if(result == 2) {
				System.out.println("Your landlord fakes sympathy and tells you that times are tough for everyone. He expects the $2000 by the end of the week. -10pts");
				points -= 10;
			}
			else if(result == 3) {
				System.out.println("You get evicted. Game over! You are now homeless, on the bright side, you didn't have to face the gentrification! -100pts");
				points -= 50;
			}
		}
		else if(n.getColor().equals("green")) //robbery
		{
			System.out.println("You wake up to the sun shining and the birds singing. It seems like a perfect day."
					+ " \nYou decide to go out for a nice stroll but you return home to find that you have been robbed! "
					+ "\n4 windows were broken and your alarm system is ringing like crazy. You assess your possessions and find that one of your golden chalices has been stolen!"
					+ "\n");
			System.out.println("What do you do? 1) Ask your neighbors if they saw anything 2) Call the police 3) Buy a new one. You can afford it anyway."
					+ "");
			int result = scan.nextInt();
			if(result == 1) {
				System.out.println("Your neighbor scoffs and side eyes you. He ignores your question and walks back into his mansion. -5pts");
				points-=5;
			}
			else if(result == 2) {
				System.out.println("The police come to assess the crime scene and tell you they will try their best to find the perpetrator. "
						+ "\nThey tell you that they suspect it's someone from Oldham, the neighborhood across town. (no point change)"
						+ "");
			}
			else if(result == 3) {
				System.out.println("You buy a bigger, shinier chalice- and invest in smash proof windows. +10pts");
				points+=10;
			}
		}
		System.out.println();
	}

	
	public void Task2() {
		Scanner scan = new Scanner(System.in);
		if(n.getColor().equals("red")) { //housing flipped
			System.out.println("You return home from a long day of work and see a bunch of your neighbors talking in the hallway. You go over to them and they tell you about the rumors that have been circulating the block. \n"
					+ "The apartment building next door is being bought over! " + "Investors think this is an up and coming neighborhood and are planning to flip the building into high end luxury flats. \n"
					+ "What do you do? 1) Ignore it. This has nothing to do with you! It's about the building next door. \n"
					+ "2) Start a protest! You already know your neighbors are against it! This could mean your building is next! Plus, you don't want to hear the construction for the next year. \n"
					+ "3) Jump in! You have $10 to your name, why not join in on the investment? You could be the next Warren Buffet!\n");
			int result = scan.nextInt();
			if(result == 1) {
				System.out.println("Ignorance is bliss.");
			}
			else if(result == 2) {
				System.out.println("You and your neighbors take your signs and megaphones to the building next door to protest. "
						+ "\nGood effort! But unfortunatel, the construction company shuts it down by threatening to run over all of you with a tractor. -10pts");
				points-=10;
			}
			else if(result == 3) {
				System.out.println("The other investors laugh in your face and tell you to get out. -20pts");
				points-=20;
			}
			double random = Math.random();
			if(random <= 0.3) {
				points+=1000000;
				System.out.println("Wait, you won the lottery! Here is a million points and you get to buy a house in Skystead! Would you like to move there? Yes or No");
				String res = scan.nextLine();
				if(res.equalsIgnoreCase("Yes")) {
					System.out.println("Congrats! You have bought a house in Skystead! Enjoy your life there");
				}
				else {
					System.out.println("Okay then");
				}
			}
			
		}
		else if(n.getColor().equals("green")) //investing
		{
			System.out.println("\nYou are driving around town in your Porsche and hear on the radio about an up and coming neighborhood that businessmen are investing in. "
					+ "\nThey say that they are expecting a 200% return on investment, meaning that you can double your profits if you invest in this apartment building that is soon to be flipped into luxury flats. \n");
			System.out.println("What do you do? 1) Go all in 2) Sit this one out\n");
			int result = scan.nextInt();
			if(result == 1) {
				System.out.println("It takes a while but you finally see your investment double in profits as the luxury flats sell out. "
						+ "\nCongrats! You are now even richer than before. +20pts\n");
				points+=20;
			}
			else if(result == 2) {
				System.out.println("Well, life goes on as before");
			}
		}
	}
	public void Task3() {
		Scanner scan = new Scanner(System.in);
		if(n.getColor().equals("red")) { //local restaurant replaced
			System.out.println("Another long day at work and you are too tired to cook. No worries! Just down the block is Oldham’s pride and joy. "
					+ "\nLa Familia, a family run Mexican restaurant that has been in Oldham for over 50 years. "
					+ "\nTheir low prices and tasty tacos have created a community in this poor town. "
					+ "\nAlthough you just moved in, the owner is kind to you and knows your name already. This is the perfect place for you to grab a bite. You walk down the street only to find that the place is permanently closed! "
					+ "\nYou find the owner packing up inside and ask him what happened. He tells you that they have been bought over by Hell’s Kitchen. "
					+ "\nGordon Ramsey’s restaurant that costs about $200 per person. Insane!\n");
			System.out.println("What do you do? 1) Start a boycott. Tell all your friends and neighbors to boycott this new restaurant. (Not like anyone could afford it anyway) "
					+ "\n2) Hunt Gordan Ramsey down personally and have a strongly worded chat. "
					+ "\n3) Accept it - instant noodles it is. ");
			int result = scan.nextInt();
			if(result == 1) {
				System.out.println("People from Oldham join in on the boycott but Hell’s Kitchen is still thriving with new influencers from all over the state coming to town to eat here. "
						+ "\nThe boycott ultimately fails. -10pts");
				points-=10;
			}
			else if(result == 2) {
				System.out.println("Gordon Ramsey out yells you and you go home crying -20pts");
				points-=20;
			}
			else if(result == 3) {
				System.out.println("You sit and eat your instant noodles in misery");
			}
			double random = Math.random();
			if(random <= 0.2) {
				points+=1000000;
				System.out.println("Wait, you won the lottery! Here is a million points and you get to buy a house in Skystead! Would you like to move there? Yes or No");
				String res = scan.nextLine();
				if(res.equalsIgnoreCase("Yes")) {
					System.out.println("Congrats! You have bought a house in Skystead! Enjoy your life there");
				}
				else {
					System.out.println("Okay then");
				}
			}
		}
		else if(n.getColor().equals("green")) //city council debate
		{
			System.out.println("You get a letter in the mail saying that you have been invited to the Skystead Housing Committee Gala. "
					+ "\nThis is a black tie event where citizens of Skystead get to talk to the city leaders about issues or concerns they may have. "
					+ "\nThey have free food so of course you are attending. You arrive there to find that a debate has already started and it is getting heated. "
					+ "\nIt may turn into a fist fight if they don't get a tie-breaking vote! It's all up to you now. "
					+ "\nOne group of neighbors wants a light up three tier fountain in the park and the other wants a new golf course- but the budget for this month only allows for one. \n");
			System.out.println("What do you do? 1) Vote for the fountain 2) Vote for the golf course 3) Abstain");
			int result = scan.nextInt();
			if(result == 1) {
				System.out.println("Congrats! Your vote tipped the ballot in your group’s favor and you get your new fountain!  "
						+ "\nBut don’t worry, the golf course people will probably get their funds next month. +10pts");
				points+=10;
			}
			else if(result == 2) {
				System.out.println("Congrats! Your vote tipped the ballot in your group’s favor and you get your new golf course!  "
						+ "\nBut don’t worry, the fountain people will probably get their funds next month. +10pts\n");
				points+=10;
			}
			else if(result == 3) {
				System.out.println("Fist fight broke out. 10 people were injured and no one gets a fountain or golf course. "
						+ "Your neighbors now hate you even more! -10pts\n");
				points-=10;
			}
			double random = Math.random();
			if(random <= 0.15) {
				System.out.println("Your crazy neighbors hacked the system and all your money was stolen! Sorry about that");
				points = 0;
			}
		}
	}
	
	public void Task4() {
		Scanner scan = new Scanner(System.in);
		if(n.getColor().equals("red")) {
			System.out.println("Now that the only good restaurant in town has been replaced by literal Hell, you decide to start cooking at home more. "
					+ "\nTo the grocery store! You arrive at the store that was once Walmart and find that it has been taken over by Erewhon! "
					+ "\nThe notorious most expensive grocery store in the world. \n");
			System.out.println("What do you do? 1) Steal the groceries because who can afford $30 ice. 2) Beg for some money or someone to buy you food. "
					+ "\n3) Go home hungry\n");
			int result = scan.nextInt();
			if(result == 1) {
				System.out.println("Nice try, but you get caught. You are now banned from Erewhon and can't buy groceries anymore. -20pts");
				points-=20;
			}
			else if(result == 2) {
				System.out.println("You sit on the street with a cardboard sign and a kind soul gives you 5 dollars. "
						+ "Unfortunately that isn't enough to buy you anything. -10pts");
				points-=10;
			}
			else if(result == 3) {
				System.out.println("*Stomach grumbles*");
			}
		}
		if(n.getColor().equals("green")) {
			System.out.println("You hear that the neighborhood across town has opened a Hell’s Kitchen and Erewhon! "
					+ "\nThose are your favorite places to eat and shop. That neighborhood is also where the luxury flats were just built and they have one available! "
					+ "\nYou want to move there. You pack your things and move to Oldham, the new luxury neighborhood. \n");
			double random = Math.random();
			if(random <= 0.15) {
				System.out.println("Your crazy neighbors hacked the system and all your money was stolen! Sorry about that");
				points = 0;
			}
		}
	}
	
}
