package com.devsu.test.application.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ClientUpdateRequest.
 * 
 * @author David Sepulveda
 */
public class ClientUpdateRequest {

    /** The client id. */
    @NotNull(message = "The clientId cannot be null")
    private Long clientId;

    /** The name. */
    @NotNull(message = "The name cannot be null")
    @Size(max = 255, message = "The name '${validatedValue}' must be between {min} and {max} characters long")
    private String name;

    /** The gender. */
    @NotNull(message = "The gender cannot be null")
    private GenderType gender;

    /** The age. */
    @NotNull(message = "The age cannot be null")
    private Integer age;

    /** The identification. */
    @NotNull(message = "The identification cannot be null")
    @Size(min = 5, max = 20, message = "The identification '${validatedValue}' must be between {min} and {max} characters long")
    private String identification;

    /** The address. */
    @NotNull(message = "The address cannot be null")
    @Size(min = 5, max = 50, message = "The address '${validatedValue}' must be between {min} and {max} characters long")
    private String address;

    /** The phone. */
    @NotNull(message = "The phone cannot be null")
    @Size(min = 9, max = 20, message = "The phone number must be between {min} and {max} characters long")
    private String phone;

    /** The password. */
    @NotNull(message = "The password cannot be null")
    @Size(min = 4, max = 4, message = "The password must be between {min} and {max} characters long")
    private String password;

    /** The status. */
    @NotNull(message = "The status cannot be null")
    private Boolean status;

    /**
     * Instantiates a new client update request.
     *
     * @param clientId       the client id
     * @param name           the name
     * @param gender         the gender
     * @param age            the age
     * @param identification the identification
     * @param address        the address
     * @param phone          the phone
     * @param password       the password
     * @param status         the status
     */
    @JsonCreator
    public ClientUpdateRequest(@JsonProperty(value = "clientId", required = true) final Long clientId,
            @JsonProperty(value = "name", required = true) final String name,
            @JsonProperty(value = "gender", required = true) final GenderType gender,
            @JsonProperty(value = "age", required = true) final Integer age,
            @JsonProperty(value = "identification", required = true) final String identification,
            @JsonProperty(value = "address", required = true) final String address,
            @JsonProperty(value = "phone", required = true) final String phone,
            @JsonProperty(value = "password", required = true) final String password,
            @JsonProperty(value = "status", required = true) final Boolean status) {
        this.clientId = clientId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.identification = identification;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.status = status;
    }

    /**
     * Gets the client id.
     *
     * @return the client id
     */
    public Long getClientId() {
        return clientId;
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
    public GenderType getGender() {
        return gender;
    }

    /**
     * Sets the gender.
     *
     * @param gender the new gender
     */
    public void setGender(GenderType gender) {
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
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }
}