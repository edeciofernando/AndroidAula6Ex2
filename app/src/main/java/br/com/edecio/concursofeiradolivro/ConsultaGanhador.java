package br.com.edecio.concursofeiradolivro;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by edecio on 14/09/2017.
 */

public class ConsultaGanhador extends AsyncTask<String, Void, String> {

    private TextView txt;

    public ConsultaGanhador(TextView txt) {
        this.txt = txt;
    }

    @Override
    protected String doInBackground(String... params) {
        String vencedor = "";
        String ws = params[0];

        try {
            URL url = new URL(ws);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                if (in != null) {
                    BufferedReader bf = new BufferedReader(new InputStreamReader(in));
                    vencedor = bf.readLine();
                }

            } finally {
                urlConnection.disconnect();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vencedor;
    }

    @Override
    protected void onPostExecute(String s) {
        String[] partes = s.split(";");
        txt.setText("Nome: " + partes[0]+"\n\nFrase: "+partes[1]);
    }
}
