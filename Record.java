public class Record {
    public String matricola;
    public String cognome;
    public String nome;
    public String citta;
    public String indirizzo;
    static int L = 100;

    static public String normalizza(String s) {           // aggiunge spazi alla stringa, fino a 20  caratteri
        for (int i = s.length(); i < 20; i++) s += " ";
        return s;
    }

    public Record() {
        matricola = normalizza(matricola);
        cognome = normalizza(cognome);
        nome = normalizza(nome);
        citta = normalizza(citta);
        indirizzo = normalizza(indirizzo);
    }

    public Record(String matricola, String cognome, String nome, String citta, String indirizzo) {
        this.matricola = normalizza(matricola);
        this.cognome = normalizza(cognome);
        this.nome = normalizza(nome);
        this.citta = normalizza(citta);
        this.indirizzo = normalizza(indirizzo);
    }

    public String toString() {
        return matricola + cognome + nome + citta + indirizzo;
    }

}