package com.github.huluvu424242.deployview.restapi;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "artifact")
public class Artifact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Convert(converter = UmgebungConverter.class)
    protected Umgebung umgebung;

    protected String departmentId;
    protected String name;
    protected String deploymentStatus;
    protected String deploymentNotice;


    public long getId(){ return id;}

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
