import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class UserForm extends JFrame implements ActionListener
{
    Container c;
    JLabel j1,j2,j3;
    JTextField name;
    JRadioButton male,female;
    JComboBox comb;
    ButtonGroup btn;
    JButton butt1;

    public UserForm()
    {
        JFrame frame=new JFrame("UserForm");
        frame.setBounds(100,100,300,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c=frame.getContentPane();//container
        c.setLayout(null);
        //For Label
        j1=new JLabel("Name :");
        j2=new JLabel("Sex :");
        j3=new JLabel("Education :");
        j1.setBounds(10,20,60,30);
        j2.setBounds(10,60,60,30);
        j3.setBounds(10,100,100,30);
        //adding label to container
        c.add(j1);
        c.add(j2);
        c.add(j3);
        //for name field
        name = new JTextField();
        name.setBounds(80,20,100,30);
        c.add(name);
        //for sex field creating radio btn
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        male.setBounds(70,60,100,30);
        female.setBounds(170,60,100,30);
        c.add(male);
        c.add(female);
        //creating buttongroup inorder to separate the gender
        btn=new ButtonGroup();
        btn.add(male);
        btn.add(female);
        male.setSelected(true);
        //For string field
        String []values={"SEE","PLUS TWO","BSC.CSIT","MSC.CSIT"};
        comb=new JComboBox(values);
        comb.setBounds(110,100,100,30);
        c.add(comb);
        //For creating Button
        butt1=new JButton("Append to File");
        butt1.setBounds(30,150,140,30);
        c.add(butt1);
        butt1.addActionListener(this);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String gen=null;
        if(male.isSelected())
        {
            gen="Male";
        }
        else if(female.isSelected())
        {
            gen= "Female";
        }
        String s1 = name.getText();
        String s2 = gen;
        String s3 = comb.getSelectedItem().toString();
        if (e.getSource() == butt1) {
            try
            {
                FileWriter w = new FileWriter( "customer.txt", true);
                w.write(s1 + ",");
                w.write(s2 + ",");
                w.write(s3 );
                w.close();
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
        }
    }

    public static void main(String[] args)
    {
        UserForm form = new UserForm();
    }
}
