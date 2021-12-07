package memory_puzzle;

import java.util.ArrayList;
import java.util.Collections;

public class Gamefield implements GameField {

    private Symbol[][] gamefield; //gedeckter Zustand
    private Symbol[][] gamefield2;//aufgedeckter Zustand


    public Gamefield() {

        gamefield = new Symbol[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                gamefield[i][j] = Symbol.Decke;
            }
        }

        gamefield2 = new Symbol[2][3];

        ArrayList<Symbol> toShuffleForGamefield2 = new ArrayList<Symbol>();
        toShuffleForGamefield2.add(Symbol.Kreis);
        toShuffleForGamefield2.add(Symbol.Kreuz);
        toShuffleForGamefield2.add(Symbol.Quadrat);
        toShuffleForGamefield2.add(Symbol.Kreis);
        toShuffleForGamefield2.add(Symbol.Kreuz);
        toShuffleForGamefield2.add(Symbol.Quadrat);

        Collections.shuffle(toShuffleForGamefield2);

        int indx = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                gamefield2[i][j] = toShuffleForGamefield2.get(indx);
                indx++;
            }
        }


    }

    public Symbol[][] getGamefield() {
        return gamefield;
    }

    public Symbol[][] getGamefieldOpen() {
        return gamefield2;
    }

    public Symbol getPosition(Position p) {
        return gamefield[p.getX()][p.getY()];
    }

    public Symbol getPositionOpen(Position p) {
        return gamefield2[p.getX()][p.getY()];
    }

    public void openPosition(Position p) {
        gamefield[p.getX()][p.getY()] = gamefield2[p.getX()][p.getY()];
        printField();
    }

    public void closePosition(Position p) {
        gamefield[p.getX()][p.getY()] = Symbol.Decke;
    }

    public boolean compareCards(Position p, Position p2){
        if (gamefield[p.getX()][p.getY()] == gamefield[p2.getX()][p2.getY()]) {
            return true;
        }
        return false;
    }

    public boolean isGedeckt() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (gamefield[i][j] != Symbol.Decke) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isAufgedeckt() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (gamefield[i][j] == Symbol.Decke) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void fieldDefinieren(Symbol[][] field) {
        this.gamefield2 = field;
    }

    public void printField() {
        char[][] fieldSymbols = new char[2][3];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (gamefield[i][j] == Symbol.Decke) {
                    fieldSymbols[i][j] = '?';
                }
                else if (gamefield[i][j] == Symbol.Kreis) {
                    fieldSymbols[i][j] = '◯';
                }
                else if (gamefield[i][j] == Symbol.Quadrat) {
                    fieldSymbols[i][j] = '□';
                }
                else if (gamefield[i][j] == Symbol.Kreuz) {
                    fieldSymbols[i][j] = 'X';
                }

            }
        }

        System.out.println("        -----       -----       -----\n" +
                "     1 |  " + fieldSymbols[0][0] + "  |   " +
                "2 |  " + fieldSymbols[0][1] + "  |   " +
                "3 |  " + fieldSymbols[0][2] + "  |\n" +
                "        -----       -----       -----\n" +
                "        -----       -----       -----\n" +
                "     4 |  " + fieldSymbols[1][0] + "  |   " +
                "5 |  " + fieldSymbols[1][1] + "  |   " +
                "6 |  " + fieldSymbols[1][2] + "  |\n" +
                "        -----       -----       -----\n" );
    }
}
