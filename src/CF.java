import utils.Utils;
public class CF extends Person {

    Person p1 = new Person();
    DebugBool debug = new DebugBool();
    ControlCode cd = new ControlCode();

    private String code = "";

    private String surname = "";

    private String name = "";

    private String gender = "";

    private int day;

    private int month;

    private int year;

    private String borncity = "";

    private String consonanti_COGNOME = "";
    private String vocali_COGNOME = "";
    private String consonanti_NOME = "";
    private String vocali_NOME = "";

    public CF (Person p1){

        this.p1 = p1;

        surname=p1.getSurname().toUpperCase();
        name=p1.getName().toUpperCase();
        gender=p1.getGender().toUpperCase();
        day=p1.getDay();
        month=p1.getMonth();
        year=p1.getYear();
        borncity=p1.getBornCity().toUpperCase();

        StringVocalC();

        if(debug.debug){
            System.out.println("DEBUG CF Cognome: " + surname);
            System.out.println("DEBUG CF Nome: " + name);
            System.out.println("DEBUG CF Giorno: " + day);
            System.out.println("DEBUG CF Mese: " + month);
            System.out.println("DEBUG CF Anno: " + year);
            System.out.println("DEBUG CF Genere: " + gender);
            System.out.println("DEBUG CF Citta: " + borncity);
            System.out.println("DEBUG CF Codice Citta: " + getCityCode());
        }


        code = codSurname()+codName()+codData()+getCityCode();

        if(debug.debug){
            System.out.println("DEBUG CF prima del control code: " + code);
        }


        code += cd.getControlCode(code);
    }

    public String getCF (){
        return code;
    }

    public String getCityCode(){
        String codiceCatastale = "";

        codiceCatastale = Utils.getCitiesCodes().getKey(borncity);

        if (codiceCatastale.equals(Utils.ERROR))
            return "*ERRORE*";
        else
            return codiceCatastale;
    }

    private String codData(){

        String s= "";
        String yearS=year+"";
        s = s+yearS.charAt(2)+yearS.charAt(3);
        switch(month){
            case 1: s+="A";break;
            case 2: s+="B";break;
            case 3: s+="C";break;
            case 4: s+="D";break;
            case 5: s+="E";break;
            case 6: s+="H";break;
            case 7: s+="L";break;
            case 8: s+="M";break;
            case 9: s+="P";break;
            case 10: s+="R";break;
            case 11: s+="S";break;
            case 12: s+="T";break;
        }

        if (debug.debug){
            System.out.println("DEBUG codData gender bif: " + gender);
        }

        if(gender.equals("M")){

            if(debug.debug){System.out.println("DEBUG codData gender is M");}

            if(day < 10){
                s+="0"+day;
            }
            else {
                s+=day;
            }
        }
        else {
            s+=(day+40);

            if (debug.debug){
                System.out.println("DEBUG codData gender is F");
                System.out.println("DEBUG codData gender aif: " + gender);
            }
        }
        return s;
    }

    private String codName(){

        String s="";
        if(consonanti_NOME.length() > 3){
            s = s + consonanti_NOME.charAt(0) + consonanti_NOME.charAt(2) + consonanti_NOME.charAt(3);
            return s;
        }
        if(consonanti_NOME.length() == 3){
            for (int i = 0; i < 3 ;i++){
                s = s + consonanti_NOME.charAt(i);
            }
            return s;
        }
        if(consonanti_NOME.length() == 2) {
            s = s + consonanti_NOME.charAt(0) + consonanti_NOME.charAt(1) + vocali_NOME.charAt(0);
            return s;
        }
        if(consonanti_NOME.length() == 1){
            s = s + consonanti_NOME.charAt(0) + vocali_NOME.charAt(0) + vocali_NOME.charAt(1);
            return s;
        }
        else {
            for (int i = 0; i < 3; i++) {
                s = s + vocali_NOME.charAt(i);
            }
            return s;
        }
    }

    private String codSurname(){

        String s="";
        if(consonanti_COGNOME.length()>=3){
            for(int i=0;i<3;i++){
                s=s+consonanti_COGNOME.charAt(i);
            }
            return s;
        }
        if(consonanti_COGNOME.length()==2){
            s = s + consonanti_COGNOME.charAt(0) + consonanti_COGNOME.charAt(1) + vocali_COGNOME.charAt(0);
            return s;
        }
        if(consonanti_COGNOME.length()==1){
            s = s + consonanti_COGNOME.charAt(0) + vocali_COGNOME.charAt(0) + vocali_COGNOME.charAt(1);
            return s;
        }
        else{
            for(int i=0;i<3;i++){
                s = s + vocali_COGNOME.charAt(i);
            }
            return s;
        }

    }

    private void StringVocalC(){

//      COGNOME
        for(int i=0;i<surname.length();i++)
            if(isVocal(surname.charAt(i)))
                vocali_COGNOME=vocali_COGNOME+surname.charAt(i);
            else
            if(surname.charAt(i)!=' ')
                consonanti_COGNOME=consonanti_COGNOME+surname.charAt(i);
//		NOME
        for(int i=0;i<name.length();i++)
            if(isVocal(name.charAt(i)))
                vocali_NOME=vocali_NOME+name.charAt(i);
            else
            if(name.charAt(i)!=' ')
                consonanti_NOME=consonanti_NOME+name.charAt(i);

        if(debug.debug){
            System.out.println("DEBUG Vocali Cognome: " + vocali_COGNOME);
            System.out.println("DEBUG Consonanti Cognome: " + consonanti_COGNOME);
            System.out.println("DEBUG Vocali Nome: " + vocali_NOME);
            System.out.println("DEBUG Consonanti Nome: " + consonanti_NOME);
        }

    }

    private boolean isVocal(char c){
        if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
            return true;
        }
        else {
            return false;
        }
    }
}
