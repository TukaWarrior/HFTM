<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>Übung 2: Wahrheitstabelle V1</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <style>
        body {
            font-family: Arial, sans-serif;
            font-size: 12px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th,
        td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
    </style>
</head>

<body>
    <table>
        <thead>
            <tr>
                <th>$a</th>
                <th>$b</th>
                <th>$a and $b</th>
                <th>$a or $b</th>
                <th>$a xor $b</th>
            </tr>
        </thead>
        <tbody>
            <?php
            echo "<h1>" . "Wahrheitstabelle" . "</h1><br>";
            $a_values = array(true, true, false, false);
            $b_values = array(true, false, true, false);

            for ($i = 0; $i < count($a_values); $i++) {
                $a = $a_values[$i];
                $b = $b_values[$i];

                echo "<tr>";
                echo "<td>" . ($a ? 'true' : 'false') . "</td>";
                echo "<td>" . ($b ? 'true' : 'false') . "</td>";
                echo "<td>" . ($a && $b ? 'true' : 'false') . "</td>";
                echo "<td>" . ($a || $b ? 'true' : 'false') . "</td>";
                echo "<td>" . ($a xor $b ? 'true' : 'false') . "</td>";
                echo "</tr>";
            }
            ?>
        </tbody>
    </table>
</body>

</html>