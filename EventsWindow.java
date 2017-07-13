import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/** An object named EventsWindow, which it
  * initializes a GUI of the main window
  * for the users to select the event they
  * will like to attend and if they are a VIP
  * or a regular user.
  * @author Gerardo Muela
  * @author Guillermo Ramirez
  * @author Carlos Herrera
  * @author Alejandro Berlanga
  */
public class EventsWindow extends JFrame{
  public GameWindow game;
  public IceShowWindow iceShow;
  public ConcertWindow concert;
  private JPanel labelPanel; 
  private JPanel buttonPanel;
  private JLabel label;
  private JButton gameButton;
  private JButton iceShowButton;
  private JButton concertButton;
  private JPanel vipPanel;
  private JCheckBox vipButton;
  /*Constructor of the EventsWindow class to initiliaze all its fields*/
  public EventsWindow(){
    setTitle("Seating Chart");
    setSize(300,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    createLabelPanel();
    createButtonPanel();
    createVIPPanel();
    add(vipPanel,BorderLayout.SOUTH);
    add(labelPanel,BorderLayout.NORTH);
    add(buttonPanel,BorderLayout.CENTER);
    setVisible(true);
  }
  /*Method to initialize the VIP check box and the panel where the check box will be allocated*/
  private void createVIPPanel(){
    vipPanel = new JPanel();
    vipButton = new JCheckBox("Are you VIP?");
    vipPanel.add(vipButton);
  }
  /*Method to initialize the "Select Event" label and the panel where the label will be allocated*/
  private void createLabelPanel(){
    labelPanel = new JPanel();
    label = new JLabel("Select Event:");
    labelPanel.add(label);
  }
  /*Method to initialize the buttons to select the event and the panel where the button will be allocated*/
  private void createButtonPanel(){
    buttonPanel = new JPanel();
    gameButton = new JButton("Game");
    iceShowButton = new JButton("Ice Show");
    concertButton = new JButton("Concert");
    EventsButtons eventsButtons = new EventsButtons();
    buttonPanel.add(gameButton);
    gameButton.addActionListener(eventsButtons);
    buttonPanel.add(iceShowButton);
    iceShowButton.addActionListener(eventsButtons);
    buttonPanel.add(concertButton);
    concertButton.addActionListener(eventsButtons);
  }
  /*ConcertButtons class that implements the class ActionListener to add the action performed
   * when the buttons in the EventsWindow are clicked*/
  public class EventsButtons implements ActionListener{
    /*Method to add the action when a button of the EventsWindow is clicked
     * @param ActionEvent click on a JButton object*/
    public void actionPerformed(ActionEvent e){
      if(e.getSource().equals(gameButton)){
        game = new GameWindow();
        if(vipButton.isSelected()){
          game.setUser(true);
        }
        else
          game.setUser(false);
        setVisible(false);
        dispose();
      }
      else if(e.getSource().equals(iceShowButton)){
        iceShow = new IceShowWindow();
        if(vipButton.isSelected()){
          iceShow.setUser(true);
        }
        else
          iceShow.setUser(false);
        setVisible(false);
        dispose();
      }
      else if(e.getSource().equals(concertButton)){
        concert = new ConcertWindow();
        if(vipButton.isSelected()){
          concert.setUser(true);
        }
        else
          concert.setUser(false);
        setVisible(false);
        dispose();
      }
    }
  }
}