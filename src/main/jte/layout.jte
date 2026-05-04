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
    <title>${title} | CEGIB </title>

    <script src="/jquery.min.js"></script>

    <!-- AJOUT : CSS DataTables -->
    <link href="/dataTables/dataTables.min.css" rel="stylesheet">

    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/bootstrap/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="/bootstrap-icons/bootstrap-icons.min.css">
    <script src="/slimselect/slimselect.js"></script>
    <link rel="stylesheet" href="/slimselect/slimselect.css">

    <!-- AJOUT : JS DataTables (doit être après jQuery) -->
    <script src="/dataTables/dataTables.min.js"></script>

    <style>
        /* ... Votre style existant reste identique ... */
        :root {
            --cegib-green: #198754;
            --cegib-light-green: #e9f5ee;
            --sidebar-width: 260px;
        }
        body { background-color: #f4f7f6; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }
        .sidebar { width: var(--sidebar-width); min-height: 100vh; background: var(--cegib-green); color: white; box-shadow: 4px 0 10px rgba(0,0,0,0.1); }
        .sidebar .nav-link { color: rgba(255,255,255,0.8); padding: 12px 20px; margin: 5px 15px; border-radius: 8px; font-weight: 500; }
        .sidebar .nav-link:hover { background: rgba(255,255,255,0.1); color: #fff; }
        .sidebar .nav-link.active { background: #fff; color: var(--cegib-green) !important; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }
        .main-wrapper { flex-grow: 1; display: flex; flex-direction: column; }
        .top-navbar { background: #fff; border-bottom: 2px solid var(--cegib-green); padding: 12px 25px; }
        .card { border: none; border-top: 4px solid var(--cegib-green); border-radius: 10px; box-shadow: 0 5px 15px rgba(0,0,0,0.05); }
        .card-header { background: #fff; font-weight: bold; color: var(--cegib-green); }
        .alert { border: none; border-left: 5px solid; }
    </style>
</head>

<body class="d-flex h-100">
<!-- ... Le reste du body reste identique ... -->
<nav class="sidebar d-none d-md-block">
    <div class="p-4 text-center border-bottom border-white border-opacity-25 mb-3">
        <h4 class="text-white fw-bold mb-0">CEGIB MARCHE</h4>
        <small class="text-white-50">Gestion des Marchés</small>
    </div>
    <ul class="nav flex-column">
        <li class="nav-item">
            <a class="nav-link @if(title.equals("Accueil")) active @endif" href="/">
                <i class="bi bi-house-door-fill me-2"></i> Accueil
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link @if(title.contains("Marche")) active @endif" href="/marche/list">
                <i class="bi bi-file-earmark-text-fill me-2"></i> Marchés
            </a>
        </li>

<%--        <li class="nav-item">--%>
<%--            <a class="nav-link @if(title.contains("Marche")) active @endif" href="/marche/listValider">--%>
<%--                <i class="bi bi-file-earmark-text-fill me-2"></i> Marché validé--%>
<%--            </a>--%>
<%--        </li>--%>
    </ul>
</nav>

<div class="main-wrapper">
    <header class="top-navbar d-flex justify-content-between align-items-center">
        <h5 class="mb-0 fw-bold text-uppercase" style="color: var(--cegib-green);">${title}</h5>
        <!-- ... Dropdown utilisateur ... -->
    </header>

    <main class="container-fluid p-4">
        @if(null != messages && !messages.isEmpty())
            <div class="mb-4">
                @for(var el: messages.entrySet())
                    <div class="alert alert-${el.getKey()} shadow-sm bg-white" role="alert">
                        <i class="bi bi-info-circle me-2"></i> ${el.getValue()}
                    </div>
                @endfor
            </div>
        @endif

        <div class="card">
            <div class="card-body p-4">
                ${content}
            </div>
        </div>
    </main>

    <footer class="mt-auto bg-white py-3 border-top text-center text-muted small">
        &copy; 2026 <strong>CEGIB</strong> - Système de Gestion <span class="ms-2 badge bg-success">v0.0.1</span>
    </footer>
</div>
</body>
</html>
