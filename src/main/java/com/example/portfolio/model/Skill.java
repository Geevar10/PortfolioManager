package com.example.portfolio.model;

import jakarta.persistence.*;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String level;
    private String category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
