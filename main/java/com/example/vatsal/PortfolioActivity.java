package com.example.vatsal;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PortfolioActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);

        TextView bio = findViewById(R.id.bioText);
        bio.setText("Hi! I'm a beginner Android developer using Java.");
    }
}
