package lk.codelabs.rentcloud.model.dto.customer;

import java.util.List;
import lk.codelabs.rentcloud.model.entity.customer.Loyality;

public class CustomerDTO {

	private int id;
    private String firstName;
    private String lastName;
    private String dlNumber;
    private String zipcode;
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
	
	public CustomerDTO() {}
	
	public CustomerDTO(int id, String firstName, String lastName, String dlNumber, String zipcode,
			List<Loyality> loyalities) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dlNumber = dlNumber;
		this.zipcode = zipcode;
		this.loyalities = loyalities;
	}
	
    
    
    
}
