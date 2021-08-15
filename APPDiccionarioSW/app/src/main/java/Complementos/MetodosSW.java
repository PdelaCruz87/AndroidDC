package Complementos;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class MetodosSW {

    //Declarando la IP
    public static final String IP_SERVER = "http://192.168.0.2/";
    //Implementando variables para la conexiòn y obtenciòn de informaciòn
    Context context;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    public MetodosSW() {
    }

    //Mètodo Consultar
    public void consultarSW(Context context, Response.Listener listener,
                            Response.ErrorListener errorListener) {
        this.context = context;
        try {
            String url;
            url = IP_SERVER + "diccionario_sw/mostrar_sw.php";
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener);
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {

            Toast.makeText(context, "ConflictoC: " + e.getCause() + " *** " + e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("C---- " + e.getCause() + " *** " + e.getMessage());

        }

    }



}
