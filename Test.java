public class Test {

    public static void main(String[] args) {

        Anagrafico arc = new Anagrafico();

        arc.apriFile();
        //arc.aggiungi("AZ999", "Gialli", "Federica", "San dona del Piave", "Piazza Vittorio III 6");
        //arc.aggiungi("AZ123", "Rossi", "Gianluca", "Castelfranco", "Lungo Sile 6");

        arc.reInizializzaFile();

        arc.vediTutti();
	
		/*
		int pos = arc.cercaMatricola("AZ132");
		if (pos >0){ String s= arc.recPosizione(pos);
					 System.out.println(s);
				   }
		else System.out.println("matricola inesistente");
		*/

        arc.modifica(200, "Mestre", "Garibaldi 35");


        //String s = arc.recPosizione(200);

        //System.out.println(s.substring(0,20));


        //System.out.println(s.substring(20,40));
	
		/*System.out.println(s.substring(40,60));
		System.out.println(s.substring(60,80));
		System.out.println(s.substring(80,100));

		*/

        arc.chiudiFile();

    } // main

}