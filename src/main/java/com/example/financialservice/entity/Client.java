package com.example.financialservice.entity;


import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "secret_word")
    private String code;

    public Client(long clientId, String lastname, String firstname, String middleName, String code) {
        this.clientId = clientId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.middleName = middleName;
        this.code = code;
    }

    public Client() {

    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
