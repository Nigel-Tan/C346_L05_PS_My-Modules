package sg.edu.rp.c346.id21023028.mymodules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ModuleDetailActivity extends AppCompatActivity {

    TextView moduleDetail;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_detail);

        moduleDetail = findViewById(R.id.textView);
        btnReturn = findViewById(R.id.buttonReturn);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModuleDetailActivity.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intentReceived = getIntent();
        String msg = intentReceived.getStringExtra("detail");
        moduleDetail.setText(msg);
    }
}