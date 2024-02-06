package com.devsu.test.domain.models;

import jakarta.persistence.MappedSuperclass;

/**
 * The Class Person.
 *
 * @author David Sepulveda
 */
@MappedSuperclass
public class Person {

    /** The name. */
    private String name;
    
    /** The gender. */
    private String gender;
    
    /** The age. */
    private int age;
    
    /** The identification. */
    private String identification;
    
    /** The address. */
    private String address;
    
    /** The phone. */
    private String phone;

    /**
     * Instantiates a new person.
     */
    public Person() {
    }

    /**
     * Instantiates a new person.
     *
     * @param name the name
     * @param gender the gender
     * @param age the age
     * @param identification the identification
     * @param address the address
     * @param phone the phone
     */
    public Person(String name, String gender, int age, String identification, String address, String phone) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.identification = identification;
        this.address = address;
        this.phone = phone;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender.
     *
     * @param gender the new gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age.
     *
     * @param age the new age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the identification.
     *
     * @return the identification
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * Sets the identification.
     *
     * @param identification the new identification
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone.
     *
     * @param phone the new phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}