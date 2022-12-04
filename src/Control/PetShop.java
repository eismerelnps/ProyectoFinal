package Control;

import java.io.*;
import java.nio.charset.CoderMalfunctionError;
import java.util.ArrayList;

import Pets.Cat;
import Pets.Dog;
import Pets.Pet;
import UI.UI;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

@Getter
@Setter

public class PetShop {

    public static ArrayList<Pet> pets = new ArrayList<Pet>();

    public void showPets() {
        for (Pet show : pets) {
            System.out.println(show.toString());

        }
    }

    public void sellPet(String Code) {
        boolean pass = false;
        int index = 0;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getCode().equals(Code)) {
                pass = true;
                index = pets.indexOf(pets.get(i));
            }
        }
            if (pass == true){
                pets.remove(pets.get(index));
                JOptionPane.showMessageDialog(null, "Se ha vendido exitosamente la mascota");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha encontrado una mascota con este codigo");
            }


    }


    public void fillCat(int AgeinMonth, String Procedence, String Color, String EyesColor, String Sex, boolean Perdigree, float Price, String Code) {
        boolean pass = true;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getCode().equals(Code)) {
                pass = false;
            }
        }
        if (pass == true) {
            Cat cat  = new Cat(AgeinMonth, Procedence, Color, EyesColor, Sex, Perdigree, Price, Code);
            pets.add(cat);
            JOptionPane.showMessageDialog(null,
                    "Agregado con exito",
                    "Alerta",
                    2);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Ya existe una mascota con el código: " + Code + ", cambielo",
                    "Alerta",
                    2);
        }
    }

    public void fillDog(int AgeinMonth, String Procedence, String Color, String Race, String Coder) {
        boolean pass = true;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getCode().equals(Coder)) {
                pass = false;
            }
        }
        if (pass == true) {
            float Price = 0;
            if (AgeinMonth == 0) {
                AgeinMonth = 1;
            }
            if (AgeinMonth <= 24) {
                Price = 1000 / AgeinMonth;
            } else if (AgeinMonth >= 25) {
                Price = 35;
            }
            if (Race == "Chow-Chow") {
                Price += 30;
            } else if (Race == "Dalmata") {
                Price += 50;
            }
            Dog dog = new Dog(AgeinMonth, Procedence, Color, Price, Race, Coder);
            pets.add(dog);

            JOptionPane.showMessageDialog(null,
                    "Agregado con exito",
                    "Alerta",
                    2);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Ya existe una mascota con el código: " + Coder + ", cambielo",
                    "Alerta",
                    2);
        }
    }


    public void countrySearch(String Country) {
        int count = 0;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getProcedence().equals(Country)) {
                count += 1;
            }
        }
        if (count == 0) {
            JOptionPane.showMessageDialog(null,
                    "No hay mascotas procedentes de " + Country,
                    "Informacion",
                    1);
        } else
            JOptionPane.showMessageDialog(null,
                    "Hay " + count + " mascotas procedentes de " + Country,
                    "Informacion",
                    1);
    }

    public void priceSearch(String sCode) {
        int index = 0;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getCode().equals(sCode)) {
                index = pets.indexOf(pets.get(i));
            }
        }
        System.out.println(index);
        System.out.println(pets.size());
        if (index > 0) {
            JOptionPane.showMessageDialog(null,
                    "La mascota tiene un precio de: " + pets.get(index).getPrice() + "$",
                    "Alerta",
                    2);
        } else {
            JOptionPane.showMessageDialog(null,
                    "No se ha encotrado una mascota con el codigo: " + sCode,
                    "Alerta",
                    2);
        }
    }

    public void checkCode(String sCode) {//para saber si ya existe una mascota en el arrayList con el mismo codigo
        boolean pass = true;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getCode().equals(sCode)) {
                pass = false;
            }
        }
        if (pass == true) {
            JOptionPane.showMessageDialog(null,
                    "Agregado con exito",
                    "Alerta",
                    2);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Ya existe una mascota con el código: " + sCode + ", cambielo",
                    "Alerta",
                    2);
        }



        System.out.println("size: "+pets.size());
}
    public void olderPet() {
        int age = 0;
        int index = 0;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getAgeinMonth() > age) {
                age = pets.get(i).getAgeinMonth();
                index = pets.indexOf(pets.get(i));
            }
        }
        JOptionPane.showMessageDialog(null,
                pets.get(index).toString(),
                "Mascota de mayor edad",
                1);
    }
    public void predominantColor() {
        int count = 0;
        String[] colors = new String[pets.size()];
        for (int i = 0; i < pets.size(); i++) {
            colors[i] = pets.get(i).getColor();
            System.out.println(colors[i]);
        }
        for (int i = 0; i < pets.size(); i++) {
            for (int j = 0; j < pets.size(); j++) {
                if (colors[i] == colors[j]) {
                    count++;
                    System.out.println(count);
                    count =0;
                }
            }
        }

    }
    public void CreateDataBase() {
        Connection connection = null;
        String sURL = "jdbc:mysql://localhost:3306/petShop";
        try {
            connection = DriverManager.getConnection(sURL, "root", "password");
            Statement statement = connection.createStatement();
            statement.execute("create database petShop");
            JOptionPane.showMessageDialog(null,
                    "Base de datos creada con exito",
                    "Creada",
                    1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error en la conexion",
                    "Error",
                    0);
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Error cerrando conexiones",
                        "Informacion",
                        0);
            }
        }
    }

    public void InsertDB(int AgeinMonth, String Procedence, String Color, float Price, String Race, String Code) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String sDriver = "com.mysql.jdbc.Driver";
        String sURL = "jdbc:mysql://localhost:3306/petShop";
        Connection connection = null;
        Class.forName(sDriver).newInstance();
        connection = DriverManager.getConnection(sURL, "root", "passworld");
        Statement statement = null;
        statement = connection.prepareStatement("INSERT INTO pets VALUES (?,?,?,?,?,?)");

    }
}