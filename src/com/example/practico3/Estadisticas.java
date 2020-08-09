package com.example.practico3;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;


public class Estadisticas extends Activity {
	TextView tv1,tv2,tv3;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_estadisticas);
		tv1=(TextView)findViewById(R.id.textView1);
		tv2=(TextView)findViewById(R.id.textView2);
		tv3=(TextView)findViewById(R.id.textView3);
		
		Bundle contador=getIntent().getExtras();
		
		String contaArg=contador.getString("Argentina");
		tv1.setText("El país Argentina ha ingresado "+contaArg+" veces");
		
		String contaBr=contador.getString("Brasil");
		tv2.setText("El país Brasil ha ingresado "+contaBr+" veces");
		
		String contaCh=contador.getString("Chile");
		tv3.setText("El país Chile ha ingresado "+contaCh+" veces");
	}

	public void retornar (View v) {
		finish();
	}

}
