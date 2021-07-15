// Generated by view binder compiler. Do not edit!
package com.example.app_traslado_datos.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.app_traslado_datos.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnEnviar;

  @NonNull
  public final ImageView imgInicio;

  @NonNull
  public final EditText txtApe;

  @NonNull
  public final EditText txtDire;

  @NonNull
  public final EditText txtEdad;

  @NonNull
  public final EditText txtNom;

  @NonNull
  public final EditText txtTel;

  private ActivityMainBinding(@NonNull LinearLayout rootView, @NonNull Button btnEnviar,
      @NonNull ImageView imgInicio, @NonNull EditText txtApe, @NonNull EditText txtDire,
      @NonNull EditText txtEdad, @NonNull EditText txtNom, @NonNull EditText txtTel) {
    this.rootView = rootView;
    this.btnEnviar = btnEnviar;
    this.imgInicio = imgInicio;
    this.txtApe = txtApe;
    this.txtDire = txtDire;
    this.txtEdad = txtEdad;
    this.txtNom = txtNom;
    this.txtTel = txtTel;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_enviar;
      Button btnEnviar = rootView.findViewById(id);
      if (btnEnviar == null) {
        break missingId;
      }

      id = R.id.img_inicio;
      ImageView imgInicio = rootView.findViewById(id);
      if (imgInicio == null) {
        break missingId;
      }

      id = R.id.txt_Ape;
      EditText txtApe = rootView.findViewById(id);
      if (txtApe == null) {
        break missingId;
      }

      id = R.id.txt_Dire;
      EditText txtDire = rootView.findViewById(id);
      if (txtDire == null) {
        break missingId;
      }

      id = R.id.txt_Edad;
      EditText txtEdad = rootView.findViewById(id);
      if (txtEdad == null) {
        break missingId;
      }

      id = R.id.txt_Nom;
      EditText txtNom = rootView.findViewById(id);
      if (txtNom == null) {
        break missingId;
      }

      id = R.id.txt_tel;
      EditText txtTel = rootView.findViewById(id);
      if (txtTel == null) {
        break missingId;
      }

      return new ActivityMainBinding((LinearLayout) rootView, btnEnviar, imgInicio, txtApe, txtDire,
          txtEdad, txtNom, txtTel);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
