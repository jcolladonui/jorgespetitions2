package org.example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PetitionController {

    private List<Petition> petitions = new ArrayList<>();

    @GetMapping("/create")
    public String createPetitionForm() {
        return "create";
    }

    @PostMapping("/submit")
    public String submitPetition(@RequestParam String title, @RequestParam String description) {
        Petition newPetition = new Petition(title, description);
        petitions.add(newPetition);
        return "redirect:/View";
    }

    @GetMapping("/view")
    public String viewPetitions(Model model) {
        model.addAttribute("petitions", petitions);
        return "View";
    }

    @GetMapping("/search")
    public String searchPetitionForm() {
        return "search";
    }

    @GetMapping("/Search")
    public String searchPetition(@RequestParam String keyword, Model model) {
        List<Petition> searchResults = new ArrayList<>();
        for (Petition petition : petitions) {
            if (petition.getTitle().contains(keyword) || petition.getDescription().contains(keyword)) {
                searchResults.add(petition);
            }
        }
        model.addAttribute("searchResults", searchResults);
        return "search";
    }

    @GetMapping("/view/{id}")
    public String viewPetition(@PathVariable int id, Model model) {
        Petition petition = petitions.get(id);
        model.addAttribute("petition", petition);
        return "view_petition";
    }

    @PostMapping("/sign")
    public String signPetition(@RequestParam int id, @RequestParam String name, @RequestParam String email) {
        Petition petition = petitions.get(id);
        petition.addSignature(new Signature(name, email));
        return "redirect:/sign-success";
    }

    @GetMapping("/sign-success")
    public String signPetitionSuccess() {
        return "sign_petition_success";
    }
}

