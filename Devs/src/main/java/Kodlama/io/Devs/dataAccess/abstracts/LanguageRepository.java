package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;


public interface LanguageRepository {
	
	void add(ProgrammingLanguage programmingLanguage) throws Exception;
    void update(ProgrammingLanguage programmingLanguage) throws Exception;
    void delete(ProgrammingLanguage programmingLanguage) throws Exception;
    List<ProgrammingLanguage> getAll();
    ProgrammingLanguage getId(int id) throws Exception;

}
