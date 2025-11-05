package com.example.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.portfolio.model.*;
import com.example.portfolio.service.PortfolioService;

@Controller
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", portfolioService.getAllUsers());
        return "index";
    }

    @GetMapping("/create")
    public String createProfileForm(Model model) {
        model.addAttribute("user", new User());
        return "create_profile";
    }

    @PostMapping("/save")
    public String saveProfile(@ModelAttribute User user) {
        portfolioService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/profile/{id}")
    public String viewProfile(@PathVariable Long id, Model model) {
        User user = portfolioService.getUserById(id);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/project/create")
    public String createProjectForm(@RequestParam Long userId, Model model) {
        Project p = new Project();
        p.setUser(new User());
        model.addAttribute("project", p);
        model.addAttribute("userId", userId);
        return "create_project";
    }

    @PostMapping("/project/save")
    public String saveProject(@RequestParam Long userId, @ModelAttribute Project project) {
        portfolioService.addProjectToUser(userId, project);
        return "redirect:/profile/" + userId;
    }

    @GetMapping("/skill/create")
    public String createSkillForm(@RequestParam Long userId, Model model) {
        model.addAttribute("skill", new Skill());
        model.addAttribute("userId", userId);
        return "create_skill";
    }

    @PostMapping("/skill/save")
    public String saveSkill(@RequestParam Long userId, @ModelAttribute Skill skill) {
        portfolioService.addSkillToUser(userId, skill);
        return "redirect:/profile/" + userId;
    }

    @GetMapping("/achievement/create")
    public String createAchievementForm(@RequestParam Long userId, Model model) {
        model.addAttribute("achievement", new Achievement());
        model.addAttribute("userId", userId);
        return "create_achievement";
    }

    @PostMapping("/achievement/save")
    public String saveAchievement(@RequestParam Long userId, @ModelAttribute Achievement achievement) {
        portfolioService.addAchievementToUser(userId, achievement);
        return "redirect:/profile/" + userId;
    }
}
