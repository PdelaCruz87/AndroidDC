<?php
//Incluyendo la clase de la conección 
include_once("conection.php");
//Creando array para contener la informacion para trasladar o recepcionar informacion
$jsonArray = array();
//Definiendo campos que serán utilizados
if(isset($_GET["nombre_producto"])&&isset($_GET["fecha_producto"])&&
isset($_GET["precio_producto"])&&isset($_GET["ubicacion_producto"])){

//Declarando variables a insertar
$nombre_producto = $_GET["nombre_producto"];
$fecha_producto =$_GET["fecha_producto"];
$precio_producto =$_GET["precio_producto"];
$ubicacion_producto=$_GET["ubicacion_producto"];
//Declaracion de la consulta a realizar
$insertar = "INSERT INTO tbl_producto (nombre_producto, fecha_producto, 
precio_producto, ubicacion_producto) VALUES ('{$nombre_producto}','{$fecha_producto}',{$precio_producto},'{$ubicacion_producto}');";
//Obtenemos el resultado de la conexion y la consulta que se fue a realizar a la BDD
$resultado =  mysqli_query($connection, $insertar) or die ('Error'. mysqli_error($connection));
//Agregar el resultado como dato array

$jsonArray["tbl_producto"][]= $resultado;
//Asignacion del arreglo al JSON para la estructura a manipular
echo json_encode($jsonArray);
mysqli_close($connection);
}else{
echo json_encode ($jsonArray);
mysqli_close ($connection);
//echo 'Datos no insertados';
}

?>