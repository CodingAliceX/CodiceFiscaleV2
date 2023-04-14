import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person();

        Scanner scan = new Scanner(System.in);

        DebugBool debug = new DebugBool();

        String name = "";

        String surname = "";

        int day;

        int month;

        int year;

        String borncity = "";

        String gender = "";

        System.out.println("##########################################################");
        System.out.println("#                                                        #");
        System.out.println("#                     ______________                     #");
        System.out.println("#                   #    Calcolo     #                   #");
        System.out.println("#                   # Codice Fiscale #                   #");
        System.out.println("#                   # ______________ #                   #");
        System.out.println("#                                                        #");
        System.out.println("#                                                        #");
        System.out.println("##########################################################");
        System.out.println("");

        System.out.println("Inserire Dati Persona: \n\n");

        System.out.println("Inserisci Nome: ");
        name = scan.nextLine();

        System.out.println("Inserisci Cognome: ");
        surname = scan.nextLine();

        System.out.println("Inserisci Giorno di Nascita: ");
        day = scan.nextInt();

        System.out.println("Inserisci Mese di Nascita: ");
        month = scan.nextInt();

        System.out.println("Inserisci Anno di Nascita: ");
        year = scan.nextInt();
        scan.nextLine();

        System.out.println("Inserisci Paese di Nascita: ");
        borncity = scan.nextLine();

        System.out.println("Inserisci Genere (M o F)");
        gender = scan.nextLine();


        p1.setName(name);
        p1.setSurname(surname);
        p1.setDay(day);
        p1.setMonth(month);
        p1.setYear(year);
        p1.setGender(gender);
        p1.setBornCity(borncity);

        if(debug.debug){

            System.out.println("DEBUG Main Nome: " + p1.getName());
            System.out.println("DEBUG Main Cognome: " + p1.getSurname());
            System.out.println("DEBUG Main Giorno: " + p1.getDay());
            System.out.println("DEBUG Main Mese: " + p1.getMonth());
            System.out.println("DEBUG Main Anno: " + p1.getYear());
            System.out.println("DEBUG Main Citta: " + p1.getBornCity());
            System.out.println("DEBUG Main Genere: " + p1.getGender());

        }

        CF codf = new CF(p1);

        System.out.println("##########################################################");
        System.out.println("#           Codice Fiscale: " + codf.getCF() + "             #");
        System.out.println("##########################################################");

    }
}