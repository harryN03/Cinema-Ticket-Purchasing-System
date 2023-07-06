import java.util.ArrayList;

public class Customer extends User {
    private String firstName;
    private String lastName;
    private ArrayList<Ticket> tickets;

    public Customer(String username, String userPassword, String firstName, String lastName) {
        super(username, userPassword);
        this.firstName = firstName;
        this.lastName = lastName;
        this.tickets = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Ticket> displayTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void buyTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    public double getTicketPrice(String ticketID) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == ticketID) {
                return ticket.price;
            }
        }
        return -1; // return -1 if no matching ticket is found
    }
}
