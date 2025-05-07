import java.io.*;

public class Anagrafico {
    RandomAccessFile dati;

    public Anagrafico() {
    }

    public void apriFile() {                        //  apre il file in lettura e scrittura
        try {
            dati = new RandomAccessFile(".\\dati.dat", "rw");
        } catch (IOException e) {
        }
    }

    public void chiudiFile() {
        try {
            dati.close();
        } catch (IOException e) {
        }
    }

    //  aggiunge un record alla fine del file
    public void aggiungi(String matricola, String cognome, String nome, String citta, String indirizzo) {
        try {
            Record r = new Record(matricola, cognome, nome, citta, indirizzo);
            String s = r.toString();
            byte[] b = s.getBytes();
            dati.seek(dati.length());       // si posiziona a fine file
            dati.write(b);
        } catch (IOException e) {
        }
    }

    public String recPosizione(int pos) {      //  restituisce il record in posizione pos
        try {
            byte[] b = new byte[Record.L];
            dati.seek(pos);
            dati.read(b);
            String s = new String(b);
            return s;
        } catch (IOException e) {
        }
        return "";
    }

    public void vediTutti() {      //  visualizza tutti i record del file
        try {
            byte[] b = new byte[Record.L];
            dati.seek(0);

            int ok = dati.read(b);      // se fine file ok diviene negativo
            while (ok > 0) {
                String s = new String(b);
                System.out.println(s);
                ok = dati.read(b);
            }
        } catch (IOException e) {
        }
    }

    public int cercaMatricola(String mat) {      //  data la matricola, restituisce la posizione nel file
        try {
            byte[] b = new byte[20];         //  se non � presente restituisce -1
            int pos = 0;
            dati.seek(pos);
            int ok = dati.read(b);
            while (ok > 0) {
                String s = new String(b);
                s = s.trim();
                if (s.equals(mat)) return pos;
                pos += Record.L;
                dati.seek(pos);
                ok = dati.read(b);
            }
        } catch (IOException e) {
        }
        return -1;
    }

    // modifica della città e dell'indirizzo
    public void modifica(int pos, String citta, String indirizzo) {
        try {
            citta = Record.normalizza(citta);
            indirizzo = Record.normalizza(indirizzo);
            String s = citta + indirizzo;
            byte[] b = s.getBytes();
            dati.seek(pos + 60);    //  si posiziona sulla città
            dati.write(b);
        } catch (IOException e) {
        }
    }

    public void reInizializzaFile() {
        String vet[][] = {
                {"AZ120", "Rozzi", "Giancarlo", "Castelfranco", "Lungo Brenta 3"},
                {"AZ122", "Rotti", "Gianluca", "Castelbardo", "Lungo Piave 5"},
                {"AZ124", "Rizzi", "Gianluigi", "Castellibero", "Lungo Po 7"},
                {"AZ125", "Ruzza", "Gianmaria", "Castelsicuro", "Lungo Sile 8"},
                {"AZ126", "Razzi", "Gianandrea", "Castelvecchio", "Lungo Adige 9"}
        };
        try {
            chiudiFile();
            File f = new File(".\\dati.dat");   //  cancella il file
            f.delete();
            apriFile();                         // ricrea il file

            for (int i = 0; i < 5; i++) {
                Record r = new Record(vet[i][0], vet[i][1], vet[i][2], vet[i][3], vet[i][4]);
                String s = r.toString();
                byte[] b = s.getBytes();
                dati.seek(dati.length());       // si posiziona a fine file
                dati.write(b);
            }
        } catch (IOException e) {
        }
    }

    public void cancella() {
    }
}