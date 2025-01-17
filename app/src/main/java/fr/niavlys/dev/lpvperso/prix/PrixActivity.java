package fr.niavlys.dev.lpvperso.prix;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import fr.niavlys.dev.lpvperso.R;
import fr.niavlys.dev.lpvperso.calculateur.Prix;

public class PrixActivity extends AppCompatActivity {

    private EditText basePrixEntry, nicoPrixEntry;
    private Button resetBasePrix, resetNicoPrix, saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prix);
        initEntry();
        initButtons();
    }

    private void initButtons() {
        resetBasePrix = findViewById(R.id.resetBasePrix);

        resetBasePrix.setOnClickListener(v -> {
            basePrixEntry.setText("9.9");
        });

        resetNicoPrix = findViewById(R.id.resetNicoPrix);
        resetNicoPrix.setOnClickListener(v -> {
            nicoPrixEntry.setText("7.5");
        });

        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(v -> {
            Prix.BASE.setPrix(Float.parseFloat(String.valueOf(basePrixEntry.getText())));
            Prix.NICO.setPrix(Float.parseFloat(String.valueOf(nicoPrixEntry.getText())));
        });
    }

    private void initEntry() {
        basePrixEntry = findViewById(R.id.basePrixEntry);
        basePrixEntry.setText(String.valueOf(Prix.BASE.getPrix()));
        nicoPrixEntry = findViewById(R.id.nicoPrixEntry);
        nicoPrixEntry.setText(String.valueOf(Prix.NICO.getPrix()));
    }
}
