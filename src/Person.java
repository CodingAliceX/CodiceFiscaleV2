public class Person  {
    private String surname;

    private String name;

    private int day;

    private int month;

    private int year;

    private String gender;

    private String c_born;

    public void setSurname(String s){
        surname = s;
    }

    public void setName(String s){
        name = s;
    }

    public void setDay(int d){
        day = d;
    }

    public void setMonth(int d){
        month = d;
    }

    public void setYear(int d){
        year = d;
    }

    public void setBornCity(String b){
        c_born = b;
    }

    public void setGender(String g){
        gender = g;
    }

    public String getSurname(){
        return surname;
    }

    public String getName(){
        return name;
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    public String getBornCity(){
        return c_born;
    }

    public String getGender(){
        return gender;
    }
}

