package org.addresses.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Changes")
public class Changes {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private ChangeType changeType;
    @Column(name = "changing_entity")
    private String changingEntity;
    @Column(name = "substance_of_change")
    private String substanceOfChange;

    public Changes(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(ChangeType changeType) {
        this.changeType = changeType;
    }

    public String getChangingEntity() {
        return changingEntity;
    }

    public void setChangingEntity(String changingEntity) {
        this.changingEntity = changingEntity;
    }

    public String getSubstanceOfChange() {
        return substanceOfChange;
    }

    public void setSubstanceOfChange(String substanceOfChange) {
        this.substanceOfChange = substanceOfChange;
    }
}
