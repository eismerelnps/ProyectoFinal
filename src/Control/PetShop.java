package Control;

import java.util.ArrayList;

import Pets.Cat;
import Pets.Dog;
import Pets.Pet;
import UI.UI;

import javax.swing.*;


public class PetShop {

    ArrayList<Pet> pets = new ArrayList<Pet>();

    public void showPets() {
        for (Pet show : pets) {
            System.out.println(show.toString());

        }
    }

    public void sellPet(String Code) {

        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).equals(Code)){
               pets.remove(pets.get(i));
               JOptionPane.showMessageDialog(null, "Se ha vendido exitosamente la mascota");
            }else JOptionPane.showMessageDialog(null, "No se ha encontrado una mascota con este codigo");
        }
    }
    public void fillCat(int AgeinMonth, String Procedence, String Color, String EyesColor, String Sex, boolean Perdigree, float Price, String Code){

        Cat cat = new Cat(AgeinMonth, Procedence, Color, EyesColor, Sex, Perdigree, Price, Code );
        pets.add(cat);
    }
    public void fillDog(int AgeinMonth,String Procedence, String Color, float Price, String Race, String Code){
        Dog dog = null;
        if(pets.size() >= 1) {
            for (int i = 0; i < pets.size(); i++) {
                if (pets.get(i).getCode().equals(Code)) {
                    System.out.println("ENcontrado");
                    JOptionPane.showMessageDialog(null, "Ya existe una mascota con el mismo codigo, por favor cambielo");
                } else
                    System.out.println("No enco");
                    dog = new Dog(AgeinMonth, Procedence, Color,Price , Race, Code);
                      pets.add(dog);
            }
        }

    }
}