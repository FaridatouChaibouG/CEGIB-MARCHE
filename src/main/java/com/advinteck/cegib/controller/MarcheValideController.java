package com.advinteck.cegib.controller;

import org.springframework.ui.Model;
import com.advinteck.cegib.dto.ActiviteDTO;
import com.advinteck.cegib.dto.MarcheDTO;
import com.advinteck.cegib.dto.NifDTO;
import com.advinteck.cegib.service.MarcheService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/marcheValide")
public class MarcheValideController {

    private final MarcheService marcheService;

    public MarcheValideController(MarcheService marcheService) {
        this.marcheService = marcheService;
    }


    @GetMapping("/listValider")
    public String listmarcheValider(Model model) {
        List<MarcheDTO> marchesList = marcheService.marcheListValide();
        model.addAttribute("marches", marchesList);
        return "marcheValide/list";
    }


    @GetMapping("/details/{id}")
    public String detailsMarche( @PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {

        Map<String, String> messages = new HashMap<>();

        Optional<MarcheDTO> marcheOpt = marcheService.findOneMarcheById(id);

        if (marcheOpt.isEmpty()) {
            messages.put("danger", "Marché introuvable pour l'id " + id);
            redirectAttributes.addFlashAttribute("messages", messages);
            return "redirect:/marcheValide/list";
        }

        MarcheDTO marcheDTO = marcheOpt.get();

        List<ActiviteDTO> activites = marcheService.marcheActiviteList(id);
        List<NifDTO> nifs = marcheService.marcheNifList(id);

        model.addAttribute("marcheDTO", marcheDTO);
        model.addAttribute("marcheActiviteDTOs", activites);
        model.addAttribute("marcheNifDTOs", nifs);
        model.addAttribute("messages", messages);

        return "marcheValide/details";
    }

}