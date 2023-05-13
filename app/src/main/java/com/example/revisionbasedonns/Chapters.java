package com.example.revisionbasedonns;

public class Chapters {
    private String name;
    private String description;

    public Chapters() {
        // Default constructor with no parameters
    }

    public Chapters(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Chapters\n{" +
                "name='" + name + '\'' +
                ",\n description='" + description + '\'' +
                '}';
    }
}
