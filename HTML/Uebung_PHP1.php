<!DOCTYPE html>
<html lang="de">

<head>
    <meta charset="utf-8" />
    <title>PHP in (X)HTML einbinden</title>
    <link rel="stylesheet" type="text/css" href="styleU1.css" />
</head>

<body>
    <?php
    $vorname = "Alain";
    $name = "Berset";
    $firma = "Eidgenössisches Departement des Inneren";
    $strasse = "Bundesplatz 3";
    $ort = "3005 Bern";
    $telefon = "+41 31 322 87 90";
    $fax = "+41 58 462 78 32";

    echo "<h1>" . "Profil von $vorname $name" . "</h1><br>";
    echo "Name              " . "<strong>" . "$name" . "</strong><br>";
    echo "Vorname           " . "<strong>" . "$vorname" . "</strong><br>";
    echo "Organisation      " . "<strong>" . "$firma" . "</strong><br>";
    echo "Strasse           " . "<strong>" . "$strasse" . "</strong><br>";
    echo "Ortschaft         " . "<strong>" . "$ort" . "</strong><br>";
    echo "Telefonnummer     " . "<strong>" . "$telefon" . "</strong><br>";
    echo "Faxnummer         " . "<strong>" . "$fax" . "</strong><br>";
    ?>
    
</body>

</html>