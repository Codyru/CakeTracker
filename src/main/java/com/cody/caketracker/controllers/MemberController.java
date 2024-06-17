package com.cody.caketracker.controllers;

import com.cody.caketracker.models.Member;
import com.cody.caketracker.services.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public String homePage() {
        return "base";
    }

    @GetMapping("/members")
    public String listMembers(Model model) {
        try {
            model.addAttribute("members", memberService.getAllMembers());
            return "members_list";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Could not retrieve members.");
            return "error";
        }
    }

    @GetMapping("/members/sorted")
    public String sortedMembers(Model model) {
        model.addAttribute("members", memberService.getSortedMembersByBirthday());
        return "members_list";
    }

    @GetMapping("/members/add")
    public String showAddMemberForm(Member member) {
        return "add_member";
    }

    @PostMapping("/members/add")
    public String addMember(@Valid Member member, BindingResult result, Model model) {
        try {
            memberService.addMember(member);
            return "redirect:/members";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("member", member); // Keep the user input in the form
            return "add_member";
        }
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", ex.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
