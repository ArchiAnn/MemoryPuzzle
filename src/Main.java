import memory_puzzle.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FeldExistiertNichtException, StateException, KarteBereitsAufgedecktException, PositionNichtInFeldException {

        int cardnum;
        Scanner scanner = new Scanner(System.in);

        MemoryPuzzle memoryPuzzle = new MemoryPuzzleImpl();
        System.out.println("Hello!");
        memoryPuzzle.getGamefield().printField();
        System.out.println("give me the number of the card you want to open\n");

        while(memoryPuzzle.getGamefield().isAufgedeckt()==false){
            askWhichCard();
            cardnum = scanner.nextInt();
            try {
                if (cardnum == 1) {
                    memoryPuzzle.karteAufdecken(new Position(0, 0));
                } else if (cardnum == 2) {
                    memoryPuzzle.karteAufdecken(new Position(0, 1));
                } else if (cardnum == 3) {
                    memoryPuzzle.karteAufdecken(new Position(0, 2));
                } else if (cardnum == 4) {
                    memoryPuzzle.karteAufdecken(new Position(1, 0));
                } else if (cardnum == 5) {
                    memoryPuzzle.karteAufdecken(new Position(1, 1));
                } else if (cardnum == 6) {
                    memoryPuzzle.karteAufdecken(new Position(1, 2));
                } else {
                    System.out.println("Wrong number, please enter a number again");
                }
            }
            catch (KarteBereitsAufgedecktException e){
                System.out.println("This card is already open");
            }
        }



    }

    public static void askWhichCard(){
        System.out.print("which card?");
    }
}
