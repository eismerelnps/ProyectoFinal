package Pets;

public class Dog extends Pet {
    private String Race;


    public Dog(String Name, int AgeinMonth, String Procedence, String Color, float Price, String Race, String Code) {
        super(Name, AgeinMonth, Procedence, Color, Price, Code);
        this.Race = Race;
    }

    public String getRace() {
        return Race;
    }

   @Override
    public String toString() {
        return "\nPerro " +
                "\nNombre:" +getName() +
                "\nCode: " + getCode() + " " +
                "\nEdad: " + getAgeinMonth() + " meses " +
                "\nProcedencia: " + getProcedence() + " " +
                "\nColor: " + getColor() + " " +
                "\nRaza: " + getRace() + " " +
                "\nPrecio: " + getPrice() + "$";

    }
}

