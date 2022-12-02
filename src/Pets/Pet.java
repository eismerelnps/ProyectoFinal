package Pets;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
