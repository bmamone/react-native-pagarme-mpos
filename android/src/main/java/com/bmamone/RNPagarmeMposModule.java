
package com.bmamone;

import android.widget.Toast;
import java.util.Set;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNPagarmeMposModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNPagarmeMposModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNPagarmeMpos";
  }

  @ReactMethod
  public void show(String message, int duration) {
    BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (mBluetoothAdapter == null) {
        // Device does not support Bluetooth

    }
//    if (!mBluetoothAdapter.isEnabled()) {
//        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//        startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
//    }
    Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();

    if (pairedDevices.size() > 0) {
      // There are paired devices. Get the name and address of each paired device.
      for (BluetoothDevice device : pairedDevices) {
          String deviceName = device.getName();
          String deviceHardwareAddress = device.getAddress(); // MAC address
          Toast.makeText(getReactApplicationContext(), deviceName + " " + deviceHardwareAddress, duration).show();
      }
    }
    Toast.makeText(getReactApplicationContext(), Integer.toString(pairedDevices.size()) + " dispositivos", duration).show();
  }
}