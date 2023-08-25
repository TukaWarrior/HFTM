!DOCTYPE html>
<html>
<body>

<?php

// Syntax
// PHP Keywords are not case-sensitive
ECHO "Hello World!<br>";
echo "Hello World!<br>";
EcHo "Hello World!<br>";

// PHP variable names are case-sensitive
$color = "red";
echo "My car is " . $color . "<br>";
echo "My house is " . $COLOR . "<br>";
echo "My boat is " . $coLOR . "<br>";


// Variables
/* 
A variable starts with the $ sign, followed by the name of the variable
A variable name must start with a letter or the underscore character
A variable name cannot start with a number
A variable name can only contain alpha-numeric characters and underscores (A-z, 0-9, and _ )
Variable names are case-sensitive ($age and $AGE are two different variables)
*/

// Examples
$txt = "Hello world!";
$x = 5;
$y = 10.5;

echo "I love $txt!";
echo "I love " . $txt . "!";
echo $x + $y;


// Constants
define("Pi",3.141);


//Test of a variable is set
isset($myVar); /* Outputs True if set, false if variable is NULL */

$myVar1 = "A string"; /* String */
$myVar2 = "4711"; /* String */
$myVar3 = 4711; /* Integer */
$myVar4 = 4711.1; /* Double / Float */
$myVar1 = 54e-4; /* Double / Float */
$myVar1 = ssqrt(2); /* Double / Float */

echo "<b>\$myVar3</b> hat den Inhalt
<b>\"$myVar3\"</b> und Datentyp:<b>" .
gettype($myVar3)."</b>.<br>";
// $myVar3 hat den Inhalt "4711" und Datentyp:integer


// Variable Scope
/*
The scope of a variable is the part of the script where the variable can be referenced/used.
PHP has three different variable scopes: local, global, static
*/

// Global Scope
$x = 5; // global scope

function myTest() {
  // using x inside this function will generate an error
/*  echo "<p>Variable x inside function is: $x</p>"; */
}
myTest();

echo "<p>Variable x outside function is: $x</p>";


/* Special Characters
\\ // \
\n // New Line
\t // Tabulator
\$ // $
\" // "
\r // Return
\v // Vertical Tabulator
\f // Form Feed
\' // '
*/

// Change Datatype
gettype(); // Returns Data Type
is_int(); // Tests if datatype is int
is_float(); // Tests if datataype is double
is_array(); 
is_object();
is_numeric(); 
is_string();
is_bool();
is_scalar(); // Tests if a numeric value is present
is_resource();
is_NULL();  


// Explicit assignment
$myVar = (double)12; 


// Typecasting
$myVar=2.75; settype($myVar, "integer");
settype($myVar,
"float");
settype($myVar,
"string");
$myVar=2.75; intval($myVar);
$myVar="3.1Bar"; doubleval($myVar);
$myVar=2.75; strval($myVar); 


// Operators
// +, -, *, /, % 
// +=, -=, *=, /=, %=, ++, --
// . .= (To connect Strings)
// and (&&), or (||), xor (Logical operators)
// &, |, ! (Alters operatoirs)
// <, <=, >, >=, ==, !=, ===, !==


// If Statement
if ($i<0) {
    echo "$i ist kleiner als Null\n";
}



// If-Else Statement
if ($i<0) {
    echo "$i ist kleiner als Null\n";
    } else {
    echo "$i ist nicht kleiner als Null\n";
} 



// If-Else If-If Statement
if ($i<0) {
    echo "$i ist kleiner als Null\n";
    }
    else if ($i>0) {
    echo "$i ist groesser als Null\n";
    }
    else {
    echo "$i ist Null\n";
} 


// Switch-Case
switch ($ampelStatus) {
    case "Grün":
    echo "Go!";
    break;
    case "Orange":
    echo "Mach vorwärts!";
    break;
    case "Rot":
    echo "Stehen geblieben!";
    break;
    default:
    echo "Wo sind wir denn gelandet?";
} 


// Iteration
$i = 0;
while ($i<10) {
    echo $i;
    $i++;
}


// Do-While
$i = 0;
do {
    echo $i;
    $i++;
} while ($i<10);


// For-Loop
$i = 0;
for ($i=0; $i<10; $i++) {
    echo $i;
} 
?>

</body>
</html>