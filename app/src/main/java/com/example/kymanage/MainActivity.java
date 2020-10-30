package com.example.kymanage;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kymanage.Activity.BaseActivity;
import com.example.kymanage.Activity.MainMenuActivity;
import com.example.kymanage.Beans.LoginBean;
import com.example.kymanage.presenter.IBaseView;
import com.example.kymanage.presenter.LoginPresenter;
import com.example.kymanage.utils.PropertiesUtil;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends BaseActivity implements IBaseView<LoginBean> {


    private Button login_button;
    private EditText name,password;
    private String string_name;
    private String string_password;
    private LoginPresenter loginPresenter;
    private static final String TAG = "MainActivity";
    //private CheckBox remember;
    private boolean checked=false;
    private String token;
    private int code;
    private int code2=0;
    //记住用户名
    private SharedPreferences sp;
    //震动
    private Vibrator vibrator;



    @Override
    public int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        login_button = findViewById(R.id.login);
        name = findViewById(R.id.username);
        password = findViewById(R.id.password);
        //方便测试
//        name.setText("xmao");
//        password.setText("xmao");

        //获得实例对象
        sp = this.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        //remember = findViewById(R.id.remember);

//        ImmersionBar.with(this)
//                .navigationBarDarkIcon(true)
//                .statusBarDarkFont(true)
//                .init();


    }

    @Override
    public void initData() {
        //初始化用户名密码
//        name.setText("");
//        password.setText("");
        name.setText(sp.getString("USER_NAME", ""));
        //方便测试
//        name.setText("xmao");
//        password.setText("xmao");


        loginPresenter = new LoginPresenter();
        loginPresenter.setView(this);

        //String names = preferences.getString("name", "");
        //String passwords = preferences.getString("password", "");
//        if (names!=""){
//            name.setText(names);
//            password.setText(passwords);
//            remember.setChecked(true);
//        }else {
//            remember.setChecked(false);
//        }
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }


    @Override
    public void initLisenter() {
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    vibrator.vibrate(30);
//                    Toast.makeText(MainActivity.this, "正在登陆...", Toast.LENGTH_SHORT).show();
                    string_name = name.getText().toString();
                    string_password = password.getText().toString();
                    System.out.println("login2");
                    URL url = null;
                    url = new URL("http://" + "10.254.100.81" + "/ThingX" + "/Home/");
                    String authorization = "Mobile "
                            + Base64.base64Encode(string_name + ":" + string_password);
                    HttpURLConnection conn = null;
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestProperty("Authorization", authorization);
                    conn.setDoOutput(true);
                    code = 0;
                    conn.connect();
                    code = conn.getResponseCode();
//                            System.out.println("---"+code);
                    code2=code;
                    //System.out.println(1);
                    if (code == 403) {
                        token = conn.getHeaderField("twx-mobile-token");
                    }
                    if(code2==403) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("USER_NAME", string_name);
                        editor.putString("PASSWORD",string_password);
                        editor.commit();
                        loginPresenter.Logindata(string_name, string_password);
                    }else {
                        Toast.makeText(MainActivity.this, "登录失败，请验证用户名或密码！", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
//        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                checked = remember.isChecked();
//
//            }
//        });

    }

    @Override
    public void onDataSuccess(LoginBean data) {
        Log.i(TAG, "onDataSuccess: 网络请求成功！");
        boolean login = data.getRes();
        String Authority=data.getAuthority().toString();
        String namedes=data.getNamedes();
        if (login==true){
            Log.i(TAG, "onDataSuccess: checked: "+ checked);
            if (checked){
                SharedPreferences user = MainActivity.this.getSharedPreferences("userInfo",Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = user.edit();
                edit.putString("name",string_name );
                edit.putString("password",string_password );
                edit.commit();
                //remember.setChecked(true);
            }else {
                SharedPreferences preferences = MainActivity.this.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("factory", data.getFactory());
                editor.putString("username", string_name);
                editor.commit();
                //remember.setChecked(false);
            }
            Toast.makeText(this, "登陆成功！", Toast.LENGTH_SHORT).show();
            //System.out.println(1);
            Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);
            //intent.setAction("one");
            intent.putExtra("username", string_name);
            intent.putExtra("Authority", Authority);
            intent.putExtra("Authority1", data.getAuthority1().toString());
            intent.putExtra("Authority2", data.getAuthority2().toString());
            intent.putExtra("Authority3", data.getAuthority3().toString());
            intent.putExtra("Authority4", data.getAuthority4().toString());
            intent.putExtra("Name", namedes);
            startActivity(intent);
            //System.out.println(2);
        }else{
            Log.i(TAG, "onDataSuccess: 登录失败，请验证用户名或密码！");
            Toast.makeText(this, "登录失败，请验证用户名或密码！", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFailed(String msg) {
        Log.i(TAG, "onFailed: 网络请求失败！");
        Log.i(TAG, "onFailed: 失败原因： "+msg);
        Toast.makeText(this, "登陆失败，连接错误："+msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //注销初始化用户名和密码
        //name.setText("");
        password.setText("");
    }
}
