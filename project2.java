import java.util.Random;
import java.util.Scanner;


public class project2 {
    static int playerHand = 0;
    static int playerCard = 0;
    static int dealerHand = 0;
    static int choice = 0;
    static int numOfGames = 0;
    static int playerWins = 0;
    static int dealerWins = 0;
    static int numOfTies = 0;
    static Scanner sc = new Scanner(System.in);
    static Random randGen = new Random();

    public static void main(String args[]) {
        games();
        cardDealer();
    }

    public static void cardDealer(){
        playerCard = randGen.nextInt(13) + 1;
        playerHand = playerCard + playerHand;
        if (playerCard <= 10 && playerCard > 1) {
            System.out.println("Your card is a " + playerCard + "!");
            System.out.println("Your hand is: " + playerHand);
            System.out.println("");
        } else if (playerCard == 11) {
            System.out.println("Your card is a JACK!");
        } else if (playerCard == 12) {
            System.out.println("Your card is a QUEEN!");
        } else if (playerCard == 13) {
            System.out.println("Your card is a KING!");
        } else if (playerCard == 1) {
            System.out.println("Your card is an ACE!");
            System.out.println("Your hand is " + playerHand);
            System.out.println("");
        }
        if (playerCard >= 11) {
            playerHand = playerHand - playerCard + 10;
            System.out.println("Your hand is: " + playerHand + "!");
            System.out.println("");
        }
        if(playerHand == 21){
            System.out.println("BLACKJACK! You win!");
            System.out.println("");
            playerWins++;
            playerHand = 0;
            games();
            cardDealer();
            return;
        }
        if(playerHand > 21){
            System.out.println("You exceeded 21! You lose :(");
            System.out.println("");
            dealerWins++;
            playerHand =0;
            games();
            cardDealer();
            return;
        }
        choices();
    }

    public static void choices() {
        System.out.println("1.Get another card");
        System.out.println("2.Hold hand");
        System.out.println("3.Print statistics");
        System.out.println("4.Exit");
        System.out.println("");
        System.out.print("Choose an option:");
       try {
           choice = sc.nextInt();
       }
       catch(Exception excpt){
           sc.nextLine();
           System.out.println("");
           System.out.println("Invalid input!");
           System.out.println("Please enter an integer value between 1 and 4.");
           System.out.println("");
           choices();
       }
       if(choice >4 || choice < 1){
           System.out.println("");
           System.out.println("Invalid input!");
           System.out.println("Please enter an integer value between 1 and 4.");
           System.out.println("");
           choices();
       }
        System.out.println("");
        switch (choice) {
            case 1:
                cardDealer();
                break;

            case 2:
                dealerHand = randGen.nextInt(11) + 16;
                System.out.println("Dealer's hand: " + dealerHand);
                System.out.println("Your hand is: " + playerHand);
                System.out.println("");
                if (dealerHand > playerHand && dealerHand <= 21) {
                    System.out.println("Dealer wins!");
                    System.out.println("");
                    dealerWins++;
                    playerHand = 0;
                } else if (playerHand > dealerHand || dealerHand > 21) {
                    System.out.println("You win!");
                    System.out.println("");
                    playerWins++;
                    playerHand = 0;
                } else if (playerHand == dealerHand) {
                    System.out.println("It's a tie! No one wins!");
                    System.out.println("");
                    numOfTies++;
                    playerHand = 0;
                }
                games();
                cardDealer();
                break;
            case 3:
                System.out.println("Number of Player wins: " + playerWins);
                System.out.println("Number of Dealer wins: " + dealerWins);
                System.out.println("Number of tie games: " + numOfTies);
                System.out.println("Total # of games played is: " + (numOfGames - 1));
                System.out.println("Percentage of player wins: " + ((double) playerWins / (double) (numOfGames - 1)) * 100 + "%");
                System.out.println("");
                choices();
                break;
            case 4:
                break;
        }
        }

    public static void games(){
        numOfGames++;
        System.out.println("START GAME #" + numOfGames);
        System.out.println("");
    }
}

