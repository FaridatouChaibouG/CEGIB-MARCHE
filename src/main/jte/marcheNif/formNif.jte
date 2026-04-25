@import com.advinteck.cegib.dto.NifDTO
@import com.advinteck.cegib.generated.referentiel.tables.pojos.*
@import org.springframework.validation.BindingResult
@import java.util.Map


@param BindingResult  bindingResult
@param NifDTO nifDTO
@param Map<String, String> messages


@template.layout(
title = "Formulaire d'ajout",
messages = messages,
content = @`
    <div class="card">
        <div class="card-body">
            <form action="/marcheNif/savemarcheNif" method="post">
                <div class="row mb-3">

                    <div class="form-floating mb-3 ">
                        <input type="text" class="form-control" id="identifiant" name="identifiant" placeholder="Identifiant" value="${nifDTO.getIdentifiant()}">
                        <label for="identifiant"> Numéro du marché </label>
                        @template.formMessage(bindingResult = bindingResult, field = "identifiant")

                    </div>



                    <div class="form-floating mb-3 ">
                        <input type="text" class="form-control" id="raisonSociale" name="raisonSociale" placeholder="RaisonSociale" value="${nifDTO.getRaisonSociale()}">
                        <label for="raisonSociale"> Raison Sociale </label>
                        @template.formMessage(bindingResult = bindingResult, field = "raisonSociale")

                    </div>

                   <div>
                    <button type="submit" class="btn btn-primary">Enregistrer</button>
                    <a href="/marche/details" class="btn btn-warning">Retour</a>
                    </div>

                </div>
            </form>
        </div>
    </div>
    <script>

    </script>
`)

