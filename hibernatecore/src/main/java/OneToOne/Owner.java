package OneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="owner_data")
public class Owner {
	@Id
	@Column(name="owner_id")
	private int id;
	private String name;
	private String address;
	@OneToOne(mappedBy = "ownerName")
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicleName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Vehicle getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(Vehicle vehicleName) {
		this.vehicleName = vehicleName;
	}
	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", address=" + address + ", vehicleName=" + vehicleName + "]";
	}
	
	
}
