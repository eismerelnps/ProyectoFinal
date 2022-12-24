package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

import Control.*;

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
    private JTextField textFieldDogColor;
    private JRadioButton bulldogRadioButton;
    private JRadioButton dalmataRadioButton;
    private JRadioButton chowChowRadioButton;
    private JButton addPetButton;
    private JPanel SelectPet;
    JPanel addDog;
    private JButton siguienteButton;
    private JTextField catEyesColor;
    private JRadioButton hembraRadioButton;
    private JRadioButton machoRadioButton;
    private JCheckBox noCheckBox;
    private JPanel addCat;
    private JButton agregarCatButton;
    private JButton priceSearchButton;
    private JTextField catAge;
    private JTextField catProcedence;
    private JTextField catColor;
    private JButton countrySearchbutton;
    private JTextField codeTextField;
    private JTextField catCode;
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
    private JButton button2;
    private JButton searchPriceButton;
    private JTextField searchPriceText;
    private JPanel searchPriceJPanel;
    private JButton buscarMayorButton;
    private JButton colorMenosPredominanteButton;
    private JButton listadoAlfabeticoButton;
    private JRadioButton oscuroRadioButton;
    private JRadioButton claroRadioButton;
    private JButton button3;
    private JComboBox procedenceComboBox;
    private JComboBox comboBox2;
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
    private JList list1;
    private JTextField nameTextField;
    private JLabel nameText;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button4;
    private float Saldo = 0;
    float h = 0;
    float s = 0;
    float b = 0;

    PetShop petShop = new PetShop();

    public UI(float Saldo) {
        this.Saldo = Saldo;
    }

    public UI() {

        KindOfPet.setVisible(false);
        addCat.setVisible(false);
        addDog.setVisible(false);
        venderJPanel.setVisible(false);
        countrySearchJPanel.setVisible(false);
        searchPriceJPanel.setVisible(false);
        readTXT("C:\\PetShop\\saldo.txt");
        //readTXT("C:\\PetShop\\MODE.txt");
        countryList();


        Saldotext.setText(String.valueOf(Saldo));

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KindOfPet.setVisible(true);
                JOptionPane.showOptionDialog(null,
                        KindOfPet,
                        "",
                        JOptionPane.DEFAULT_OPTION,
                        -1,
                        null, new Object[]{},
                        null);




            }
        });
        dogRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                catRadioButton.setSelected(false);
            }
        });
        catRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dogRadioButton.setSelected(false);
            }
        });
        bulldogRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dalmataRadioButton.setSelected(false);
                chowChowRadioButton.setSelected(false);
            }
        });
        dalmataRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bulldogRadioButton.setSelected(false);
                chowChowRadioButton.setSelected(false);
            }
        });
        chowChowRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bulldogRadioButton.setSelected(false);
                dalmataRadioButton.setSelected(false);
            }
        });
        noCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (noCheckBox.isSelected() == false) {
                    noCheckBox.setText("No");
                } else noCheckBox.setText("Si");

            }
        });
        hembraRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                machoRadioButton.setSelected(false);
            }
        });
        machoRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hembraRadioButton.setSelected(false);
            }
        });
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dogRadioButton.isSelected() == true) {
                    addDog.setVisible(true);
                    raceJPanel.setVisible(true);
                    addCat.setVisible(false);
                    JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(SwingUtilities.getRootPane(KindOfPet));
                    dialog.dispose();

                } else if (catRadioButton.isSelected() == true) {
                    addDog.setVisible(true);
                    addCat.setVisible(true);
                    raceJPanel.setVisible(false);
                    JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(SwingUtilities.getRootPane(KindOfPet));
                    dialog.dispose();
                } else if (dogRadioButton.isSelected() == false || catRadioButton.isSelected() == false) {
                    JOptionPane.showMessageDialog(null,
                            "Por favor selecciona el tipo de mascota primero",
                            "Alerta",
                            2);
                }

            }
        });
        addPetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (catRadioButton.isSelected() == true){
                    String Name = null;
                    int AgeinMonth = 0;
                    String Code = null;
                    String Procedence = null;
                    String Color = null;
                    boolean pass = false;
                    String EyesColor = null;
                    String Sex =  null;
                    boolean Perdigree = false;

                    try {
                        if (nameText.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                    "Por favor introduzca el nombre primero",
                                    "Alerta",
                                    1);
                            pass = false;
                        }else if (codeTextField.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null,
                                    "Por favor introduzca el código primero",
                                    "Alerta",
                                    1);
                            pass = false;
                        }else if (ageTextField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                    "Por favor introduzca la edad primero",
                                    "Alerta",
                                    1);
                            pass = false;
                        } else if (procedenceComboBox.getSelectedIndex() == 0 ) {
                            JOptionPane.showMessageDialog(null,
                                    "Por favor seleccione un país",
                                    "",
                                    1);
                            pass = false;
                        } else if (ColorComboBox.getSelectedIndex() == 0) {
                            JOptionPane.showMessageDialog(null,
                                    "Por favor seleccione un color",
                                    "",
                                    1);
                            pass = false;
                        } else if (EyesColorComboBox.getSelectedIndex() == 0) {
                            JOptionPane.showMessageDialog(null,
                                    "Por favor seleccione color de ojos",
                                    "",
                                    1);
                        }else if (hembraRadioButton.isSelected() == false && machoRadioButton.isSelected() == false){
                            JOptionPane.showMessageDialog(null,
                                    "Por favor selecciona el sexo del gato",
                                    "Alerta",
                                    1);
                        }else {
                            if (hembraRadioButton.isSelected() == true) {
                                Sex = "Hembra";
                            } else Sex = "Macho";
                            Perdigree = noCheckBox.isSelected();
                            pass = true;
                        }


                        if(pass == true){
                            Name = nameTextField.getText();
                            Code = codeTextField.getText();
                            AgeinMonth = Integer.parseInt(ageTextField.getText());
                            if (AgeinMonth == 0){
                                AgeinMonth = 1;
                            }
                            Procedence = String.valueOf(procedenceComboBox.getItemAt(procedenceComboBox.getSelectedIndex()));
                            Color = String.valueOf(ColorComboBox.getItemAt(procedenceComboBox.getSelectedIndex()));
                            EyesColor = String.valueOf(EyesColorComboBox.getItemAt(EyesColorComboBox.getSelectedIndex()));

                            petShop.fillCat(Name, AgeinMonth, Procedence, Color, EyesColor, Sex, Perdigree, Code);
                        }

                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(null, "Ingrese la edad solo en números", "Error", 0);
                    }
                    readTXT("C:\\PetShop\\saldo.txt");
                }
                if (dogRadioButton.isSelected() == true){
                    String Name = null;
                    String Color = null;
                    String Race = null;
                    String Code = null;
                    String Procedence = null;
                    int AgeinMonth = 0;
                    boolean pass = true;

                    if (bulldogRadioButton.isSelected() == true) {
                        Race = bulldogRadioButton.getText();
                        pass = true;
                    } else if (dalmataRadioButton.isSelected() == true) {
                        Race = "Dalmata";
                        pass = true;
                    } else if (chowChowRadioButton.isSelected() == true) {
                        Race = "Chow-Chow";
                        pass = true;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Por favor selecciona la raza primero",
                                "",
                                1);
                        pass = false;
                    }

                    try {
                        if (nameTextField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                    "Por favor introduzca el nombre primero",
                                    "",
                                    1);
                            pass = false;
                        }else if (codeTextField.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null,
                                    "Por favor introduzca el codigo primero",
                                    "",
                                    1);
                            pass = false;
                        }else if (ageTextField.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null,
                                    "Por favor introduzca la edad primero",
                                    "",
                                    1);
                            pass = false;
                            //appling regular expresions to determinate if string contains numbers or any symbol different that characters
                        }else if (ColorComboBox.getSelectedIndex() == 0) {
                            JOptionPane.showMessageDialog(null,
                                    "Por favor seleccione un color",
                                    "",
                                    1);
                            pass = false;
                        } else if (procedenceComboBox.getSelectedIndex() == 0 ) {
                            JOptionPane.showMessageDialog(null,
                                    "Por favor seleccione un país",
                                    "",
                                    1);
                            pass = false;
                        } else {
                            Name = nameTextField.getText();
                            Code = codeTextField.getText();
                            AgeinMonth = Integer.parseInt(ageTextField.getText());
                            Procedence = String.valueOf(procedenceComboBox.getItemAt(procedenceComboBox.getSelectedIndex()));
                            Color = String.valueOf(ColorComboBox.getItemAt(ColorComboBox.getSelectedIndex()));
                            pass = true;
                        }



                        if (pass == true){
                            float Price = 0;
                            petShop.fillDog(Name, AgeinMonth, Procedence, Color, Race, Code);
                        }

                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(null, "Ingrese la edad solo en números", "Error", 0);
                    }
                    System.out.println(pass+Code+AgeinMonth+Procedence+Color+Race);
                    readTXT("C:\\PetShop\\saldo.txt");
                }

            }
        });
        priceSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPriceJPanel.setVisible(true);
                JOptionPane.showOptionDialog(null,
                        searchPriceJPanel,
                        "Saber precio",
                        -1,
                        3,
                        null, new Object[]{},
                        3);
            }

        });
        countrySearchbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countrySearchJPanel.setVisible(true);
                JOptionPane.showOptionDialog(null,
                        countrySearchJPanel,
                        "Cantidad por país",
                        -1,
                        3,
                        null, new Object[]{},
                        3);


            }
        });
        venderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                venderJPanel.setVisible(true);
                JOptionPane.showOptionDialog(null,
                        venderJPanel,
                        "Vender Mascota",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null, new Object[]{},
                        null);

            }
        });
        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sellCode.getText().isEmpty() == true){
                    JOptionPane.showMessageDialog(null,
                            "Por favor introduzca un código primero",
                            "",
                            0,
                            null);
                }else{
                    String Code = sellCode.getText();
                    petShop.sellPet(Code);
                }
            }
        });
        searchCountryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (countrySearchTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Escriba el nombre de un país para poder buscar",
                            "",
                            2);
                } else
                    petShop.countrySearch(countrySearchTextField.getText());
            }
        });
        generarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomgenerate();
            }

        });
        inicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petShop.showPets();
            }
        });
        showArraybutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petShop.showPets();


            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petShop.createTXT("C:\\PetShop\\saldo.txt", Saldo);

            }
        });
        searchPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sellCode.getText().isEmpty() == true) {
                    JOptionPane.showMessageDialog(null,
                            "Por favor introduzca un código primero",
                            "",
                            0,
                            null);
                } else {
                    petShop.priceSearch(searchPriceText.getText());
                    JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(SwingUtilities.getRootPane(searchPriceJPanel));
                    dialog.dispose();
                }
            }
        });
        buscarMayorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petShop.olderPet();
            }
        });
        colorMenosPredominanteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petShop.lessPredominantColor();
            }
        });
        listadoAlfabeticoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petShop.sortArray();
            }
        });
        oscuroRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                claroRadioButton.setSelected(false);
                //petShop.createTXT("C:\\PetShop\\MODE.txt", "DARK");
                Mode("DARK");
            }
        });
        claroRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oscuroRadioButton.setSelected(false);
               // petShop.createTXT("C:\\PetShop\\MODE.txt", "LIGHT");
                Mode("LIGHT");
            }
        });
        sellCode.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == '\n'){
                    String Code = sellCode.getText();
                    petShop.sellPet(Code);
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readTXT("C:\\PetShop\\Saldo.txt");
            }
        });

        searchPriceText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == '\n'){
                    String Code = sellCode.getText();
                    petShop.priceSearch(searchPriceText.getText());
                }
            }
        });
        countrySearchTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == '\n'){
                    String Code = sellCode.getText();
                    petShop.countrySearch(countrySearchTextField.getText());
                }
            }
        });
        addDog.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == 'g'){
                    String Code = sellCode.getText();
                    randomgenerate();
                }
            }
        });
        addCat.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == 'g'){
                    String Code = sellCode.getText();
                    randomgenerate();
                }
            }
        });
    }
    public void StartInterface() {
        JFrame window = new JFrame("Control.PetShop");
        window.setContentPane(new UI().MainPanel);
        window.pack();
        window.setBounds(0, 0, 1000, 515);
        window.setVisible(true);
        window.setMinimumSize(new Dimension(250, 250));
        window.setBackground(Color.darkGray);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public enum generCountry {//para generar un pais random
        Cuba, Venezuela, China, Alemania, Polonia, USA, Canada, Inglaterra, Brazil, Panama, Australia;
        private static final Random PRNG = new Random();
        private static final generCountry[] directions = values();

        public static generCountry randomgenerCountry() {
            return directions[PRNG.nextInt(directions.length)];
        }
    }//generar paises random

    public enum generateColor {//para generar un pais random
        Blanco, Negro, Amarillo, Marron, Gris, Oro;
        private static final Random PRNG = new Random();
        private static final generateColor[] directions = values();

        public static generateColor randomgenerateColor() {
            return directions[PRNG.nextInt(directions.length)];
        }
    }
    public enum generateEyesColor{//para generar un color de ojos random
        Verde, Negro, Amarillo, Marron, Gris, Oro, Bicolor;
        private static final Random PRNG = new Random();
        private static final generateEyesColor[] directions = values();

        public static generateEyesColor randomgenerateEyesColor() {
            return directions[PRNG.nextInt(directions.length)];
        }
    }
    public enum generateName {//para generar un nombre random
        Max, Buddy, Molly, Bailey, Maggie, Daisy, Lucy, Sadie, Bella, Charlie, Princesa, Lucky, Rocky, Coco, Oso, Jake,
        Sombra, Jack, Toby, Ángel, Chloe, Harley, Abby, Sophie, Ginger, Dama, Sam, Gizmo, Buster, Baby, Pepper, Missy,
        Roxy, Sammy, Zoe, Sasha, Cody, Duke, Gracie, Riley, Sassy, Shaggy, Oreo, Preciosos, Bandit, Casey, Smokey, Rusty, Teddy, Oscar, Lola;
        private static final Random PRNG = new Random();
        private static final generateName[] directions = values();

        public static generateName randomgenerateName() {
            return directions[PRNG.nextInt(directions.length)];
        }
    }

    public void generateCode() {
        String n = "";
        for (int i = 0; i < 6; i++) {
            n = n.concat(String.valueOf((int) (Math.random() * 12)));
        }
        codeTextField.setText(n);
    }//generar un codigo random
    public void generateRace(){
        int Option;
       Option = (int) (Math.random() * 3);
       if (dogRadioButton.isSelected() == true){
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
       if (catRadioButton.isSelected() == true){
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
    public void Mode(String Mode){
        Color pBlue = new Color(48,79,254);
        Color dark = new Color(60,63,65);
        Color lightBlack = new Color(39,42,44);
        Color white = new Color(254, 254, 254);
        Color gray = new Color(250, 250, 250);



        if(Mode == "DARK"){
            UIManager UI=new UIManager();
            UI.put("OptionPane.background", dark);
            UI.put("Panel.background", dark);
            UI.put("OptionPane.messageForeground", white);
            UI.put("Button.background",lightBlack);
            UI.put("Button.foreground", white );

            MainPanel.setBackground(dark);
            leftPanel.setBackground(dark);
            addPet.setBackground(dark);
            addDog.setBackground(dark);
            addCat.setBackground(dark);
            raceJPanel.setBackground(dark);
            hembraRadioButton.setBackground(dark);
            machoRadioButton.setBackground(dark);
            chowChowRadioButton.setBackground(dark);
            dalmataRadioButton.setBackground(dark);
            bulldogRadioButton.setBackground(dark);
            oscuroRadioButton.setBackground(dark);
            claroRadioButton.setBackground(dark);
            KindOfPet.setBackground(dark);
            venderJPanel.setBackground(dark);
            searchPriceJPanel.setBackground(dark);
            countrySearchJPanel.setBackground(dark);
            dogRadioButton.setBackground(dark);
            catRadioButton.setBackground(dark);


            //all backgrounds
            inicioButton.setBackground(lightBlack);
            agregarButton.setBackground(lightBlack);
            venderButton.setBackground(lightBlack);
            priceSearchButton.setBackground(lightBlack);
            countrySearchbutton.setBackground(lightBlack);
            buscarMayorButton.setBackground(lightBlack);
            showArraybutton.setBackground(lightBlack);
            colorMenosPredominanteButton.setBackground(lightBlack);
            listadoAlfabeticoButton.setBackground(lightBlack);
            sellButton.setBackground(lightBlack);
            searchPriceButton.setBackground(lightBlack);
            searchCountryButton.setBackground(lightBlack);


            siguienteButton.setBackground(lightBlack);
            generarButton.setBackground(lightBlack);
            addPetButton.setBackground(lightBlack);
            nameTextField.setBackground(lightBlack);
            codeTextField.setBackground(lightBlack);
            procedenceComboBox.setBackground(lightBlack);
            ageTextField.setBackground(lightBlack);
            ColorComboBox.setBackground(lightBlack);
            EyesColorComboBox.setBackground(lightBlack);
            noCheckBox.setBackground(lightBlack);
            sellCode.setBackground(lightBlack);
            searchPriceText.setBackground(lightBlack);
            countrySearchTextField.setBackground(lightBlack);





            //all buttons
            inicioButton.setForeground(white);
            agregarButton.setForeground(white);
            venderButton.setForeground(white);
            priceSearchButton.setForeground(white);
            countrySearchbutton.setForeground(white);
            buscarMayorButton.setForeground(white);
            showArraybutton.setForeground(white);
            colorMenosPredominanteButton.setForeground(white);
            listadoAlfabeticoButton.setForeground(white);
            generarButton.setForeground(white);
            addPetButton.setForeground(white);
            saldoText.setForeground(white);
            Saldotext.setForeground(white);
            USD.setForeground(white);
            text1.setForeground(white);
            text2.setForeground(white);
            text3.setForeground(white);
            text4.setForeground(white);
            nameText.setForeground(white);
            codeText.setForeground(white);
            ageText.setForeground(white);
            countryText.setForeground(white);
            colorText.setForeground(white);
            raceText.setForeground(white);
            eyescolorText.setForeground(white);
            perdigreeText.setForeground(white);
            sexText.setForeground(white);
            dogRadioButton.setForeground(white);
            catRadioButton.setForeground(white);
            siguienteButton.setForeground(white);
            hembraRadioButton.setForeground(white);
            machoRadioButton.setForeground(white);
            chowChowRadioButton.setForeground(white);
            dalmataRadioButton.setForeground(white);
            bulldogRadioButton.setForeground(white);
            codeTextField.setForeground(white);
            ageTextField.setForeground(white);
            procedenceComboBox.setForeground(white);
            ColorComboBox.setForeground(white);
            EyesColorComboBox.setForeground(white);
            noCheckBox.setForeground(white);
            oscuroRadioButton.setForeground(white);
            claroRadioButton.setForeground(white);

            nameTextField.setForeground(white);
            sellCode.setForeground(white);
            searchPriceText.setForeground(white);
            countrySearchTextField.setForeground(white);
            sellButton.setForeground(white);
            searchPriceButton.setForeground(white);
            searchCountryButton.setForeground(white);




        }

        if (Mode == "LIGHT"){
            UIManager UI=new UIManager();
            UI.put("OptionPane.background", white);
            UI.put("Panel.background", white);
            UI.put("OptionPane.messageForeground", pBlue);
            UI.put("Button.background", gray);
            UI.put("Button.foreground", pBlue );

            MainPanel.setBackground(white);
            leftPanel.setBackground(white);
            addPet.setBackground(white);
            addDog.setBackground(white);
            addCat.setBackground(white);
            raceJPanel.setBackground(white);
            hembraRadioButton.setBackground(white);
            machoRadioButton.setBackground(white);
            chowChowRadioButton.setBackground(white);
            dalmataRadioButton.setBackground(white);
            bulldogRadioButton.setBackground(white);
            oscuroRadioButton.setBackground(white);
            claroRadioButton.setBackground(white);
            KindOfPet.setBackground(white);
            venderJPanel.setBackground(white);
            searchPriceJPanel.setBackground(white);
            countrySearchJPanel.setBackground(white);
            dogRadioButton.setBackground(white);
            catRadioButton.setBackground(white);


            //all backgrounds
            inicioButton.setBackground(gray);
            agregarButton.setBackground(gray);
            venderButton.setBackground(gray);
            priceSearchButton.setBackground(gray);
            countrySearchbutton.setBackground(gray);
            buscarMayorButton.setBackground(gray);
            showArraybutton.setBackground(gray);
            colorMenosPredominanteButton.setBackground(gray);
            listadoAlfabeticoButton.setBackground(gray);
            sellButton.setBackground(gray);
            searchPriceButton.setBackground(gray);
            searchCountryButton.setBackground(gray);


            siguienteButton.setBackground(white);
            generarButton.setBackground(white);
            addPetButton.setBackground(white);
            nameTextField.setBackground(white);
            codeTextField.setBackground(white);
            procedenceComboBox.setBackground(white);
            ageTextField.setBackground(white);
            ColorComboBox.setBackground(white);
            EyesColorComboBox.setBackground(white);
            noCheckBox.setBackground(white);
            sellCode.setBackground(white);
            searchPriceText.setBackground(white);
            countrySearchTextField.setBackground(white);





            //all buttons
            inicioButton.setForeground(pBlue);
            agregarButton.setForeground(pBlue);
            venderButton.setForeground(pBlue);
            priceSearchButton.setForeground(pBlue);
            countrySearchbutton.setForeground(pBlue);
            buscarMayorButton.setForeground(pBlue);
            showArraybutton.setForeground(pBlue);
            colorMenosPredominanteButton.setForeground(pBlue);
            listadoAlfabeticoButton.setForeground(pBlue);
            generarButton.setForeground(pBlue);
            addPetButton.setForeground(pBlue);
            saldoText.setForeground(pBlue);
            Saldotext.setForeground(pBlue);
            USD.setForeground(pBlue);
            text1.setForeground(pBlue);
            text2.setForeground(pBlue);
            text3.setForeground(pBlue);
            text4.setForeground(pBlue);
            nameText.setForeground(pBlue);
            codeText.setForeground(pBlue);
            ageText.setForeground(pBlue);
            countryText.setForeground(pBlue);
            colorText.setForeground(pBlue);
            raceText.setForeground(pBlue);
            eyescolorText.setForeground(pBlue);
            perdigreeText.setForeground(pBlue);
            sexText.setForeground(pBlue);
            dogRadioButton.setForeground(pBlue);
            catRadioButton.setForeground(pBlue);
            siguienteButton.setForeground(pBlue);
            hembraRadioButton.setForeground(pBlue);
            machoRadioButton.setForeground(pBlue);
            chowChowRadioButton.setForeground(pBlue);
            dalmataRadioButton.setForeground(pBlue);
            bulldogRadioButton.setForeground(pBlue);
            codeTextField.setForeground(pBlue);
            ageTextField.setForeground(pBlue);
            procedenceComboBox.setForeground(pBlue);
            ColorComboBox.setForeground(pBlue);
            EyesColorComboBox.setForeground(pBlue);
            noCheckBox.setForeground(pBlue);
            oscuroRadioButton.setForeground(pBlue);
            claroRadioButton.setForeground(pBlue);

            nameTextField.setForeground(pBlue);
            sellCode.setForeground(pBlue);
            searchPriceText.setForeground(pBlue);
            countrySearchTextField.setForeground(pBlue);
            sellButton.setForeground(pBlue);
            searchPriceButton.setForeground(pBlue);
            searchCountryButton.setForeground(pBlue);

        }
    }
    public String readTXT(String PATH){
        BufferedReader bufferedReader = null;
        File file = null;
        String linea = null;
        Scanner scanner;
        try {
            file = new File(PATH);
            //se pasa el flujo al objeto scanner
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                // el objeto scanner lee linea a linea desde el archivo
                linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
                //se usa una expresión regular
                //que valida que antes o despues de una coma (,) exista cualquier cosa
                //parte la cadena recibida cada vez que encuentre una coma
                delimitar.useDelimiter("\\s*,\\s*");
                Saldotext.setText(delimitar.next());
                System.out.println(linea);

                }
            //se cierra el ojeto scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return linea;
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
        if(dogRadioButton.isSelected() == true){
            ageTextField.setText(String.valueOf(age));
            generateCode();
            generateRace();
            procedenceComboBox.setSelectedIndex(countries + 1);
            ColorComboBox.setSelectedIndex(colors + 1);

        }else if(catRadioButton.isSelected() == true){
            procedenceComboBox.setSelectedIndex(countries + 1);
            ColorComboBox.setSelectedIndex(colors + 1);
            ageTextField.setText(String.valueOf(age));
            EyesColorComboBox.setSelectedIndex(eyesColor + 1);
            generateCode();
            generateRace();
        }
    }
    public void countryList(){
        String listado[] = {"Seleccione un país", "Afganistán","Albania","Alemania","Andorra","Angola","Antigua y Barbuda","Arabia Saudita","Argelia","Argentina","Armenia","Australia","Austria","Azerbaiyán","Bahamas","Bangladés","Barbados","Baréin","Bélgica","Belice","Benín","Bielorrusia","Birmania","Bolivia","Bosnia y Herzegovina","Botsuana","Brasil","Brunéi","Bulgaria","Burkina Faso","Burundi","Bután","Cabo Verde","Camboya","Camerún","Canadá","Catar","Chad","Chile","China","Chipre","Ciudad del Vaticano","Colombia","Comoras","Corea del Norte","Corea del Sur","Costa de Marfil","Costa Rica","Croacia","Cuba","Dinamarca","Dominica","Ecuador","Egipto","El Salvador","Emiratos Árabes Unidos","Eritrea","Eslovaquia","Eslovenia","España","Estados Unidos","Estonia","Etiopía","Filipinas","Finlandia","Fiyi","Francia","Gabón","Gambia","Georgia","Ghana","Granada","Grecia","Guatemala","Guyana","Guinea","Guinea ecuatorial","Guinea-Bisáu","Haití","Honduras","Hungría","India","Indonesia","Irak","Irán","Irlanda","Islandia","Islas Marshall","Islas Salomón","Israel","Italia","Jamaica","Japón","Jordania","Kazajistán","Kenia","Kirguistán","Kiribati","Kuwait","Laos","Lesoto","Letonia","Líbano","Liberia","Libia","Liechtenstein","Lituania","Luxemburgo","Madagascar","Malasia","Malaui","Maldivas","Malí","Malta","Marruecos","Mauricio","Mauritania","México","Micronesia","Moldavia","Mónaco","Mongolia","Montenegro","Mozambique","Namibia","Nauru","Nepal","Nicaragua","Níger","Nigeria","Noruega","Nueva Zelanda","Omán","Países Bajos","Pakistán","Palaos","Palestina","Panamá","Papúa Nueva Guinea","Paraguay","Perú","Polonia","Portugal","Reino Unido","República Centroafricana","República Checa","República de Macedonia","República del Congo","República Democrática del Congo","República Dominicana","República Sudafricana","Ruanda","Rumanía","Rusia","Samoa","San Cristóbal y Nieves","San Marino","San Vicente y las Granadinas","Santa Lucía","Santo Tomé y Príncipe","Senegal","Serbia","Seychelles","Sierra Leona","Singapur","Siria","Somalia","Sri Lanka","Suazilandia","Sudán","Sudán del Sur","Suecia","Suiza","Surinam","Tailandia","Tanzania","Tayikistán","Timor Oriental","Togo","Tonga","Trinidad y Tobago","Túnez","Turkmenistán","Turquía","Tuvalu","Ucrania","Uganda","Uruguay","Uzbekistán","Vanuatu","Venezuela","Vietnam","Yemen","Yibuti","Zambia","Zimbabue"};
        String EyesColor[] = {"Seleccione un color", "Verde", "Negro", "Amarillo", "Marron", "Gris", "Oro", "Bicolor"};
        String Color[] = {"Seleccione un color", "Blanco", "Negro", "Amarillo","Marron", "Gris", "Oro"};
        procedenceComboBox.setModel(new DefaultComboBoxModel(listado));
        ColorComboBox.setModel(new DefaultComboBoxModel(Color));
        EyesColorComboBox.setModel(new DefaultComboBoxModel(EyesColor));
    }
}