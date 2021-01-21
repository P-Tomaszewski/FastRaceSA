package p.tomaszewski.FastRace.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import p.tomaszewski.FastRace.model.Contact;

import javax.validation.Valid;

@Controller
@RequestMapping("/contact")
public class ContactController {

    public ContactController() {
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    String showContact(Model model) {
        model.getAttribute("contact");
        var contact = new Contact();
        model.addAttribute("contact", contact);
        return "contact";
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String postContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "contact";
        }
        return "redirect:/contact";
    }
}