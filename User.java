/** An object named User represents the user of ticket system
* stores values for total price, determines whether user is VIP based 
on the seat quantity selected.
*@author Gerardo Muela
*@author Guillermo Ramirez
*@author Carlos Herrera
*@author Alejandro Berlanga
*/
public class User {
  /*To hold total number of seats selected*/
  public int seatQuantity;
  /*To hold the value of the total calculated price*/
  public double totalPrice;
  /* To indicate wheter user is VIP or not*/
  private boolean vip;
  /*Method to determine whether user is eligible for 10% discount
  according to quantity of seats purchased (>5)*/
  public void discount(){
    if(seatQuantity > 5 && this.vip==false) { 
      this.totalPrice -=(this.totalPrice*.10);
    } 
    else if(this.vip){
      this.totalPrice -= (this.totalPrice * .20);
    }
  }
  /*Method to store true/false value determined by whether or not
  user checks 'VIP' checkbox in the main event window*/
  public void setVIP(boolean vip){
    this.vip = vip;
  }
}