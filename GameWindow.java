import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*An object named GameWindow which
*initializes a GUI of the Game event seats 
* and court for the user to select the seats
* they want to purchase
* @author Gerardo Muela
* @author Guillermo Ramirez
* @author Carlos Herrera
* @author Alejandro Berlanga
*/

public class GameWindow extends JFrame{
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
  private GameButtons gameButtons = new GameButtons();
  public User user;
  /*Constructor of the GameWindow class to initialize all the fields*/
  public GameWindow(){
    setTitle("Game Window");
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
  /*Method to intialize a panel and buttons representing the north seating section
  /*Seat price determined by the distance from the court*/
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
        northButtons[i].setBackground(Color.green);
      }
      else if(i >= 10 && i < 20){
        northButtons[i].setText("$20.00");
        northButtons[i].setBackground(Color.orange);
      }
      else if(i >= 0 && i < 10){
        northButtons[i].setText("$10.00");
        northButtons[i].setBackground(Color.yellow);
      }
      northButtons[i].addActionListener(gameButtons);
      northButtonsPanel.add(northButtons[i]);
    }
  }
  /*Method to intialize a panel and buttons representing the south seating section*/
  /*Seat price determined by the distance from the court*/
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
        southButtons[i].setBackground(Color.green);
      }
      else if(i >= 10 && i < 20){
        southButtons[i].setText("$20.00");
        southButtons[i].setBackground(Color.orange);
      }
      else if(i >= 20 && i < 30){
        southButtons[i].setText("$10.00");
        southButtons[i].setBackground(Color.yellow);
      }
      southButtons[i].addActionListener(gameButtons);
      southButtonsPanel.add(southButtons[i]);
    }
  }
  /*Method to intialize a panel and buttons representing the west seating section*/
  /*Seat price determined by the distance from the court*/
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
        westButtons[i].setBackground(Color.green);
      }
      else if(i%3==1){
        westButtons[i].setText("$20.00");
        westButtons[i].setBackground(Color.orange);
      }
      else if(i%3==0){
        westButtons[i].setText("$10.00");
        westButtons[i].setBackground(Color.yellow);
      }
      westButtons[i].addActionListener(gameButtons);
      westButtonsPanel.add(westButtons[i]);
    }
  }
  /*Method to intialize a panel and buttons representing the east seating section*/
  /*Seat price determined by the distance from the court*/
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
        eastButtons[i].setBackground(Color.green);
      }
      else if(i%3==1){
        eastButtons[i].setText("$20.00");
        eastButtons[i].setBackground(Color.orange);
      }
      else if(i%3==2){
        eastButtons[i].setText("$10.00");
        eastButtons[i].setBackground(Color.yellow);
      }
      eastButtons[i].addActionListener(gameButtons);
      eastButtonsPanel.add(eastButtons[i]);
    }
  }
  /*Method to initialize "Pay now" button and panel*/
  private void createButtonPanel(){
    buttonPanel = new JPanel();
    button = new JButton();
    button.setText("Pay now");
    button.setFont(new Font("Broadway",Font.BOLD,20));
    button.addActionListener(gameButtons);
    buttonPanel.add(button);
  }
 /*Method to initiliaze the field User from the ConcertWindow object
   * @param vip a boolean that represents with true if the user is VIP,
   * false if the user is not VIP*/
    public void setUser(boolean vip){
    user = new User();
    user.setVIP(vip);
  }
  /*GamesButtons class that implements the class ActionListener to add the action performed
   * when the buttons in the GameWindow are clicked*/
  public class GameButtons implements ActionListener{
    JButton button;
    /*Method to add the action when the button of the GameWindow is clicked
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
            button.setBackground(Color.orange);
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