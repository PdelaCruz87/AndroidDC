
<?php

include_once ("conection.php");
$jsonArray = array();
if(isset($_GET["id_producto"])){
$id_producto = $_GET["id_producto"];

$buscarId = "SELECT nombre_producto, fecha_producto, precio_producto, ubicacion_producto
FROM tbl_producto WHERE id_producto =  $id_producto";
$resultado = mysqli_query($connection, $buscarId) or die ("Error ". mysqli_error($connection));

if($registros = mysqli_fetch_array($resultado)){
    $jsonArray["tbl_producto"][] = $registros;
    
}else{
    $jsonArray["tbl_producto"][]=$registros;
echo 'Datos no encontrados';
}
echo json_encode($jsonArray);
mysqli_close($connection);
}else{

echo json_encode($jsonArray);
   mysqli_close($connection);
    echo 'Datos no encontrados';

}


?>