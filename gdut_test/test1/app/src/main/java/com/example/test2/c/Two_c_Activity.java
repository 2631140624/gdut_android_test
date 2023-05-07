package com.example.test2.c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.test1.R;

import java.util.List;

public class Two_c_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_cactivity);
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