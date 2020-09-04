package com.github.huluvu424242.deployview.restapi;

import java.io.Serializable;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artifact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Convert(converter = UmgebungConverter.class)
    protected Umgebung umgebung;

    protected String departmentId;
    protected String name;
    protected String deploymentStatus;
    protected String deploymentNotice;


    public Artifact() {

    }

    public Artifact(final String umgebung,
                    final String department,
                    final String name,
                    final String deploymentStatus,
                    final String deploymentNotice) {
        this.umgebung = new Umgebung(umgebung);
        this.departmentId = department;
        this.name = name;
        this.deploymentStatus = deploymentStatus;
        this.deploymentNotice = deploymentNotice;
    }


    public Long getId() {
        return id;
    }

    public Umgebung getUmgebung() {
        return umgebung;
    }

    public void setUmgebung(Umgebung umgebung) {
        this.umgebung = umgebung;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeploymentStatus() {
        return deploymentStatus;
    }

    public void setDeploymentStatus(String deploymentStatus) {
        this.deploymentStatus = deploymentStatus;
    }

    public String getDeploymentNotice() {
        return deploymentNotice;
    }

    public void setDeploymentNotice(String deploymentNotice) {
        this.deploymentNotice = deploymentNotice;
    }


}
