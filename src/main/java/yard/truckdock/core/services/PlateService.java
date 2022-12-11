package yard.truckdock.core.services;

import org.hibernate.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yard.truckdock.core.dto.PlateDTO;
import yard.truckdock.core.entities.Plate;
import yard.truckdock.core.exceptions.PlateException;
import yard.truckdock.core.repositories.PlateRepository;
import yard.truckdock.core.validators.InformPlateValidator;

@Service
public class PlateService {

	@Autowired
	private PlateRepository plateRepository;

	@Transactional
	public PlateDTO insert(PlateDTO dto) throws Exception {
		Plate entityPlate = new Plate();
		final var plateFormatted = formatPlate(dto.getPlate());
		dto.setPlate(plateFormatted);
		if(!InformPlateValidator.validPlate(dto.getPlate())) {
			throw new PlateException("Informed plate is incorrect!");
		}
		entityPlate.setPlate(dto.getPlate());
		entityPlate = plateRepository.save(entityPlate);
		return new PlateDTO(entityPlate);
	}

	private String formatPlate(String plate) {
		return plate.toUpperCase().trim();
	}

	public PlateDTO findById(Long id) throws Exception {
		final var idPlate = plateRepository.findById(id);
		Plate entity = idPlate.orElseThrow(() -> new Exception("Placa com esse id não encontrada"));
		return new PlateDTO(entity);
	}
}
