package yard.truckdock.core.dto;

import java.io.Serializable;

import yard.truckdock.core.entities.Plate;

public class PlateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String plate;


	public PlateDTO() {
	}

	public PlateDTO(Long id, String plate) {
		this.id = id;
		this.plate = plate;
	}

	public PlateDTO(Plate plate) {
		this.id = plate.getId();
		this.plate = plate.getPlate();
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Long getId() {
		return id;
	}
}
