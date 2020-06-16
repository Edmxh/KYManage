package com.example.kymanage.net;

import android.text.TextUtils;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

//log的工具类
public class Logutil {
//init
public static void init() {
  Logger.addLogAdapter(new AndroidLogAdapter());
}

public static void d(String msg) {
  if (!TextUtils.isEmpty(msg)) {
      Logger.d(msg);
  }
}

public static void e(String msg) {
  if (!TextUtils.isEmpty(msg)) {
      Logger.e(msg);
  }
}

public static void i(String msg) {
  if (!TextUtils.isEmpty(msg)) {
      Logger.i(msg);
  }
}

public static void v(String msg) {
  if (!TextUtils.isEmpty(msg)) {
      Logger.v(msg);
  }
}

public static void w(String msg) {
  if (!TextUtils.isEmpty(msg)) {
      Logger.w(msg);
  }
}

public static void json(String msg) {
  if (!TextUtils.isEmpty(msg)) {
      Logger.json(msg);
  }


}


}
