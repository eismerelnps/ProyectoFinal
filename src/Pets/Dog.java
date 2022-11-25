package Pets;

public class Dog extends Pet {
    private String Race;


    public Dog(int AgeinMonth, String Procedence, String Color,float Price, String Race, String Code) {
        super(AgeinMonth, Procedence, Color, Price, Code);
        this.Race = Race;
    }

    public String getRace() {
        return Race;
    }

    @Override
    public String toString() {
        return "\nPerro "+
                "\nCode: "+getCode()+" "+
                "\nEdad: "+getAgeinMonth()+" meses "+
                "\nProcedencia: "+getProcedence()+" "+
                "\nColor: "+getColor()+" "+
                "\nRaza: "+getRace()+" "+
                "\nPrecio: "+getPrice()+"$";

    }
}

