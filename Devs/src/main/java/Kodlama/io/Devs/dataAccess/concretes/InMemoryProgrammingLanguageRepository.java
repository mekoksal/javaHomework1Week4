package Kodlama.io.Devs.dataAccess.concretes;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements LanguageRepository{

	List<ProgrammingLanguage> languageList;
	
	@Autowired
	public InMemoryProgrammingLanguageRepository() {
		languageList = new ArrayList<ProgrammingLanguage>();
		languageList.add(new ProgrammingLanguage(1,"C#"));
		languageList.add(new ProgrammingLanguage(2,"Java"));
		languageList.add(new ProgrammingLanguage(3,"Python"));
		
		
	}

	
	
	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		for (ProgrammingLanguage programmingLanguageToAdd :languageList) {
            if (programmingLanguageToAdd.getName().equalsIgnoreCase(programmingLanguage.getName()))
                throw new Exception("Bu isimde bir programlama dili mevcut.");
            else if (programmingLanguageToAdd.getId()==programmingLanguage.getId())
                throw new Exception(MessageFormat.format("Bu index kullaniliyor. Siradaki index: {0}. ", languageList.size()+1));
        }
       languageList.add(programmingLanguage);
		
	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) throws Exception {
		for (ProgrammingLanguage programmingLanguageToDelete : languageList) {
            if (programmingLanguage.getId()==programmingLanguageToDelete.getId() ||
                    programmingLanguage.getName().equalsIgnoreCase(programmingLanguageToDelete.getName())){
                languageList.remove(programmingLanguageToDelete);
                break;
            }
            if (programmingLanguageToDelete.getId()==languageList.size() && (programmingLanguageToDelete.getId()!=(programmingLanguage.getId())
                    || !programmingLanguageToDelete.getName().equals(programmingLanguage.getName())))
                throw new Exception("Böyle bir kayıt bulunamadı.");
        }
		
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		for (ProgrammingLanguage programmingLanguageToUpdate : languageList) {
            if (programmingLanguageToUpdate.getName().equalsIgnoreCase(programmingLanguage.getName()))
                throw new Exception("Bu isimde bir programlama dili mevcut.");
            if (programmingLanguageToUpdate.getId() == programmingLanguage.getId())
                programmingLanguageToUpdate.setName(programmingLanguage.getName());
            else
                throw new Exception("Böyle bir kayıt bulunamadı.");
        }
		
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return languageList;
	}

	@Override
	public ProgrammingLanguage getId(int id) throws Exception {
		 for (ProgrammingLanguage programmingLanguage : languageList) {
	            if (programmingLanguage.getId() == id)
	                return programmingLanguage;
	        }
	        throw new Exception("Bu Id'ye sahip bir dil bulunamadi.");
	}

}
