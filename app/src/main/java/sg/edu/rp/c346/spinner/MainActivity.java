package sg.edu.rp.c346.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner) ;
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.button);
        alNumbers = new ArrayList<>();

        //alNumbers.add("2");
        //alNumbers.add("4");
        //alNumbers.add("6");
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,alNumbers);
        spn2.setAdapter(aaNumbers);
        String [] a = getResources().getStringArray(R.array.odd_numbers);

        /*btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();

                if (pos == 0){
                    String[]strNumbers = getResources().getStringArray(R.array.even_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
                else {
                    String[]strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
            }
        });*/
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        alNumbers.clear();
                        String[]strNumbers = getResources().getStringArray(R.array.even_numbers);
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        break;

                    case 1:
                        alNumbers.clear();
                        String[]strNumbers2 = getResources().getStringArray(R.array.odd_numbers);
                        alNumbers.addAll(Arrays.asList(strNumbers2));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
