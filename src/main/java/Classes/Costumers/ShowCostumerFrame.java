package Classes.Costumers;

import Classes.Function;
import Classes.RequestFrame;
import Classes.RequestType;
import Classes.SubClasses.Address;
import Classes.SubClasses.Birthdate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ShowCostumerFrame extends JFrame implements Function {

    private JPanel showCostumerPane;

    //labels
    private JLabel lbHeadline;
    private JLabel lbLastName;
    private JLabel lbGender;
    private JLabel lbMobilenumber;
    private JLabel lbFirstName;
    private JLabel lbMessage;
    private JLabel lbImage;
    private JLabel lbAddress;
    private JLabel lbCountry;
    private JLabel lbCity;
    private JLabel lbStreet;
    private JLabel lbZip;
    private JLabel lbHouseNumber;
    private JLabel lbBirthdate;
    private JLabel lbEmail;

    //TextFields
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfGender;
    private JTextField tfMobilenumber;
    private JTextField tfDay;
    private JTextField tfMonth;
    private JTextField tfYear;
    private JTextField tfCountry;
    private JTextField tfCity;
    private JTextField tfStreet;
    private JTextField tfZip;
    private JTextField tfHouseNumber;
    private JTextField tfEmail;
    //Buttons
    private JButton btnSave;
    private JButton btnCancel;

    //Other
    private JCheckBox cbEdit;
    private JScrollBar scrollBar1;



    private Data data;
    private CostumersFrame costumersFrame;

    private Costumer slcCostumer;
    private ShowCostumerFrame self = this;


    public ShowCostumerFrame(Data data, Costumer slcCostumer, CostumersFrame costumersFrame){
        this.data = data;
        this.costumersFrame = costumersFrame;
        slcCostumer = slcCostumer;
        setContentPane(showCostumerPane);
        setLocation(800,300);
        setSize(400,380);
        setVisible(true);
        setResizable(true);

        setup();

        tfFirstName.setEnabled(false);
        tfLastName.setEnabled(false);
        tfDay.setEnabled(false);
        tfMonth.setEnabled(false);
        tfYear.setEnabled(false);
        tfGender.setEnabled(false);
        tfMobilenumber.setEnabled(false);
        tfCountry.setEnabled(false);
        tfCity.setEnabled(false);
        tfZip.setEnabled(false);
        tfStreet.setEnabled(false);
        tfHouseNumber.setEnabled(false);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("monkey.gif"));
        lbImage.setIcon(icon);

    }

    public void apply(Boolean success) {
        if (success) {
            editCostumer();
        } else {
            System.out.println("Article NOT saved!");
        }
    }

    public void setup(){

        tfFirstName.setText(slcCostumer.getFirstName());
        tfLastName.setText(slcCostumer.getLastName());
        tfDay.setText(Integer.toString(slcCostumer.getBirthdate().getDay()));
        tfMonth.setText(Integer.toString(slcCostumer.getBirthdate().getMonth()));
        tfYear.setText(Integer.toString(slcCostumer.getBirthdate().getYear()));
        tfGender.setText(""+slcCostumer.getGender()+"");
        tfEmail.setText(""+slcCostumer.getEmailAddress()+"");
        tfMobilenumber.setText(""+slcCostumer.getMobilenumber());

        tfCountry.setText(""+slcCostumer.getAddress().getCountry());
        tfCity.setText(""+slcCostumer.getAddress().getCity());
        tfZip.setText(""+slcCostumer.getAddress().getZip());
        tfStreet.setText(""+slcCostumer.getAddress().getStreet());
        tfHouseNumber.setText(""+slcCostumer.getAddress().getHouseNumber());


        btnSave.setEnabled(false);

        cbEdit.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){

                    btnSave.setEnabled(true);

                    tfFirstName.setEnabled(true);
                    tfLastName.setEnabled(true);
                    tfDay.setEnabled(true);
                    tfMonth.setEnabled(true);
                    tfYear.setEnabled(true);
                    tfGender.setEnabled(true);
                    tfMobilenumber.setEnabled(true);
                    tfCountry.setEnabled(true);
                    tfCity.setEnabled(true);
                    tfZip.setEnabled(true);
                    tfStreet.setEnabled(true);
                    tfHouseNumber.setEnabled(true);

                }

                if(e.getStateChange() == ItemEvent.DESELECTED){

                    btnSave.setEnabled(false);

                    tfFirstName.setEnabled(false);
                    tfLastName.setEnabled(false);
                    tfDay.setEnabled(false);
                    tfMonth.setEnabled(false);
                    tfYear.setEnabled(false);
                    tfGender.setEnabled(false);
                    tfMobilenumber.setEnabled(false);
                    tfCountry.setEnabled(false);
                    tfCity.setEnabled(false);
                    tfZip.setEnabled(false);
                    tfStreet.setEnabled(false);
                    tfHouseNumber.setEnabled(false);

                }
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RequestFrame request = new RequestFrame(RequestType.edit, self, self.costumersFrame);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    void editCostumer() {
        slcCostumer.setFirstName(tfFirstName.getText());
        slcCostumer.setLastName(tfLastName.getText());
        slcCostumer.setGender(tfGender.getText());
        slcCostumer.setBirthdate(new Birthdate(Integer.valueOf(tfDay.getText()),Integer.valueOf(tfMobilenumber.getText()),Integer.valueOf(tfYear.getText())));
        slcCostumer.setMobilenumber(tfMobilenumber.getText());
        slcCostumer.setAddress(new Address(tfCountry.getText(),tfCity.getText(),tfStreet.getText(),tfZip.getText(),tfHouseNumber.getText()));

        data.uploadDataToServer();

        System.out.println("contactPerson changed");
        dispose();
    }

    public CostumersFrame getCostumersFrame() {
        return costumersFrame;
    }

    public void setCostumersFrame(CostumersFrame costumersFrame) {
        this.costumersFrame = costumersFrame;
    }
}
