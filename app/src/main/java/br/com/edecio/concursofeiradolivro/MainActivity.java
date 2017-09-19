package br.com.edecio.concursofeiradolivro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGanhador;
    private TextView txtFrase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGanhador = (Button) findViewById(R.id.btnGanhador);
        txtFrase = (TextView) findViewById(R.id.txtFrase);

        btnGanhador.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ConsultaGanhador consultaGanhador = new ConsultaGanhador(txtFrase);
        consultaGanhador.execute("http://10.0.2.2/wsconcurso/ganhador.php");
    }
}
