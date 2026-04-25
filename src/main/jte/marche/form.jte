@import com.advinteck.cegib.generated.referentiel.tables.pojos.*
@import org.springframework.validation.BindingResult
@import java.util.List
@import java.util.Map
@import com.advinteck.cegib.dto.MarcheDTO

@param BindingResult  bindingResult
@param MarcheDTO marcheDTO
@param Map<String, String> messages
@param List<TypesMarche>  typeMarcheList
@param List<Imputation>  imputationList
@param List<AutoriteContractante>  autoriteContractanteList
@param List<AutoriteContractanteStructures>  structureAutoriteContractanteList
@param List<ModesPassation>  modePassationList

@template.layout(
title = "Formulaire d'ajout du marché",
messages = messages,
content = @`
   <div class="card">
       <div class="card-body">
           <form action="/marche/save" method="post">
               <div class="row mb-3">

                   <div class="form-floating mb-3 col-md-6">
                       <input type="text" class="form-control" id="numMarche" name="numMarche" placeholder="NumMarche" value="${marcheDTO.getNumMarche()}">
                       <label for="numMarche"> Numéro du marché </label>
                       @template.formMessage(bindingResult = bindingResult, field = "numMarche")

                   </div>

                   <div class="form-floating mb-3 col-md-6">
                       <select class="form-select" name="imputation" id="imputation">
                           <option value="">Veuillez selectionner
                           </option>
                           @for(var el: imputationList)
                               <option selected="${marcheDTO.getImputation() != null  && marcheDTO.getImputation().equals(el.getImputation())}" value="${el.getImputation()}">
                                   ${el.getImputation()} - ${el.getIntitule()}
                               </option>
                           @endfor
                       </select>
                       <label for="imputation"> Imputation </label>
                       @template.formMessage(bindingResult = bindingResult, field = "imputation")
                   </div>

                   <div class="form-floating mb-3 ">
                       <input type="text" class="form-control" id="objetMarche" name="objetMarche" placeholder="ObjetMarche" value="${marcheDTO.getObjetMarche()}">
                       <label for="objetMarche"> Objet du marché </label>
                       @template.formMessage(bindingResult = bindingResult, field = "objetMarche")

                   </div>

                   <div class="form-floating mb-3 col-md-6">
                       <input type="date" class="form-control" id="dateApprobation" name="dateApprobation" placeholder="Date d'approbation" value="">
                       <label for="dateApprobation"> Date d'approbation </label>
                       @template.formMessage(bindingResult = bindingResult, field = "dateApprobation")

                   </div>

                   <div class="form-floating mb-3 col-md-6">
                       <select class="form-select" name="autoriteContractanteCode" id="autoriteContractanteCode">
                           <option value="">Veuillez selectionner
                           </option>
                           @for(var el: autoriteContractanteList)
                               <option selected="${marcheDTO.getAutoriteContractanteCode() != null  && marcheDTO.getAutoriteContractanteCode().equals(el.getCode())}" value="${el.getCode()}">
                                   ${el.getCode()} - ${el.getIntitule()}
                               </option>
                           @endfor
                       </select>
                       <label for="autoriteContractante"> Autorité Contractante </label>
                       @template.formMessage(bindingResult = bindingResult, field = "autoriteContractante")
                   </div>

                   <div class="form-floating mb-3 col-md-6">
                       <select class="form-select" name="structureAutoriteContractanteCode" id="structureAutoriteContractanteCode">
                           <option value="">Veuillez selectionner
                           </option>
                           @for(var el: structureAutoriteContractanteList)
                               <option selected="${marcheDTO.getStructureAutoriteContractanteCode() != null   && marcheDTO.getStructureAutoriteContractanteCode().equals(el.getCode())}" value="${el.getCode()}" >
                                   ${el.getCode()} - ${el.getIntitule()}
                               </option>
                           @endfor
                       </select>
                       <label for="structureAutoriteContractante"> Structure de l'autorité contractante </label>
                       @template.formMessage(bindingResult = bindingResult, field = "structureAutoriteContractante")
                   </div>

                   <div class="form-floating mb-3 col-md-6">
                       <input type="text" class="form-control" id="approuvePar" name="approuvePar" placeholder="ApprouvePar" value="${marcheDTO.getApprouvePar()}">
                       <label for="approuvePar"> Approuvé par </label>
                       @template.formMessage(bindingResult = bindingResult, field = "approuvePar")

                   </div>

                   <div class="form-floating mb-3 col-md-6">
                       <input type="text" class="form-control" id="titulaireMarche" name="titulaireMarche" placeholder="TitulaireMarche" value="${marcheDTO.getTitulaireMarche()}">
                       <label for="titulaireMarche"> Titulaire du marché </label>
                       @template.formMessage(bindingResult = bindingResult, field = "titulaireMarche")

                   </div>

                   <div class="form-floating mb-3 col-md-6">
                       <select class="form-select" name="typeMarcheCode" id="typeMarcheCode">
                           <option value="">Veuillez selectionner
                           </option>
                           @for(var el: typeMarcheList)
                               <option selected="${marcheDTO.getTypeMarcheCode() != null   && marcheDTO.getTypeMarcheCode().equals(el.getCode())}" value="${el.getCode()}">
                                   ${el.getCode()} - ${el.getIntitule()}
                               </option>
                           @endfor
                       </select>
                       <label for="typeMarche"> Type de marché </label>
                       @template.formMessage(bindingResult = bindingResult, field = "typeMarche")
                   </div>


                   <div class="form-floating mb-3 col-md-6">
                       <select class="form-select" name="modePassationCode" id="modePassationCode">
                           <option value="">Veuillez selectionner
                           </option>
                           @for(var el: modePassationList)
                               <option selected="${marcheDTO.getModePassationCode() != null && marcheDTO.getModePassationCode().equals(el.getCode())}" value="${el.getCode()}">
                                   ${el.getCode()} - ${el.getIntitule()}
                               </option>
                           @endfor
                       </select>
                       <label for="modePassation"> Mode passation</label>
                       @template.formMessage(bindingResult = bindingResult, field = "modePassation")
                   </div>



               </div>


                <div>
                    <button type="submit" class="btn btn-primary">Enregistrer</button>
                    <a href="/marche/list" class="btn btn-warning">Retour</a>
                </div>
            </form>
        </div>
    </div>
    <script>
        new SlimSelect({
            select: '#typeMarches'
        });        new SlimSelect({
            select: '#imputations',
        });        new SlimSelect({
            select: '#autoriteContractantes'

        });
        new SlimSelect({            select: '#structureAutoriteContractantes'});
        new SlimSelect({
            select: '#titulaireMarches'
        });
        new SlimSelect({select: '#modePassations'});
    </script>
`)

