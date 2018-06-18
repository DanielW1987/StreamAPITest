package com.waginator.model;

import java.time.LocalDate;
import java.util.*;

/**
 * User: DanielW
 * Date: 07.06.2018
 * Time: 12:13
 */

public class PersonRepository {
  ////////////////////// region Variables  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  private static Map<Long, Person> repository = new HashMap<>();
  // endregion
  ////////////////////// region Initialisation /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  static{
    Person p1 = new Person(1L, "Max Mustermann", 51_000_00, "Feuerwehr", Gender.MALE, LocalDate.of(1987, 4, 6), Arrays.asList("Hund", "Katze"));
    Person p2 = new Person(2L, "Erika Meier", 49_000_00, "Feuerwehr", Gender.FEMALE, LocalDate.of(1978, 6, 7), Arrays.asList("Micro-Schwein"));
    Person p3 = new Person(3L, "Bernd Becker", 68_000_00, "Feuerwehr", Gender.MALE, LocalDate.of(1964, 2, 21), new ArrayList<>());
    Person p4 = new Person(4L, "Hans Wurst", 70_000_00, "Arzt", Gender.MALE, LocalDate.of(1961, 11, 10), new ArrayList<>());
    Person p5 = new Person(5L, "Viktoria Müller", 43_000_00, "Arzt", Gender.FEMALE, LocalDate.of(1968, 9, 20), Arrays.asList("Hund"));
    Person p6 = new Person(6L, "Christiane Behrend", 65_000_00, "Arzt", Gender.FEMALE, LocalDate.of(1978, 7, 31), Arrays.asList("Katze"));
    Person p7 = new Person(7L, "Philipp Neumann", 55_000_00, "Polizei", Gender.MALE, LocalDate.of(1970, 5, 7), Arrays.asList("Hamster"));
    Person p8 = new Person(8L, "Paul Janke", 51_000_00, "Polizei", Gender.MALE, LocalDate.of(1975, 3, 1), Arrays.asList("Kaninchen", "Meerschweinchen"));
    Person p9 = new Person(9L, "Sebastian Frank", 32_000_00, "Polizei", Gender.MALE, LocalDate.of(1989, 1, 27), Arrays.asList("Schlange", "Spinne"));

    repository.put(p1.getId(), p1);
    repository.put(p2.getId(), p2);
    repository.put(p3.getId(), p3);
    repository.put(p4.getId(), p4);
    repository.put(p5.getId(), p5);
    repository.put(p6.getId(), p6);
    repository.put(p7.getId(), p7);
    repository.put(p8.getId(), p8);
    repository.put(p9.getId(), p9);

  }
  // endregion
  ////////////////////// region Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  public static Collection<Person> get(){
    return repository.values();
  }

  public static Person findById(Long id){
    return repository.get(id);
  }
  // endregion
  ////////////////////// region Inner Classes //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////// End of Class //////////////////////////////////////////////////////////////////////////////////////////////////////////////// endregion
}

