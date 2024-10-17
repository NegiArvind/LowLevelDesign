package models;

import enums.Language;

public class Movie {
    private int id;
    private String name;
    private int duration;
    private Language language;

    public Movie() {
    }

    public Movie(int id, String name, int duration, Language language) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
