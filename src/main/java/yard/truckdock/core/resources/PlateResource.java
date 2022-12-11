package yard.truckdock.core.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import yard.truckdock.core.dto.PlateDTO;
import yard.truckdock.core.services.PlateService;

@RestController
@RequestMapping(value = "/plate")
public class PlateResource {

	@Autowired
	private PlateService plateService;
	
	@PostMapping
	public ResponseEntity<PlateDTO> insert(@RequestBody PlateDTO dto) throws Exception {
		dto = plateService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PlateDTO> find(@PathVariable Long id) throws Exception {
		final var dto = plateService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
