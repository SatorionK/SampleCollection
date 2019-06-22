package com.websarva.wings.android.implicitlntentsample;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //緯度経度の情報取得
        TextView ido = findViewById(R.id.ido);
        TextView keido = findViewById(R.id.keido);

        //LocationManagerの生成
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        //リスナオジェクトの生成（クラス作成の必要あり）
        GPSLocationListener locationListener = new GPSLocationListener();
        //位置情報追跡・開始
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }

    private class GPSLocationListener implements LocationListener{
        @Override
        public void onLocationChanged(Location location){
            //緯度取得
            idod = location.getLatitude();
            //軽度取得
            keidod = location.getLongitude();
            //緯度表示
            ido.setText(double.toString(idod));
            //軽度表示
            keido.setText(double.toString(keidod));
        }
        @Override
        public void onProviderDisabled(String provider){};

        @Override
        public void onProviderEnabled(String provider){};

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras){};

    }


}
