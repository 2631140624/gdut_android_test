package com.example.mytest2.test2.c;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mytest2.R;

import java.util.List;

public class CActivity extends AppCompatActivity {

    //文件存储 0
    //sp  1
    //sqlite 2
    int count =0;
    int age=0;

    TextView textView;
    EditText editTextName;
    EditText editTextPhone;
    TextView tv_show_name;
    TextView tv_show_phone;
    Button btn_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_cactivity);
        textView=findViewById(R.id.tv_state);
        editTextName=findViewById(R.id.editTextTextName);
        editTextPhone=findViewById(R.id.editTextPhone);
        tv_show_name=findViewById(R.id.tv_show_name);
        tv_show_phone=findViewById(R.id.tv_show_phone);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                if (count==3){
                    count=0;
                }
                switch (count){
                    case 0:
                        textView.setText("文件存储方式"); break;
                    case 1:
                        textView.setText("SharedPreference存储方式"); break;
                    case 2:
                        textView.setText("SqLite存储方式"); break;
                }

            }
        });

        //添加
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (count){
                    case 0:
                        if (UserFileStorage.getUsers(CActivity.this).size()==0&& (!editTextName.getText().toString().equals(""))) {
                            UserFileStorage.saveUser(CActivity.this, new User(1, editTextName.getText().toString(), age, editTextPhone.getText().toString()));
                        }
                        break;
                    case 1:
                        UserSharedPreferences.saveUser(CActivity.this, new User(2, editTextName.getText().toString(), age, editTextPhone.getText().toString()));
                        break;
                    case 2:
                        UserDbHelper dbHelper = new UserDbHelper(CActivity.this);
                        dbHelper.saveUser(new User(3, editTextName.getText().toString(), age, editTextPhone.getText().toString()));
                        break;
                }
            }
        });
        //查找
        btn_search=findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (count){
                    case 0:
                        List<User> user0 = UserFileStorage.getUsers(CActivity.this);
                        if (user0.size()==0){
                            Toast.makeText(CActivity.this, "已经被删除", Toast.LENGTH_SHORT).show();
                        }else {
                            User user = user0.get(0);
                            tv_show_name.setText("姓名：" + user.getName());
                            tv_show_phone.setText("号码：" + user.getEmail());
                        }
                        break;
                    case 1:
                        List<User> user1 = UserSharedPreferences.getUsers(CActivity.this);
                        if (user1.size()==0){
                            Toast.makeText(CActivity.this, "已经被删除", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            User user_2 = user1.get(0);
                            tv_show_name.setText("姓名：" + user_2.getName());
                            tv_show_phone.setText("号码：" + user_2.getEmail());
                        }
                        break;
                    case 2:
                        UserDbHelper dbHelper = new UserDbHelper(CActivity.this);
                        List<User> users2 = dbHelper.getUsers();
                        if (users2.size()==0){
                            Toast.makeText(CActivity.this, "已经被删除", Toast.LENGTH_SHORT).show();
                        }else {
                                    tv_show_name.setText("姓名：" + users2.get(0).getName());
                                    tv_show_phone.setText("号码：" + users2.get(0).getEmail());
                        }
                        break;
                }

            }
        });
        //更改
        findViewById(R.id.btn_change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (count){
                    case 0:
                        UserFileStorage.updateUser(CActivity.this, new User(1, editTextName.getText().toString(), 30, editTextPhone.getText().toString()));
                        break;
                    case 1:
                        UserSharedPreferences.updateUser(CActivity.this, new User(2, editTextName.getText().toString(), 35, editTextPhone.getText().toString()));
                        break;
                    case 2:
                        UserDbHelper dbHelper = new UserDbHelper(CActivity.this);
                        dbHelper.updateUser(new User(3, editTextName.getText().toString(), 0, editTextPhone.getText().toString()));

                        break;
                }
                Toast.makeText(CActivity.this, "数据已经更改", Toast.LENGTH_SHORT).show();
                btn_search.callOnClick();
            }
        });
        //删除
        findViewById(R.id.btn_del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (count){
                    case 0:
                        UserFileStorage.deleteUser(CActivity.this, 1);
                        break;
                    case 1:
                        UserSharedPreferences.deleteUser(CActivity.this, 2);
                        break;
                    case 2:
                        UserDbHelper dbHelper = new UserDbHelper(CActivity.this);
                        dbHelper.deleteUser(3);
                        break;
                }
                editTextName.setText("");
                editTextPhone.setText("");
                Toast.makeText(CActivity.this, "已经删除", Toast.LENGTH_SHORT).show();
            }
        });



/*
        // 存储用户信息
        UserFileStorage.saveUser(this, new User(1, "张三", 25, "zhangsan@example.com"));
        UserSharedPreferences.saveUser(this, new User(2, "李四", 30, "lisi@example.com"));
        UserDbHelper dbHelper = new UserDbHelper(this);
        dbHelper.saveUser(new User(3, "王五", 35, "wangwu@example.com"));

// 更新用户信息
        UserFileStorage.updateUser(this, new User(1, "张三", 30, "zhangsan@example.com"));
        UserSharedPreferences.updateUser(this, new User(2, "李四", 35, "lisi@example.com"));
        UserDbHelper dbHelper = new UserDbHelper(this);
        dbHelper.updateUser(new User(3, "王五", 40, "wangwu@example.com"));

// 删除用户信息
        UserFileStorage.deleteUser(this, 1);
        UserSharedPreferences.deleteUser(this, 2);
        UserDbHelper dbHelper = new UserDbHelper(this);
        dbHelper.deleteUser(3);

// 查询用户信息
        List<User> users = UserFileStorage.getUsers(this);
        List<User> users = UserSharedPreferences.getUsers(this);
        UserDbHelper dbHelper = new UserDbHelper(this);
        List<User> users = dbHelper.getUsers();*/

    }
}