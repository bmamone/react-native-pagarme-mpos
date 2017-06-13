
package com.bmamone;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

public class RNPagarmeMposModule extends ReactContextBaseJavaModule {
  static final int REQUEST_ENABLE_BT = 1;
  private final ReactApplicationContext reactContext;
  private BluetoothAdapter mBluetoothAdapter;

  public RNPagarmeMposModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (mBluetoothAdapter == null) {
        // Device does not support Bluetooth

    }
  }

  @Override
  public String getName() {
    return "RNPagarmeMpos";
  }

  @ReactMethod
  public void getPairedDevices(Callback errorCallback, Callback successCallback) {
    Activity currentActivity = getCurrentActivity();
    if (!mBluetoothAdapter.isEnabled()) {
        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        currentActivity.startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
    }
    Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
    WritableArray devices = Arguments.createArray();

    if (pairedDevices.size() > 0) {
        for (BluetoothDevice device : pairedDevices) {
            WritableMap _device = Arguments.createMap();
            _device.putString("name", device.getName());
            _device.putString("address", device.getAddress());
            devices.pushMap(_device);
        }
    }
    Toast.makeText(getReactApplicationContext(), Integer.toString(pairedDevices.size()) + " dispositivos", 1).show();
    successCallback.invoke(devices);
  }

  @ReactMethod
  public void getNearbyDevices(Callback errorCallback, Callback successCallback) {

  }

  @ReactMethod
  public void pairWithDevice(String deviceAddress) {}
}