import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener {
    private View view;
    private Anagrafico model;

    public Control(View view, Anagrafico model) {
        this.view = view;
        this.model = model;

        // Collegare i bottoni agli eventi
        this.view.addCercaListener(this);
        this.view.addAggiungiListener(this);
        this.view.addModificaListener(this);
        this.view.addCancellaListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Cerca")) {
            String matricola = view.getMatricola();
            int pos = model.cercaMatricola(matricola);
            if (pos >= 0) {
                String record = model.recPosizione(pos);
                view.setOutput(record);
            } else {
                view.setOutput("Matricola non trovata.");
            }
        } else if (e.getActionCommand().equals("Aggiungi")) {
            model.aggiungi(view.getMatricola(), view.getCognome(), view.getNome(), view.getCitta(), view.getIndirizzo());
            view.setOutput("Record aggiunto.");
        } else if (e.getActionCommand().equals("Modifica")) {
            int pos = model.cercaMatricola(view.getMatricola());
            if (pos >= 0) {
                model.modifica(pos, view.getCitta(), view.getIndirizzo());
                view.setOutput("Record modificato.");
            } else {
                view.setOutput("Matricola non trovata.");
            }
        } else if (e.getActionCommand().equals("Cancella")) {
            // Implementare la logica di cancellazione
            view.setOutput("Funzione di cancellazione non implementata.");
        }
    }
}
