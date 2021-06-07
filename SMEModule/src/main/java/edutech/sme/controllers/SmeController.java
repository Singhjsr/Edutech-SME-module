package edutech.sme.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edutech.sme.dto.SmeDTO;
import edutech.sme.entities.Sme;
import edutech.sme.exception.SMEException;
import edutech.sme.models.Appointment;
import edutech.sme.models.SuccessInfo;
import edutech.sme.services.SmeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/sme")
public class SmeController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	SmeService s;
	Logger log = LoggerFactory.getLogger(SmeController.class);

	@ApiOperation(value = "show all SME", notes = "this api will show all the SMEs")
	@GetMapping("/list")
	public List<Sme> view() throws SMEException {
		List<Sme> sme = s.showAll();
		if (s.showAll().isEmpty()) {
			log.info("request for SME list that is empty");
			throw new SMEException("NO SME FOUND");
		}
		log.info("request for SME list");
		return sme;

	}

	@ApiOperation(value = "add new SME", notes = "this api will add new SME")
	@PostMapping("/add")
	public ResponseEntity<SuccessInfo> join(@ApiParam(value = "new sme data") @Valid @RequestBody SmeDTO smeDTO) {
		Sme sme = smeDTO.convertToSmeEntity();
		int id = s.add(sme);

		log.info("adding new SME to database");
		SuccessInfo info = new SuccessInfo("Added Successfully with id " + id, HttpStatus.OK);
		return new ResponseEntity<>(info, HttpStatus.OK);
	}

	@ApiOperation(value = "delete SME", notes = "this api will delete SME by id provided")
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<SuccessInfo> remove(@ApiParam(value = "id to remove data of SME") @PathVariable int id) {
		s.delete(id);
		log.info("deleting SME from database for id ");
		SuccessInfo info = new SuccessInfo("Deleted Successfully", HttpStatus.OK);
		return new ResponseEntity<>(info, HttpStatus.OK);

	}

	@ApiOperation(value = "sh0w SME detail by id", notes = "this api will show SME based on their id")
	@GetMapping("/{id}")
	public Sme viewById(@ApiParam(value = "id of SME") @PathVariable int id) throws SMEException {
		Sme sme = s.byId(id);
		if (sme == null) {
			log.info("no such SME with id ");
			throw new SMEException("NO SUCH ID FOUND");

		}
		log.info("finding and returning SME for id ");
		return sme;
	}

	@ApiOperation(value = "update SME", notes = "this api will update SME")
	@PutMapping("/modify/{id}")
	public ResponseEntity<SuccessInfo> update(
			@ApiParam(value = "SME data for updation") @Valid @RequestBody SmeDTO smeDTO, @PathVariable int id) {
		Sme sme = smeDTO.convertToSmeEntity();
		sme.setId(id);
		s.update(sme);
		log.info("updating SME");
		SuccessInfo info = new SuccessInfo("UPDATED Successfully", HttpStatus.ACCEPTED);
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);

	}

	@ApiOperation(value = "view appointment list", notes = "this api will return appointment list")
	@GetMapping("/appointment/list")
	public List<Appointment> getAllAppointments() throws SMEException {
		log.info("getAllAppointments method in controller called");
		try {

			return restTemplate.getForObject("http://edutech-appointment/appointment/list", List.class);
		} catch (Exception e) {
			throw new SMEException("Data retreived failed");

		}

	}

}
