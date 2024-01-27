package com.example.bai10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextName, editTextPass;
    Button btnCreateNew,  btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPass =(EditText) findViewById(R.id.editTextPass);
        btnLogin =(Button) findViewById(R.id.buttonLogin);
        btnCreateNew =(Button) findViewById(R.id.buttonCreateNew);
        btnCreateNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });
//        Intent intent = getIntent();
//        String receivedEmail = intent.getStringExtra("Email");
//        String receivedPass = intent.getStringExtra("PassWord");
//        Log.d("Hello" , receivedEmail);
//        Log.d("Hello" , receivedPass);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               loginUser();
            }
        });
    }
    private void loginUser() {
        String email = editTextName.getText().toString().trim();
        String password = editTextPass.getText().toString().trim();
        Intent intent1 = getIntent();
        String receivedEmail = intent1.getStringExtra("Email");
        String receivedPass = intent1.getStringExtra("PassWord");

        if (isValidInput(email, password)) {

            if (password.equals(receivedPass)) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            } else {
                // Đăng nhập không thành công, hiển thị thông báo hoặc thực hiện xử lý phù hợp
                Toast.makeText(MainActivity.this, "Đăng nhập không thành công. Vui lòng kiểm tra lại thông tin.", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Thông báo lỗi khi dữ liệu đầu vào không hợp lệ
            Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin đăng nhập.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidInput(String email, String password) {
        return !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password);
    }
}