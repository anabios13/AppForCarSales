package by.anabios13.appforcarsales.controllers;

import by.anabios13.appforcarsales.models.CarBlank;
import by.anabios13.appforcarsales.services.CarBlankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public  String index(@RequestParam(value="page",required = false) Integer page,Model model){
       if(page==null)
        model.addAttribute("carBlanks",carBlankService.findAll(0));
       else
           model.addAttribute("carBlanks",carBlankService.findAll(page));
        return "cars/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("carBlank", carBlankService.findOne(id));
        return "cars/show";
    }

    @GetMapping("/new")
    public String newCarBlank(@ModelAttribute("carBlank")CarBlank carBlank){
        return "cars/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("carBlank") CarBlank carBlank){
      carBlankService.save(carBlank);
        return  "redirect:/cars";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("carBlank",carBlankService.findOne(id));
        return "cars/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("carBlank") CarBlank carBlank,
                         @PathVariable("id") int id){
        carBlankService.update(id,carBlank);
        return "redirect:/cars";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        carBlankService.delete(id);
        return "redirect:/cars";
    }
}
