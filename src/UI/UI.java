package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;
import Control.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class UI {
    private JPanel MainPanel;
    private JButton inicioButton;
    private JButton agregarButton;
    private JButton venderButton;
    private JPanel addPet;
    private JRadioButton dogRadioButton;
    private JRadioButton catRadioButton;
    private JPanel KindOfPet;
    private JTextField ageTextField;
    private JRadioButton bulldogRadioButton;
    private JRadioButton dalmataRadioButton;
    private JRadioButton chowChowRadioButton;
    private JButton addPetButton;
    JPanel addPetChildren;
    private JButton siguienteButton;
    private JRadioButton hembraRadioButton;
    private JRadioButton machoRadioButton;
    private JCheckBox noCheckBox;
    private JPanel addCat;
    private JButton priceSearchButton;
    private JButton countrySearchbutton;
    private JTextField codeTextField;
    private JPanel venderJPanel;
    private JTextField sellCode;
    private JButton sellButton;
    private JLabel Saldotext;
    private JPanel leftPanel;
    private JPanel countrySearchJPanel;
    private JTextField countrySearchTextField;
    private JButton searchCountryButton;
    private JButton generarButton;
    private JButton showArraybutton;
    private JButton testButton1;
    private JButton searchPriceButton;
    private JTextField searchPriceText;
    private JPanel searchPriceJPanel;
    private JButton buscarMayorButton;
    private JButton colorMenosPredominanteButton;
    private JButton listadoAlfabeticoButton;
    private JRadioButton oscuroRadioButton;
    private JRadioButton claroRadioButton;
    private JButton testButton2;
    private JComboBox procedenceComboBox;
    private JComboBox ColorComboBox;
    private JComboBox EyesColorComboBox;
    private JPanel raceJPanel;
    private JLabel saldoText;
    private JLabel USD;
    private JLabel text1;
    private JLabel codeText;
    private JLabel ageText;
    private JLabel countryText;
    private JLabel colorText;
    private JLabel raceText;
    private JLabel eyescolorText;
    private JLabel sexText;
    private JLabel perdigreeText;
    private JLabel text2;
    private JLabel text3;
    private JLabel text4;
    private JTextField nameTextField;
    private JLabel nameText;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton LOGINButton;
    private JPanel devOptions;
    private javax.swing.JScrollPane JScrollPane;
    private JPanel loginPanel;
    private JPanel saldoJPanel;
    private JComboBox procedenceComboBox2;
    private float Saldo;

    PetShop petShop = new PetShop();

    public UI(float Saldo) {
        this.Saldo = Float.parseFloat(petShop.readTXT("C:\\PetShop\\saldo.txt", "0", false));
    }

    public UI() {
        petShop.checkFiles();
        saldoJPanel.setVisible(false);
        addPet.setVisible(false);
        JScrollPane.setVisible(false);
        KindOfPet.setVisible(false);
        addCat.setVisible(false);
        addPetChildren.setVisible(false);
        venderJPanel.setVisible(false);
        countrySearchJPanel.setVisible(false);
        searchPriceJPanel.setVisible(false);
        oscuroRadioButton.setVisible(false);
        claroRadioButton.setVisible(false);
        //MainPanel.setLayout(null);
        //loginPanel.setBounds(FlowLayout.CENTER, FlowLayout.CENTER, 75, 50);
        //JScrollPane.setSize(100, 200);

        countryList();
        setSaldo();//set the saldo text on grafic interface





        JSONObject petDetail = new JSONObject();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONParser jsonParser = new JSONParser();


        Saldo = Float.parseFloat(petShop.readTXT("C:\\PetShop\\saldo.txt", "0", false));
        Saldotext.setText(String.valueOf(Saldo));

        agregarButton.addActionListener(e -> {
            KindOfPet.setVisible(true);
            JOptionPane.showOptionDialog(null,
                    KindOfPet,
                    "",
                    JOptionPane.DEFAULT_OPTION,
                    -1,
                    null, new Object[]{},
                    null);




        });
        dogRadioButton.addActionListener(e -> catRadioButton.setSelected(false));
        catRadioButton.addActionListener(e -> dogRadioButton.setSelected(false));
        bulldogRadioButton.addActionListener(e -> {
            dalmataRadioButton.setSelected(false);
            chowChowRadioButton.setSelected(false);
        });
        dalmataRadioButton.addActionListener(e -> {
            bulldogRadioButton.setSelected(false);
            chowChowRadioButton.setSelected(false);
        });
        chowChowRadioButton.addActionListener(e -> {
            bulldogRadioButton.setSelected(false);
            dalmataRadioButton.setSelected(false);
        });
        noCheckBox.addActionListener(e -> {
            if (!noCheckBox.isSelected()) {
                noCheckBox.setText("No");
            } else noCheckBox.setText("Si");

        });
        hembraRadioButton.addActionListener(e -> machoRadioButton.setSelected(false));
        machoRadioButton.addActionListener(e -> hembraRadioButton.setSelected(false));
        siguienteButton.addActionListener(e -> {
            if (dogRadioButton.isSelected()) {
                addPetChildren.setVisible(true);
                raceJPanel.setVisible(true);
                addCat.setVisible(false);
                JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(SwingUtilities.getRootPane(KindOfPet));
                dialog.dispose();

            } else if (catRadioButton.isSelected()) {
                addPetChildren.setVisible(true);
                addCat.setVisible(true);
                raceJPanel.setVisible(false);
                JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(SwingUtilities.getRootPane(KindOfPet));
                dialog.dispose();
            } else if (!dogRadioButton.isSelected() || !catRadioButton.isSelected()) {
                JOptionPane.showMessageDialog(null,
                        "Por favor selecciona el tipo de mascota primero",
                        "",
                        2,
                        petShop.getErrorIcon());
            }

        });
        addPetButton.addActionListener(e -> {
            if (catRadioButton.isSelected()){
                String Name;
                int AgeinMonth;
                String Code;
                String Procedence;
                String Color;
                String EyesColor;
                String Sex =  null;
                boolean Perdigree = false;
                boolean pass;
                float Price =0;



                try {
                    if (nameTextField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Por favor introduzca el nombre",
                                "",
                                1,
                                petShop.getErrorIcon());
                        pass = false;
                    }else if (codeTextField.getText().isEmpty()){
                        JOptionPane.showMessageDialog(
                                null,
                                "Por favor introduzca el código primero",
                                "",
                                1,
                                petShop.getErrorIcon());
                        pass = false;
                    }else if (ageTextField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Por favor introduzca la edad primero",
                                "",
                                1,
                                petShop.getErrorIcon());
                        pass = false;
                    }else if (procedenceComboBox.getSelectedIndex() == 0 ) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Por favor seleccione un país",
                                "",
                                1,
                                petShop.getErrorIcon());
                        pass = false;
                    } else if (ColorComboBox.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Por favor seleccione un color",
                                "",
                                1,
                                petShop.getErrorIcon());
                        pass = false;
                    } else if (EyesColorComboBox.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Por favor seleccione un color de ojos",
                                "",
                                1,
                                petShop.getErrorIcon());
                        pass = false;
                    }else if (!hembraRadioButton.isSelected() && !machoRadioButton.isSelected()){
                        JOptionPane.showMessageDialog(null,
                                "Por favor defina el sexo del gato",
                                "",
                                JOptionPane.INFORMATION_MESSAGE,
                                petShop.getErrorIcon());
                        pass = false;
                    } else if (Integer.parseInt(ageTextField.getText()) < 0) {
                        JOptionPane.showMessageDialog(null,
                                "Por favor introduzca una edad válida",
                                "",
                                1,
                                petShop.getErrorIcon());
                        pass = false;
                    } else {
                        if (hembraRadioButton.isSelected()) {
                            Sex = "Hembra";
                        } else {Sex = "Macho";
                        Perdigree = noCheckBox.isSelected();
                        }
                        pass = true;
                    }


                    if(pass){
                        Name = nameTextField.getText();
                        Code = codeTextField.getText();
                        AgeinMonth = Integer.parseInt(ageTextField.getText());
                        if (AgeinMonth == 0 || AgeinMonth < 0){
                            ageTextField.setText("1");
                            AgeinMonth = 1;
                        }

                        if (AgeinMonth <= 24) {
                            Price = 1000 / AgeinMonth;
                        } else if (AgeinMonth >= 25) {
                            Price = 35;
                        }
                        if (Perdigree) {
                            Price *= 2;
                        }
                        Procedence = String.valueOf(procedenceComboBox.getItemAt(procedenceComboBox.getSelectedIndex()));
                        Color = String.valueOf(ColorComboBox.getItemAt(ColorComboBox.getSelectedIndex()));
                        EyesColor = String.valueOf(EyesColorComboBox.getItemAt(EyesColorComboBox.getSelectedIndex()));

                        petShop.fillCat(Name, AgeinMonth, Procedence, Color, EyesColor, Sex, Perdigree, Code, Price);
                        petDetail.put("PET", "CAT");
                        petDetail.put("Name", Name);
                        petDetail.put("Code", Code);
                        petDetail.put("AgeinMonth", AgeinMonth);
                        petDetail.put("Procedence", Procedence);
                        petDetail.put("Color", Color);
                        petDetail.put("EyesColor", EyesColor);
                        petDetail.put("Sex", Sex);
                        petDetail.put("Perdigree", Perdigree);
                        jsonObject.put("petdetail",petDetail);
                        jsonArray.put(jsonObject);

                        Saldo = Saldo + Price;
                        Saldotext.setText(String.valueOf(Saldo));
                        petShop.createTXT("C:\\PetShop\\saldo.txt", String.valueOf(Saldo), false);
                        petShop.createTXT("C:\\PetShop\\DB.json\\", jsonObject.toString(),true);

                    }

                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ingrese la edad solo en números",
                            "",
                            JOptionPane.ERROR_MESSAGE,
                            petShop.getErrorIcon());
                }

            }
            if (dogRadioButton.isSelected()){
                String Name;
                String Color;
                String Race = null;
                String Code;
                String Procedence;
                int AgeinMonth;
                boolean pass;
                float Price = 0;



                try {

                    if (nameTextField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Por favor introduzca el nombre primero",
                                "",
                                JOptionPane.INFORMATION_MESSAGE,
                                petShop.getErrorIcon());
                        pass = false;
                    }else if (codeTextField.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,
                                "Por favor introduzca el código primero",
                                "",
                                JOptionPane.INFORMATION_MESSAGE,
                                petShop.getErrorIcon());
                        pass = false;
                    }else if (ageTextField.getText().isEmpty()){
                        JOptionPane.showMessageDialog(
                                null,
                                "Por favor introduzca la edad primero",
                                "",
                                JOptionPane.INFORMATION_MESSAGE,
                                petShop.getErrorIcon());
                        pass = false;
                    }else if (ColorComboBox.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Por favor seleccione un color",
                                "",
                                JOptionPane.INFORMATION_MESSAGE,
                                petShop.getErrorIcon());
                        pass = false;
                    } else if (procedenceComboBox.getSelectedIndex() == 0 ) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Por favor seleccione un país",
                                "",
                                JOptionPane.INFORMATION_MESSAGE,
                                petShop.getErrorIcon());
                        pass = false;
                    } else if (Integer.parseInt(ageTextField.getText()) < 0 || Integer.parseInt(ageTextField.getText()) > 180) {
                        JOptionPane.showMessageDialog(null,
                                "Por favor introduzca una edad válida",
                                "",
                                JOptionPane.INFORMATION_MESSAGE,
                                petShop.getErrorIcon());
                        pass = false;
                    }else if (bulldogRadioButton.isSelected()) {
                        Race = bulldogRadioButton.getText();
                        pass = true;
                    } else if (dalmataRadioButton.isSelected()) {
                        Race = "Dalmata";
                        pass = true;
                    } else if (chowChowRadioButton.isSelected()) {
                        Race = "Chow-Chow";
                        pass = true;
                    } else if (!bulldogRadioButton.isSelected() && !dalmataRadioButton.isSelected() && !chowChowRadioButton.isSelected()){
                        JOptionPane.showMessageDialog(null,
                                "Por favor selecciona la raza primero",
                                "",
                                JOptionPane.INFORMATION_MESSAGE,
                                petShop.getErrorIcon());
                        pass = false;
                    }
                    else {
                        pass = true;
                    }


                    if (pass){
                        Name = nameTextField.getText();
                        Code = codeTextField.getText();
                        AgeinMonth = Integer.parseInt(ageTextField.getText());
                        Procedence = String.valueOf(procedenceComboBox.getItemAt(procedenceComboBox.getSelectedIndex()));
                        Color = String.valueOf(ColorComboBox.getItemAt(ColorComboBox.getSelectedIndex()));
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

                        petShop.fillDog(Name, AgeinMonth, Procedence, Color, Race, Code, Price);
                        jsonObject.put("PET", "DOG");
                        jsonObject.put("Name", Name);
                        jsonObject.put("Code", Code);
                        jsonObject.put("AgeinMonth", AgeinMonth);
                        jsonObject.put("Procedence", Procedence);
                        jsonObject.put("Color", Color);
                        jsonObject.put("Race", Race);

                        Saldo += Price;
                        Saldotext.setText(String.valueOf(Saldo));
                        petShop.createTXT("C:\\PetShop\\saldo.txt", String.valueOf(Saldo), false);
                        petShop.createTXT("C:\\PetShop\\DB.json\\", jsonObject.toString(),true);

                    }

                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null,
                            "Ingrese la edad solo en números",
                            "",
                            JOptionPane.ERROR_MESSAGE,
                            petShop.getErrorIcon());
                }
            }

        });
        priceSearchButton.addActionListener(e -> {
            searchPriceJPanel.setVisible(true);
            JOptionPane.showOptionDialog(null,
                    searchPriceJPanel,
                    "Saber precio",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    petShop.getPriceSearchIcon(), new Object[]{},
                    3);
        });
        countrySearchbutton.addActionListener(e -> {
            countrySearchJPanel.setVisible(true);
            JOptionPane.showOptionDialog(null,
                    countrySearchJPanel,
                    "Cantidad por país",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    petShop.getCountryIcon(), new Object[]{},
                    3);


        });
        venderButton.addActionListener(e -> {
            venderJPanel.setVisible(true);
            JOptionPane.showOptionDialog(null,
                    venderJPanel,
                    "Vender Mascota",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    petShop.getSellIcon(),
                    new Object[]{},
                    null);
        });
        sellButton.addActionListener(e -> {
            if (sellCode.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,
                        "Por favor introduzca un código primero",
                        "",
                        JOptionPane.ERROR_MESSAGE,
                        petShop.getErrorIcon());
            }else{
                String Code = sellCode.getText();
                petShop.sellPet(Code);
            }
        });
        searchCountryButton.addActionListener(e -> {
           countrySearchSet();
        });
        generarButton.addActionListener(e -> randomgenerate());
        inicioButton.addActionListener(e -> {
            if (addPetChildren.isVisible()){
                addPetChildren.setVisible(false);
            }
        });
        showArraybutton.addActionListener(e -> {

            JSONParser jsonParser12 = new JSONParser();

            try (FileReader reader = new FileReader("C:\\PetShop\\DB.json"))
            {
                //Read JSON file
                Object obj = jsonParser12.parse(reader);

                JSONArray employeeList = (JSONArray) obj;
                System.out.println(employeeList);

                //Iterate over employee array
               // employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

            } catch (IOException | ParseException ex) {
                ex.printStackTrace();
            }
        });
        testButton1.addActionListener(e -> {
            try {

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("PetShop.ser"));
                objectOutputStream.writeObject(nameTextField.getText());
                objectOutputStream.writeObject("test1");
                objectOutputStream.writeObject("test2");
                objectOutputStream.writeObject("test3");

                testButton1.setVisible(false);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });
        searchPriceButton.addActionListener(e -> {
            if (searchPriceText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Por favor introduzca un código primero",
                        "",
                        JOptionPane.ERROR_MESSAGE,
                        petShop.getErrorIcon());
            } else {
                petShop.priceSearch(searchPriceText.getText());
                JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(SwingUtilities.getRootPane(searchPriceJPanel));
                dialog.dispose();
            }
        });
        buscarMayorButton.addActionListener(e -> petShop.olderPet());
        colorMenosPredominanteButton.addActionListener(e -> petShop.lessPredominantColor());
        listadoAlfabeticoButton.addActionListener(e -> PetShop.sortArray());
        oscuroRadioButton.addActionListener(e -> {
            claroRadioButton.setSelected(false);
            oscuroRadioButton.setVisible(false);
            claroRadioButton.setVisible(true);
            petShop.createTXT("C:\\PetShop\\MODE.txt\\",  "DARK", false);
            Mode("DARK");
        });
        claroRadioButton.addActionListener(e -> {
            oscuroRadioButton.setSelected(false);
            claroRadioButton.setVisible(false);
            oscuroRadioButton.setVisible(true);
            petShop.createTXT("C:\\PetShop\\MODE.txt\\",  "LIGHT", false);
            Mode("LIGHT");
        });
        sellCode.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == '\n'){
                if (sellCode.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,
                            "Por favor introduzca un código primero",
                            "",
                            JOptionPane.ERROR_MESSAGE,
                            petShop.getErrorIcon());
                }else{
                        String Code = sellCode.getText();
                        petShop.sellPet(Code);
                    }
                }

            }
        });
        testButton2.addActionListener(e -> {
           JSONParser jsonParser1 = new JSONParser();
            FileReader fileReader;
            Object object;
            JSONObject jsonObject1;

            try {
               fileReader = new FileReader("C:\\PetShop\\DB.json\\");
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }


            try {
               object = jsonParser1.parse(fileReader);
            } catch (IOException | ParseException ex) {
                throw new RuntimeException(ex);
            }
            try {
                fileReader.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            jsonObject1 = (JSONObject) object;
            System.out.println(jsonObject1.toString());



        });

        searchPriceText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == '\n'){
                if (searchPriceText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Por favor introduzca un código primero",
                            "",
                            JOptionPane.ERROR_MESSAGE,
                            petShop.getErrorIcon());
                } else {

                        String Code = sellCode.getText();
                        petShop.priceSearch(searchPriceText.getText());
                    }
                    JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(SwingUtilities.getRootPane(searchPriceJPanel));
                    dialog.dispose();
                }

            }
        });
        procedenceComboBox2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == '\n') {
                   countrySearchSet();
                    }
                }
        });
        addPetChildren.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == 'g'){
                    String Code = sellCode.getText();
                    randomgenerate();
                }
            }
        });

        LOGINButton.addActionListener(e -> {
                addPet.setVisible(true);
                JScrollPane.setVisible(true);
                devOptions.setVisible(false);
                loginPanel.setVisible(false);
                saldoJPanel.setVisible(true);
            Theme();//define the theme of the app can be dark or light according to what user choose previously

        });
    }
    public void StartInterface() {
        JFrame window = new JFrame("PetShop");
        window.setContentPane(new UI().MainPanel);
        window.pack();
        window.setBounds(300, 150, 1000, 515);
        window.setVisible(true);
        window.setMinimumSize(new Dimension(250, 250));
        window.setBackground(Color.darkGray);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public enum generateName {//para generar un nombre random
        Max, Buddy, Molly, Bailey, Maggie, Daisy, Lucy, Sadie, Bella, Charlie, Princesa, Lucky, Rocky, Coco, Oso, Jake,
        Sombra, Jack, Toby, Angel, Chloe, Harley, Abby, Sophie, Ginger, Dama, Sam, Gizmo, Buster, Baby, Pepper, Missy,
        Roxy, Sammy, Zoe, Sasha, Cody, Duke, Gracie, Riley, Sassy, Shaggy, Oreo, Preciosos, Bandit, Casey, Smokey, Rusty, Teddy, Oscar, Lola;
        private static final Random PRNG = new Random();
        private static final generateName[] directions = values();

        public static generateName randomgenerateName() {
            return directions[PRNG.nextInt(directions.length)];
        }
    }

    public void generateCode() {//generar un codigo random
        String n = "";
        for (int i = 0; i < 6; i++) {
            n = n.concat(String.valueOf((int) (Math.random() * 12)));
        }
        codeTextField.setText(n);
    }
    public void generateRace(){
        int Option;
       Option = (int) (Math.random() * 3);
       if (dogRadioButton.isSelected()){
           if (Option == 0){
               bulldogRadioButton.setSelected(true);
               dalmataRadioButton.setSelected(false);
               chowChowRadioButton.setSelected(false);
           } else if (Option == 1) {
               bulldogRadioButton.setSelected(false);
               dalmataRadioButton.setSelected(true);
               chowChowRadioButton.setSelected(false);
           }else if (Option == 2) {
               bulldogRadioButton.setSelected(false);
               dalmataRadioButton.setSelected(false);
               chowChowRadioButton.setSelected(true);
           }
       }
       if (catRadioButton.isSelected()){
           if (Option == 0){
               hembraRadioButton.setSelected(true);
               machoRadioButton.setSelected(false);
               noCheckBox.setSelected(true);
           } else if (Option == 1) {
               hembraRadioButton.setSelected(false);
               machoRadioButton.setSelected(true);
               noCheckBox.setSelected(false);
           }else if (Option == 2) {
               hembraRadioButton.setSelected(true);
               machoRadioButton.setSelected(false);
               noCheckBox.setSelected(true);
           }
       }
    }
    public void Mode(String Mode) {
        Color colorPrimary = null;
        Color colorSecundary = null;
        Color colorThird = null;
        Color fontColor = null;
        Color paneButton = null;

        if (Mode.equals("DARK")) {
            colorPrimary = new Color(60, 63, 65);//dark
            colorSecundary = new Color(50, 53, 55);//lightBlack
            colorThird = new Color(254, 254, 254);//white
            fontColor = new Color(254, 254, 254);
            paneButton = new Color(60, 63, 65);//dark
        }
        if (Mode.equals("LIGHT")) {
            colorPrimary = new Color(254, 254, 254);//white
            colorSecundary = new Color(48, 79, 254);//pblue
            fontColor =  new Color(48, 79, 254);
            colorThird = new Color(250, 250, 250);//gray
            paneButton = new Color(254, 254, 254);//white
        }

        UIManager.put("OptionPane.background", colorPrimary);
        UIManager.put("Panel.background", colorPrimary);
        UIManager.put("OptionPane.messageForeground", fontColor);
        UIManager.put("Button.background", paneButton);
        UIManager.put("Button.foreground", fontColor);
        UIManager.put("Button.focusable", false);

        MainPanel.setBackground(colorPrimary);
        leftPanel.setBackground(colorPrimary);
        addPet.setBackground(null);
        addPetChildren.setBackground(null);
        addCat.setBackground(null);
        raceJPanel.setBackground(null);
        hembraRadioButton.setBackground(null);
        machoRadioButton.setBackground(null);
        chowChowRadioButton.setBackground(null);
        dalmataRadioButton.setBackground(null);
        bulldogRadioButton.setBackground(null);
        oscuroRadioButton.setBackground(null);
        claroRadioButton.setBackground(null);
        KindOfPet.setBackground(null);
        venderJPanel.setBackground(null);
        searchPriceJPanel.setBackground(null);
        countrySearchJPanel.setBackground(null);
        dogRadioButton.setBackground(null);
        catRadioButton.setBackground(null);
        JScrollPane.setBackground(null);
        saldoJPanel.setBackground(null);
        loginPanel.setBackground(null);
        userTextField.setBackground(null);
        passwordField.setBackground(null);


        //all backgrounds
        inicioButton.setBackground(null);
        agregarButton.setBackground(null);
        venderButton.setBackground(null);
        priceSearchButton.setBackground(null);
        countrySearchbutton.setBackground(null);
        buscarMayorButton.setBackground(null);
        colorMenosPredominanteButton.setBackground(null);
        listadoAlfabeticoButton.setBackground(null);
        sellButton.setBackground(null);
        searchPriceButton.setBackground(null);
        searchCountryButton.setBackground(null);
        LOGINButton.setBackground(null);

        showArraybutton.setBackground(colorSecundary);
        testButton1.setBackground(colorSecundary);
        testButton2.setBackground(colorSecundary);


        siguienteButton.setBackground(null);
        generarButton.setBackground(null);
        addPetButton.setBackground(null);
        nameTextField.setBackground(null);
        codeTextField.setBackground(null);
        procedenceComboBox.setBackground(null);
        ageTextField.setBackground(null);
        ColorComboBox.setBackground(null);
        EyesColorComboBox.setBackground(null);
        noCheckBox.setBackground(null);
        sellCode.setBackground(null);
        searchPriceText.setBackground(null);
        procedenceComboBox2.setBackground(null);

        //all buttons
        inicioButton.setForeground(fontColor);
        agregarButton.setForeground(fontColor);
        venderButton.setForeground(fontColor);
        priceSearchButton.setForeground(fontColor);
        countrySearchbutton.setForeground(fontColor);
        buscarMayorButton.setForeground(fontColor);
        colorMenosPredominanteButton.setForeground(fontColor);
        listadoAlfabeticoButton.setForeground(fontColor);
        generarButton.setForeground(fontColor);
        addPetButton.setForeground(fontColor);
        saldoText.setForeground(fontColor);
        Saldotext.setForeground(fontColor);
        USD.setForeground(fontColor);
        text1.setForeground(fontColor);
        text2.setForeground(fontColor);
        text3.setForeground(fontColor);
        text4.setForeground(fontColor);
        nameText.setForeground(fontColor);
        codeText.setForeground(fontColor);
        ageText.setForeground(fontColor);
        countryText.setForeground(fontColor);
        colorText.setForeground(fontColor);
        raceText.setForeground(fontColor);
        eyescolorText.setForeground(fontColor);
        perdigreeText.setForeground(fontColor);
        sexText.setForeground(fontColor);
        dogRadioButton.setForeground(fontColor);
        catRadioButton.setForeground(fontColor);
        siguienteButton.setForeground(fontColor);
        hembraRadioButton.setForeground(fontColor);
        machoRadioButton.setForeground(fontColor);
        chowChowRadioButton.setForeground(fontColor);
        dalmataRadioButton.setForeground(fontColor);
        bulldogRadioButton.setForeground(fontColor);
        codeTextField.setForeground(fontColor);
        ageTextField.setForeground(fontColor);
        procedenceComboBox.setForeground(fontColor);
        ColorComboBox.setForeground(fontColor);
        EyesColorComboBox.setForeground(fontColor);
        noCheckBox.setForeground(fontColor);
        oscuroRadioButton.setForeground(fontColor);
        claroRadioButton.setForeground(fontColor);
        userTextField.setForeground(fontColor);
        passwordField.setForeground(fontColor);
        LOGINButton.setForeground(fontColor);
        procedenceComboBox2.setForeground(fontColor);

        nameTextField.setForeground(fontColor);
        sellCode.setForeground(fontColor);
        searchPriceText.setForeground(fontColor);

        sellButton.setForeground(fontColor);
        searchPriceButton.setForeground(fontColor);
        searchCountryButton.setForeground(fontColor);


        showArraybutton.setForeground(Color.RED);
        testButton1.setForeground(Color.RED);
        testButton2.setForeground(Color.RED);
        nameTextField.setBackground(null);






    }


    public void randomgenerate() {
        int age = (int) (Math.random() * 13);
        int countries = (int) (Math.random() * 194);
        int colors = (int) (Math.random() * 6);
        int eyesColor = (int) (Math.random() * 5);
        if (age == 0){
            age = 1;
        }
        nameTextField.setText(generateName.randomgenerateName().name());
        if(dogRadioButton.isSelected()){
            ageTextField.setText(String.valueOf(age));
            generateCode();
            generateRace();
            procedenceComboBox.setSelectedIndex(countries + 1);
            ColorComboBox.setSelectedIndex(colors + 1);

        }else if(catRadioButton.isSelected()){
            procedenceComboBox.setSelectedIndex(countries + 1);
            ColorComboBox.setSelectedIndex(colors + 1);
            ageTextField.setText(String.valueOf(age));
            EyesColorComboBox.setSelectedIndex(eyesColor + 1);
            generateCode();
            generateRace();
        }
    }
    public void countryList(){
        String[] listado = {"Seleccione un país", "Afganistán","Albania","Alemania","Andorra","Angola","Antigua y Barbuda","Arabia Saudita","Argelia","Argentina","Armenia","Australia","Austria","Azerbaiyán","Bahamas","Bangladés","Barbados","Baréin","Bélgica","Belice","Benín","Bielorrusia","Birmania","Bolivia","Bosnia y Herzegovina","Botsuana","Brasil","Brunéi","Bulgaria","Burkina Faso","Burundi","Bután","Cabo Verde","Camboya","Camerún","Canadá","Catar","Chad","Chile","China","Chipre","Ciudad del Vaticano","Colombia","Comoras","Corea del Norte","Corea del Sur","Costa de Marfil","Costa Rica","Croacia","Cuba","Dinamarca","Dominica","Ecuador","Egipto","El Salvador","Emiratos Árabes Unidos","Eritrea","Eslovaquia","Eslovenia","España","Estados Unidos","Estonia","Etiopía","Filipinas","Finlandia","Fiyi","Francia","Gabón","Gambia","Georgia","Ghana","Granada","Grecia","Guatemala","Guyana","Guinea","Guinea ecuatorial","Guinea-Bisáu","Haití","Honduras","Hungría","India","Indonesia","Irak","Irán","Irlanda","Islandia","Islas Marshall","Islas Salomón","Israel","Italia","Jamaica","Japón","Jordania","Kazajistán","Kenia","Kirguistán","Kiribati","Kuwait","Laos","Lesoto","Letonia","Líbano","Liberia","Libia","Liechtenstein","Lituania","Luxemburgo","Madagascar","Malasia","Malaui","Maldivas","Malí","Malta","Marruecos","Mauricio","Mauritania","México","Micronesia","Moldavia","Mónaco","Mongolia","Montenegro","Mozambique","Namibia","Nauru","Nepal","Nicaragua","Níger","Nigeria","Noruega","Nueva Zelanda","Omán","Países Bajos","Pakistán","Palaos","Palestina","Panamá","Papúa Nueva Guinea","Paraguay","Perú","Polonia","Portugal","Reino Unido","República Centroafricana","República Checa","República de Macedonia","República del Congo","República Democrática del Congo","República Dominicana","República Sudafricana","Ruanda","Rumanía","Rusia","Samoa","San Cristóbal y Nieves","San Marino","San Vicente y las Granadinas","Santa Lucía","Santo Tomé y Príncipe","Senegal","Serbia","Seychelles","Sierra Leona","Singapur","Siria","Somalia","Sri Lanka","Suazilandia","Sudán","Sudán del Sur","Suecia","Suiza","Surinam","Tailandia","Tanzania","Tayikistán","Timor Oriental","Togo","Tonga","Trinidad y Tobago","Túnez","Turkmenistán","Turquía","Tuvalu","Ucrania","Uganda","Uruguay","Uzbekistán","Vanuatu","Venezuela","Vietnam","Yemen","Yibuti","Zambia","Zimbabue"};
        String[] EyesColor = {"Seleccione un color", "Verde", "Negro", "Amarillo", "Marron", "Gris", "Oro", "Bicolor"};
        String[] Color = {"Seleccione un color", "Blanco", "Negro", "Amarillo","Marron", "Gris", "Oro"};
        procedenceComboBox.setModel(new DefaultComboBoxModel(listado));
        procedenceComboBox2.setModel(new DefaultComboBoxModel(listado));
        ColorComboBox.setModel(new DefaultComboBoxModel(Color));
        EyesColorComboBox.setModel(new DefaultComboBoxModel(EyesColor));
    }

    public void Theme(){
        String line;
        line = petShop.readTXT("C:\\PetShop\\MODE.txt\\", "LIGHT", false);
        if(line.equals("LIGHT")){
            Mode("LIGHT");
            claroRadioButton.setSelected(true);
            oscuroRadioButton.setVisible(true);
            claroRadioButton.setVisible(false);
        }else if (line.equals("DARK")){
        Mode("DARK");
        claroRadioButton.setSelected(false);
        oscuroRadioButton.setVisible(false);
        claroRadioButton.setVisible(true);
        }else {
            petShop.createTXT("C:\\PetShop\\MODE.txt\\", "LIGHT", false);
            JOptionPane.showMessageDialog(
                    null,
                    "Se ha restablecido el tema por defecto",
                    "",
                    1,
                    petShop.getDoneIcon());
        }
    }
    public void setSaldo(){
        Saldotext.setText(petShop.readTXT("C:\\PetShop\\saldo.txt", "0", false));
    }
    public void countrySearchSet(){
        if (procedenceComboBox2.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Escoja un país para poder buscar",
                    "",
                    JOptionPane.WARNING_MESSAGE,
                    petShop.getErrorIcon());
        } else
            petShop.countrySearch(String.valueOf(procedenceComboBox2.getItemAt(procedenceComboBox2.getSelectedIndex())));
    }
}