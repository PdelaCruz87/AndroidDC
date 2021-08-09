package Complementos;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class MetodosSW {
    //Declarando la constante de IP del servidor en mi red lan
    public static final String IP_SERVER = "http://192.168.0.6/";
    //Implementar variables para la conexion y obtencion de informacion
    Context context;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    public MetodosSW() {

    }

    //Metodo insertar
    public void insertarSW(Context context, String nombre, String fecha,
                           int precio, String ubicacion,
                           Response.Listener listener, Response.ErrorListener errorListener) {

        this.context = context;
        try {
            String url;
            url = IP_SERVER + "producto_sw/insertar_sw.php?nombre_producto=" +
                    nombre + "&fecha_producto=" + fecha + "&precio_producto=" +
                    precio + "&ubicacion_producto=" + ubicacion;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener);
            requestQueue.add(jsonObjectRequest);

        } catch (Exception e) {
            Toast.makeText(context, "Conflicto I: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            System.err.println("-----" + e.getCause() + "-----" + e.getMessage());
        }
    }

    //Metodo Buscar por ID
    public void buscarIDSW(Context context, int id, Response.Listener listener, Response.ErrorListener errorListener) {
        this.context = context;
        try {
            String url;
            url = IP_SERVER + "producto_sw/buscar_sw.php?id_producto=" + id;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener);
            requestQueue.add(jsonObjectRequest);

        } catch (Exception e) {
            Toast.makeText(context, "ConflictoB: " + e.getCause() + " *** " + e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("B---- " + e.getCause() + " *** " + e.getMessage());
        }

    }

    //Mètodo Consultar
    public void consultarSW(Context context, Response.Listener listener,
                            Response.ErrorListener errorListener) {
        this.context = context;
        try {
            String url;
            url = IP_SERVER + "producto_sw/mostrar_sw.php";
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener);
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {

            Toast.makeText(context, "ConflictoC: " + e.getCause() + " *** " + e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("C---- " + e.getCause() + " *** " + e.getMessage());

        }

    }

    //Método Eliminar
    public void eliminarSW(Context context, int id, Response.Listener listener,
                           Response.ErrorListener errorListener) {
        this.context = context;
        try {
            String url;
            url = IP_SERVER + "producto_sw/eliminar_sw.php?id_producto=" + id;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener);
            requestQueue.add(jsonObjectRequest);

        } catch (Exception e) {

            Toast.makeText(context, "ConflictoEliminar: " + e.getCause() + " *** " + e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("E---- " + e.getCause() + " *** " + e.getMessage());

        }

    }

    //Método Actualizar
    public void actualizarSW(Context context, int id, String nombre, String fecha, int precio, String ubicacion,
                             Response.Listener listener, Response.ErrorListener errorListener) {
        this.context = context;

        try {
            String url;
            url = IP_SERVER + "producto_sw/actualizar_sw.php?id_producto=" + id + "&nombre_producto=" +
                    nombre + "&fecha_producto=" + fecha + "&precio_producto=" + precio + "&ubicacion_producto=" + ubicacion;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener);
            requestQueue.add(jsonObjectRequest);

        } catch (Exception e) {
            Toast.makeText(context, "ConflictoActualizar: " + e.getCause() + " *** " + e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("Ac---- " + e.getCause() + " *** " + e.getMessage());
        }

    }

}
