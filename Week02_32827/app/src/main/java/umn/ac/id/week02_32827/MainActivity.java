package umn.ac.id.week02_32827;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

// Classes for Android widgets.
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

// Utility.
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    // UI components from 'activity_main.xml'.
    EditText angka1, angka2;
    TextView hasil;
    Button btnTambah, btnKurang, btnKali, btnBagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 'Connecting' our components to the XML file.
        angka1 = (EditText) this.findViewById(R.id.angka1);
        angka2 = (EditText) this.findViewById(R.id.angka2);
        hasil = (TextView) this.findViewById(R.id.hasil);
        btnTambah = (Button) this.findViewById(R.id.btnTambah);
        btnKurang = (Button) this.findViewById(R.id.btnKurang);
        btnKali = (Button) this.findViewById(R.id.btnKali);
        btnBagi = (Button) this.findViewById(R.id.btnBagi);

        // Interactions.
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('+');
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('-');
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('*');
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('/');
            }
        });
    }

//    // Version from the lab module.
//    protected void hitung(char operator) {
//        double operand1 = Double.parseDouble(angka1.getText().toString());
//        double operand2 = Double.parseDouble(angka2.getText().toString());
//        double result = 0.0;
//
//        switch (operator) {
//            case '+':
//                result = operand1 + operand2;
//                break;
//            case '-':
//                result = operand1 - operand2;
//                break;
//            case '*':
//                result = operand1 * operand2;
//                break;
//            case '/':
//                result = operand1 / operand2;
//                break;
//        }
//
//        hasil.setText(String.valueOf(result));
//    }

    // The lab module does not take errors into consideration. Here's my modified function.
    protected void hitung(char operator) {
        double operand1, operand2, result = 0.0;

        try {
            operand1 = Double.parseDouble(angka1.getText().toString());
            operand2 = Double.parseDouble(angka2.getText().toString());
            switch (operator) {
                case '+':
                    result = operand1 + operand2;
                    break;
                case '-':
                    result = operand1 - operand2;
                    break;
                case '*':
                    result = operand1 * operand2;
                    break;
                case '/':
                    result = operand1 / operand2;
                    break;
            }
        } catch (Exception e) {
            result = 0.0;
            Log.i("Error", e.getMessage());
        } finally {
            hasil.setText(String.valueOf(result));
        }
    }

}