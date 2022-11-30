package Control;

import java.io.*;
import java.util.ArrayList;

import Pets.Cat;
import Pets.Dog;
import Pets.Pet;
import UI.UI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
        Cat cat = null;
        if(pets.size() >= 1) {
            for (int i = 0; i < pets.size(); i++) {
                if (pets.get(i).getCode().equals(Code)) {
                    System.out.println("Encontrado");
                    JOptionPane.showMessageDialog(null, "Ya existe una mascota con el mismo codigo, por favor cambielo");
                } else
                    System.out.println("No enco");
                cat = new Cat(AgeinMonth, Procedence, Color, EyesColor, Sex, Perdigree, Price, Code);
                pets.add(cat);
            }
        }}
    public void fillDog(int AgeinMonth,String Procedence, String Color, float Price, String Race, String Coder){
        Dog dog = null;
        if(pets.size() >= 1) {
            for (int i = 0; i < pets.size(); i++) {
                if (pets.get(i).getProcedence().equals(Coder)) {
                    System.out.println("Encontrado");
                    JOptionPane.showMessageDialog(null, "Ya existe una mascota con el mismo codigo, por favor cambielo");
                } else
                    System.out.println("No enco");
                    dog = new Dog(AgeinMonth, Procedence, Color,Price , Race, Coder);
                      pets.add(dog);
            }
        }

    }
    public void countrySearch(String Country){
        int count = 0;
        for (int i = 0; i < pets.size(); i ++){
            if(pets.get(i).getProcedence().equals(Country)){
                count += 1;
            }
        }
        if (count == 0){
            JOptionPane.showMessageDialog(null,
                    "No hay mascotas procedentes de "+Country,
                    "Informacion",
                    1 );
        }else
        JOptionPane.showMessageDialog(null,
                "Hay "+count+" mascotas procedentes de "+Country,
                "Informacion",
                1 );
    }
    public void priceSearch(String sCode){
        int index;
        for(Pet search: pets){
            if(search.getCode().equals(sCode)) {
                index = pets.indexOf(search);
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
            JOptionPane.showMessageDialog( null,
                    "Base de datos creada con exito",
                    "Creada",
                    1 );
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error en la conexion",
                    "Error",
                    0);
        }finally {
                try {
                    if (connection !=null) connection.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Error cerrando conexiones",
                            "Informacion",
                            0 );
                }
            }
    }
    public void InsertDB(int AgeinMonth, String Procedence, String Color, float Price, String Race, String Code) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String sDriver =  "com.mysql.jdbc.Driver";
        String sURL = "jdbc:mysql://localhost:3306/petShop";
        Connection connection = null;
        Class.forName(sDriver).newInstance();
        connection = DriverManager.getConnection(sURL, "root", "passworld");
        Statement statement = null;
        statement = connection.prepareStatement("INSERT INTO pets VALUES (?,?,?,?,?,?)");

    }
}