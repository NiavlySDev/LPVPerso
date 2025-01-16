package fr.niavlys.dev.lpvperso.main;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import fr.niavlys.dev.lpvperso.calculateur.CalculateurActivity;
import fr.niavlys.dev.lpvperso.prix.PrixActivity;
import fr.niavlys.dev.lpvperso.R;
import fr.niavlys.dev.lpvperso.stock.StockActivity;

public class MainActivity extends AppCompatActivity {
    
    private Button stockButton;
    private Button prixButton;
    private Button calcButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initButtons();

    }

    private void initButtons() {
        stockButton = findViewById(R.id.stockButton);
        stockButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StockActivity.class);
            startActivity(intent);
        });
        prixButton = findViewById(R.id.prixButton);
        prixButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PrixActivity.class);
            startActivity(intent);
        });
        calcButton = findViewById(R.id.calcButton);
        calcButton.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(MainActivity.this, CalculateurActivity.class);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}