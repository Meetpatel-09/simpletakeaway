package com.example.simpletakeaway.controller;

import com.example.simpletakeaway.model.Item;
import com.example.simpletakeaway.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping({"viewItemList"})
    public String viewAllItems(Model model, @ModelAttribute("message") String message) {
        model.addAttribute("list", service.getAllItems());
        model.addAttribute("msq", message);

        return "ViewItemList";
    }

    @PostMapping({"/updateItem/{id}"})
    public String updateItem(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (service.updateItem(id)) {
            redirectAttributes.addFlashAttribute("message", "Update Successful");
            return  "redirect:/viewItemList";
        }

        redirectAttributes.addFlashAttribute("message", "Update Failure");
        return "redirect:/viewItemList";
    }

    @GetMapping("/addItem")
    public String addItem(Model model) {
        model.addAttribute("item", new Item());
        return "AddItem";
    }

    @PostMapping("/saveItem")
    public String saveItem(Item item, RedirectAttributes redirectAttributes) {

        if (service.saveOrUpdateItem(item)) {
            redirectAttributes.addFlashAttribute("message", "Save Successfully");
            return "redirect:/viewItemList";
        }

        redirectAttributes.addFlashAttribute("message", "Save Failure");
        return "redirect:/addItem";
    }

    @GetMapping("/editItem/{id}")
    public String editItem(@PathVariable int id, Model model) {
        model.addAttribute("item", service.getItemById(id));

        return "EditItem";
    }

    @PostMapping("/editSaveItem")
    public String editSaveItem(Item item, RedirectAttributes redirectAttributes) {
        if (service.saveOrUpdateItem(item)) {
            redirectAttributes.addFlashAttribute("message", "Edit Successfully");
            return "redirect:/viewItemList";
        }

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/editItem/" + item.getIditem();
    }

    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (service.deleteItem(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Successfully");
        }
        redirectAttributes.addFlashAttribute("message", "Delete Failure");
        return "redirect:/viewItemList";
    }

}
