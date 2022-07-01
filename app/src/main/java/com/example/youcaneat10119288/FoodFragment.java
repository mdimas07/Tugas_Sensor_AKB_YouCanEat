package com.example.youcaneat10119288;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 Nama  : Muhamad Dimas
 NIM   : 10119288
 Kelas : IF7
 */

public class FoodFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Initialize view
        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        SupportMapFragment mapFragment=(SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_map);

        // check condition
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            mapFragment.getMapAsync(googleMap -> {
                //Lokasi 1
                LatLng lokasi1 = new LatLng(-6.884416956536183, 107.6135207844539);
                MarkerOptions options1 = new MarkerOptions().position(lokasi1).title("Yagami Ramen House Dago");
                //Lokasi 2
                LatLng lokasi2 = new LatLng(-6.887607515479654, 107.61517415741044);
                MarkerOptions options2 = new MarkerOptions().position(lokasi2).title("Richeese Factory");
                //Lokasi 3
                LatLng lokasi3 = new LatLng(-6.884571414010729, 107.61358972918848);
                MarkerOptions options3 = new MarkerOptions().position(lokasi3).title("Ayam Geprek Pangeran");
                //Lokasi 4
                LatLng lokasi4 = new LatLng(-6.887547965387006, 107.61536990320131);
                MarkerOptions options4 = new MarkerOptions().position(lokasi4).title("Warung Nasi Babeh Kurnia");
                //Lokasi 5
                LatLng lokasi5 = new LatLng(-6.891838989532043, 107.61734253516966);
                MarkerOptions options5 = new MarkerOptions().position(lokasi5).title("Nasi Goreng Rempah Mafia");

                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi3,17));
                googleMap.addMarker(options1);
                googleMap.addMarker(options2);
                googleMap.addMarker(options3);
                googleMap.addMarker(options4);
                googleMap.addMarker(options5);


            });
        }
        else {
            // When permission is not granted
            // Call method
            requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION }, 100);
        }
        // Return view
        return view;
    }

}