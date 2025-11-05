package com.example.portfolio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.portfolio.model.*;
import com.example.portfolio.repository.*;
import com.example.portfolio.service.PortfolioService;
import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private AchievementRepository achievementRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Project addProjectToUser(Long userId, Project project) {
        User user = getUserById(userId);
        if (user == null) return null;
        project.setUser(user);
        Project saved = projectRepository.save(project);
        user.getProjects().add(saved);
        userRepository.save(user);
        return saved;
    }

    @Override
    public Skill addSkillToUser(Long userId, Skill skill) {
        User user = getUserById(userId);
        if (user == null) return null;
        skill.setUser(user);
        Skill saved = skillRepository.save(skill);
        user.getSkills().add(saved);
        userRepository.save(user);
        return saved;
    }

    @Override
    public Achievement addAchievementToUser(Long userId, Achievement achievement) {
        User user = getUserById(userId);
        if (user == null) return null;
        achievement.setUser(user);
        Achievement saved = achievementRepository.save(achievement);
        user.getAchievements().add(saved);
        userRepository.save(user);
        return saved;
    }
}
