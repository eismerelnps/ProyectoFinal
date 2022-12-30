package Pets;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pet {
    private String Name;
    private int AgeinMonth;
    private String Procedence;
    private String Color;
    private float Price;
    private String Code;

    public Pet(String Name, int AgeinMonth, String Procedence, String Color, float Price, String Code) {
        this.Name = Name;
        this.AgeinMonth = AgeinMonth;
        this.Procedence = Procedence;
        this.Color = Color;
        this.Price = Price;
        this.Code = Code;

    }


}
