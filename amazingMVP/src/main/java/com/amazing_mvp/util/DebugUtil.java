package com.amazing_mvp.util;

public class DebugUtil {

  public static final boolean DEBUG = true;

  public static void log(String log) {
    if(DEBUG) {
      System.out.println("LOG: " + log);
    }
  }

}
