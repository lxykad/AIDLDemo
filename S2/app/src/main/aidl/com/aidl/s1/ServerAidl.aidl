// ServerAidl.aidl
package com.aidl.s1;


interface ServerAidl {

    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    String getServerAidlData(String s);

}
