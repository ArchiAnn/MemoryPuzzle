package memory_puzzle;

/**
 * Regeln:
 *  - 1 Spieler
 *  - Anzahl der Karten = 6 ( Symbole = 2x Kreis, 2x Kreuz, 2x Quadrat , Decke)
 *  - Feldgroesse = 2 x 3
 *
 *
 *  1. Alle Karten werden gemischt, gedeckt und in Reihen zu einem 3x2 Rechteck geordnet.
 *  2. Zwei Karten werden nacheinander aufgedeckt
 *  3. Sind es zwei gleiche Symbole, bleiben diese Karten aufgedeckt.
 *  4. Sind es zwei verschiedene Symbole, werden diese beiden Karten umgedreht.
 *  5. Wurde das letzte Symbolpaar aufgedeckt, ist das Spiel beendet
 *  6. Fehlerzustand bei Exceptions
 *
 *  State Machine:
 *  1. Alle Karten gedeckt
 *  2. Erste Karte aufdecken
 *  3. Zweite Karte aufdecken
 *  4. Spiel beendet (alle Karten aufgedeckt)
 *  5. Fehlerzustand bei Exceptions
 *
 *
 */

public interface MemoryPuzzle {
    /**
     * eine Karte wird auf einer freien Position in dem Spielfeld aufgedeckt
     * (Fuer Zustaende 2 und 3, Zustandsuebergaenge zu 4 und 5 werden hier abgefragt)
     *
     * @return true, wenn erfolgreiches Aufdecken, sonst false
     * @throws KarteBereitsAufgedecktException, wenn die Karte an der Position bereits aufgedeckt ist
     * @throws PositionNichtInFeldException, wenn die Position sich nicht in dem Feld befindet
     * @throws StateException, wenn nicht im Zustand 2 oder 3
     */

    boolean karteAufdecken(Position p) throws KarteBereitsAufgedecktException, PositionNichtInFeldException, StateException;

    /**

     * @return Gamefield
     * gibt das Spielfeld zurück
     *
     */

    GamefieldImpl getGamefield() throws FeldExistiertNichtException;
}
