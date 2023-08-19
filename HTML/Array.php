<!DOCTYPE html>
<html>

<body>
    <?php
        $persArray = array("Nr" => 1, 
        "Name" => "Müller", 
        "Vorname" => "Hans", 
        "Strasse" => "Erlenweg 3", 
        "Land" => "CH", 
        "PLZ" => "2540", 
        "Ort" => "Grenchen", 
        "Tel" => "0321234567", 
        "EMail" => "hans.Mueller@sowieso.ch");

        foreach ($persArray as $key => $value){
            echo $key . ": " . $value . "<br/>";
        }
        echo "<br/>";

        $outPut ="<table width=380 border=\"1\">
        <tr>
        <td width=\"130\">Kundennummer:</td>
        <td width=\"250\">$persArray[Nr]</td>
        </tr>
        <tr>
        <td>Vorname, Name:</td>
        <td>$$persArray[Vorname] , $persArray[Name]</td>
        </tr>
        <tr>
        <td>Land, PLZ, Ort:</td>
        <td>$persArray[Land] , $persArray[PLZ], $persArray[Ort]</td>
        </tr>
        <tr>
        <td>Kontakt Tel.:</td>
        <td>$persArray[Tel]</td>
        </tr>
        <tr>
        <td>Email:</td>
        <td>$persArray[EMail]</td>
        </tr>
        </table>";
        echo $outPut;
        ?>

</body>

</html>