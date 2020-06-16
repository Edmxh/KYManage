package hardware.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import java.nio.ByteBuffer;

/************************************************************
 * Copyright 2000-2066 Olc Corp., Ltd.
 * All rights reserved.
 * <p>
 * Description     : The Main activity for the Camera application
 * History        :( ID, Date, Author, Description)
 * v1.0, 2017/1/20,  Administrator, create
 ************************************************************/
public class printer {
    //*****************************Android 7.1***************************************
    public int OpenN(Context context) {
        return 1;
    }
    public int CloseN() {
        return 0;
    }
    public int StepN(byte bStep) {
        return -1;
    }
    public int UnreelingN(byte bStep) {
        return -1;
    }
    public void GoToNextPageN() {}
    //public int PrintImage(short[] data)
    public int PrintImageExN(byte[] data, int nBit) { return -1; }
    public int PrintString24N(byte[] data) {
        return -1;
    }
    public int IsReadyN() {
        return -1;
    }
    public int SetGrayLevelN(byte blevel) {
        return -1;
    }
    public int ReadDataN(byte[] data) {
        return -1;
    }
    public int ReadDataExN(byte[] data, int noffset, int ncount) {
        return -1;
    }


    //******************************Android 7.1***********************************
//**************************************Anroid 5.1********************************

}