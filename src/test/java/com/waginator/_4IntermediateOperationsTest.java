package com.waginator;

import com.waginator.model.Gender;
import com.waginator.model.Person;
import com.waginator.model.PersonRepository;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * User: DanielW
 * Date: 07.06.2018
 * Time: 14:02
 */

public class _4IntermediateOperationsTest {
  ////////////////////// region Variables  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  private static Collection<Person> persons = PersonRepository.get();
  // endregion
  ////////////////////// region Initialisation /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // endregion
  ////////////////////// region Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Test
  public void lazyStream1(){

    System.out.println("Nothing is printed to the console");
    Stream<String> stringStream = Stream.of("d2", "a2", "b1", "b3", "c")
                                        .filter(s -> {
                                            System.out.println("element: " + s);
                                            return s.startsWith("d");
                                        });

    System.out.println("Now it works!");
    stringStream.forEach(System.out::println);

  }

  @Test
  public void lazyStream2(){

    // Stream evaluates lazy!
    persons.stream()
           .peek(person -> System.out.println("Output from peek: " + person))
           .limit(1)
           .forEach(System.out::println);

  }

  @Test
  public void filter(){

    /*
     * Gesucht sind: Alle Frauen, die vor 1970 geboren sind
     * (Verknüpfung von Predicate)
     */
    Predicate<Person> filterPredicate = person -> person.getGender() == Gender.FEMALE;
    filterPredicate                   = filterPredicate.and( person -> person.getBirthday().getYear() < 1970 );

    persons.stream()
           .filter(filterPredicate)
           .forEach(System.out::println);

  }

  @Test
  public void skipAndLimit(){

    List<Integer> collect = Stream.iterate(2, i -> i * 2)
                                  .skip(3)  // skip 2, 4, 8 (3)
                                  .limit(5) // limit to 5 elements: 16, 32, 64, 128, 256 (5)
                                  .collect(Collectors.toList());
    System.out.println(collect);
  }

  @Test
  public void map(){
    // Bekannt sind nur die IDs von ausgewählten Personen
    Long[] personIDs = {1L, 3L, 6L, 8L};

    // Die Person-Objekte sollen in einem Stream verarbeitet werden.
    Stream.of(personIDs)
          .map(id -> PersonRepository.findById(id))
        //.map(PersonRepository::findById)
          .forEach(System.out::println);

  }

  @Test
  public void mapToPrimitiveDouble(){
    // Durchnittsgehalt aller Personen, die bei der Feuerwehr arbeiten
    OptionalDouble averageSalary = persons.stream()
                                          .filter(person -> person.getJobTitle().equals("Feuerwehr"))
                                          .mapToDouble(person -> person.getGrossSalaryPerYear() / 100.0)
                                          .average();

    if(averageSalary.isPresent()){
      System.out.println("Average salary: " + averageSalary);
    }
    else{
      System.out.println("Cannot calculate the average salary.");
    }
  }

  @Test
  public void distinct(){
    // Wie viele unterschiedliche Berufe gibt es?
    long count = persons.stream()
                        .map(person -> person.getJobTitle())
                        .distinct()
                        .peek(System.out::println)
                        .count();

    System.out.println(count + " unterschiedliche Berufe!");
  }

  @Test
  public void flatMap(){
    // FlatMap transforms each element of the stream into a stream of other objects
    List<Integer> list1 = Arrays.asList(1, 2, 3);
    List<Integer> list2 = Arrays.asList(4, 5, 6);
    List<Integer> list3 = Arrays.asList(7, 8, 9);
    List<List<Integer>> allLists = Arrays.asList(list1, list2, list3);

    allLists.stream()
            //.flatMap(list -> list.stream())
            .forEach(System.out::println);
  }

  @Test
  public void flatMap2(){

    // Alle möglichen Haustiere ohne Duplikate
    persons.stream()
           .flatMap(person -> person.getPets().stream())
           .distinct()
           .forEach(System.out::println);

  }

  @Test
  public void sorted(){
    // Alle Personen nach Namen sortieren
    persons.stream()
           .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
           //.sorted(Comparator.comparing(Person::getName))
           .forEach(System.out::println);
  }

  // endregion
  ////////////////////// region Inner Classes //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////// End of Class //////////////////////////////////////////////////////////////////////////////////////////////////////////////// endregion
}

