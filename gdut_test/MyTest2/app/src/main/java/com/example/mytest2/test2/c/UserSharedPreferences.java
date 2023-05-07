package com.example.mytest2.test2.c;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author :yinxiaolong
 * @describe : com.example.test2.c
 * @date :2023/4/15 21:21
 */
public class UserSharedPreferences {

    private static final String PREF_NAME = "users";

    public static boolean saveUser(Context context, User user) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(String.valueOf(user.getId()), user.toString());
        return editor.commit();
    }

    public static boolean updateUser(Context context, User user) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(String.valueOf(user.getId()), user.toString());
        return editor.commit();
    }

    public static boolean deleteUser(Context context, int userId) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(String.valueOf(userId));
        return editor.commit();
    }

    public static List<User> getUsers(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        List<User> users = new ArrayList<>();
        Map<String, ?> allEntries = prefs.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            String data = (String) entry.getValue();
            users.add(User.fromString(data));
        }
        return users;
    }
}
