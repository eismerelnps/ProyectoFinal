package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import Control.*;
import Pets.Cat;

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
                        "Title",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null, new Object[]{},
                        null);

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


                } else if (gatoRadioButton.isSelected() == true) {
                    addDog.setVisible(false);
                    addCat.setVisible(true);
                } else if (perroRadioButton.isSelected() == false || gatoRadioButton.isSelected() == false) {
                    JOptionPane.showMessageDialog(null, "Seleciona que tipo de mascota desea agreagar");
                }
            }
        });
        agregarDogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String Code = dogCode.getText();

                    int AgeinMonth = Integer.parseInt(textFieldDogage.getText());

                    String Procedence = textFieldDogcountry.getText();
                    String Color = textFieldDogColor.getText();
                    String Race = null;

                    if (bulldogRadioButton.isSelected() == true) {
                        Race = bulldogRadioButton.getText();
                    } else if (dalmataRadioButton.isSelected() == true) {
                        Race = "Dalmata";
                    } else if (chowChowRadioButton.isSelected() == true) {
                        Race = "Chow-Chow";
                    } else JOptionPane.showMessageDialog(null,
                            "Por favor selecciona la raza primero",
                            "Informacion",
                            1);


                    if (Code == null) {
                        JOptionPane.showMessageDialog(null,
                                "Por favor introduzca el codigo primero",
                                "Informacion",
                                1);
                    }
                    if (AgeinMonth == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Por favor introduzca la edad primero",
                                "Informacion",
                                1);
                    }
                    if (Procedence == null) {
                        JOptionPane.showMessageDialog(null,
                                "Por favor introduzca la procedencia primero",
                                "Informacion",
                                1);
                    }
                    if (Color == null) {
                        JOptionPane.showMessageDialog(null,
                                "Por favor introduzca el color primero",
                                "Informacion",
                                1);
                    }
                    if (Race == null) {
                        JOptionPane.showMessageDialog(null,
                                "Por favor selecciona la raza primero",
                                "Informacion",
                                1);
                    } else {
                       // Saldo += Price;
                        float Price = 0;
                      //  Dog dog = new Dog(AgeinMonth, Procedence, Color, Price, Race, Code);
                        petShop.fillDog(AgeinMonth, Procedence, Color, Race, Code);
                        //comboBox1.addItem(dog);
                        Saldotext.setText(String.valueOf(Saldo));
                        // petShop.checkCode(Code);
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Ingrese la edad solo en números", "Error", 0);
                }
            }
        });
        agregarCatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String Code = catCode.getText();
                    int AgeinMonth = 0;

                    AgeinMonth = Integer.parseInt(catAge.getText());
                    if (AgeinMonth == 0){
                        AgeinMonth = 1;
                    }

                    String Procedence = catProcedence.getText();
                    String Color = catColor.getText();
                    String EyesColor = catEyesColor.getText();
                    String Sex;
                    if (hembraRadioButton.isSelected() == true) {
                        Sex = "Hembra";
                    } else Sex = "Macho";
                    boolean Perdigree = noCheckBox.isSelected();
                    float Price = 0;
                    if (AgeinMonth <= 24) {
                        Price = 1000 / AgeinMonth;
                    } else if (AgeinMonth >= 25) {
                        Price = 35;
                    }
                    if (Perdigree == true) {
                        Price *= 2;
                    }
                    Saldo += Price;
                    Cat cat = new Cat(AgeinMonth, Procedence, Color, EyesColor, Sex, Perdigree, Price, Code);
                    petShop.fillCat(AgeinMonth, Procedence, Color, EyesColor, Sex, Perdigree, Price, Code);
                    comboBox1.addItem(cat);
                    Saldotext.setText(String.valueOf(Saldo));
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
                        "Vender MAscota",
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
                if(perroRadioButton.isSelected() == true){
                    textFieldDogcountry.setText(generCountry.randomgenerCountry().toString());
                    textFieldDogColor.setText(generateColor.randomgenerateColor().toString());
                    textFieldDogage.setText(String.valueOf((int) (Math.random() * 13)));
                    generateCode();
                    generateRace();

                }else if(gatoRadioButton.isSelected() == true){
                    catProcedence.setText(generCountry.randomgenerCountry().toString());
                    catColor.setText(generateColor.randomgenerateColor().toString());
                   catAge.setText(String.valueOf((int) (Math.random() * 13)));
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
                petShop.checkCode(dogCode.getText());
            }
        });
        searchPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petShop.priceSearch(searchPriceText.getText());
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
                petShop.predominantColor();
            }
        });
    }
    public void StartInterface() {
        JFrame window = new JFrame("Control.PetShop");
        window.setContentPane(new UI().MainPanel);
        window.pack();
        window.setBounds(0, 0, 1000, 350);
        window.setVisible(true);
        window.setMinimumSize(new Dimension(250, 250));
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
               noCheckBox.setSelected(true);
           }
       }
    }
}