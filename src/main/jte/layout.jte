@import gg.jte.Content
@import java.util.Map

@param String title
@param Content content
@param Map<String, String> messages

<!DOCTYPE html>
<html lang="fr" class="h-100">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <title>${title}</title>

    <script src="/jquery.min.js"></script>

    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/bootstrap/js/bootstrap.bundle.min.js"></script>

    <link rel="stylesheet" href="/bootstrap-icons/bootstrap-icons.min.css">

    <link href="/dataTables/dataTables.min.css" rel="stylesheet">
    <script src="/dataTables/dataTables.min.js"></script>

    <link href="/slimselect/slimselect.css" rel="stylesheet">
    <script src="/slimselect/slimselect.js"></script>
</head>

<body id="page-top" class="d-flex flex-column h-100">

<%--utilisation du sidebard--%>
<div id="content" class="flex-grow-1 d-flex">
    <nav class="bg-light border-end p-3" >
        <ul class="nav flex-column gap-2">

            <li class="nav-item">
                <a class="nav-link text-primary border-bottom" href="/">
                    <i class="bi bi-house-door me-2"></i> Acceuil
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link text-success border-bottom" href="/marche/list">
                    <i class="bi bi-markdown-fill me-2"></i>  Marche
                </a>
            </li>

        </ul>
    </nav>

<div id="content" class="flex-grow-1">

    <nav class="navbar navbar-expand-lg bg-success">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">CEGIB-MARCHE</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/"></a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>

    <main class="container-fluid px-4">
        <div class="content-body animate-up pt-4">
            <div class="mb-3">
                @if(null != messages && !messages.isEmpty())
                    @for(var el: messages.entrySet())
                        <span class="alert alert-${el.getKey()}"> ${el.getValue()} </span>
                    @endfor
                @endif
            </div>

            <div class="card">
                <div class="card-header h3"> ${title} </div>
                <div class="card-body">
                    ${content}
                </div>
            </div>
        </div>

    </main>
</div>
</div>
<footer class="bg-success border-top py-3">
    <div class="container-fluid px-4 d-flex justify-content-between align-items-center small text-muted">
        <span>&copy; 2026 <strong>CEGIB</strong></span>
        <span class="d-none d-sm-inline">Version 0.0.1-Dev</span>
    </div>

</footer>

</body>
</html>