import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton numberButton[] = new JButton[10];
    JButton funtionalButton[] = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton delButton, clrButton, decimButton, negetiveButton, equalButton;    
    JPanel panel;

    Font MyFont = new Font("Ink Free", Font.BOLD, 30);

    double num1 =0;
    double num2 =0;
    double result = 0;
    char opertor;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(MyFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decimButton = new JButton(".");
        equalButton = new JButton("=");        
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negetiveButton = new JButton("(-)");

        funtionalButton[0] = addButton;
        funtionalButton[1] = subButton;
        funtionalButton[2] = mulButton;
        funtionalButton[3] = divButton;
        funtionalButton[4] = decimButton;
        funtionalButton[5] = equalButton;        
        funtionalButton[6] = delButton;
        funtionalButton[7] = clrButton;
        funtionalButton[8] = negetiveButton;

        for(int i=0; i<9; i++){
            funtionalButton[i].addActionListener(this);
            funtionalButton[i].setFont(MyFont);
            funtionalButton[i].setFocusable(false);
        }
        for(int i=0; i<=9; i++){
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(MyFont);
            numberButton[i].setFocusable(false);
        }

        negetiveButton.setBounds(50,430,100,50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);

        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);

        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        
        panel.add(decimButton);
        panel.add(numberButton[0]);
        panel.add(equalButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negetiveButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
       Calculator  cal =  new Calculator(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
           for(int i=0; i<10; i++){
               if(e.getSource()== numberButton[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
               }
           }  
           if(e.getSource()==decimButton){
            textfield.setText(textfield.getText().concat("."));
           }
           if(e.getSource()==addButton){
               num1 = Double.parseDouble(textfield.getText());
               opertor = '+';
               textfield.setText("");
           }
           if(e.getSource()==subButton){
               num1 = Double.parseDouble(textfield.getText());
               opertor = '-';
               textfield.setText("");
           }
           if(e.getSource()==mulButton){
               num1 = Double.parseDouble(textfield.getText());
               opertor = '*';
               textfield.setText("");
           }
           if(e.getSource()==divButton){
               num1 = Double.parseDouble(textfield.getText());
               opertor = '/';
               textfield.setText("");
           }
           if(e.getSource()==equalButton){
               num2 = Double.parseDouble(textfield.getText());
               switch(opertor){
                case '+':   
                    result = num1 + num2;
                    break;
                
                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    result = num1 / num2;
                    break;

               }
               textfield.setText((String.valueOf(result)));
               num1 = result;
           }
           if(e.getSource()==delButton){
               String str = textfield.getText();
               textfield.setText((""));
               for(int i=0; i<str.length()-1; i++){
                textfield.setText(textfield.getText()+str.charAt(i));
               }
           }
           if(e.getSource()==clrButton){
            textfield.setText("");
           }
           if(e.getSource() == negetiveButton){
               Double neg = Double.parseDouble(textfield.getText());
               neg *= -1;
               textfield.setText(String.valueOf(neg));

           }
    }
}
