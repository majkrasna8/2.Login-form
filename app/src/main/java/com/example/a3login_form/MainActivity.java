package com.example.a3login_form;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Declare UI elements
    private EditText etUsername;
    private EditText etFullName;
    private EditText etCountry;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etPassword;
    private RadioGroup rgGender;
    private CheckBox cbTerms;

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

        etUsername = findViewById(R.id.etUsername);
        etFullName = findViewById(R.id.etFullName);
        etCountry = findViewById(R.id.etCountry);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        rgGender = findViewById(R.id.rgGender);
        cbTerms = findViewById(R.id.cbTerms);
        Button btnCreateAccount = findViewById(R.id.btnCreateAccount);

        btnCreateAccount.setOnClickListener(v -> showRegistrationDetails());
    }

    private void showRegistrationDetails() {
        String username = etUsername.getText().toString();
        String fullName = etFullName.getText().toString();
        String country = etCountry.getText().toString();
        String email = etEmail.getText().toString();
        String phone = etPhone.getText().toString();
        String password = etPassword.getText().toString();

        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        String gender;
        if (selectedGenderId == R.id.rbMale) {
            gender = "Male";
        } else if (selectedGenderId == R.id.rbFemale) {
            gender = "Female";
        } else {
            gender = "Not selected";
        }

        String termsAccepted = cbTerms.isChecked() ? "Yes" : "No";

        String details = "Username: " + username + "\n" +
                "Name: " + fullName + "\n" +
                "Country: " + country + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phone + "\n" +
                "Password: " + password + "\n" +
                "Gender: " + gender + "\n" +
                "Terms Accepted: " + termsAccepted;

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Registration Details")
                .setMessage(details)
                .setPositiveButton("OK", null)
                .show();
    }
}
