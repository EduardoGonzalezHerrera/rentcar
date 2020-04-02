package lk.codelabs.rentcloud.model.entity.customer;

//import lombok.Data;

import javax.persistence.*;

import java.util.List;


/**
 * @author Krishantha Dinesh
 * krishantha@krishantha.com
 * www.krishantha.com
 * twitter @krishantha
 * on 14-October-2019 16:24
 * @Project rentcloudmodel
 */


@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String firstName;
    private String lastName;
    private String dlNumber;
    private String zipcode;
    @OneToMany(mappedBy = "customer")
    private List<Loyality> loyalities;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDlNumber() {
		return dlNumber;
	}
	public void setDlNumber(String dlNumber) {
		this.dlNumber = dlNumber;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public List<Loyality> getLoyalities() {
		return loyalities;
	}
	public void setLoyalities(List<Loyality> loyalities) {
		this.loyalities = loyalities;
	}
	
	public Customer() {}
	
	public Customer(String firstName, String lastName, String dlNumber, String zipcode,
			List<Loyality> loyalities) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dlNumber = dlNumber;
		this.zipcode = zipcode;
		this.loyalities = loyalities;
	}
    
	
    


}
