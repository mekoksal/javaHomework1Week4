package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private LanguageRepository languageRepository;
	
	@Autowired
	public ProgrammingLanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	
	
	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		if(programmingLanguage.getName().equals(""))
            throw new Exception("İsim boş geçilemez.");
        languageRepository.add(programmingLanguage);
		
	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) throws Exception {
		languageRepository.delete(programmingLanguage);
		
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		if(programmingLanguage.getName().equals(""))
            throw new Exception("İsim boş geçilemez.");
        languageRepository.update(programmingLanguage);
		
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getId(int id) throws Exception {
		// TODO Auto-generated method stub
		 return languageRepository.getId(id);
	}

}
