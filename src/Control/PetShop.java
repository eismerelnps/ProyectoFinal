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
import java.util.HashMap;
import java.util.Map;

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
        if (pass == true) {
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
            Cat cat = new Cat(AgeinMonth, Procedence, Color, EyesColor, Sex, Perdigree, Price, Code);
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


        System.out.println("size: " + pets.size());
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

    public void lessPredominantColor() {
        int count = 0;
        String[] array = new String[pets.size()];
        for (int i = 0; i < pets.size(); i++) {
            array[i] = pets.get(i).getColor();
        }
        //buscar el color menos repetido hashmap
        //crear un hashmap
        HashMap<String, Integer> map = new HashMap<>();
        //recorrer el array
        for (int i = 0; i < array.length; i++) {
            //si el color no esta en el hashmap
            if (!map.containsKey(array[i])) {
                //añadirlo al hashmap
                map.put(array[i], 1);
            } else {
                //si esta en el hashmap
                //sumarle 1
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        //recorrer el hashmap
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " " + entry.getValue() + ",");
        }
        //buscar el color menos repetido
        String colorMenosRepetido = "";
        int numeroVeces = 1000;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            //si el numero de veces que se repite es menor que el numero de veces que se repite el color menos repetido
            if (entry.getValue() < numeroVeces) {
                //guardar el color menos repetido
                colorMenosRepetido = entry.getKey();
                //guardar el numero de veces que se repite
                numeroVeces = entry.getValue();
            }
        }

        //guardar en un array todos los color que se repiten = numeroVeces
        String[] colores = new String[map.size()];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == numeroVeces) {
                colores[count] = entry.getKey();
                count++;
            }

        }
        // mostrar un showOptionDialog con el array limpio de nulls
        String[] coloresLimpio = new String[count];
        for (int i = 0; i < coloresLimpio.length; i++) {
            if (colores[i] != null) {
                coloresLimpio[i] = colores[i];
            }
        }
        int option = JOptionPane.showOptionDialog(null,
                "El color menos repetido es: ",
                "Color menos repetido",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                coloresLimpio,
                coloresLimpio[0]);
    }

    public void alfaOrder() {
        String[] Countries = new String[pets.size()];
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getProcedence().equals(Countries[i])) {

            } else {
                Countries[i] = pets.get(i).getProcedence();
            }
            System.out.println(Countries[i]);
        }
    }

    public static int compareStrings(String word1, String word2) {
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            if ((int) word1.charAt(i) != (int) word2.charAt(i))//comparing unicode values
                return (int) word1.charAt(i) - (int) word2.charAt(i);
        }
        if (word1.length() != word2.length())//smaller word is occurs at the beginning of the larger word
            return word1.length() - word2.length();
        else
            return 0;
    }

    public static String[] stringArraySort(String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (compareStrings(words[i], words[j]) > 0)//words[i] is greater than words[j]
                {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        return words;
    }

    public static void sortArray() {
        String[] arrToSort = new String[pets.size()];
        for (int i = 0; i < pets.size(); i++) {
            arrToSort[i] = pets.get(i).getProcedence();
            System.out.println(arrToSort[i]);
        }
        String[] sortedArr = stringArraySort(arrToSort);
        for (int i = 0; i < sortedArr.length; i++) {
            System.out.print(sortedArr[i] + " ");
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