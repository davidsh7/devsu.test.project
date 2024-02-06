package com.devsu.test.domain.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * The Class Client.
 *
 * @author David Sepulveda
 */
@Entity
@Table(name = "Clients")
public class Client extends Person implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The client id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "clients_seq")
    @SequenceGenerator(name = "clients_seq", sequenceName = "CLIENTS_SEQ", allocationSize = 1)
    @Column(name = "clientid")
    private Long clientId;

    /** The password. */
    private String password;
    
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
    public boolean getStatus() {
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