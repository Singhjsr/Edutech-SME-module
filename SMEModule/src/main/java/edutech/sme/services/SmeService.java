package edutech.sme.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edutech.sme.dao.SmeRepository;
import edutech.sme.entities.Sme;


@Service("smeService")
public class SmeService {
	Logger log=LoggerFactory.getLogger(SmeService.class);
	
	@Autowired
	SmeRepository smeRepo;
	
	
	public void delete(int id) {
		log.info("delete method called");
		smeRepo.deleteById(id);
	}
	
	public List<Sme> showAll(){
		log.info("showAll method called");
		return smeRepo.findAll();
		
	}
	public int add(Sme s){
		log.info("add method called");
		return smeRepo.save(s).getId();
		
	
		}
	
	public Sme byId(int i){
		log.info("findById method called");
		return smeRepo.findById(i).orElse(null);
		
	}
	
	public void update(Sme s){
		log.info("update method called");
		smeRepo.save(s);
		
	}
	

}
