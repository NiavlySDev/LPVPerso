package fr.niavlys.dev.lpvperso.stock;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import fr.niavlys.dev.lpvperso.R;

public class StockActivity extends Activity {

    private Button addBaseStock;
    private Button removeBaseStock;
    private Button resetBaseStock;

    private Button addNicoStock;
    private Button removeNicoStock;
    private Button resetNicoStock;

    private Button addFiole100Stock;
    private Button removeFiole100Stock;
    private Button resetFiole100Stock;

    private Button addFiole250Stock;
    private Button removeFiole250Stock;
    private Button resetFiole250Stock;

    private Button addFiole500Stock;
    private Button removeFiole500Stock;
    private Button resetFiole500Stock;

    private TextView baseNombreAffichage;
    private TextView nicoNombreAffichage;
    private TextView fiole100NombreAffichage;
    private TextView fiole250NombreAffichage;
    private TextView fiole500NombreAffichage;

    private Button retour;

    private Stock stock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock);

        initButton();
        initText();

        stock = new Stock();
        loadStock();
    }

    private void loadStock() {
        SharedPreferences sharedPreferences = getSharedPreferences("StockPrefs", MODE_PRIVATE);

        stock = new Stock();
        stock.setBase(sharedPreferences.getInt("base", 0));
        stock.setNico(sharedPreferences.getInt("nico", 0));
        stock.setFiole100(sharedPreferences.getInt("fiole100", 0));
        stock.setFiole250(sharedPreferences.getInt("fiole250", 0));
        stock.setFiole500(sharedPreferences.getInt("fiole500", 0));

        baseNombreAffichage.setText(String.valueOf(stock.getBase()));
        nicoNombreAffichage.setText(String.valueOf(stock.getNico()));
        fiole100NombreAffichage.setText(String.valueOf(stock.getFiole100()));
        fiole250NombreAffichage.setText(String.valueOf(stock.getFiole250()));
        fiole500NombreAffichage.setText(String.valueOf(stock.getFiole500()));
    }

    private void save() {
        SharedPreferences sharedPreferences = getSharedPreferences("StockPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("base", stock.getBase());
        editor.putInt("nico", stock.getNico());
        editor.putInt("fiole100", stock.getFiole100());
        editor.putInt("fiole250", stock.getFiole250());
        editor.putInt("fiole500", stock.getFiole500());
        editor.apply();
    }

    private void initText() {
        baseNombreAffichage = findViewById(R.id.baseNombreAffichage);
        nicoNombreAffichage = findViewById(R.id.nicoNombreAffichage);
        fiole100NombreAffichage = findViewById(R.id.fiole100NombreAffichage);
        fiole250NombreAffichage = findViewById(R.id.fiole250NombreAffichage);
        fiole500NombreAffichage = findViewById(R.id.fiole500NombreAffichage);
    }

    private void initButton() {
        addBaseStock = findViewById(R.id.addBaseStock);
        addBaseStock.setOnClickListener(v -> {
            stock.addBase();
            baseNombreAffichage.setText(String.valueOf(stock.getBase()));
            save();
        });

        removeBaseStock = findViewById(R.id.removeBaseStock);
        removeBaseStock.setOnClickListener(v -> {
            stock.removeBase();
            baseNombreAffichage.setText(String.valueOf(stock.getBase()));
            save();
        });

        resetBaseStock = findViewById(R.id.resetBaseStock);
        resetBaseStock.setOnClickListener(v -> {
            stock.resetBase();
            baseNombreAffichage.setText(String.valueOf(stock.getBase()));
            save();
        });

        addNicoStock = findViewById(R.id.addNicoStock);
        addNicoStock.setOnClickListener(v -> {
            stock.addNico();
            nicoNombreAffichage.setText(String.valueOf(stock.getNico()));
            save();
        });

        removeNicoStock = findViewById(R.id.removeNicoStock);
        removeNicoStock.setOnClickListener(v -> {
            stock.removeNico();
            nicoNombreAffichage.setText(String.valueOf(stock.getNico()));
            save();
        });

        resetNicoStock = findViewById(R.id.resetNicoStock);
        resetNicoStock.setOnClickListener(v -> {
            stock.resetNico();
            nicoNombreAffichage.setText(String.valueOf(stock.getNico()));
            save();
        });

        addFiole100Stock = findViewById(R.id.addFiole100Stock);
        addFiole100Stock.setOnClickListener(v -> {
            stock.addFiole100();
            fiole100NombreAffichage.setText(String.valueOf(stock.getFiole100()));
            save();
        });

        removeFiole100Stock = findViewById(R.id.removeFiole100Stock);
        removeFiole100Stock.setOnClickListener(v -> {
            stock.removeFiole100();
            fiole100NombreAffichage.setText(String.valueOf(stock.getFiole100()));
            save();
        });

        resetFiole100Stock = findViewById(R.id.resetFiole100Stock);
        resetFiole100Stock.setOnClickListener(v -> {
            stock.resetFiole100();
            fiole100NombreAffichage.setText(String.valueOf(stock.getFiole100()));
            save();
        });

        addFiole250Stock = findViewById(R.id.addFiole250Stock);
        addFiole250Stock.setOnClickListener(v -> {
            stock.addFiole250();
            fiole250NombreAffichage.setText(String.valueOf(stock.getFiole250()));
            save();
            
        });

        removeFiole250Stock = findViewById(R.id.removeFiole250Stock);
        removeFiole250Stock.setOnClickListener(v -> {
            stock.removeFiole250();
            fiole250NombreAffichage.setText(String.valueOf(stock.getFiole250()));
            save();
        });

        resetFiole250Stock = findViewById(R.id.resetFiole250Stock);
        resetFiole250Stock.setOnClickListener(v -> {
            stock.resetFiole250();
            fiole250NombreAffichage.setText(String.valueOf(stock.getFiole250()));
            save();
        });

        addFiole500Stock = findViewById(R.id.addFiole500Stock);
        addFiole500Stock.setOnClickListener(v -> {
            stock.addFiole500();
            fiole500NombreAffichage.setText(String.valueOf(stock.getFiole500()));
            save();
        });

        removeFiole500Stock = findViewById(R.id.removeFiole500Stock);
        removeFiole500Stock.setOnClickListener(v -> {
            stock.removeFiole500();
            fiole500NombreAffichage.setText(String.valueOf(stock.getFiole500()));
            save();
        });

        resetFiole500Stock = findViewById(R.id.resetFiole500Stock);
        resetFiole500Stock.setOnClickListener(v -> {
            stock.resetFiole500();
            fiole500NombreAffichage.setText(String.valueOf(stock.getFiole500()));
            save();
        });

        retour = findViewById(R.id.retourStock);
        retour.setOnClickListener(v -> {
            finish();
        });
    }
    
    
}
