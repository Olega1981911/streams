package task5;

import java.time.LocalDate;
import java.util.Objects;


public class Booking {
    private Long bookingID;
    private LocalDate bookingDate;
    private Status status;
    private Client nameClient;
    private Product product;

    public Booking(Long bookingID, LocalDate bookingDate, Status status, Client nameClient, Product product) {
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
        this.status = status;
        this.nameClient = nameClient;
        this.product = product;
    }

    public Long getBookingID() {
        return bookingID;
    }

    public void setBookingID(Long bookingID) {
        this.bookingID = bookingID;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Client getNameClient() {
        return nameClient;
    }

    public void setNameClient(Client nameClient) {
        this.nameClient = nameClient;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingID, booking.bookingID) && Objects.equals(bookingDate, booking.bookingDate) && status == booking.status && Objects.equals(nameClient, booking.nameClient) && Objects.equals(product, booking.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingID, bookingDate, status, nameClient, product);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Booking: ");
        sb.append("ID = ").append(bookingID).append(", дата :").append(bookingDate).append(", статус : ").append(status).append(", ").append(nameClient).append(", ").append(product);
        return sb.toString();
    }
}
