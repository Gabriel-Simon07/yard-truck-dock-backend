package yard.truckdock.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yard.truckdock.core.dto.PlateDTO;
import yard.truckdock.core.entities.Plate;
import yard.truckdock.core.repositories.PlateRepository;
import yard.truckdock.core.validators.InformPlateValidator;

@Service
public class PlateService {

	@Autowired
	private PlateRepository plateRepository;

	@Transactional
	public PlateDTO insert(PlateDTO dto) throws Exception {
		Plate entityPlate = new Plate();
		final var value = plateRepository.findById(dto.getId());
		if(dto.getPlate().equals(value)) {
			throw new Exception("Informed plate exists!");
		}

		if(!InformPlateValidator.validPlate(dto.getPlate())) {
			throw new Exception("Informed plate is incorrect!");
		}
		entityPlate.setPlate(dto.getPlate());
		entityPlate = plateRepository.save(entityPlate);
		return new PlateDTO(entityPlate);
	}

}
