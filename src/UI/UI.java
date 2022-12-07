package UI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import Control.*;

public class UI {
    private JPanel MainPanel;
    private JButton inicioButton;
    private JButton agregarButton;
    private JButton venderButton;
    private JPanel addPet;
    private JRadioButton perroRadioButton;
    private JRadioButton gatoRadioButton;
    private JPanel KindOfPet;
    private JTextField textFieldDogage;
    private JTextField textFieldDogcountry;
    private JTextField textFieldDogColor;
    private JRadioButton bulldogRadioButton;
    private JRadioButton dalmataRadioButton;
    private JRadioButton chowChowRadioButton;
    private JButton agregarDogButton;
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
    private JTextField dogCode;
    private JTextField catCode;
    private JPanel venderJPanel;
    private JTextField sellCode;
    private JButton eliminarButton;
    private JLabel Saldotext;
    private JPanel leftPanel;
    private JComboBox comboBox1;
    private JPanel countrySearchJPanel;
    private JTextField countrySearchTextField;
    private JButton searchCountryButton;
    private JButton generarButton;
    private JButton button1;
    private JButton button2;
    private JButton searchPriceButton;
    private JTextField searchPriceText;
    private JPanel searchPriceJPanel;
    private JButton buscarMayorButton;
    private JButton colorMenosPredominanteButton;
    private JButton listadoAlfabeticoButton;
    private JRadioButton oscuroRadioButton;
    private JRadioButton claroRadioButton;
    private float Saldo = 0;

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

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KindOfPet.setVisible(true);
                JOptionPane.showOptionDialog(null,
                        KindOfPet,
                        "Agregar mascota",
                        JOptionPane.DEFAULT_OPTION,
                        -1,
                        null, new Object[]{},
                        null);
                //cerrar JOptionPane



            }
        });
        perroRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gatoRadioButton.setSelected(false);
            }
        });
        gatoRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perroRadioButton.setSelected(false);
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
                if (perroRadioButton.isSelected() == true) {
                    addDog.setVisible(true);
                    addCat.setVisible(false);
                    JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(SwingUtilities.getRootPane(KindOfPet));
                    dialog.dispose();

                } else if (gatoRadioButton.isSelected() == true) {
                    addDog.setVisible(false);
                    addCat.setVisible(true);
                    JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(SwingUtilities.getRootPane(KindOfPet));
                    dialog.dispose();
                } else if (perroRadioButton.isSelected() == false || gatoRadioButton.isSelected() == false) {
                    JOptionPane.showMessageDialog(null,
                            "Por favor selecciona el tipo de mascota primero",
                            "Alerta",
                            2);
                }

            }
        });
        agregarDogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                            "Informacion",
                            1);
                    pass = false;
                }

                try {
                            if (dogCode.getText().isEmpty()){
                                JOptionPane.showMessageDialog(null,
                                        "Por favor introduzca el codigo primero",
                                        "Informacion",
                                        1);
                                pass = false;
                            }else if (textFieldDogage.getText().isEmpty()){
                                JOptionPane.showMessageDialog(null,
                                        "Por favor introduzca la edad primero",
                                        "Informacion",
                                        1);
                                pass = false;
                                //appling regular expresions to determinate if string contains numbers or any symbol different that characters
                            }else if (textFieldDogcountry.getText().isEmpty() || !textFieldDogcountry.getText().matches("\\p{Alpha}+")) {
                                JOptionPane.showMessageDialog(null,
                                        "Por favor introduzca un país válido",
                                        "Alerta",
                                        2);
                                pass = false;
                            }else if (textFieldDogColor.getText().isEmpty() || !textFieldDogColor.getText().matches("\\p{Alpha}+")) {
                                JOptionPane.showMessageDialog(null,
                                        "Por favor introduzca un color válido",
                                        "Alerta",
                                        1);
                                pass = false;
                            } else {
                                Code = dogCode.getText();
                                AgeinMonth = Integer.parseInt(textFieldDogage.getText());
                                Procedence = textFieldDogcountry.getText();
                                Color = textFieldDogColor.getText();
                                pass = true;
                            }



                        if (pass == true){
                            float Price = 0;
                            petShop.fillDog(AgeinMonth, Procedence, Color, Race, Code);
                        }

                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(null, "Ingrese la edad solo en números", "Error", 0);
                    }
                System.out.println(pass+Code+AgeinMonth+Procedence+Color+Race);
                // "//d+" "\p{Alpha}+"
            }
        });
        agregarCatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int AgeinMonth = 0;
                String Code = null;
                String Procedence = null;
                String Color = null;
                boolean pass = false;
                String EyesColor = null;
                String Sex =  null;
                boolean Perdigree = false;
                try {
                    if (catCode.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,
                                "Por favor introduzca el código primero",
                                "Alerta",
                                1);
                        pass = false;
                    }else if (catAge.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "Por favor introduzca la edad primero",
                                "Alerta",
                                1);
                        pass = false;
                    } else if (catProcedence.getText().isEmpty() || !catProcedence.getText().matches("\\p{Alpha}+")) {
                        JOptionPane.showMessageDialog(null,
                                "Por favor introduzca un páis válido",
                                "Alerta",
                                1);
                        pass = false;
                    } else if (catColor.getText().isEmpty() || !catColor.getText().matches("\\p{Alpha}+")) {
                        JOptionPane.showMessageDialog(null,
                                "Por favor introduzca un color válido",
                                "Alerta",
                                1);
                        pass = false;
                    } else if (catEyesColor.getText().isEmpty() || !catEyesColor.getText().matches("\\p{Alpha}+")) {
                        JOptionPane.showMessageDialog(null,
                                "Por favor introduzca un color de ojos válido",
                                "Alerta",
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
                        Code = catCode.getText();
                        AgeinMonth = Integer.parseInt(catAge.getText());
                        if (AgeinMonth == 0){
                            AgeinMonth = 1;
                        }
                        Procedence = catProcedence.getText();
                        Color = catColor.getText();
                        EyesColor = catEyesColor.getText();

                        petShop.fillCat(AgeinMonth, Procedence, Color, EyesColor, Sex, Perdigree, Code);
                    }

                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Ingrese la edad solo en números", "Error", 0);
                }
            }
        });
        priceSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPriceJPanel.setVisible(true);
                JOptionPane.showOptionDialog(null,
                        searchPriceJPanel,
                        "Cantidad por país",
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
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Code = sellCode.getText();
                petShop.sellPet(Code);
            }
        });
        searchCountryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (countrySearchTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Escriba el nombre de un país para poder buscar",
                            "Alerta",
                            2);
                } else
                    petShop.countrySearch(countrySearchTextField.getText());
            }
        });
        generarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int age = (int) (Math.random() * 13);
                if (age == 0){
                    age = 1;
                }
                if(perroRadioButton.isSelected() == true){
                    textFieldDogcountry.setText(generCountry.randomgenerCountry().toString());
                    textFieldDogColor.setText(generateColor.randomgenerateColor().toString());
                    textFieldDogage.setText(String.valueOf(age));
                    generateCode();
                    generateRace();

                }else if(gatoRadioButton.isSelected() == true){
                    catProcedence.setText(generCountry.randomgenerCountry().toString());
                    catColor.setText(generateColor.randomgenerateColor().toString());
                   catAge.setText(String.valueOf(age));
                   catEyesColor.setText(generateEyesColor.randomgenerateEyesColor().toString());
                    generateCode();
                    generateRace();

                }
            }

        });
        inicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petShop.showPets();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petShop.showPets();


            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petShop.createTXT();
            }
        });
        searchPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petShop.priceSearch(searchPriceText.getText());
                JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(SwingUtilities.getRootPane(searchPriceJPanel));
                dialog.dispose();
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
                Mode("DARK");
            }
        });
        claroRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oscuroRadioButton.setSelected(false);
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
    }
    public void StartInterface() {
        JFrame window = new JFrame("Control.PetShop");
        window.setContentPane(new UI().MainPanel);
        window.pack();
        window.setBounds(0, 0, 1000, 450);
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

    public void generateCode() {
        String n = "";
        for (int i = 0; i < 6; i++) {
            n = n.concat(String.valueOf((int) (Math.random() * 12)));
        }
        dogCode.setText(n);
        catCode.setText(n);
    }//generar un codigo random
    public void generateRace(){
        int Option;
       Option = (int) (Math.random() * 3);
       if (perroRadioButton.isSelected() == true){
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
       if (gatoRadioButton.isSelected() == true){
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
        if(Mode == "DARK"){
            MainPanel.setBackground(Color.LIGHT_GRAY);
            leftPanel.setBackground(Color.DARK_GRAY);
            addPet.setBackground(Color.gray);
            addDog.setBackground(Color.DARK_GRAY);
            addCat.setBackground(Color.DARK_GRAY);
            LineBorder lineBorder1 = new LineBorder(Color.WHITE, 1, true );
            inicioButton.setBorder(lineBorder1);
            inicioButton.setBackground(Color.BLACK);
            inicioButton.setForeground(Color.WHITE);


        }
        if (Mode == "LIGHT"){
            MainPanel.setBackground(Color.LIGHT_GRAY);
            leftPanel.setBackground(Color.WHITE);
            addPet.setBackground(Color.WHITE);
            addDog.setBackground(Color.WHITE);
            addCat.setBackground(Color.WHITE);
        }
    }
}