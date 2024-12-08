package com.example.myapplication;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText deposit_amount;
    private EditText interest_rate;
    private EditText term;
    private TextView result;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        deposit_amount = findViewById(R.id.editTextDepositAmount);
        deposit_amount.setInputType(InputType.TYPE_CLASS_NUMBER);

        interest_rate = findViewById(R.id.editTextInterestRate);
        interest_rate.setInputType(InputType.TYPE_CLASS_NUMBER);

        term = findViewById(R.id.editTextTerm);
        term.setInputType(InputType.TYPE_CLASS_NUMBER);
        result = findViewById(R.id.textView2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator();
            }
        });
    }

    public void calculator(){
        String str_deposit_amount_c = deposit_amount.getText().toString();
        double deposit_amount_c = Double.parseDouble(str_deposit_amount_c);

        String str_interest_rate_c = interest_rate.getText().toString();
        double interest_rate_c = Double.parseDouble(str_interest_rate_c);

        String str_term_c = term.getText().toString();
        double term_c = Double.parseDouble(str_term_c);

        if (!str_deposit_amount_c.isEmpty() && !str_interest_rate_c.isEmpty() && !str_term_c.isEmpty()){
            double depozit = deposit_amount_c * Math.pow((1 + (interest_rate_c/100)), term_c);
            result.setText(String.format("Результат: %.2f", depozit));
        }
        else{
            result.setText("Введены не все данные");
        }
    }
}