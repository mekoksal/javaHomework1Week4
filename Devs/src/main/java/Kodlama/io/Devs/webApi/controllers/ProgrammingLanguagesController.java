package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController //annotation
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService languageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService languageService) {
		this.languageService = languageService;
	}
	
	 @PostMapping("add")
	    public void add(ProgrammingLanguage programmingLanguage) throws Exception{
	        languageService.add(programmingLanguage);
	    }
	    @PutMapping("update")
	    public void update(ProgrammingLanguage programmingLanguage) throws Exception{
	        languageService.update(programmingLanguage);
	    }
	    @DeleteMapping("delete")
	    public void delete(ProgrammingLanguage programmingLanguage) throws Exception{
	        languageService.delete(programmingLanguage);
	    }
	    @GetMapping("/getall")
	    public List<ProgrammingLanguage> getAll(){
	        return languageService.getAll();
	    }
	    @GetMapping("getbyid")
	    public ProgrammingLanguage getId(int id) throws Exception {
	        return languageService.getId(id);
	    }
	

}
