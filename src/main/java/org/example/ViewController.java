package org.example;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping
    public String showPetitions(Model model) {
        List<Petition> petitions = petitionService.getAllPetitions();
        model.addAttribute("petitions", petitions);
        return "View";
    }
}
