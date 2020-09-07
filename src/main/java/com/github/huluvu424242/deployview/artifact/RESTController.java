package com.github.huluvu424242.deployview.artifact;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {


    @Autowired
    protected DataService dataService;

    @GetMapping("/api/artifacts")
    public List<Artifact> listAllArtifacts(){
        return dataService.listArtifacts();
    }

    @GetMapping("/api/umgebungen")
    public List<String> listAllEnvironments(){
        return dataService.listUmgebungen();
    }

    @PostMapping("/api/import")
    public ResponseEntity<ExportWrapper> importArtifacts(@RequestBody ExportWrapper exportWrapper) {
        dataService.importArtifacts(exportWrapper);
        return ResponseEntity.ok(exportWrapper);
    }

    @GetMapping("/api/export.json")
    public ResponseEntity<Resource> exportArtifactsAsJSONFile() throws JsonProcessingException {
        final ExportWrapper exportWrapper = new ExportWrapper(dataService.listArtifacts(), dataService.getDefaultNextVal());
        final ObjectMapper objectMapper = new ObjectMapper();
        final String objectAsString = objectMapper.writeValueAsString(exportWrapper);
        final byte[] bytes = objectAsString.getBytes(Charset.forName("UTF-8"));

        final InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(bytes));
        return ResponseEntity.ok()
                .contentLength(bytes.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @DeleteMapping("/api/{umgebung}/{department}/{artifact}")
    public void deleteArtifact(
            @PathVariable(name = "umgebung") String umgebung,
            @PathVariable(name = "department") String department,
            @PathVariable(name = "artifact") String artifactName) {
        dataService.deleteArtifact(umgebung, department, artifactName);
    }


    @PostMapping("/api/{umgebung}/{department}/{artifact}/{status}")
    public void updateArtifactStatus(
            @PathVariable(name = "umgebung") String umgebung,
            @PathVariable(name = "department") String department,
            @PathVariable(name = "artifact") String artifactName,
            @PathVariable(name = "status") String deploymentStatus) {
        dataService.saveArtifactUpdate(umgebung, department, artifactName, deploymentStatus, " ");
    }

    @PostMapping("/api/{umgebung}/{department}/{artifact}/{status}/{notiz}")
    public void updateArtifact(
            @PathVariable(name = "umgebung") String umgebung,
            @PathVariable(name = "department") String department,
            @PathVariable(name = "artifact") String artifactName,
            @PathVariable(name = "status") String deploymentStatus,
            @PathVariable(name = "notiz") String notiz) {
        dataService.saveArtifactUpdate(umgebung, department, artifactName, deploymentStatus, notiz);
    }

    @PutMapping("/api/{umgebung}/{department}/{artifact}")
    public void createArtifact(
            @PathVariable(name = "umgebung") String umgebung,
            @PathVariable(name = "department") String department,
            @PathVariable(name = "artifact") String artifactName) {
        dataService.createArtifact(umgebung, department, artifactName);
    }

}


