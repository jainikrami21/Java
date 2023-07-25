package OneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicle_data")
public class Vehicle {
	@Id
	@Column(name="vehicle_id")
	private int id;
	@Column(name="vehicle_name")
	private String model;
	@OneToOne
	@JoinColumn(name = "owner_id")
	private Owner ownerName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Owner getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(Owner ownerName) {
		this.ownerName = ownerName;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", model=" + model + ", ownerName=" + ownerName + "]";
	}
	
	
}
