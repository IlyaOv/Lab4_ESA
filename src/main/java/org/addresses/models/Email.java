package org.addresses.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Email")
public class Email {
    @Id
    @GeneratedValue
    private int id;
    private String address;
    private String heading;
    private String body;

    public Email(){}

    public Email(String address, String heading, String body){
        this.address = address;
        this.heading = heading;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
