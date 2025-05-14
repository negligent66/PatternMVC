public class Main {
    public static void main(String[] args) {
        Anagrafico model = new Anagrafico();
        View view = new View();
        new Control(view, model);

        view.setVisible(true);
    }
}