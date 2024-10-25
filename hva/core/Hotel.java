package hva.core;

import hva.core.exception.*;
import java.io.*;
import java.util.*;

public class Hotel implements Serializable {

  @Serial
  private static final long serialVerssionUID = 202407081733L;
  
  private Set <Habitat> _habitats;
  private Set <Tree> _trees;
  private Set <Animal> _animals;
  private Set <Vaccine> _vaccines;
  private Set <Employee> _employees;
  private Set <Species> _species;
  private Season _season;
  private Vaccination _vaccinations;


  public Hotel() {
      _animals = new TreeSet<Animal>();
      _species = new TreeSet<Species>();
      _habitats = new TreeSet<Habitat>();
      _employees = new TreeSet<Employee>();
      _trees = new TreeSet<Tree>();
      _vaccines = new TreeSet<Vaccine>();

      _season = Season.SPRING;
      _vaccinations = new Vaccination ();
  }

  //get methods
  public Season getSeason (){
    return _season;
  }

  public List<String> showAllAnimals() {
    List<String> animals = new ArrayList<>();
    for (Animal animal : _animals) {
        animals.add("ANIMAL|" + animal.getId() + "|" + animal.getName() + "|" + animal.getSpecies() + "|" + animal.getHealthHistory());
    }
    Collections.sort(animals);
    return animals;
  }

  public List<String> showAllVaccines() {
    List<String> vaccines = new ArrayList<>();
    for (Vaccine vaccine : _vaccines) {
        if (!vaccine.getSpecies().isEmpty()) {
            vaccines.add("VACINA|" + vaccine.getId() + "|" + vaccine.getName() + "|" + vaccine.getNumApplications() + "|" + String.join(",", vaccine.getSpecies()));
        }
        else {
            vaccines.add("VACINA|" + vaccine.getId() + "|" + vaccine.getName() + "|" + vaccine.getNumApplications());
        }

    }
    Collections.sort(vaccines);
    return vaccines;
  }

  public List<String> showAllHabitats() {
    List<String> habitats = new ArrayList<>();
    for (Habitat habitat : _habitats) {
      habitats.add("HABITAT|" + habitat.getId() + "|" + habitat.getName() + "|" + habitat.getArea() + "|" + habitat.getNumTrees());
    }
    Collections.sort(habitats);
    return habitats;
  }

  public List<String> showAllEmployees() {
    List<String> employees = new ArrayList<>();
    for (Employee employee : _employees) {
      if (!employee.getResponsabilities().isEmpty()) {
        employees.add(employee.getType() + "|" + employee.getId() + "|" + employee.getName() + "|" + String.join(",", employee.getResponsabilities()));
      }
      else {
        employees.add(employee.getType() + "|" + employee.getId() + "|" + employee.getName());
      } 
    }
    
    Collections.sort(employees);
    return employees;
  }


  public void skipSeason (){
    _season.skipSeason();
  }

  public void registerSpecies(String id, String name){
    Species species = new Species(id, name);
    _species.add(species);
  }

  public void registerEmployee(String id, String name, String type){
    if (type.equalsIgnoreCase("TRT")) {
      Zookeeper newZookeeper = new Zookeeper(id, name, type);
      _employees.add(newZookeeper);
    } 
    else if (type.equalsIgnoreCase("VET")) {
      Veterinarian veterinarian = new Veterinarian(type, id, name);
      _employees.add(veterinarian);
    }
  }

  public void registerVaccine(String id, String name, String[] species){
    //OUT of time TO FIX
    //List<String> species = Arrays.asList(speciesId); FIX ME
    //Vaccine vacina = new Vaccine(id, name, species);
    //_vaccines.add(vacina);
  }

  public Habitat registerHabitat(String id, String name, int area){
    Habitat habitat = new Habitat(id, name, area);
    _habitats.add(habitat);
    return habitat;
  }

  public void registerAnimal(String animalId, String name, String habitatId, String species){
    Animal animal = new Animal(animalId, name, species);
    _animals.add(animal);
    //add to habitat with id FIX ME
  }

  public Tree createTree(String id, String name, String type, int age, int diff){
    EvergreenTree tree = new EvergreenTree(id, name, age);
    _trees.add(tree);
    return tree;
  }

  public void addResponsibility(String idEmployee, String resp){
    //FIX ME RESp
    for (Employee employee : _employees) {
      if (employee.getId().equals(idEmployee)) {
          //employee.add(responsabilidade);
          //FIX ME Differ Respons species and hab
          return;
      }
    }
  }
  
  /**
   * Read text input file and create corresponding domain entities.
   * 
   * @param filename name of the text input file
   * @throws UnrecognizedEntryException if some entry is not correct
   * @throws IOException if there is an IO erro while processing the text file
   **/
  void importFile(String filename) throws UnrecognizedEntryException, IOException /* FIXME maybe other exceptions */  {
    Parser parser = new Parser(this);
    parser.parseFile(filename);
  }
}