package com.advinteck.cegib.controller;


import com.advinteck.cegib.dto.ActiviteDTO;
import com.advinteck.cegib.dto.MarcheDTO;
import com.advinteck.cegib.dto.NifDTO;
import com.advinteck.cegib.service.MarcheService;
import com.advinteck.cegib.service.ReferentielService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

//    @GetMapping("/listValider")
//    public String listmarcheValider(Model model) {
//        List<MarcheDTO> marchesList = marcheService.marcheValideList();
//        model.addAttribute("marches", marchesList);
//        return "marche/list";
//    }

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
    public String save(@ModelAttribute @Valid MarcheDTO marcheDTO,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes redirectAttributes) {

        Map<String, String> messages = new HashMap<>();

        if (bindingResult.hasErrors()) {

            model.addAttribute("bindingResult", bindingResult);
            model.addAttribute("marcheDTO", marcheDTO);

            model.addAttribute("imputationList", referentielService.imputationsList());
            model.addAttribute("autoriteContractanteList", referentielService.autoriteContractantesList());
            model.addAttribute("structureAutoriteContractanteList", referentielService.structureAutoriteContractantesList());
            model.addAttribute("typeMarcheList", referentielService.typeMarchesList());
            model.addAttribute("modePassationList", referentielService.modePassationsList());

            return "marche/form";
        }


        String numeroMarche = marcheDTO.getNumMarche();

        if (marcheService.NumeroMarcheAlreadyExists(numeroMarche)) {

            messages.put("danger", "Le numéro du marché " + numeroMarche + " est déjà attribué.");

            model.addAttribute("messages", messages);
            model.addAttribute("bindingResult", bindingResult);
            model.addAttribute("marcheDTO", marcheDTO);

            model.addAttribute("imputationList", referentielService.imputationsList());
            model.addAttribute("autoriteContractanteList", referentielService.autoriteContractantesList());
            model.addAttribute("structureAutoriteContractanteList", referentielService.structureAutoriteContractantesList());
            model.addAttribute("typeMarcheList", referentielService.typeMarchesList());
            model.addAttribute("modePassationList", referentielService.modePassationsList());

            return "marche/form";
        }


        MarcheDTO saveMarche;

        try {
            saveMarche = marcheService.save(marcheDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        messages.put("success", "Nouveau marché ajouté avec succès.");

        redirectAttributes.addFlashAttribute("messages", messages);

        return "redirect:/marche/details/" + saveMarche.getId();
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

        model.addAttribute("marcheNifDTOs", marcheService.marcheNifList(id));

        model.addAttribute("nifList", referentielService.nifsList());

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



    @GetMapping("edit/{id}")
    public String editMarcheForm(Model model, RedirectAttributes redirectAttributes, @PathVariable Long id) {


        Optional<MarcheDTO> marcheOpt = marcheService.findOneMarcheById(id);

        if (marcheOpt.isEmpty()) {
            Map<String, String> messages = new HashMap<>();
            messages.put("danger", "Echec de modification : marché non trouvé pour l'id " + id);
            redirectAttributes.addFlashAttribute("messages", messages);
            return "redirect:/marche/list";
        }
        MarcheDTO marcheDTO = marcheOpt.get();

        model.addAttribute("marcheDTO", marcheDTO);
        model.addAttribute("imputationList", referentielService.imputationsList());
        model.addAttribute("autoriteContractanteList", referentielService.autoriteContractantesList());
        model.addAttribute("autoriteContractanteStructuresList", referentielService.structureAutoriteContractantesList());
        model.addAttribute("typesMarcheList", referentielService.typeMarchesList());
        model.addAttribute("modesPassationList", referentielService.modePassationsList());

        return "marche/editForm";
    }


    @PostMapping("/update")
    public String update(
            @ModelAttribute @Valid MarcheDTO marcheDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("bindingResult", bindingResult);

            model.addAttribute("imputationList", referentielService.imputationsList());

            model.addAttribute("autoriteContractanteList", referentielService.autoriteContractantesList());

            model.addAttribute("autoriteContractanteStructuresList", referentielService.structureAutoriteContractantesList());

            model.addAttribute("typesMarcheList", referentielService.typeMarchesList());

            model.addAttribute("modesPassationList", referentielService.modePassationsList());

            return "marche/editForm";
        }

        marcheService.update(marcheDTO);

        Map<String, String> messages = new HashMap<>();
        messages.put("success", "Marché modifié avec succes.");

        redirectAttributes.addFlashAttribute("messages", messages);


        return "redirect:/marche/list";
    }



    @GetMapping("/delete/{id}")
    public String deleteMarche( @PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {

        Map<String, String> messages = new HashMap<>();

        Optional<MarcheDTO> marcheOpt = marcheService.findOneMarcheById(id);

        if (marcheOpt.isEmpty()) {
            messages.put("danger", "Marché introuvable pour l'id " + id);
            redirectAttributes.addFlashAttribute("messages", messages);
            return "redirect:/marche/list";
        }

        MarcheDTO marcheDTO = marcheOpt.get();

        List<ActiviteDTO> activites = marcheService.marcheActiviteList(id);
        List<NifDTO> nifs = marcheService.marcheNifList(id);

        model.addAttribute("marcheDTO", marcheDTO);
        model.addAttribute("marcheActiviteDTOs", activites);
        model.addAttribute("marcheNifDTOs", nifs);
        model.addAttribute("messages", messages);

        return "marche/delete";
    }



    @GetMapping("/delete/Delete/{id}")
    public String DeleteMarche(@PathVariable Long id,  RedirectAttributes redirectAttributes) {

        Map<String, String> messages = new HashMap<>();
        List<ActiviteDTO> activites = marcheService.marcheActiviteList(id);

        for (ActiviteDTO activite : activites) {
            marcheService.deleteActivite(activite.getId());
        }

        List<NifDTO> nifs = marcheService.marcheNifList(id);

        for (NifDTO nif : nifs) {
            marcheService.deleteNif(nif.getId());
        }

        marcheService.deleteMarche(id);

        messages.put("success", "Marché supprimé avec succès");
        redirectAttributes.addFlashAttribute("messages", messages);

        return "redirect:/marche/list";
    }





}
