package memory_puzzle;

public class MemoryPuzzleImpl implements MemoryPuzzle {

    private Status status = Status.START;

    private Gamefield gamefield;
    private boolean compare = false;
    private int rememberX, rememberY, turn;


    public MemoryPuzzleImpl() {
        gamefield = new Gamefield();
        turn = 1;
    }



    @Override
    public boolean karteAufdecken(Position p) throws KarteBereitsAufgedecktException, PositionNichtInFeldException, StateException {
       /* if(this.status != Status.START || this.status != Status.FIRSTCARD || this.status != Status.SECONDCARD ){
            throw new StateException(" aufdecken call but wrong status") ;
        }*/
        if (p.getX() < 0 || p.getX() > 1 || p.getY() < 0 || p.getY() > 2) {
            throw new PositionNichtInFeldException();
        }

        if (gamefield.getPosition(p) != Symbol.Decke) {
            throw new KarteBereitsAufgedecktException();
        }

        gamefield.openPosition(p);

        if (turn % 2 == 1){
            rememberX = p.getX();
            rememberY = p.getY();
            status = Status.FIRSTCARD;
            turn++;
        }
        else {
            status = Status.SECONDCARD;
            compare = gamefield.compareCards(new Position(rememberX, rememberY),p);
            if(compare == false){
                gamefield.closePosition(new Position(rememberX, rememberY));
                gamefield.closePosition(p);
            }
            else {
                if (isEnd()) {
                    status = Status.END;
                    System.out.println("End of the game");
                    return true;
                }
            }
            turn++;
        }
        return false;
    }

    private boolean isEnd() {
        return gamefield.isAufgedeckt();
    }

    public Gamefield getGamefield() throws FeldExistiertNichtException  {
        if(gamefield == null){
            throw new FeldExistiertNichtException();
        }
        return gamefield;
    }
}
