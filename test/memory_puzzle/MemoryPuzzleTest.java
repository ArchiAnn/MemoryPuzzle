package memory_puzzle;


import org.junit.Assert;
import org.junit.Test;

public class MemoryPuzzleTest {

    private MemoryPuzzleImpl getMemoryPuzzle(){

        return new MemoryPuzzleImpl();
    }


    /*---- Karte aufdecken Tests ----*/

    @Test
    public void karteAufdeckenGood1()
            throws KarteBereitsAufgedecktException, PositionNichtInFeldException, StateException {
        MemoryPuzzleImpl memoryPuzzle = getMemoryPuzzle();

        Assert.assertTrue(memoryPuzzle.getGamefield().isGedeckt());

        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 0)), Symbol.Decke);
        memoryPuzzle.karteAufdecken(new Position(0, 0));
        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 0)), memoryPuzzle.getGamefield().getPositionOpen(new Position(0, 0)) );

        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(1, 2)), Symbol.Decke);
        memoryPuzzle.karteAufdecken(new Position(1, 2));
        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(1, 2)), memoryPuzzle.getGamefield().getPositionOpen(new Position(1, 2)) );

    }

    @Test
    public void karteAufdeckenGood2()
            throws KarteBereitsAufgedecktException, PositionNichtInFeldException, StateException  {
        MemoryPuzzleImpl memoryPuzzle = getMemoryPuzzle();

        Assert.assertTrue(memoryPuzzle.getGamefield().isGedeckt());

        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 0)), Symbol.Decke);
        memoryPuzzle.karteAufdecken(new Position(0, 0));
        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 0)), memoryPuzzle.getGamefield().getPositionOpen(new Position(0, 0)) );

        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(1, 2)), Symbol.Decke);
        memoryPuzzle.karteAufdecken(new Position(1, 2));
        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(1, 2)), memoryPuzzle.getGamefield().getPositionOpen(new Position(1, 2)) );

        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 2)), Symbol.Decke);
        memoryPuzzle.karteAufdecken(new Position(0, 2));
        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 2)), memoryPuzzle.getGamefield().getPositionOpen(new Position(0, 2)) );


    }

    @Test(expected = KarteBereitsAufgedecktException.class)
    public void karteAufdeckenBadBereitsAufgedeckt()
            throws KarteBereitsAufgedecktException, PositionNichtInFeldException, StateException  {
        MemoryPuzzleImpl memoryPuzzle = getMemoryPuzzle();

        Assert.assertTrue(memoryPuzzle.getGamefield().isGedeckt());


        memoryPuzzle.getGamefield().fieldDefinieren(new Symbol[][]{{Symbol.Kreis, Symbol.Kreis}, {Symbol.Kreuz, Symbol.Kreuz}, {Symbol.Quadrat, Symbol.Quadrat}});


        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 0)), Symbol.Decke);
        memoryPuzzle.karteAufdecken(new Position(0, 0));
        Assert.assertEquals(memoryPuzzle.getGamefield().getPosition(new Position(0, 0)), memoryPuzzle.getGamefield().getPositionOpen(new Position(0, 0)) );
        memoryPuzzle.karteAufdecken(new Position(0, 0));

    }

    @Test(expected = PositionNichtInFeldException.class)
    public void karteAufdeckenBadPositionNichtInFeld()
            throws KarteBereitsAufgedecktException, PositionNichtInFeldException, StateException {

        MemoryPuzzleImpl memoryPuzzle = getMemoryPuzzle();
        Assert.assertTrue(memoryPuzzle.getGamefield().isGedeckt());
        memoryPuzzle.karteAufdecken(new Position(2, 3));

    }

    /*---- Win Tests ----*/

    @Test
    public void winGood()
            throws KarteBereitsAufgedecktException, PositionNichtInFeldException, StateException {

        MemoryPuzzleImpl memoryPuzzle = getMemoryPuzzle();
        // Set Scenario : Feld definieren

        Assert.assertTrue(memoryPuzzle.getGamefield().isGedeckt());

        memoryPuzzle.getGamefield().fieldDefinieren(new Symbol[][]{{Symbol.Kreis, Symbol.Kreis}, {Symbol.Kreuz, Symbol.Kreuz}, {Symbol.Quadrat, Symbol.Quadrat}});


        Assert.assertFalse(memoryPuzzle.karteAufdecken(new Position(0, 0)));
        //memoryPuzzle.karteAufdecken(new Position(1, 0));
        Assert.assertFalse(memoryPuzzle.karteAufdecken(new Position(1, 0)));
        //memoryPuzzle.karteAufdecken(new Position(0, 1));
        Assert.assertFalse(memoryPuzzle.karteAufdecken(new Position(0, 1)));
        //memoryPuzzle.karteAufdecken(new Position(1, 1));
        Assert.assertFalse(memoryPuzzle.karteAufdecken(new Position(1, 1)));
        //memoryPuzzle.karteAufdecken(new Position(0, 2));
        Assert.assertFalse(memoryPuzzle.karteAufdecken(new Position(0, 2)));
        //memoryPuzzle.karteAufdecken(new Position(1, 2));
        Assert.assertTrue(memoryPuzzle.karteAufdecken(new Position(1, 2)));

    }



}
