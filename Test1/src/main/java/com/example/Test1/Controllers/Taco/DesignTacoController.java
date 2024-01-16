package com.example.Test1.Controllers.Taco;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.Test1.Models.Users;
import com.example.Test1.Repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.Test1.Models.Tacos;
import com.example.Test1.Models.Ingredients;
import com.example.Test1.Models.Ingredients.Type;
import com.example.Test1.Models.Orders;
import com.example.Test1.Repositories.TacosRepository;
import com.example.Test1.Repositories.IngredientsRepository;


import java.security.Principal;


import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/design")
@SessionAttributes("order")
@Slf4j
@RequiredArgsConstructor
public class DesignTacoController {

    private final IngredientsRepository ingredientRepo;

    private TacosRepository tacoRepo;

    private UsersRepository userRepo;

    @Autowired
    public DesignTacoController(
            IngredientsRepository ingredientRepo,
            TacosRepository tacoRepo,
            UsersRepository userRepo) {
        this.ingredientRepo = ingredientRepo;
        this.tacoRepo = tacoRepo;
        this.userRepo = userRepo;
    }

    @ModelAttribute(name = "order")
    public Orders order() {
        return new Orders();
    }

    @ModelAttribute(name = "design")
    public Tacos design() {
        return new Tacos();
    }

    @GetMapping
    public String showDesignForm(Model model, Principal principal) {
        log.info("   --- Designing taco");
        List<Ingredients> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(ingredients::add);

        Type[] types = Ingredients.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        String username = principal.getName();
        Users user = userRepo.findByUsername(username);
        model.addAttribute("user", user);

        return "design";
    }

    @PostMapping
    public String processDesign(
            @Valid Tacos taco, Errors errors,
            @ModelAttribute Orders order) {

        log.info("   --- Saving taco");

        if (errors.hasErrors()) {
            return "design";
        }

        Tacos saved = tacoRepo.save(taco);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }

    private List<Ingredients> filterByType(
            List<Ingredients> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
