package Pets;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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


}
