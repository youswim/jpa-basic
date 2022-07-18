package chap5page1;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AddressHistory {

    @Id
    @GeneratedValue
    private Long id;

    private Address address;

    public AddressHistory(String city, String street, String zipcode) {
        this.address = new Address(city, street, zipcode);
    }

    public AddressHistory(Long id, Address address) {
        this.id = id;
        this.address = address;
    }
}
