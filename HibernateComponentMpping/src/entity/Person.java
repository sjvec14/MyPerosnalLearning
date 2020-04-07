
package entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="add_street") ),
		@AttributeOverride(name="city", column=@Column(name="add_city") ),
		@AttributeOverride(name="zipcode", column=@Column(name="add_zipcode") )
	})
	private Address address;
	
	public Person() {}	
	public Person(String name, Address address) {
		this.name = name;
		this.address = address;
	}
	
}
















