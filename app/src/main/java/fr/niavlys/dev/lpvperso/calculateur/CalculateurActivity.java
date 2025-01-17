package fr.niavlys.dev.lpvperso.calculateur;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import fr.niavlys.dev.lpvperso.R;

public class CalculateurActivity extends AppCompatActivity {

    
    
    private EditText nombreBaseEntry;
    private EditText nombreNicoEntry;
    private EditText prixGoutEntry;
    private EditText nombreGoutEntry;
    private EditText parGoutEntry;
    private EditText fraisEntry;
    private EditText fioleEntry;

    private TextView prixBaseText;
    private TextView prixNicoText;

    private View calculateButton;
    private View copierButton;
    private View retourButton;
    private View resetButton;

    private TextView outputText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculateur);
        initTextes();
        initButtons();
        initEntrys();
        initButtonsActions();
        loadSave();
    }

    private void initTextes() {
        prixBaseText = findViewById(R.id.prixBaseTexte);
        prixNicoText = findViewById(R.id.prixNicoText);

        prixBaseText.setText(Prix.BASE.getPrix()+"€/"+Prix.BASE.getQuantite()+"ml");
        prixNicoText.setText(Prix.NICO.getPrix()+"€/"+Prix.NICO.getQuantite()+"ml");
    }

    private void initEntrys() {
        nombreBaseEntry = findViewById(R.id.nombreBaseEntry);
        nombreNicoEntry = findViewById(R.id.nombreNicoEntry);
        prixGoutEntry = findViewById(R.id.prixGoutEntry);
        nombreGoutEntry = findViewById(R.id.nombreGoutEntry);
        parGoutEntry = findViewById(R.id.parGoutEntry);
        fraisEntry = findViewById(R.id.fraisEntry);
        fioleEntry = findViewById(R.id.fioleEntry);
    }

    private void initButtons() {
        copierButton = findViewById(R.id.copierButton);
        outputText = findViewById(R.id.outputText);
        retourButton = findViewById(R.id.retourButton);
        resetButton = findViewById(R.id.resetButton);
    }

    private void initButtonsActions() {
        calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(v -> {
            if(!(nombreBaseEntry.getText().toString().isEmpty() && nombreNicoEntry.getText().toString().isEmpty() && prixGoutEntry.getText().toString().isEmpty() && nombreGoutEntry.getText().toString().isEmpty())){
                Float nombreBase = Float.parseFloat(nombreBaseEntry.getText().toString());
                Float nombreNico = Float.parseFloat(nombreNicoEntry.getText().toString());
                Float prixGout = Float.parseFloat(prixGoutEntry.getText().toString());
                Float nombreGout = Float.parseFloat(nombreGoutEntry.getText().toString());
                Float parGout = Float.parseFloat(parGoutEntry.getText().toString());
                Float frais = Float.parseFloat(fraisEntry.getText().toString());
                Float fiole = Float.parseFloat(fioleEntry.getText().toString());

                Float prixBase = (float) ((Prix.BASE.getPrix()/Prix.BASE.getQuantite())*nombreBase);
                Float prixNico = (float) ((Prix.NICO.getPrix()/Prix.NICO.getQuantite())*nombreNico);
                Float prixGoutTotal = (float) ((prixGout/parGout)*nombreGout);
                Float prixTotal = prixBase + prixNico + prixGoutTotal + frais + fiole;

                outputText.setText(outputText.getText()+"Base: "+String.format("%.2f", prixBase)+"€ ("+Prix.BASE.getPrix()+"€/"+Prix.BASE.getQuantite()+"ml)");
                outputText.setText(outputText.getText()+"\n"+"Nicotine: "+String.format("%.2f", prixNico)+"€ ("+Prix.NICO.getPrix()+"€/"+Prix.NICO.getQuantite()+"ml)");
                outputText.setText(outputText.getText()+"\n"+"Gout: "+String.format("%.2f", prixGoutTotal)+"€ ("+String.format("%.2f", prixGout)+"€/"+String.format("%.2f", parGout)+"ml)");
                outputText.setText(outputText.getText()+"\n"+"Frais: "+String.format("%.2f", frais)+"€");
                outputText.setText(outputText.getText()+"\n"+"Fiole: "+String.format("%.2f", fiole)+"€");
                outputText.setText(outputText.getText()+"\n"+"Total: "+String.format("%.2f", prixTotal)+"€");
                save();
            }
        });

        copierButton.setOnClickListener(this::copyToClipboard);

        retourButton.setOnClickListener(v -> {
            finish();
        });

        resetButton.setOnClickListener(v -> {
            outputText.setText("");
            nombreBaseEntry.setText("");
            nombreNicoEntry.setText("");
            prixGoutEntry.setText("");
            nombreGoutEntry.setText("");
            parGoutEntry.setText("");
            fraisEntry.setText("");
            fioleEntry.setText("");
        });
    }

    private void loadSave() {
        SharedPreferences sharedPreferences = getSharedPreferences("CalculateurPrefs", MODE_PRIVATE);

        nombreBaseEntry.setText(sharedPreferences.getString("nombreBase", ""));
        nombreNicoEntry.setText(sharedPreferences.getString("nombreNico", ""));
        prixGoutEntry.setText(sharedPreferences.getString("prixGout", ""));
        nombreGoutEntry.setText(sharedPreferences.getString("nombreGout", ""));
        parGoutEntry.setText(sharedPreferences.getString("parGout", ""));
        fraisEntry.setText(sharedPreferences.getString("frais", ""));
        fioleEntry.setText(sharedPreferences.getString("fiole", ""));
        outputText.setText(sharedPreferences.getString("outputText", ""));
    }

    private void save() {
        SharedPreferences sharedPreferences = getSharedPreferences("CalculateurPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("nombreBase", nombreBaseEntry.getText().toString());
        editor.putString("nombreNico", nombreNicoEntry.getText().toString());
        editor.putString("prixGout", prixGoutEntry.getText().toString());
        editor.putString("nombreGout", nombreGoutEntry.getText().toString());
        editor.putString("parGout", parGoutEntry.getText().toString());
        editor.putString("frais", fraisEntry.getText().toString());
        editor.putString("fiole", fioleEntry.getText().toString());
        editor.putString("outputText", outputText.getText().toString());

        editor.apply();
    }

    private void copyToClipboard(View view) {
        String textToCopy = outputText.getText().toString();
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("output", textToCopy);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clip);
        }
    }
}
