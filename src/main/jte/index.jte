@import java.util.Map

@param Map<String, String> messages

@template.layout(
title = "Page d'accueil",
messages = messages,
content = @`
    <span>
        Bienvenue <strong> CEBIB-MARCHE</strong>
    </span>

`)
