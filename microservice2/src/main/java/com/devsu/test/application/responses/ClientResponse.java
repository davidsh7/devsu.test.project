package com.devsu.test.application.responses;

/**
 * The Class ClientResponse.
 * 
 * @author David Sepulveda
 */
public class ClientResponse {

    /** The client id. */
    private Long clientId;

    /** The name. */
    private String name;

    /** The gender. */
    private String gender;

    /** The age. */
    private Integer age;

    /** The identification. */
    private String identification;

    /** The address. */
    private String address;

    /** The phone. */
    private String phone;
    
    /** The status. */
    private boolean status;

    /**
     * Gets the client id.
     * 
     * @return the client id
     */
    public Long getClientId() {
        return clientId;
    }

    /**
     * Sets the client id.
     * 
     * @param clientId the new client id
     */
    public void setClientId(Long clientId) {
        this.clientId = clientId;
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
    public Integer getAge() {
        return age;
    }

    /**
     * Sets the age.
     * 
     * @param age the new age
     */
    public void setAge(Integer age) {
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

    /**
     * Checks if is status.
     *
     * @return true, if is status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}