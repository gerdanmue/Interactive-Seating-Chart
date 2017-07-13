import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/** An object named ConcertWindow, which it
  * initializes a GUI of the Concert seats and
  * stage for users to buy the seats they prefer.
  * @author Gerardo Muela
  * @author Guillermo Ramirez
  * @author Carlos Herrera
  * @author Alejandro Berlanga
  */
public class ConcertWindow extends JFrame{
  /*Buttons to represent each seat*/
  private JButton buttons[];
  /*Panel to allocate the button of for the user to pay the seats*/
  private JPanel buttonPanel;
  /*Panel to allocate the buttons representing the seats available*/
  private JPanel buttonsPanel;
  /*Button for the user to pay for the seats chosen by him/her*/
  private JButton button;
  /*ConcertButtons object to add the action to the buttos representing the seats*/
  private ConcertButtons concertButtons = new ConcertButtons();
  /*User object for the ConcertWindow to know which type of user, either regular or vip, is buying the seats*/
  private User user;
  /*Constructor of the ConcerWindow class to initiliaze all its fields*/
  public ConcertWindow(){
    /*Set the title of the GUI window*/
    setTitle("Concert Window");
    /*Set the close operation for the GUI window as the X on the upper right corner.*/
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    /*Set initial size for the GUI window.*/
    setSize(1000,1000);
    /*Set the layout of the GUI window to a Border layout.*/
    setLayout(new BorderLayout());
    /*Call of the method to initialize the "Pay Now" button and the panel where the button will be allocated*/
    createButtonPanel();
    /*Call of the method to initialize the buttons representing the seats and the panel where the button will be allocated*/
    createButtonsPanel();
    /*Add the button panel holding the "Pay Now" button in the North side of the JFrame*/
    add(buttonPanel,BorderLayout.NORTH);
    /*Add the buttons panel holding the buttons representing the seats in the Center side of the JFrame*/
    add(buttonsPanel,BorderLayout.CENTER);
    /*Set the visibility of the window to "true" so the GUI window can be visible.*/
    setVisible(true);
  }
  /*Method to initialize the "Pay Now" button and the panel where the button will be allocated*/
  private void createButtonPanel(){
    buttonPanel = new JPanel();
    button = new JButton();
    button.setText("Pay now");
    button.setFont(new Font("Broadway",Font.BOLD,20));
    button.addActionListener(concertButtons);
    buttonPanel.add(button);
  }
  /*Method to initialize the buttons representing the seats and the panel where the button will be allocated*/
  private void createButtonsPanel(){
    buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(6,10));
    buttons = new JButton [60];
    for(int i = 0; i < buttons.length; i++){
      buttons[i] = new JButton("");
      buttons[i].setFont(new Font("Broadway",Font.BOLD,20));
      if(i >= 0 && i < 20){
        buttons[i].setText("$30.00");
        buttons[i].setBackground(Color.green);
      }
      else if(i >= 20 && i < 40){
        buttons[i].setText("$20.00");
        buttons[i].setBackground(Color.blue);
      }
      else if(i >= 40 && i < 60){
        buttons[i].setText("$10.00");
        buttons[i].setBackground(Color.yellow);
      }
      buttons[i].addActionListener(concertButtons);
      buttonsPanel.add(buttons[i]);
    }
  }
  /*Method to initiliaze the field User from the ConcertWindow object
   * @param vip a boolean that represents with true if the user is VIP,
   * false if the user is not VIP*/
  public void setUser(boolean vip){
    user = new User();
    user.setVIP(vip);
  }
  /*ConcertButtons class that implements the class ActionListener to add the action performed
   * when the buttons in the ConcertWindow are clicked*/
  public class ConcertButtons implements ActionListener{
    JButton button;
    /*Method to add the action when a button of the ConcertWindow is clicked
     * @param ActionEvent click on a JButton object*/
    public void actionPerformed(ActionEvent e){
      button = (JButton)e.getSource();
      if(button.getText().equals("Pay now")){
        user.discount();
        JOptionPane.showMessageDialog(null,"Your total was: "+user.totalPrice+"\nQuantity seats: "+user.seatQuantity);
        System.exit(0);
      }
      else{
        if(button.getBackground() != Color.RED){
          button.setBackground(Color.RED);
          double price = Double.parseDouble(button.getText().substring(1));
          user.seatQuantity++;
          user.totalPrice+=price;
        }
        else{
          if(button.getText().equals("$30.00")){
            button.setBackground(Color.green);
          }
          else if(button.getText().equals("$20.00")){
            button.setBackground(Color.blue);
          }
          else if(button.getText().equals("$10.00")){
            button.setBackground(Color.yellow);
          }
          double price = Double.parseDouble(button.getText().substring(1));
          user.seatQuantity--;
          user.totalPrice-=price;
        }
      }
    }
  }
}