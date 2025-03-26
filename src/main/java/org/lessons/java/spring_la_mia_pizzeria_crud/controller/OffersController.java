package org.lessons.java.spring_la_mia_pizzeria_crud.controller;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Offer;
import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.java.spring_la_mia_pizzeria_crud.repo.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/offers")
public class OffersController {

    @Autowired
    private OfferRepository repo;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("offer") Offer formOffer, BindingResult bindingResult, Model model ) {
        
        if(bindingResult.hasErrors()){
            return "offers/create-or-edit";
        }

        repo.save(formOffer);

        return "redirect:/pizzas";
    }
    
    
}
