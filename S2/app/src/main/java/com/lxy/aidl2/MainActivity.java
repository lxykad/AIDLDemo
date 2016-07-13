package com.lxy.aidl2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.aidl.s1.ServerAidl;

public class MainActivity extends AppCompatActivity {

    TextView mTv;
    ServerAidl mServerAidl;
    ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            mServerAidl = ServerAidl.Stub.asInterface(service);
            try {
                String s = mServerAidl.getServerAidlData("");
                mTv.setText(s);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            mServerAidl = null;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTv = (TextView) findViewById(R.id.tv);
    }


    //
    public void getDataFromRemote(View view) {

        //获取远程服务
        Intent intent = new Intent();
        //param1  app包名  param2 服务的包名.服务的类名
        intent.setComponent(new ComponentName("com.aidl.s1", "com.aidl.s1.service.Service1"));

        bindService(intent, mConnection, BIND_AUTO_CREATE);



    }
}
