import java.util.*;

public class Lottery{
  private Set<Integer> winningTicket;
  private Set<Integer> ticket;
  int winnings;

  public final MAX = 30;
  public final MIN = 1;
  public final N = 6;

  /**
    * Default constructor calls method to initialize winningTicket
    *
    */
    public Lottery(){
      this.winnings = 0;
    }

    public Set<Integer> generateTicket(){
      Set<Integer> ticket = new TreeSet<>();

      while (ticket.size() < N){
          ticket.add((int)(Math.random()*(MAX - MIN + 1) + MIN));
      }

      return ticket;

    }

    public getUserTicket(String type){
      // user can use a random ticket
      if (type.equals("random")){
        this.ticket = generateTicket();
        return;
      }
      // user can enter their numbers manually
      Scanner in = new Scanner(System.in);

    }

  public static void main(String[] args){

  }



}
