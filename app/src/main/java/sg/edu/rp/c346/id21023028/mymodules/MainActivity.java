package sg.edu.rp.c346.id21023028.mymodules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button btn;

    private Intent valueReturn(Intent intent){
        intent.putExtra("detail", moduleDetails());
        return intent;
    }

    private String moduleName(String[] modClass){
        boolean first = true;
        String fullName = "";
        for (String name : modClass){
            if (!first){
                fullName += " "+name;
            }
            else{
                first = false;
            }
        }
        return fullName;
    }

    private ArrayList<String> addDetails(ArrayList<String> details,String year,String sem,
                                         String credit, String area){
        details.add(year);
        details.add(sem);
        details.add(credit);
        details.add(area);
        return details;
    }

    private String moduleDetails(){
        String[] modClass = spinner.getSelectedItem().toString().split(" ");
        ArrayList<String> details = new ArrayList<String>();
        details.add(modClass[0]); //module code
        details.add(moduleName(modClass)); //module name
        switch (modClass[0]){
            case "C346":
                details = addDetails(details,"2023","1","4","E63A");
                break;
            case "C303":
                details = addDetails(details,"2023","1","4","W66L");
                break;
            case "C286":
                details = addDetails(details,"2023","1","4","E53D");
                break;
            case "C300":
                details = addDetails(details,"2023","1","4","NA");
                break;
        }
        return msgFormat(details);
    }

    private String msgFormat(ArrayList<String> details){
        String msg = "";
        msg = String.format("Module Code: %s" +
                "\nModule Name: %s" +
                "\nAcademic Year: %s" +
                "\nSemester %s" +
                "\nModule Credit: %s" +
                "\nVenue: %s"
                ,details.get(0),details.get(1),details.get(2),details.get(3),details.get(4)
                ,details.get(5));
        return msg;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        btn = findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        ModuleDetailActivity.class);
                Intent intentUse = valueReturn(intent); //return intent with the details to be filled in
                startActivity(intentUse);
            }
        });
    }
}