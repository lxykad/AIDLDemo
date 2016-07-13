package com.aidl.s1.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.aidl.s1.ServerAidl;

public class Service1 extends Service {

    private IBinder mBinder = new ServerAidl.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getServerAidlData(String s) throws RemoteException {
            return s + "我是远程服务";
        }
    };


    public Service1() {

    }

    @Override
    public IBinder onBind(Intent intent) {

        return mBinder;
    }


}
