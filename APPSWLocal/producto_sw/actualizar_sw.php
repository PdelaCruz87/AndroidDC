<?php

include_once("conection.php");
$jsonArray = array();

if(isset($_GET["id_producto"])){
$id_producto = $_GET["id_producto"];
$nombre_producto = $_GET["nombre_producto"];
$fecha_producto = $_GET["fecha_producto"];
$precio_producto = $_GET["precio_producto"];
$ubicacion_producto = $_GET["ubicacion_producto"];

$actualizar = "UPDATE tbl_producto SET nombre_producto = '$nombre_producto',
fecha_producto = '$fecha_producto', precio_producto = $precio_producto, ubicacion_producto = '$ubicacion_producto'
WHERE id_producto = $id_producto";
$resultado = mysqli_query($connection, $actualizar) or die ("Error".mysqli_error($connection));
$jsonArray["tbl_producto"][] = $resultado;
echo json_encode($jsonArray);
mysqli_close($connection);

}
else{
    echo json_encode($jsonArray);
    mysqli_close($connection);

}

?>