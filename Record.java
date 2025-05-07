public class Record{

    public String Matricola;
    public String Cognome;
    public String Nome;
    public String Citta;
    public String Indirizzo;
    static int L = 100;

    static public String normalizza(String s){           // aggiunge spazi alla stringa, fino a 20  caratteri
      int i=s.length();
      for( ; i<20; i++) s= s + " ";
      return s;
    }

    Record(){
        Matricola = normalizza(Matricola);
        Cognome = normalizza(Cognome);
        Nome = normalizza(Nome);
        Citta = normalizza(Citta);
        Indirizzo = normalizza(Indirizzo);}

    Record (String matricola, String cognome, String nome, String citta, String indirizzo){
        Matricola = normalizza(matricola);
        Cognome = normalizza(cognome);
        Nome = normalizza(nome);
        Citta = normalizza(citta);
        Indirizzo = normalizza(indirizzo); 
    }

    public String toString() {
        return    Matricola + Cognome + Nome + Citta + Indirizzo;
    }

}