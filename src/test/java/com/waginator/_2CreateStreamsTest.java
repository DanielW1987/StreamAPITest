package com.waginator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * User: DanielW
 * Date: 07.06.2018
 * Time: 13:54
 * <p>
 * Copyright LucaNet AG
 */
public class _2CreateStreamsTest {

  @Test
  public void createStreamOfT(){
    Stream<String> stringStream = Stream.of("Hallo", "Welt", "!" );
    stringStream.forEach(string -> System.out.println(string));
  }

  @Test
  public void createStreamOfArray(){
    Long[] longs = {1L, 2L, 3L, 4L, 5L};
    Stream<Long> longStream = Stream.of(longs);
    longStream.forEach(longElement -> System.out.print(longElement));
  }

  @Test
  public void createStreamOnCollection(){
    List<String> stringList = new ArrayList<>();
    stringList.add("Tick");
    stringList.add("Trick");
    stringList.add("Track");

    stringList.stream()
              .forEach(e -> System.out.println(e));
  }

  @Test
  public void generateStream(){

    Supplier<UUID> uuidSupplier = () -> UUID.randomUUID();
    Stream<UUID> uuidStream = Stream.generate(uuidSupplier);

    // inifinite stream
    uuidStream.forEach( uuid -> System.out.println(uuid) );

  }

  @Test
  public void iterateStream(){

    Stream<Integer> infiniteStream = Stream.iterate(0, i -> i + 2);

    // also infinite stream
    infiniteStream.forEach( i -> System.out.println(i));

  }
}