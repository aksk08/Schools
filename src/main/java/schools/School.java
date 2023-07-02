package schools;

import java.util.HashMap;
import java.util.Map;

/*
Na podstawie struktury klas uczniów w szkolę napisz mechanizm,
który zwróci wszystkich uczniów danej szkoły.

Każda szkoła zawierać ma mapę klas szkolnych (klucz to nazwa klasy, wartość to obiekt Klasa),
a każda klasa szkolna powinna zawierać listę uczniów.

-> bonusowo - testy (np. że zwraca poprawnie listę wszystkich uczniów)
 */
public class School {
    private String name;
    private Map<String, SchoolClass> schoolClasses;
    public School(String name){
        this.name = name;
        this.schoolClasses = new HashMap<>(); // a jeśli nie dodałabym teh cechy w konstruktorze?
    }
    public String getName(){
        return name;
    }
    public boolean addClass(SchoolClass classToAdd){
        String schoolClassName = classToAdd.getSchoolClassName();
        if(schoolClasses.containsKey(schoolClassName)){
            System.out.println("This class already exist in the school. Propose different name to add class to a base.");
            return false;
        }
        else{
            this.schoolClasses.put(schoolClassName, classToAdd);
            return true;
        }
    }
    public boolean removeClass(SchoolClass existingClass){
        String className = existingClass.getGradeLevel();
        if(schoolClasses.containsKey(className)){
            this.schoolClasses.remove(existingClass);
            return true;
        }
        else{
            System.out.println("Class either not exist or already removed.");
            return false;
        }
    }
    public Map<String, SchoolClass> getSchoolClasses(){
        return new HashMap<>();
    }

    public int getHeadcount(Map<String, SchoolClass> schoolClasses) {  // zamienić na iterację po values()?
        int headcount = 0;
        for(Map.Entry<String, SchoolClass> entry : schoolClasses.entrySet()){
            SchoolClass klasa = entry.getValue();
            headcount = klasa.getClassGroup().size();
        }
        return headcount;
    }
    public Map<String, Integer> getEachClassHeadcount(Map<String, SchoolClass> schoolClasses){
        Map<String, Integer> listOfClasses = null; //InteliiJ wymusił inicjalizację null - mogę to inaczej rozwiązać?
        for(Map.Entry<String, SchoolClass> entry : schoolClasses.entrySet()){
            String className = entry.getKey();
            int classHeadcount = entry.getValue().getClassGroup().size();
            listOfClasses.put(className, classHeadcount);
        }
        return listOfClasses;
    }
    public void print(){
        for(Map.Entry<String, SchoolClass> entry : schoolClasses.entrySet()){
            System.out.println("Class " + entry.getKey() + " " + entry.getValue().getGradeLevel()
                    + " | number of pupils: " + entry.getValue().getClassGroup().size());
        }
    }
}