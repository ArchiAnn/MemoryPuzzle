package memory_puzzle;
public class Gamefield implements GameField {

    private Symbol[][] gamefield;
    private Symbol[][] gamefield2;


    public Gamefield() {
        gamefield = new Symbol[2][3];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                gamefield[i][j] = Symbol.Decke;
            }
        }

        gamefield2 = new Symbol[2][3];
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
}
