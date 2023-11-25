package org.example;

import java.util.ArrayList;
import java.util.List;

public class Petition {

    private String title;
    private String description;
    private List<Signature> signatures;

    public Petition(String title, String description) {
        this.title = title;
        this.description = description;
        this.signatures = new ArrayList<>();
        this.title = "Sample Petition ";
        this.description = "Description of the sample petition.";
        this.signatures.add(new Signature("John Doe", "john@example.com"));
        this.signatures.add(new Signature("Jane Smith", "jane@example.com"));
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }

    public void addSignature(Signature signature) {
        this.signatures.add(signature);
    }
}

