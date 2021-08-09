<?php

include_once("conection.php");
$jsonArray=array();
$consulta = "SELECT * FROM tbl_producto";
$resultado = mysqli_query($connection, $consulta) or die ("Error".mysqli_error($connection));

if($resultado==true){
while ($registro = mysqli_fetch_array($resultado)){
$jsonArray["tbl_producto"][]=$registro;
}
echo json_encode($jsonArray);
mysqli_close($connection);
}
else{
    
    $resultadoVacio["nombre_producto"]="...";
    $resultadoVacio["fecha_producto"]="...";
    $resultadoVacio["precio_producto"]="...";
    $resultadoVacio["ubicacion_producto"]="...";
    $jsonArray["tbl_producto"][]=$resultadoVacio;
echo json_encode($jsonArray);
mysqli_close($connection);
}



?>