package Control;

import Pets.Cat;
import Pets.Dog;
import Pets.Pet;
import UI.UI;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Getter
@Setter

public  class PetShop {
    String Saldo = (readTXT("C:\\PetShop\\saldo.txt", "0", false));



    ImageIcon errorIcon = new ImageIcon("src/icons8-warning-shield-50.png");
    static ImageIcon sterrorIcon = new ImageIcon("src/icons8-warning-shield-50.png");
    ImageIcon doneIcon = new ImageIcon("src/icons8-checkmark-64.png");
    ImageIcon noFoundIcon = new ImageIcon("src/icons8-nothing-found-80.png");
    ImageIcon cancelIcon = new ImageIcon("src/icons8-unavailable-80.png");
    ImageIcon priceSearchIcon = new ImageIcon("src/icons8-discount-finder-64.png");
    ImageIcon countryIcon = new ImageIcon("src/icons8-around-the-globe-64.png");
    ImageIcon paleteColorIcon = new ImageIcon("src/icons8-paint-palette-64.png");
    ImageIcon chashIcon = new ImageIcon("src/icons8-cash-80.png");
    ImageIcon petIcon = new ImageIcon("src/icons8-pets-80.png");
    //ImageIcon mainIcon = new ImageIcon("src/icons8-browser-homepage-64.png");

    ImageIcon sellIcon = new ImageIcon("src/icons8-huge-sale-64.png");

    ImageIcon money = new ImageIcon("src/money_finance_business_coin_dollar_icon_175930 (1).ico");



    public static ArrayList<Pet> pets = new ArrayList<Pet>();

    public void showPets() {
        for (Pet show : pets) {
            System.out.println(show.toString());
            System.out.println(Saldo);
        }
    }

    public void sellPet(String Code) {
        int option = 0;
        if (pets.size() == 0) {
            option = JOptionPane.showConfirmDialog(null,
                    "No hay ninguna mascota aún." +
                            "¿Desea agregar una nueva?",
                    "",
                    0,
                    1,
                    errorIcon);
        }
        if (option == 0) {
            System.out.println("Add pet");
        }
        boolean pass = false;
        int index = 0;
        int option1 = 2;// I started var option at 2 cause when I started it ar 0 the if of the sellin\canceling toke some value and got executed
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getCode().equals(Code)) {
                pass = true;
                index = pets.indexOf(pets.get(i));
            }
        }
        if (pass == true) {
            option1 = JOptionPane.showConfirmDialog(null,
                    "¿Está seguro que decea vender la mascota?",
                    "Vender mascota",
                    0,
                    1,
                    errorIcon);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No se ha encontrado una mascota con este código",
                    "",
                    1,
                    noFoundIcon
                    );
        }
        if (option1 == 0) {
            float selling = pets.get(index).getPrice();
            pets.remove(pets.get(index));
            JOptionPane.showMessageDialog(null,
                    "Se ha vendido la mascota por un precio de: " + selling,
                    "Vendido",
                    1,
                    doneIcon);

        } else if (option1 == 1) {//I put the else if cause with de only else: if the condition option == 0 wasnt true then else will execute
            JOptionPane.showMessageDialog(null,
                    "Se ha cancelado la venta",
                    "Cancelado",
                    1,
                    cancelIcon);
        }

    }


    public void fillCat(String Name, int AgeinMonth, String Procedence, String Color, String EyesColor, String Sex, boolean Perdigree, String Code, float Price) {
        boolean pass = true;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getCode().equals(Code)) {
                pass = false;
            }
        }

        if (pass == true) {
            Cat cat = new Cat(Name, AgeinMonth, Procedence, Color, EyesColor, Sex, Perdigree, Price, Code);
            pets.add(cat);
            JOptionPane.showMessageDialog(null,
                    "Agregado con éxito",
                    "",
                    2,
                    doneIcon);

        } else {
            JOptionPane.showMessageDialog(null,
                    "Ya existe una mascota con el código: " + Code + ", cambielo",
                    "",
                    2,
                    errorIcon);
        }
    }

    public void fillDog(String Name, int AgeinMonth, String Procedence, String Color, String Race, String Coder, float Price) {
        boolean pass = true;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getCode().equals(Coder)) {
                pass = false;
            }
        }
        if (pass == true) {


            Dog dog = new Dog(Name, AgeinMonth, Procedence, Color, Price, Race, Coder);
            pets.add(dog);

            JOptionPane.showMessageDialog(null,
                    "Agregado con exito",
                    "",
                    2,
                    doneIcon);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Ya existe una mascota con el código: " + Coder + ", cambielo",
                    "Alerta",
                    2,
                    errorIcon);
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
                    "",
                    1,
                    errorIcon);
        } else
            JOptionPane.showMessageDialog(null,
                    "Hay " + count + " mascotas procedentes de " + Country,
                    "",
                    1,
                    countryIcon);
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
                    "",
                    2,
                    chashIcon);
        } else {
            JOptionPane.showMessageDialog(null,
                    "No se ha encotrado una mascota con el codigo: " + sCode,
                    "",
                    2,
                    noFoundIcon);
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
                    2,
                    doneIcon);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Ya existe una mascota con el código: " + sCode + ", cambielo",
                    "Alerta",
                    2,
                    errorIcon);
        }


        System.out.println("size: " + pets.size());
    }

    public void olderPet() {
        int age = 0;
        int index = 0;
        if (pets.size() == 0) {
            JOptionPane.showMessageDialog(null,
                    "No hay ninguna mascota aún",
                    "",
                    1,
                    errorIcon);
        }
        if (pets.size() > 0) {
            for (int i = 0; i < pets.size(); i++) {
                if (pets.get(i).getAgeinMonth() > age) {
                    age = pets.get(i).getAgeinMonth();
                    index = pets.indexOf(pets.get(i));
                }
            }
            JOptionPane.showMessageDialog(null,
                    pets.get(index).toString(),
                    "Mascota de mayor edad",
                    1,
                    petIcon);
        }


    }

    public void lessPredominantColor() {
        boolean pass;
        if (pets.size() == 0) {
            pass = false;
        } else
            pass = true;
        if (pass == false) {
            JOptionPane.showMessageDialog(
                    null,
                    "No hay ninguna mascota aún",
                    "",
                    1,
                    errorIcon);
        } else {
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
            int option = JOptionPane.showOptionDialog(
                    null,
                    "El color menos repetido es: ",
                    "",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    paleteColorIcon,
                    coloresLimpio,
                    coloresLimpio[0]);
        }

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
        }
        String[] sortedArr = stringArraySort(arrToSort);
        if (sortedArr.length == 0){
            JOptionPane.showMessageDialog(
                    null,
                    "Por favor añada una nueva mascota",
                    "No hay ningún país aún",
                    1,
                    sterrorIcon);

        } else{
            JOptionPane.showMessageDialog(null,
                    sortedArr,
                    "Listado alfabético: ",
                    1);
        }
    }
    public  void createTXT(String PATH, String MODE, boolean APPEND){
        File file;
        FileWriter fileWriter;
        try {
             file = new File(PATH);
            if (!file.exists()) {// Check if the file already exists
                file.createNewFile();// Create the file if it doesn't exist
            }
            fileWriter = new FileWriter(PATH, APPEND );
            fileWriter.write(MODE);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
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
    public void OpenIcon(){

    }
    public String readTXT(String PATH, String SET, boolean APPEND){
        File file = new File(PATH);
        String line = null;
        Scanner scanner;
        if (!file.exists()){
            createTXT(PATH, SET, APPEND);
        }else {
            try {
                scanner = new Scanner(file);
                line= scanner.nextLine();
                System.out.println(line );
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }

        return line;
    }

}