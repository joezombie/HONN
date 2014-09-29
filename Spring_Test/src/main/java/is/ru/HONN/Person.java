package is.ru.HONN;

/**
 * Created by joezombie on 29.9.2014.
 */
public class Person {
    protected String name;
    protected String email;

    public Person (){

    }

    public Person (String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Name: " + getName() + " E-Mail: " + getEmail();
    }
}
