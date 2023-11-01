package org.example;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class DetailsController {
    @GetMapping("/{id}")
    public String showDetails(@PathVariable Long id, Model model) {
        Petition petition = petitionService.getPetitionById(id);
        model.addAttribute("petition", petition);
        return "Details";
    }
}