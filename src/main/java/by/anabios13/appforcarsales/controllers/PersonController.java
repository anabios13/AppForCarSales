package by.anabios13.appforcarsales.controllers;

import by.anabios13.appforcarsales.models.Person;
import by.anabios13.appforcarsales.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public  String index(Model model){
        model.addAttribute("people",personService.findAll());
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personService.findOne(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newCarBlank(@ModelAttribute("person") Person person){
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person  person, BindingResult bindingResult){
     if(bindingResult.hasErrors())
         return "people/new";

       personService.save(person);
        return  "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person",personService.findOne(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         @PathVariable("id") int id,BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "people/edit";

        personService.update(id,person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personService.delete(id);
        return "redirect:/people";
    }

    @GetMapping("/search")
    public String searchPage(){
        return "people/search";
    }

    @PostMapping("/search")
    public String makeSearch(Model model, @RequestParam("name") String name){
        model.addAttribute("people",personService.searchPersonByName(name));
        return "people/search";
    }
}
