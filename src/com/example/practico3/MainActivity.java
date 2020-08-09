package com.example.practico3;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;


public class MainActivity extends Activity {
	EditText et1,et2,et3;
	TextView tv1,tv2,tv3,tv4;
	CheckBox cb1;
	Spinner spinner1;
	ArrayList<String> lista1;
	ArrayAdapter<String> adaptador1;
	int cantArgentina,cantChile,cantBrasil;
	Button b4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3);
        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);
        tv3=(TextView)findViewById(R.id.textView3);
        tv4=(TextView)findViewById(R.id.textView4);
        cb1=(CheckBox)findViewById(R.id.checkBox1);
        
        b4=(Button)findViewById(R.id.button4);
        b4.setEnabled(false);
        
        spinner1=(Spinner)findViewById(R.id.spinner1);
                
        lista1=new ArrayList<String>();
        lista1.add("--No seleccionado--");
        lista1.add("Argentina");
        lista1.add("Brasil");
        lista1.add("Chile");
        
        ArrayAdapter<String> adaptador1=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista1);
        spinner1.setAdapter(adaptador1);
                
    }
    
    public void confirmar (View v) {
    	String nombre=et1.getText().toString();
    	String mailA=et2.getText().toString();
    	String mailB=et3.getText().toString();
    	
    	String pais=spinner1.getSelectedItem().toString();
    	
    	if (cb1.isChecked()==false) {
    		Toast.makeText(this, "Debés aceptar términos y condiciones.", Toast.LENGTH_LONG).show();
    	}else if(nombre.length()==0){
    		Toast.makeText(this, "El apellido y nombres no pueden estar vacíos.", Toast.LENGTH_LONG).show();
    	}else if (mailA.equals(mailB)==false || mailA.length()==0){
    		Toast.makeText(this, "Debés ingresar dos casillas de e-mail iguales.", Toast.LENGTH_LONG).show();
    	}else if(pais=="--No seleccionado--") {
    		Toast.makeText(this, "Debés seleccionar un país.", Toast.LENGTH_LONG).show();
    	}else{
    		Toast.makeText(this, "Los datos han sido completados y enviados correctamente.", Toast.LENGTH_LONG).show();
    		
    		b4.setEnabled(true);
    		
        	et1.setText("");
        	et2.setText("");
        	et3.setText("");
        	spinner1.setSelection(0);
        	cb1.setChecked(false);	
        	
        	if(pais.equals("Argentina")) {
        		cantArgentina=cantArgentina+1;
        	}
        	if(pais.equals("Brasil")) {
        		cantBrasil=cantBrasil+1;
        	}
        	if(pais.equals("Chile")) {
        		cantChile=cantChile+1;
        	}
        	
        	Intent intento1=new Intent(this, Pais.class);
        	intento1.putExtra("paisSel", pais);
        	startActivity(intento1);
    	}

    }
    
    public void borrar (View v) {
    	et1.setText("");
    	et2.setText("");
    	et3.setText("");
    	spinner1.setSelection(0);
    	cb1.setChecked(false);	
    	    	
    	Toast.makeText(this, "Todos los campos se han restablecido.", Toast.LENGTH_LONG).show();
    }
    
    public void verEstadisticas (View v) {
    	Intent intento1=new Intent(this, Estadisticas.class);
    	intento1.putExtra("Argentina", String.valueOf(cantArgentina));
    	intento1.putExtra("Brasil", String.valueOf(cantBrasil));
    	intento1.putExtra("Chile", String.valueOf(cantChile));
    	startActivity(intento1);
    }

    public void salir (View v) {
    	finish();
    }
    
}
