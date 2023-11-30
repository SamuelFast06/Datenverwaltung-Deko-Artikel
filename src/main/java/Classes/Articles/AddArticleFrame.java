package Classes.Articles;

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

    private WeightUnit weightUnit;
    private MeasuresUnit lengthUnit;
    private MeasuresUnit wideUnit;
    private MeasuresUnit heightUnit;

    private Data data;
    private ArticlesFrame parent;

    public AddArticleFrame(Data data, ArticlesFrame parent){
        this.data = data;
        this.parent = parent;
        setContentPane(addCustomerPane);
        setLocation(800,300);
        setSize(400,400);
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

                Article newArticle = new Article(UUID.randomUUID(),Integer.valueOf(atNo),atName,new WeightValue(Double.valueOf(tfWeight.getText()),weightUnit),atDescription, "00ff00",Double.valueOf(atPrice),Integer.valueOf(atQuantity), new Measures(new MeasuresValue(Double.valueOf(tfLength.getText()), lengthUnit),new MeasuresValue(Double.valueOf(tfWide.getText()),wideUnit),new MeasuresValue(Double.valueOf(tfHeight.getText()),heightUnit)));
                data.addArticle(newArticle);
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
                WeightUnit weightUnit = (WeightUnit) e.getItem();
            }
        });

        MeasuresUnit[] lengthUnits = MeasuresUnit.values();
        for(int i = 0; i < lengthUnits.length; i++){
            comboBoxLenght.addItem(lengthUnits[i]);
        }

        comboBoxLenght.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                MeasuresUnit lengthUnit = (MeasuresUnit) e.getItem();
            }
        });

        MeasuresUnit[] wideUnits = MeasuresUnit.values();
        for(int i = 0; i < wideUnits.length; i++){
            comboBoxWide.addItem(wideUnits[i]);
        }

        comboBoxWide.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                MeasuresUnit wideUnit = (MeasuresUnit) e.getItem();
            }
        });

        MeasuresUnit[] heightUnits = MeasuresUnit.values();
        for(int i = 0; i < wideUnits.length; i++){
            comboBoxHeight.addItem(heightUnits[i]);
        }

        comboBoxHeight.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               MeasuresUnit heightUnit = (MeasuresUnit) e.getItem();
            }
        });


    }

    public static void main(String[] args) {
    }

}