import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JTextField matricolaField, cognomeField, nomeField, cittaField, indirizzoField;
    private JButton cercaButton, aggiungiButton, modificaButton, cancellaButton;
    private JTextArea outputArea;

    public View() {
        setTitle("Gestione Archivio");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Pannello superiore per i campi di input
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Matricola:"));
        matricolaField = new JTextField();
        inputPanel.add(matricolaField);

        inputPanel.add(new JLabel("Cognome:"));
        cognomeField = new JTextField();
        inputPanel.add(cognomeField);

        inputPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        inputPanel.add(nomeField);

        inputPanel.add(new JLabel("Città:"));
        cittaField = new JTextField();
        inputPanel.add(cittaField);

        inputPanel.add(new JLabel("Indirizzo:"));
        indirizzoField = new JTextField();
        inputPanel.add(indirizzoField);

        add(inputPanel, BorderLayout.NORTH);

        // Pannello centrale per l'area di output
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Pannello inferiore per i bottoni
        JPanel buttonPanel = new JPanel();
        cercaButton = new JButton("Cerca");
        aggiungiButton = new JButton("Aggiungi");
        modificaButton = new JButton("Modifica");
        cancellaButton = new JButton("Cancella");

        buttonPanel.add(cercaButton);
        buttonPanel.add(aggiungiButton);
        buttonPanel.add(modificaButton);
        buttonPanel.add(cancellaButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Metodi per ottenere i dati dai campi di input
    public String getMatricola() {
        return matricolaField.getText();
    }

    public String getCognome() {
        return cognomeField.getText();
    }

    public String getNome() {
        return nomeField.getText();
    }

    public String getCitta() {
        return cittaField.getText();
    }

    public String getIndirizzo() {
        return indirizzoField.getText();
    }

    // Metodi per impostare l'output
    public void setOutput(String text) {
        outputArea.setText(text);
    }

    // Metodi per aggiungere ActionListener ai bottoni
    public void addCercaListener(ActionListener listener) {
        cercaButton.addActionListener(listener);
    }

    public void addAggiungiListener(ActionListener listener) {
        aggiungiButton.addActionListener(listener);
    }

    public void addModificaListener(ActionListener listener) {
        modificaButton.addActionListener(listener);
    }

    public void addCancellaListener(ActionListener listener) {
        cancellaButton.addActionListener(listener);
    }
}
