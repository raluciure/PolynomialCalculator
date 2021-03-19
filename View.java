import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JFrame mainFrame;
    protected JTextField firstPol;
    protected JTextField secondPol;
    protected JTextField resultPol;

    protected JButton addBtn;
    protected JButton subBtn;
    protected JButton multiplyBtn;
    protected JButton divisionBtn;
    protected JButton derivativeBtn;
    protected JButton integrationBtn;
    protected JButton clearBtn;

    private JLabel label1;
    private JLabel label2;
    private JLabel labelRes;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel;



    public View(){

        mainFrame=new JFrame("Polynomial Calculator");
        firstPol=new JTextField(50);
        secondPol=new JTextField(50);
        resultPol=new JTextField(50);
        resultPol.setEditable(false);

        addBtn=new JButton("Addition");
        subBtn=new JButton("Subtraction");
        multiplyBtn=new JButton("Multiply");
        divisionBtn=new JButton("Division");
        derivativeBtn=new JButton("Derivative");
        integrationBtn=new JButton("Integration");
        clearBtn=new JButton("Clear");

        label1=new JLabel("First polynomial = ");
        label2=new JLabel("Second polynomial = ");
        labelRes=new JLabel("Resulted polynomial = ");

        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        panel4=new JPanel();
        panel=new JPanel();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(680,300);

        panel1.add(label1);
        panel1.add(firstPol);
        panel1.setLayout(new FlowLayout());

        panel2.add(label2);
        panel2.add(secondPol);
        panel2.setLayout(new FlowLayout());

        panel3.add(addBtn);
        panel3.add(subBtn);
        panel3.add(multiplyBtn);
        panel3.add(divisionBtn);
        panel3.add(derivativeBtn);
        panel3.add(integrationBtn);
        panel3.add(clearBtn);
        panel3.setLayout(new FlowLayout());

        panel4.add(labelRes);
        panel4.add(resultPol);
        panel4.setLayout(new FlowLayout());

        panel.add(new JLabel("Introduce the polynomials starting with the highest degree!                                                                                                        "));
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel1.setBackground(Color.cyan);
        panel2.setBackground(Color.cyan);
        panel3.setBackground(Color.cyan);
        panel4.setBackground(Color.cyan);
        panel.setBackground(Color.cyan);

        mainFrame.setContentPane(panel);
        mainFrame.setVisible(true);



    }

    void addListener(ActionListener al){
        addBtn.addActionListener(al);
    }

    void subListener(ActionListener al){
        subBtn.addActionListener(al);
    }

    void mulListener(ActionListener al){
        multiplyBtn.addActionListener(al);
    }

    void divListener(ActionListener al){
        divisionBtn.addActionListener(al);
    }

    void derListener(ActionListener al){
        derivativeBtn.addActionListener(al);
    }

    void integrationListener(ActionListener al){
        integrationBtn.addActionListener(al);
    }

    void clearListener(ActionListener al){
        clearBtn.addActionListener(al);
    }

}
