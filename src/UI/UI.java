package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Control.*;
import Pets.Cat;
import Pets.Dog;

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
    private float Saldo = 0;

    PetShop petShop = new PetShop();
    public UI(float Saldo){
        this.Saldo = Saldo;
    }
    public UI() {

        KindOfPet.setVisible(false);
        addCat.setVisible(false);
        addDog.setVisible(false);
        venderJPanel.setVisible(false);
        countrySearchJPanel.setVisible(false);

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
                if (noCheckBox.isSelected() == false){
                    noCheckBox.setText("No");
                }else noCheckBox.setText("Si");

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
                if (perroRadioButton.isSelected() == true){
                    addDog.setVisible(true);
                    addCat.setVisible(false);


                }
                else if (gatoRadioButton.isSelected() == true){
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
                float Price = 0;
                int AgeinMonth = 0;

                    AgeinMonth = Integer.parseInt(textFieldDogage.getText());

                    if(AgeinMonth <= 24) {
                        Price = 1000/AgeinMonth;
                    } else if (AgeinMonth >= 25) {
                        Price = 35;
                    }


                String Procedence = textFieldDogcountry.getText();
                String Color = textFieldDogColor.getText();
                String Race;

                    if (bulldogRadioButton.isSelected() == true){
                        Race = bulldogRadioButton.getText();
                    } else if (dalmataRadioButton.isSelected() == true) {
                        Race = "Dalmata";
                    } else if (chowChowRadioButton.isSelected() == true) {
                        Race = "Chow-Chow";
                    }else Race = "Sin RA";
                if (Race == "Chow-Chow"){
                    Price += 30;
                } else if (Race == "Dalmata") {
                    Price += 50;
                }

                Saldo += Price;
               // petShop.checkDogCode(AgeinMonth, Procedence, Color, Price, Race, Code);
                Dog dog = new Dog(AgeinMonth, Procedence, Color,Price , Race, Code);
                petShop.fillDog(AgeinMonth, Procedence, Color, Price, Race,Code);
                comboBox1.addItem(dog);
                Saldotext.setText(String.valueOf(Saldo));

            }catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(null,"Ingrese la edad solo en números", "Error", 0);
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

                String Procedence = catProcedence.getText();
                String Color = catColor.getText();
                String EyesColor = catEyesColor.getText();
                String Sex;
                if (hembraRadioButton.isSelected() == true){
                    Sex = "Hembra";
                }else Sex = "Macho";
                boolean Perdigree = noCheckBox.isSelected();
                float Price = 0;
                if(AgeinMonth <= 24) {
                    Price = 1000/AgeinMonth;
                } else if (AgeinMonth >= 25) {
                    Price = 35;
                }
                if (Perdigree == true){
                    Price *= 2;
                }
                Saldo += Price;
                Cat cat = new Cat(AgeinMonth, Procedence, Color, EyesColor, Sex, Perdigree, Price, Code );
                petShop.fillCat(AgeinMonth, Procedence, Color, EyesColor, Sex, Perdigree,Price, Code);
                comboBox1.addItem(cat);
                Saldotext.setText(String.valueOf(Saldo));
                }catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null,"Ingrese la edad solo en números", "Error", 0);
                }
            }
        });
        priceSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               petShop.showPets();
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
               String Code= sellCode.getText();
            petShop.sellPet(Code);
            }
        });
        searchCountryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (countrySearchTextField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,
                            "Escriba el nombre de un país para poder buscar",
                            "Alerta",
                            2);
                }else
                petShop.countrySearch(countrySearchTextField.getText());
            }
        });
    }
    public void StartInterface(){
        JFrame window = new JFrame("Control.PetShop");
        window.setContentPane(new UI().MainPanel);
        window.pack();
        window.setBounds(0, 0, 700, 250);
        window.setVisible(true);
        window.setMinimumSize(new Dimension(250,250));
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}