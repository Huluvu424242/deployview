package com.github.huluvu424242.deployview.artifact;

import java.util.List;

public class ExportWrapper {

    protected final List<Artifact> artifacts;

    protected final long nextVal;

    public ExportWrapper(){
        this.artifacts=null;
        this.nextVal=0;
    }

    public ExportWrapper(final List<Artifact> artifacts, final long nextVal){
        this.artifacts=artifacts;
        this.nextVal=nextVal;
    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    public long getNextVal() {
        return nextVal;
    }
}
