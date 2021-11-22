package memory_puzzle;

public enum Status {
    START,        //Alle_Karten_gedeckt,                    1
    FIRSTCARD,    //Erste_Karte_aufdecken,                  2.1
    SECONDCARD,   //Zweite_Karte_aufdecken,                 2.2
  //WAIT          // wait 2sec after SecondCard chosen      2.3
    END;          //Spiel_beendet (alle Karten aufgedeckt)  3

}
