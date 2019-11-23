package com.mat.app3.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.mat.app3.models.User;

import java.util.Map;

public class UserManager {

    private static String TAG = UserManager.class.getSimpleName();
    private static String namePreferences_userdata = "data_user";

    //data user
    private static String user_id = "id";
    private static String user_user = "user";
    private static String user_name = "name";
    private static String user_password = "password";
    private static String user_email = "email";

    public static boolean saveUser(Context ctx, User user){
        boolean flag = false;
        try{
            SharedPreferences preferences = ctx.getSharedPreferences(namePreferences_userdata, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(user_user,user.getUser());
            editor.putString(user_password,user.getPass());
            editor.putString(user_email,user.getEmail());
            editor.putString(user_name,user.getName());
            flag = editor.commit();
        }catch (Exception e){
            Log.d(TAG,"saveUser:"+e.toString());
            Toast.makeText(ctx,"saveUser:"+e.toString(), Toast.LENGTH_LONG).show();
        }
        return flag;
    }

    public static User getUser(Context ctx){
        User user = null;
            try {
                SharedPreferences preferences = ctx.getSharedPreferences(namePreferences_userdata, Context.MODE_PRIVATE);
                if(
                        preferences.contains(user_id)
                        &&
                        preferences.contains(user_user)
                        &&
                        preferences.contains(user_password)
                        &&
                        preferences.contains(user_email)
                        &&
                        preferences.contains(user_name)
                ){

                    user = new User();
                    user.setUser(preferences.getString(user_user,""));
                    user.setPass(preferences.getString(user_password,""));
                    user.setEmail(preferences.getString(user_email,""));
                    user.setName(preferences.getString(user_name,""));
                    Log.d(TAG,"getUser email "+user.getEmail() );
                }
            }catch (Exception e) {
                Log.d(TAG,"getUser:" + e.toString()) ;
                Toast.makeText(ctx, "getUser:" + e.toString(), Toast.LENGTH_LONG).show();
            }

        return user;
    }

    public static boolean deleteUser(Context ctx){
        boolean flag = false;
        try {
            SharedPreferences preferences = ctx.getSharedPreferences(namePreferences_userdata, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            flag = editor.commit(); // commit changes
        }catch (Exception e) {
            Toast.makeText(ctx, "deleteUser:" + e.toString(), Toast.LENGTH_LONG).show();
            Log.d(TAG,"deleteUser: "+e.toString());
        }
        return flag;
    }

    public static Map<String,?> getMapUser(Context ctx){
        try {
            SharedPreferences preferences = ctx.getSharedPreferences(namePreferences_userdata, Context.MODE_PRIVATE);
            Map<String,?> map = preferences.getAll();
            return  map;
        }catch (Exception e) {
            Toast.makeText(ctx, "getMapUser:" + e.toString(), Toast.LENGTH_LONG).show();
        }
        return null;
    }

}
