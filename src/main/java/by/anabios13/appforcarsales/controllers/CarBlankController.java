package by.anabios13.appforcarsales.controllers;

import by.anabios13.appforcarsales.models.CarBlank;
import by.anabios13.appforcarsales.services.CarBlankService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarBlankController {
    private final CarBlankService carBlankService;

    @Autowired
    public CarBlankController(CarBlankService carBlankService) {
        this.carBlankService = carBlankService;
    }

    @GetMapping()
    public String index(@RequestParam(value = "page", required = false) Integer page, Model model) {
        if (page == null)
            model.addAttribute("carBlanks", carBlankService.findAll(0));
        else
            model.addAttribute("carBlanks", carBlankService.findAll(page));
        return "cars/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("carBlank", carBlankService.findOne(id));
        return "cars/show";
    }

    @GetMapping("/new")
    public String newCarBlank(@ModelAttribute("carBlank") CarBlank carBlank) {
        return "cars/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("carBlank") @Valid CarBlank carBlank,
                         BindingResult bindingResult) {
        carBlankService.save(carBlank);
        if (bindingResult.hasErrors())
            return "cars/new";

        return "redirect:/cars";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("carBlank", carBlankService.findOne(id));
        return "cars/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("carBlank") @Valid CarBlank carBlank,
                         @PathVariable("id") int id, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "cars/edit";

        carBlankService.update(id, carBlank);
        return "redirect:/cars";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        carBlankService.delete(id);
        return "redirect:/cars";
    }

    @GetMapping("/search")
    public String searchPage() {
        return "cars/search";
    }

    @PostMapping("/search")
    public String makeSearch(Model model, @RequestParam("nameOfCarBlank") String nameOfCarBlank) {
        model.addAttribute("carBlanks", carBlankService.searchByName(nameOfCarBlank));
        return "cars/search";
    }
}
