package com.github.huluvu424242.deployview;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "artifacts")
public class Artifact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    protected String environmentId;
    protected String departmentId;
    protected String artifactId;
    protected String deploymentStatus;
    protected String deploymentNotice;


    public String getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(String environmentId) {
        this.environmentId = environmentId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
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
