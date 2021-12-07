package memory_puzzle;


import org.junit.Assert;
import org.junit.Test;

public class MemoryPuzzleTest {

    private MemoryPuzzle getMemoryPuzzle(){
        return new MemoryPuzzleImpl();
    }

    /*---- Karte aufdecken Tests ----*/

    @Test
    public void karteAufdeckenGood1()
            throws KarteBereitsAufgedecktException, PositionNichtInFeldException, StateException, FeldExistiertNichtException {

        MemoryPuzzle memoryPuzzle = getMemoryPuzzle();
        memoryPuzzle.getGamefield().fieldDefinieren(new Symbol[][]{{Symbol.Kreis, Symbol.Kreis, Symbol.Kreuz}, {Symbol.Kreuz, Symbol.Quadrat, Symbol.Quadrat}});

        Assert.assertTrue(memoryPuzzle.getGamefield().isGedeckt());

        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 0)), Symbol.Decke);
        memoryPuzzle.karteAufdecken(new Position(0, 0));
        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 0)), memoryPuzzle.getGamefield().getPositionOpen(new Position(0, 0)) );

        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 1)), Symbol.Decke);
        memoryPuzzle.karteAufdecken(new Position(0, 1));
        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 1)), memoryPuzzle.getGamefield().getPositionOpen(new Position(0, 1)) );

    }

    @Test
    public void karteAufdeckenGood2()
            throws KarteBereitsAufgedecktException, PositionNichtInFeldException, StateException, FeldExistiertNichtException {

        MemoryPuzzle memoryPuzzle = getMemoryPuzzle();
        memoryPuzzle.getGamefield().fieldDefinieren(new Symbol[][]{{Symbol.Kreis, Symbol.Kreis, Symbol.Kreuz}, {Symbol.Kreuz, Symbol.Quadrat, Symbol.Quadrat}});

        Assert.assertTrue(memoryPuzzle.getGamefield().isGedeckt());

        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 0)), Symbol.Decke);
        memoryPuzzle.karteAufdecken(new Position(0, 0));
        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 0)), memoryPuzzle.getGamefield().getPositionOpen(new Position(0, 0)) );

        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 1)), Symbol.Decke);
        memoryPuzzle.karteAufdecken(new Position(0, 1));
        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 1)), memoryPuzzle.getGamefield().getPositionOpen(new Position(0, 1)) );

        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 2)), Symbol.Decke);
        memoryPuzzle.karteAufdecken(new Position(0, 2));
        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 2)), memoryPuzzle.getGamefield().getPositionOpen(new Position(0, 2)) );
    }

    @Test(expected = KarteBereitsAufgedecktException.class)
    public void karteAufdeckenBadBereitsAufgedeckt()
            throws KarteBereitsAufgedecktException, PositionNichtInFeldException, StateException, FeldExistiertNichtException {

        MemoryPuzzle memoryPuzzle = getMemoryPuzzle();
        memoryPuzzle.getGamefield().fieldDefinieren(new Symbol[][]{{Symbol.Kreis, Symbol.Kreis, Symbol.Kreuz}, {Symbol.Kreuz, Symbol.Quadrat, Symbol.Quadrat}});

        Assert.assertTrue(memoryPuzzle.getGamefield().isGedeckt());

        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 0)), Symbol.Decke);
        memoryPuzzle.karteAufdecken(new Position(0, 0));
        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 0)), memoryPuzzle.getGamefield().getPositionOpen(new Position(0, 0)) );
        memoryPuzzle.karteAufdecken(new Position(0, 0));
    }

    @Test(expected = PositionNichtInFeldException.class)
    public void karteAufdeckenBadPositionNichtInFeld()
            throws KarteBereitsAufgedecktException, PositionNichtInFeldException, StateException, FeldExistiertNichtException {

        MemoryPuzzle memoryPuzzle = getMemoryPuzzle();
        Assert.assertTrue(memoryPuzzle.getGamefield().isGedeckt());
        memoryPuzzle.karteAufdecken(new Position(2, 3));
    }

    /*---- getGamefield Tests ----*/

    @Test
    public void getGamefield_test() throws FeldExistiertNichtException {
        MemoryPuzzle memoryPuzzle = getMemoryPuzzle();

        Assert.assertNotNull(memoryPuzzle.getGamefield());
    }

    /* WICHTIG!
    *  getGamefield_test_bad() falls in MemoryPuzzleImpl Zeile 13 auskommentiert wurde :
    *
    public MemoryPuzzleImpl() {
        //gamefield = new Gamefield(); //Zeile 13
        turn = 1;
    }
     */
    /*
    @Test(expected = FeldExistiertNichtException.class)
    public void getGamefield_test_bad() throws FeldExistiertNichtException {
        MemoryPuzzle memoryPuzzle = getMemoryPuzzle();
        Assert.assertNotNull(memoryPuzzle.getGamefield());
    }
     */


    /*---- Win Tests ----*/

    @Test
    public void winGood() //ImplementationsTest kein Interface
            throws KarteBereitsAufgedecktException, PositionNichtInFeldException, StateException, FeldExistiertNichtException {

        MemoryPuzzle memoryPuzzle = getMemoryPuzzle();
        // Set Scenario : Feld definieren
        memoryPuzzle.getGamefield().fieldDefinieren(new Symbol[][]{{Symbol.Kreis, Symbol.Kreis, Symbol.Kreuz}, {Symbol.Kreuz, Symbol.Quadrat, Symbol.Quadrat}});

        Assert.assertTrue(memoryPuzzle.getGamefield().isGedeckt());

        Assert.assertFalse(memoryPuzzle.karteAufdecken(new Position(0, 0)));
        Assert.assertFalse(memoryPuzzle.karteAufdecken(new Position(0, 1)));
        Assert.assertFalse(memoryPuzzle.karteAufdecken(new Position(0, 2)));
        Assert.assertFalse(memoryPuzzle.karteAufdecken(new Position(1, 0)));
        Assert.assertFalse(memoryPuzzle.karteAufdecken(new Position(1, 1)));
        Assert.assertTrue(memoryPuzzle.karteAufdecken(new Position(1, 2)));
    }
}
