package Classes.Articles;

import Classes.Firebase.FirebaseContext;
import Classes.SubClasses.*;
import Classes.SubClasses.UnitsAndValues.Units.MeasuresUnit;
import Classes.SubClasses.UnitsAndValues.MeasuresValue;
import Classes.SubClasses.UnitsAndValues.Units.WeightUnit;
import Classes.SubClasses.UnitsAndValues.WeightValue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.UUID;

public class AddArticleFrame extends JFrame{

    private JPanel addCustomerPane;

    //Labels
    private JLabel lbHeadline;
    private JLabel lbName;
    private JLabel lbPrice;
    private JLabel lbMeasures;
    private JLabel lbLength;
    private JLabel lbWide;
    private JLabel lbHeight;
    private JLabel lbQuantity;
    private JLabel lbColor;
    private JLabel lbWeight;
    private JLabel lbDescription;
    private JLabel lbMessage;
    private JLabel lbImage;
    private JLabel lbArticleNo;

    //TextFields
    private JTextField tfArticleNo;
    private JTextField tfName;
    private JTextField tfPrice;
    private JTextField tfQuantity;
    private JTextField tfColor;
    private JTextField tfWeight;
    private JTextField tfLength;
    private JTextField tfWide;
    private JTextField tfHeight;


    //Buttons
    private JButton btnAdd;
    private JButton btnCancel;

    //Other
    private JTextPane tfDescription;
    private JComboBox comboBoxWeight;
    private JComboBox comboBoxLenght;
    private JComboBox comboBoxWide;
    private JComboBox comboBoxHeight;

    private WeightUnit weightUnit = WeightUnit.kg;
    private MeasuresUnit lengthUnit = MeasuresUnit.mm;
    private MeasuresUnit widthUnit = MeasuresUnit.mm;
    private MeasuresUnit heightUnit = MeasuresUnit.mm;

    private FirebaseContext firebaseContext;
    private ArticlesFrame parent;

    public AddArticleFrame(FirebaseContext firebaseContext, ArticlesFrame parent){
        this.firebaseContext = firebaseContext;
        this.parent = parent;
        setContentPane(addCustomerPane);
        setLocation(800,300);
        setSize(400,450);
        setVisible(true);
        setResizable(true);

        btnManager();
    }

    public void btnManager(){
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String atNo = tfArticleNo.getText();
                String atName = tfName.getText();
                String atPrice = tfPrice.getText();
                String atQuantity = tfQuantity.getText();

                String atWeight = tfWeight.getText();
                String atLength = tfLength.getText();
                String atWide = tfWide.getText();
                String atHeight = tfHeight.getText();
                String atDescription = tfDescription.getText();

                Article newArticle = new Article(UUID.randomUUID().toString(),Integer.valueOf(atNo),atName,new WeightValue(Double.valueOf(tfWeight.getText()),weightUnit),atDescription, "00ff00",Double.valueOf(atPrice),Integer.valueOf(atQuantity), new Measures(new MeasuresValue(Double.valueOf(tfLength.getText()), lengthUnit),new MeasuresValue(Double.valueOf(tfWide.getText()),widthUnit),new MeasuresValue(Double.valueOf(tfHeight.getText()),heightUnit)));
                firebaseContext.addDocument(newArticle);
                parent.refreshInformationPanel();

                dispose();
            }
        });

        WeightUnit[] weightUnits = WeightUnit.values();
        for(int i = 0; i < weightUnits.length; i++){
            comboBoxWeight.addItem(weightUnits[i]);
        }
        comboBoxWeight.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                weightUnit = (WeightUnit) e.getItem();
            }
        });

        MeasuresUnit[] lengthUnits = MeasuresUnit.values();
        for(int i = 0; i < lengthUnits.length; i++){
            comboBoxLenght.addItem(lengthUnits[i]);
        }

        comboBoxLenght.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lengthUnit = (MeasuresUnit) e.getItem();
            }
        });

        MeasuresUnit[] wideUnits = MeasuresUnit.values();
        for(int i = 0; i < wideUnits.length; i++){
            comboBoxWide.addItem(wideUnits[i]);
        }

        comboBoxWide.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                widthUnit = (MeasuresUnit) e.getItem();
            }
        });

        MeasuresUnit[] heightUnits = MeasuresUnit.values();
        for(int i = 0; i < wideUnits.length; i++){
            comboBoxHeight.addItem(heightUnits[i]);
        }

        comboBoxHeight.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               heightUnit = (MeasuresUnit) e.getItem();
            }
        });


    }

    public static void main(String[] args) {
    }

}