package com.waginator.model;

import java.time.LocalDate;
import java.util.List;

/**
 * User: DanielW
 * Date: 07.06.2018
 * Time: 12:07
 */

public class Person implements Comparable<Person>{
  ////////////////////// region Variables  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  private Long         id;
  private String       name;
  private long         grossSalaryPerYear;
  private String       jobTitle;
  private Gender       gender;
  private LocalDate    birthday;
  private List<String> pets;
  // endregion
  ////////////////////// region Initialisation /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public Person(Long id, String name, long grossSalaryPerYear, String jobTitle, Gender gender, LocalDate birthday, List<String> pets) {
    this.id                 = id;
    this.name               = name;
    this.grossSalaryPerYear = grossSalaryPerYear;
    this.jobTitle           = jobTitle;
    this.gender             = gender;
    this.birthday           = birthday;
    this.pets               = pets;
  }

  // endregion
  ////////////////////// region Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public long getGrossSalaryPerYear() {
    return grossSalaryPerYear;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public Gender getGender(){
    return gender;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  @Override
  public int compareTo(Person o) {
    return this.birthday.compareTo(o.birthday);
  }

  public List<String> getPets() {
    return pets;
  }

  @Override
  public String toString(){
    return this.id + " " + this.name + "(" + this.jobTitle + ", " + this.grossSalaryPerYear + ", " + this.birthday + ")";
  }

  // endregion
  ////////////////////// region Inner Classes //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////// End of Class //////////////////////////////////////////////////////////////////////////////////////////////////////////////// endregion
}

