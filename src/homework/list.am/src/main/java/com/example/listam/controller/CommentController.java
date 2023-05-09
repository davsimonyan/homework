package com.example.listam.controller;

import com.example.listam.entity.Comment;
import com.example.listam.entity.Item;
import com.example.listam.repo.CommentRepository;
import com.example.listam.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/comment")
    public String commentPage(ModelMap modelMap) {
        List<Comment> all = commentRepository.findAll();
        modelMap.addAttribute("comment", all);
        return "comment";
    }

    @GetMapping("/comment/{id}")
    public String singleCommentPage(@PathVariable("id") int id,
                                    ModelMap modelMap) {
        Optional<Comment> byId = commentRepository.findById(id);
        if (byId.isPresent()) {
            Comment comment = byId.get();
            modelMap.addAttribute("comment", comment);
            return "singleComment";
        } else {
            return "redirect:/comment";
        }

    }

    @GetMapping("/comment/add")
    public String commentAddPage(ModelMap modelMap) {
        List<Item> all = itemRepository.findAll();
        modelMap.addAttribute("items", all);
        return "addComment";
    }

    @PostMapping("/comment/add")
    public String addComment(@ModelAttribute Comment comment) {
        commentRepository.save(comment);
        return "redirect:/comment";
    }


    @GetMapping("/comment/remove")
    public String removeComment(@RequestParam("id") int id) {
        commentRepository.deleteById(id);
        return "redirect:/comment";
    }

}