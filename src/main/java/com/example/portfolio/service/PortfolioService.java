package com.example.portfolio.service;

import java.util.List;
import com.example.portfolio.model.*;

public interface PortfolioService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);

    Project addProjectToUser(Long userId, Project project);
    Skill addSkillToUser(Long userId, Skill skill);
    Achievement addAchievementToUser(Long userId, Achievement achievement);
}
