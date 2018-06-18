package com.waginator;

import com.waginator.model.Person;
import com.waginator.model.PersonRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: DanielW
 * Date: 07.06.2018
 * Time: 12:16
 * <p>
 * Copyright LucaNet AG
 */

public class _1HandsOn {
  ////////////////////// region Variables  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // endregion
  ////////////////////// region Initialisation /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // endregion
  ////////////////////// region Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  public static void main(String... args){

    System.out.println("The Java 7 Way");
    theJava7Way();

    System.out.println("The Java 8 Way");
    theJava8Way();

  }

  private static void theJava7Way(){

    List<Person> resultList = new ArrayList<>();
    for(Person person : PersonRepository.get()){

      if(    person.getJobTitle().equals("Feuerwehr")
          && person.getGrossSalaryPerYear() > 50_000_00 ){
        resultList.add(person);
      }
    }

    Collections.sort(resultList);

    for(Person person : resultList){
      System.out.println(person);
    }

  }

  private static void theJava8Way(){

    PersonRepository.get()
                    .stream()
                    .filter(person -> person.getJobTitle().equals("Feuerwehr"))
                    .filter(person -> person.getGrossSalaryPerYear() > 50_000_00)
                    .sorted()
                    .forEach(System.out::println);

  }

  // endregion
  ////////////////////// region Inner Classes //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////// End of Class //////////////////////////////////////////////////////////////////////////////////////////////////////////////// endregion
}

