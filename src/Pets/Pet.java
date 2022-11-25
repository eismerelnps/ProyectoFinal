package Pets;

import java.util.ArrayList;

public class Pet {
    private int AgeinMonth;
    private String Procedence;
    private String Color;
    private float Price;
    private String Code;

    public Pet(int AgeinMonth, String Procedence, String Color, float Price, String Code) {
        this.AgeinMonth = AgeinMonth;
        this.Procedence = Procedence;
        this.Color = Color;
        this.Price = Price;
        this.Code = Code;
    }

    public String getProcedence() {
        return Procedence;
    }

    public String getColor() {
        return Color;
    }

    public int getAgeinMonth() {
        return AgeinMonth;
    }

    public float getPrice() {
        return Price;
    }

    public String getCode() {
        return Code;
    }

    @Override
    public String toString() {
        return "\nPets.Pet:" +
                "\nCode: " + getCode() +
                "\nAgeinMonth: " + getAgeinMonth() +
                "\nProcedence: " + getProcedence() +
                "\nColor: " + getColor() +
                "\nPrice: " + getPrice() + "$";
    }
}
