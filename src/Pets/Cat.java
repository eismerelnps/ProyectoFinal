package Pets;

public class Cat extends Pet {
    private String EyesColor;
    private String Sex;
    private boolean Perdigree;


    public Cat(int Ageinmonth, String Procedence, String Color, String EyesColor, String Sex, boolean Perdigree, float Price, String Code) {
        super(Ageinmonth, Procedence, Color, Price, Code);
        this.EyesColor = EyesColor;
        this.Sex = Sex;
        this.Perdigree = Perdigree;
    }

    public String getEyesColor() {
        return EyesColor;
    }

    public String getSex() {
        return Sex;
    }

    public boolean isPerdigree() {
        return Perdigree;
    }

    @Override
    public String toString() {
        return "\nGato: " +
                "\nCode: " + getCode() +
                "\nEdad: " + getAgeinMonth() + " meses " +
                "\nProcedencia: " + getProcedence() +
                "\nColor de Ojos:" + getEyesColor() +
                "\nSexo: " + getSex() +
                "\nPerdigree: " + isPerdigree() +
                "\nPrecio: " + getPrice() + "$";
    }
}
