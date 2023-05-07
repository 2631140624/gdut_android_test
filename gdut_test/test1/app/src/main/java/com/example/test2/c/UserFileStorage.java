package com.example.test2.c;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :yinxiaolong
 * @describe : com.example.test2.c
 * @date :2023/4/15 21:19
 */
public class UserFileStorage {

    private static final String FILE_NAME = "users.txt";

    public static boolean saveUser(Context context, User user) {
        try {
            File file = new File(context.getFilesDir(), FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file, true);
            String data = user.toString() + "\n";
            fos.write(data.getBytes());
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateUser(Context context, User user) {
        List<User> users = getUsers(context);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                users.set(i, user);
                break;
            }
        }
        return saveUsers(context, users);
    }

    public static boolean deleteUser(Context context, int userId) {
        List<User> users = getUsers(context);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId) {
                users.remove(i);
                break;
            }
        }
        return saveUsers(context, users);
    }

    public static List<User> getUsers(Context context) {
        List<User> users = new ArrayList<>();
        try {
            File file = new File(context.getFilesDir(), FILE_NAME);
            if (!file.exists()) {
                return users;
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                users.add(User.fromString(line));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    private static boolean saveUsers(Context context, List<User> users) {
        try {
            File file = new File(context.getFilesDir(), FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            for (User user : users) {
                String data = user.toString() + "\n";
                fos.write(data.getBytes());
            }
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

