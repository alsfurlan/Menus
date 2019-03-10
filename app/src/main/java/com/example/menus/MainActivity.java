package com.example.menus;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menus; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_home) {
            inicio();
            return true;
        } else if(id == R.id.action_settings) {
            configuracoes();
            return true;
        } else if(id == R.id.action_notifications) {
            notificacoes();
            return true;
        } else if(id == R.id.action_exit) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void notificacoes() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(R.string.alerta);
        alert.setMessage(getMsg(R.string.action_notifications));
        alert.setPositiveButton(getString(R.string.ok), null);
        alert.setNegativeButton(getString(R.string.cancelar), null);
        alert.show();
    }

    private void configuracoes() {
        String msg = getMsg(R.string.action_settings);
        View viewById = findViewById(R.id.contentMain);
        Snackbar
                .make(viewById, msg, Snackbar.LENGTH_LONG)
                .show();
    }

    private void inicio() {
        String msg = getMsg(R.string.action_home);
        Toast
                .makeText(this, msg, Toast.LENGTH_LONG)
                .show();
    }

    private String getMsg(int resId) {
        return getString(R.string.mensagem).concat(" ").concat(getString(resId));
    }
}
