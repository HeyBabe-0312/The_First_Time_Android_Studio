package com.example.cochunho_store;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txt1;
    private EditText txt2;
    private EditText txt3;
    private EditText txttt;
    private RadioButton rbtn1;
    private RadioButton rbtn2;
    private RadioButton rbtn3;
    private RadioButton rbtn4;
    private RadioButton rbtn5;
    private RadioButton rbtn6;
    private FloatingActionButton btnAsc1;
    private FloatingActionButton btnAsc2;
    private FloatingActionButton btnAsc3;
    private FloatingActionButton btnDesc1;
    private FloatingActionButton btnDesc2;
    private FloatingActionButton btnDesc3;
    private Button total;
    private Button exit;
    private Button Del1;
    private Button Del2;
    private Button Del3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txttt = findViewById(R.id.txt_Total);
        rbtn1 = findViewById(R.id.radioButton);
        rbtn2 = findViewById(R.id.radioButton1);
        rbtn3 = findViewById(R.id.radioButton2);
        rbtn4 = findViewById(R.id.radioButton3);
        rbtn5 = findViewById(R.id.radioButton4);
        rbtn6 = findViewById(R.id.radioButton5);
        btnAsc1 = findViewById(R.id.btn_Asc1);
        btnAsc2 = findViewById(R.id.btn_Asc2);
        btnAsc3 = findViewById(R.id.btn_Asc3);
        btnDesc1 = findViewById(R.id.btn_Desc1);
        btnDesc2 = findViewById(R.id.btn_Desc2);
        btnDesc3 = findViewById(R.id.btn_Desc3);
        total = findViewById(R.id.btn_total);
        exit = findViewById(R.id.btn_exit);
        Del1 = findViewById(R.id.btn_Del1);
        Del2 = findViewById(R.id.btn_Del2);
        Del3 = findViewById(R.id.btn_Del3);
        btnAsc1.setOnClickListener(this);
        btnAsc2.setOnClickListener(this);
        btnAsc3.setOnClickListener(this);
        btnDesc1.setOnClickListener(this);
        btnDesc2.setOnClickListener(this);
        btnDesc3.setOnClickListener(this);
        exit.setOnClickListener(this);
        Del1.setOnClickListener(this);
        Del2.setOnClickListener(this);
        Del3.setOnClickListener(this);
        total.setOnClickListener(this);
    }
    public void changeValue(int i,TextView t){
        int a = Integer.parseInt(t.getText().toString());
        a += i;
        t.setText(""+a);
    }
    public void onClick(View v){
        if(v == btnAsc1) changeValue(500,txt1);
        if(v == btnAsc2) changeValue(200,txt2);
        if(v == btnAsc3) changeValue(300,txt3);
        if(v == btnDesc1) if(Integer.parseInt(txt1.getText().toString())!=0) changeValue(-500,txt1);
        if(v == btnDesc2) if(Integer.parseInt(txt2.getText().toString())!=0) changeValue(-200,txt2);
        if(v == btnDesc3) if(Integer.parseInt(txt3.getText().toString())!=0) changeValue(-300,txt3);
        if(v == exit) {
            //Create
            AlertDialog.Builder tb = new AlertDialog.Builder(this);
            //Set
            tb.setTitle("Đóng ứng dụng");
            tb.setMessage("Bạn có muốn thoát ?");
            //Nút ok
            tb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    System.exit(0);
                }
            });
            //Nút Cancel
            tb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            AlertDialog al = tb.create();
            al.show();
        }
        if(v == total){
            int tt = 0;
            int txt_1 = Integer.parseInt(txt1.getText().toString());
            int txt_2 = Integer.parseInt(txt2.getText().toString());
            int txt_3 = Integer.parseInt(txt3.getText().toString());
            if(rbtn1.isChecked()) tt += 500;
            else if(rbtn2.isChecked()) tt += 700;
            if(rbtn3.isChecked()) tt += 1000;
            else if(rbtn4.isChecked()) tt += 1300;
            if(rbtn5.isChecked()) tt += 800;
            else if(rbtn6.isChecked()) tt += 1000;
            txttt.setText(tt+txt_1+txt_2+txt_3+"");
        }
        if(v == Del1) {
            rbtn1.setChecked(false);
            rbtn2.setChecked(false);
        }
        if(v == Del2) {
            rbtn3.setChecked(false);
            rbtn4.setChecked(false);
        }
        if(v == Del3) {
            rbtn5.setChecked(false);
            rbtn6.setChecked(false);
        }
    }
}