package com.waginator;

import com.waginator.model.Gender;
import com.waginator.model.Person;
import com.waginator.model.PersonRepository;
import org.junit.Test;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

/**
 * User: DanielW
 * Date: 07.06.2018
 * Time: 14:01
 * <p>
 * Copyright LucaNet AG
 */

public class _3TerminalOperationsTest {
  ////////////////////// region Variables  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  private static Collection<Person> persons = PersonRepository.get();
  // endregion
  ////////////////////// region Initialisation /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // endregion
  ////////////////////// region Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Test
  public void match(){

    boolean result = false;

    // Gibt es mind. 1 Person, die mehr als 70K im Jahr verdient?
    result = persons.stream()
                    .anyMatch(person -> person.getGrossSalaryPerYear() > 70_000_00);

    System.out.println("Gibt es mind. 1 Person, die mehr als 70K im Jahr verdient: " + result);

    // Verdienen alle Personen 40K oder mehr im Jahr?
    result = persons.stream()
                    .allMatch(person -> person.getGrossSalaryPerYear() >= 40_000_00);

    System.out.println("Verdienen alle Personen 40K oder mehr im Jahr: " + result);

    // Verdient keiner mehr als 80K im Jahr?
    result = persons.stream()
                    .noneMatch(person -> person.getGrossSalaryPerYear() > 80_000_00);

    System.out.println("Verdient keiner mehr als 80K im Jahr: " + result);

  }

  @Test
  public void count(){
    // Wie viele Personen verdienen 50K oder mehr?
    long count = persons.stream()
                        .filter(person -> person.getGrossSalaryPerYear() > 50_000_00)
                        .count();

    System.out.println(count + " Personen verdienen 50K oder mehr im Jahr!");
  }

  @Test
  public void find(){
    /*
     * findAny()
     * As the name suggests, the findAny() method allows you to find any element from a Stream.
     * Use it when you are looking for an element without paying an attention to the encounter order.
     * In a non-parallel operation, it will most likely return the first element in the Stream but
     * there is no guarantee for this.
     */
    // Finde irgendeinen männlichen Polizisten
    Person person1 = persons.stream()
                            .filter(p ->    p.getGender() == Gender.MALE
                                         && p.getJobTitle().equals("Polizei"))
                            .findAny()
                            .get();

    System.out.println(person1);

    /*
     * findFirst()
     * When there is no encounter order it returns any element from the Stream.
     * Streams may or may not have a defined encounter order. It depends on the
     * source and the intermediate operations.
     */
    // Finde die erste Frau
    Person person2 = persons.stream()
                            .filter(p -> p.getGender() == Gender.FEMALE)
                            .findFirst()
                            .get();

    System.out.println(person2);

  }

  @Test
  public void minMax(){

    // Älteste Person
    Optional<Person> oldestPerson = persons.stream()
                                           .min(Comparator.comparing(Person::getBirthday));

    System.out.println("Oldest person is: " + oldestPerson.get() );

    // Jüngste Person
    Optional<Person> youngestPerson = persons.stream()
                                             .max(Comparator.comparing(Person::getBirthday));

    System.out.println("Youngest person is: " + youngestPerson.get() );

  }

  @Test
  public void reduce(){
    // Komma-separierte Liste der Namen aller Personen, die im Jahr 1975 oder später geboren sind
    String names = persons.stream()
                          .filter(person -> person.getBirthday().getYear() >= 1975 )
                          .map(person -> person.getName())
                          .reduce( ( s1, s2 ) -> s1 + ", " + s2 )
                          .get();

    System.out.println(names);

  }

  @Test
  public void toArray(){

    // Alle Männer in einem Array
    Object[] malePersons = persons.stream()
                                  .filter( p -> p.getGender() == Gender.MALE)
                                  .toArray();

    for( Object person : malePersons ){
      System.out.println(person);
    }

  }

  // endregion
  ////////////////////// region Inner Classes //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////// End of Class //////////////////////////////////////////////////////////////////////////////////////////////////////////////// endregion
}

