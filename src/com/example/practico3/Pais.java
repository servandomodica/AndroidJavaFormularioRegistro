package com.example.practico3;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;


public class Pais extends Activity {
	TextView tv1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pais);
		tv1=(TextView)findViewById(R.id.textView1);
		
		Bundle pais=getIntent().getExtras();
		String paisSelecc=pais.getString("paisSel");
		tv1.setText("El país seleccionado es: "+paisSelecc);
		
	}

	public void retornar (View v) {
		finish();
	}

}
