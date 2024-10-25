package hva.core;

//Exceptions
import hva.core.exception.UnrecognizedEntryException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    private Hotel _hotel;
  
    Parser(Hotel h) {
      _hotel = h;
    }
  
    public void parseFile(String filename) throws IOException, UnrecognizedEntryException {
      try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = reader.readLine()) != null)
          parseLine(line);
      } // catch (IOException, ) #DO wtong file name
    }
  
    private void parseLine(String line) throws UnrecognizedEntryException {
      String[] components = line.split("\\|");
      switch(components[0]) {
      case "ESPÉCIE" -> parseSpecies(components);
      case "ANIMAL" -> parseAnimal(components);
      case "ÁRVORE" -> parseTree(components);
      case "HABITAT" -> parseHabitat(components);
      case "TRATADOR" -> parseEmployee(components, "TRT");
      case "VETERINÁRIO" -> parseEmployee(components, "VET");
      case "VACINA" -> parseVaccine(components);
      default-> throw new UnrecognizedEntryException ("tipo de entrada inválido: " + components[0]);
      }
    }
  
    // Parse a line with format ANIMAL|id|nome|idEspécie|idHabitat
    private void parseAnimal(String[] components) throws UnrecognizedEntryException {
      try {
        String id = components[1];
        String name = components[2];
        String habitatId = components[4];
        String speciesId = components[3];
  
        _hotel.registerAnimal(id, name, habitatId, speciesId);
      } catch (Exception e) {
        throw new UnrecognizedEntryException("Invalid entry: " + e.getMessage());
      }
    }
  
    // Parse a line with format ESPÉCIE|id|nome
    private void parseSpecies(String[] components) throws UnrecognizedEntryException {
      try {
        String id = components[1];
        String name = components[2];
  
        _hotel.registerSpecies(id, name);
      } catch (Exception e) {
        throw new UnrecognizedEntryException("Invalid entry: " + e.getMessage());
      }
    }
    
    // Parse a line with format TRATADOR|id|nome|idHabitat1,...,idHabitatN or
    // VETERINÁRIO|id|nome|idEspécie1,...,idEspécieN
    private void parseEmployee(String[] components, String empType) throws UnrecognizedEntryException {
      try {
        String id = components[1];
        String name = components[2];
  
        _hotel.registerEmployee(id, name, empType);
  
        if (components.length == 4) {
          for(String responsibility : components[3].split(","))
            _hotel.addResponsibility(components[1], responsibility);
        }
      } catch (Exception e) {
        throw new UnrecognizedEntryException("Invalid entry: " + e.getMessage());
      }
    }
  
    // Parse a line with format VACINA|id|nome|idEspécie1,...,idEspécieN
    private void parseVaccine(String[] components) throws UnrecognizedEntryException{
      try {
        String id = components[1];
        String name = components[2];
        
        String[] speciesIds = components.length == 4 ? components[3].split(",") : new String[0];
        //Vaccine vaccine = new Vaccine(id, name);
        _hotel.registerVaccine(id, name, speciesIds);
      } catch (Exception e) {
        throw new UnrecognizedEntryException("Invalid entry: " + e.getMessage());
      }
    }
  
    // Parse a line with format ÁRVORE|id|nome|idade|dificuldade|tipo
    private void parseTree(String[] components) throws UnrecognizedEntryException {
      try {
        String id = components[1];
        String name = components[2];
        int age = Integer.parseInt(components[3]);
        int diff = Integer.parseInt(components[4]);
        String type = components[5];
        //String habitat = components[1];
      
  
        _hotel.createTree(id, name, type, age, diff);
      } catch (Exception e) {
        throw new UnrecognizedEntryException("Invalid entry: " + e.getMessage());
      }
    }
  
    // Parse a line with format HABITAT|id|nome|área|idÁrvore1,...,idÁrvoreN
    private void parseHabitat(String[] components) throws UnrecognizedEntryException {
      try {
        String id = components[1];
        String name = components[2];
        int area = Integer.parseInt(components[3]);
        Habitat hab = _hotel.registerHabitat(id, name, area);
        //só _hotel.registarHabitat(id, name, area);
  
        if (components.length == 5) {
          String[] listOfTree = components[4].split(",");
          //for(String treeKey : listOftrees){
          // FIX ME  }
        }
      } catch (Exception e) {
          throw new UnrecognizedEntryException("Invalid entry: " + e.getMessage());
      }
    }
  }