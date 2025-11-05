package com.example.portfolio.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String contact;
    private String education;
    private String workExperience;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Skill> skills = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Achievement> achievements = new ArrayList<>();

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }

    public String getWorkExperience() { return workExperience; }
    public void setWorkExperience(String workExperience) { this.workExperience = workExperience; }

    public List<Project> getProjects() { return projects; }
    public void setProjects(List<Project> projects) { this.projects = projects; }

    public List<Skill> getSkills() { return skills; }
    public void setSkills(List<Skill> skills) { this.skills = skills; }

    public List<Achievement> getAchievements() { return achievements; }
    public void setAchievements(List<Achievement> achievements) { this.achievements = achievements; }
}
