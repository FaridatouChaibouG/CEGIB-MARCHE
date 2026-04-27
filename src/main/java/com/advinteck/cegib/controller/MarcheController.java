package com.advinteck.cegib.controller;


import com.advinteck.cegib.dto.ActiviteDTO;
import com.advinteck.cegib.dto.MarcheDTO;
import com.advinteck.cegib.dto.NifDTO;
import com.advinteck.cegib.generated.marche.tables.pojos.MarcheNifs;
import com.advinteck.cegib.generated.marche.tables.pojos.MarcheActivite;
import com.advinteck.cegib.service.MarcheService;
import com.advinteck.cegib.service.ReferentielService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/marche")
public class MarcheController {

    private final MarcheService marcheService;
    private final ReferentielService referentielService;

    public MarcheController(MarcheService marcheService, ReferentielService referentielService) {
        this.marcheService = marcheService;
        this.referentielService = referentielService;
    }

    @GetMapping("/list")
    public String listmarche(Model model) {
        List<MarcheDTO> marchesList = marcheService.marcheList();
        model.addAttribute("marches", marchesList);
        return "marche/list";
    }

    @GetMapping("/addForm")
    public String addMarcheForm(Model model) {

        model.addAttribute("marcheDTO", new MarcheDTO());
        model.addAttribute("imputationList", referentielService.imputationsList());
        model.addAttribute("autoriteContractanteList", referentielService.autoriteContractantesList());
        model.addAttribute("structureAutoriteContractanteList", referentielService.structureAutoriteContractantesList());
        model.addAttribute("typeMarcheList", referentielService.typeMarchesList());
        model.addAttribute("modePassationList", referentielService.modePassationsList());


        return "marche/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Valid MarcheDTO marcheDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        Map<String, String> messages = new HashMap<>();
        if (bindingResult.hasErrors()) {

            model.addAttribute("bindingResult", bindingResult);
            model.addAttribute("imputationList", referentielService.imputationsList());
            model.addAttribute("autoriteContractanteList", referentielService.autoriteContractantesList());
            model.addAttribute("structureAutoriteContractanteList", referentielService.structureAutoriteContractantesList());
            model.addAttribute("typeMarcheList", referentielService.typeMarchesList());
            model.addAttribute("modePassationList", referentielService.modePassationsList());


            return "marche/form";
        }

//        String NumeroMarche = marcheDTO.getNumMarche();
//        if (marcheService.NumeroMarcheAlreadyExists(NumeroMarche)) {
//            messages.put("danger", "Le numéro du marché " + NumeroMarche + " est déjà attribué.");
//            model.addAttribute("messages", messages);
//            model.addAttribute("imputationList", referentielService.imputationsList());
//            model.addAttribute("autoriteContractanteList", referentielService.autoriteContractantesList());
//            model.addAttribute("structureAutoriteContractanteList", referentielService.structureAutoriteContractantesList());
//            model.addAttribute("typeMarcheList", referentielService.typeMarchesList());
//            model.addAttribute("modePassationList", referentielService.modePassationsList());
//
//            return "marche/form";
//        }

        try {
            marcheService.save(marcheDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        messages.put("success", "Nouveau marché ajouté avec succes.");
        redirectAttributes.addFlashAttribute("messages", messages);
        return "redirect:/marche/list";
    }


    @GetMapping("/details/{id}")
    public String detailsMarche(
            Model model,
            RedirectAttributes redirectAttributes,
            @PathVariable Long id
    ) {

        Optional<MarcheDTO> marcheDTO = marcheService.findOneMarcheById(id);

        if (marcheDTO.isEmpty()) {
            Map<String, String> messages = new HashMap<>();
            messages.put("danger", "Marché non trouvé pour l'id : " + id);

            redirectAttributes.addFlashAttribute("messages", messages);
            return "redirect:/marche/list";
        }


        model.addAttribute("marcheDTO", marcheDTO.get());

        //recuperation de la liste des marche_nif
        model.addAttribute("marcheNifDTOs", marcheService.marcheNifList(id));

        model.addAttribute("nifList", referentielService.nifsList());

        //recuperation de la liste des marche_activite
        model.addAttribute("marcheActiviteDTOs", marcheService.marcheActiviteList(id));

        model.addAttribute("dppActiviteList", referentielService.dppdActiviteList());

        return "marche/details";
    }

    @PostMapping("/savemarcheNif")
    public String savemarcheNif(@ModelAttribute NifDTO nifDTO, Model model, RedirectAttributes redirectAttributes) {

        Map<String, String> messages = new HashMap<>();
        try {
            marcheService.savemarcheNif(nifDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        messages.put("success", "Nif ajouté avec succes.");
        redirectAttributes.addFlashAttribute("messages", messages);
        return "redirect:/marche/details/" + nifDTO.getMarcheId();
    }

    @PostMapping("/updatemarcheNif")
    public String editNif(@ModelAttribute  NifDTO nifDTO,Model model, RedirectAttributes redirectAttributes){


        Map<String, String> messages = new HashMap<>();
        try {
            marcheService.editNif(nifDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        messages.put("success", " Nif modifié avec succes.");
        redirectAttributes.addFlashAttribute("messages", messages);
        return "redirect:/marche/details/" + nifDTO.getMarcheId();
    }




    @GetMapping("/nif/delete/{id}")
    public String deletenif(
            RedirectAttributes redirectAttributes,
            @PathVariable Long id

    ) {
        Map<String, String> messages = new HashMap<>();
        NifDTO nifDTO = marcheService.findOneMarcheNifById(id);

        if (nifDTO == null) {
            messages.put("danger", "Echec de suppression : nif non trouvé pour l'id " + id);
        } else {
            marcheService.deleteNif(id);
            messages.put("success", "nif supprimé avec succès");
        }

        redirectAttributes.addFlashAttribute("messages", messages);
        return "redirect:/marche/details/" + nifDTO.getMarcheId();
    }


    @PostMapping("/savemarcheActivite")
    public String savemarcheActivite(@ModelAttribute ActiviteDTO activiteDTO, Model model, RedirectAttributes redirectAttributes) {

        Map<String, String> messages = new HashMap<>();
        try {
            marcheService.savemarcheActivite(activiteDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        messages.put("success", "activité ajouté avec succes.");
        redirectAttributes.addFlashAttribute("messages", messages);
        return "redirect:/marche/details/" + activiteDTO.getMarcheId();
    }


    @PostMapping("/updatemarcheActivite")
    public String editActivite(@ModelAttribute  ActiviteDTO activiteDTO,Model model, RedirectAttributes redirectAttributes){


        Map<String, String> messages = new HashMap<>();
        try {
            marcheService.editActivite(activiteDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        messages.put("success", " Activité modifié avec succes.");
        redirectAttributes.addFlashAttribute("messages", messages);
        return "redirect:/marche/details/" + activiteDTO.getMarcheId();
    }


    @GetMapping("/activite/delete/{id}")
    public String deleteActivite(
            RedirectAttributes redirectAttributes,
            @PathVariable Long id

    ) {
        Map<String, String> messages = new HashMap<>();
        ActiviteDTO activiteDTO = marcheService.findOneActiviteByCodeActivite(id);

        if (activiteDTO == null) {
            messages.put("danger", "Echec de suppression : activité non trouvé pour l'id " + id);
        } else {
            marcheService.deleteActivite(id);
            messages.put("success", "activité supprimé avec succès");
        }

        redirectAttributes.addFlashAttribute("messages", messages);
        return "redirect:/marche/details/" + activiteDTO.getMarcheId();
    }










}
