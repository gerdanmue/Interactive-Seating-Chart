import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** An object named IceShowWindow, which it
  * initializes a GUI of the Ice Show seats and
  * stage for users to buy the seats they prefer.
  * @author Gerardo Muela
  * @author Guillermo Ramirez
  * @author Carlos Herrera
  * @author Alejandro Berlanga
  */
public class IceShowWindow extends JFrame{
  public JButton eastButtons[];
  public JButton westButtons[];
  public JButton northButtons[];
  public JButton southButtons[];
  private JPanel eastButtonsPanel;
  private JPanel westButtonsPanel;
  private JPanel northButtonsPanel;
  private JPanel southButtonsPanel;
  public JButton button;
  private JPanel buttonPanel;
  private IceShowButtons iceShowButtons = new IceShowButtons();
  public User user;

/*Constructor of the IceShowWindow class to initiliaze all its fields*/
  public IceShowWindow(){
    setTitle("Ice Show Window");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1000,1000);
    setLayout(new BorderLayout());
    createNorthButtonsPanel();
    createSouthButtonsPanel();
    createWestButtonsPanel();
    createEastButtonsPanel();
    createButtonPanel();
    add(northButtonsPanel,BorderLayout.NORTH);
    add(southButtonsPanel,BorderLayout.SOUTH);
    add(eastButtonsPanel,BorderLayout.EAST);
    add(westButtonsPanel,BorderLayout.WEST);
    add(buttonPanel,BorderLayout.CENTER);
    setVisible(true);
  }

/*Method to initialize the North buttons representing the seats and the panel where the button will be allocated*/
  private void createNorthButtonsPanel(){
    northButtonsPanel = new JPanel();
    northButtonsPanel.setPreferredSize(new Dimension(50,150));
    northButtonsPanel.setLayout(new GridLayout(3,10));
    northButtons = new JButton [30];
    for(int i = 0; i < northButtons.length; i++){
      northButtons[i] = new JButton("");
      northButtons[i].setFont(new Font("Broadway",Font.BOLD,10));
      if(i >= 20 && i < 30){
        northButtons[i].setText("$30.00");
        northButtons[i].setBackground(Color.cyan);
      }
      else if(i >= 10 && i < 20){
        northButtons[i].setText("$20.00");
        northButtons[i].setBackground(Color.magenta);
      }
      else if(i >= 0 && i < 10){
        northButtons[i].setText("$10.00");
        northButtons[i].setBackground(new Color(130,230,150));
      }
      northButtons[i].addActionListener(iceShowButtons);
      northButtonsPanel.add(northButtons[i]);
    }
  }

/*Method to initialize the South buttons representing the seats and the panel where the button will be allocated*/
  private void createSouthButtonsPanel(){
    southButtonsPanel = new JPanel();
    southButtonsPanel.setPreferredSize(new Dimension(50,150));
    southButtonsPanel.setLayout(new GridLayout(3,10));
    southButtons = new JButton [30];
    for(int i = 0; i < southButtons.length; i++){
      southButtons[i] = new JButton("");
      southButtons[i].setFont(new Font("Broadway",Font.BOLD,10));
      if(i >= 0 && i < 10){
        southButtons[i].setText("$30.00");
        southButtons[i].setBackground(Color.cyan);
      }
      else if(i >= 10 && i < 20){
        southButtons[i].setText("$20.00");
        southButtons[i].setBackground(Color.magenta);
      }
      else if(i >= 20 && i < 30){
        southButtons[i].setText("$10.00");
        southButtons[i].setBackground(new Color(130,230,150));
      }
      southButtons[i].addActionListener(iceShowButtons);
      southButtonsPanel.add(southButtons[i]);
    }
  }

/*Method to initialize the West buttons representing the seats and the panel where the button will be allocated*/
  private void createWestButtonsPanel(){
    westButtonsPanel = new JPanel();
    westButtonsPanel.setPreferredSize(new Dimension(250,50));
    westButtonsPanel.setLayout(new GridLayout(5,3));
    westButtons = new JButton [15];
    for(int i = 0; i < westButtons.length; i++){
      westButtons[i] = new JButton("");
      westButtons[i].setFont(new Font("Broadway",Font.BOLD,10));
      if(i%3==2){
        westButtons[i].setText("$30.00");
        westButtons[i].setBackground(Color.cyan);
      }
      else if(i%3==1){
        westButtons[i].setText("$20.00");
        westButtons[i].setBackground(Color.magenta);
      }
      else if(i%3==0){
        westButtons[i].setText("$10.00");
        westButtons[i].setBackground(new Color(130,230,150));
      }
      westButtons[i].addActionListener(iceShowButtons);
      westButtonsPanel.add(westButtons[i]);
    }
  }

/*Method to initialize the East buttons representing the seats and the panel where the button will be allocated*/
  private void createEastButtonsPanel(){
    eastButtonsPanel = new JPanel();
    eastButtonsPanel.setPreferredSize(new Dimension(250,50));
    eastButtonsPanel.setLayout(new GridLayout(5,3));
    eastButtons = new JButton [15];
    for(int i = 0; i < eastButtons.length; i++){
      eastButtons[i] = new JButton("");
      eastButtons[i].setFont(new Font("Broadway",Font.BOLD,10));
      if(i%3==0){
        eastButtons[i].setText("$30.00");
        eastButtons[i].setBackground(Color.cyan);
      }
      else if(i%3==1){
        eastButtons[i].setText("$20.00");
        eastButtons[i].setBackground(Color.magenta);
      }
      else if(i%3==2){
        eastButtons[i].setText("$10.00");
        eastButtons[i].setBackground(new Color(130,230,150));
      }
      eastButtons[i].addActionListener(iceShowButtons);
      eastButtonsPanel.add(eastButtons[i]);
    }
  }

/*Method to initialize the "Pay Now" button and the panel where the button will be allocated*/
  private void createButtonPanel(){
    buttonPanel = new JPanel();
    button = new JButton();
    button.setText("Pay now");
    button.setFont(new Font("Broadway",Font.BOLD,20));
    button.addActionListener(iceShowButtons);
    buttonPanel.add(button);
  }

/*Method to initiliaze the field User from the IceShowWindow object
   * @param vip a boolean that represents with true if the user is VIP,
   * false if the user is not VIP*/
    public void setUser(boolean vip){
    user = new User();
    user.setVIP(vip);
  }

/*ConcertButtons class that implements the class ActionListener to add the action performed
   * when the buttons in the IceShowWindow are clicked*/
  public class IceShowButtons implements ActionListener{
    JButton button;

    /*Method to add the action when the button of the IceShowWindow is clicked
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
            button.setBackground(Color.cyan);
          }
          else if(button.getText().equals("$20.00")){
            button.setBackground(Color.magenta);
          }
          else if(button.getText().equals("$10.00")){
            button.setBackground(new Color(130,230,150));
          }
          double price = Double.parseDouble(button.getText().substring(1));
          user.seatQuantity--;
          user.totalPrice-=price;
        }
      }
    }
  }
}