package com.example.diegoos.geoproy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.esri.arcgisruntime.mapping.view.MapView;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.portal.Portal;
import com.esri.arcgisruntime.portal.PortalItem;
import com.esri.arcgisruntime.security.UserCredential;
//import com.esri.arcgisruntime.mapping.Portal

public class MainActivity extends AppCompatActivity {

    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Portal portal = new Portal("http://www.arcgis.com");
        PortalItem mapPortalItem = new PortalItem(portal, "e55c377d1df847cbbe8ee12b2f85542f");
        UserCredential credential = new UserCredential("diegoda", "Diegoda123");

        portal.setCredential(credential);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMapView = (MapView) findViewById(R.id.mapView);
        ArcGISMap map = new ArcGISMap(mapPortalItem);

        //ArcGISMap map = new ArcGISMap(Basemap.Type.TOPOGRAPHIC, 34.056295, -117.195800, 16);
        mMapView.setMap(map);

    }
    @Override
    protected void onPause(){
        mMapView.pause();
        super.onPause();
    }
    @Override
    protected void onResume(){
        super.onResume();
        mMapView.resume();
    }

}
