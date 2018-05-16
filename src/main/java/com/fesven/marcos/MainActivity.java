package com.fesven.marcos;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.wonderkiln.camerakit.CameraKit;
import com.wonderkiln.camerakit.CameraView;

public class MainActivity extends AppCompatActivity implements AccionesCamaraFragment.OnFragmentInteractionListener,CamaraFragment.OnFragmentInteractionListener{

    FragmentTransaction ft;
    AccionesCamaraFragment accionesCamaraFragment;
    CamaraFragment camaraFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindUI();
    }

    public void bindUI(){
        ft = getSupportFragmentManager().beginTransaction();

        init();

        ft.replace(R.id.fragmentAccionesCamara, accionesCamaraFragment);
        ft.replace(R.id.fragmentCamara, camaraFragment);
        ft.commit();

    }

    public void init(){
        accionesCamaraFragment = new AccionesCamaraFragment();
        camaraFragment = new CamaraFragment();
    }

    @Override
    public void onClickBtnGirarCamara() {
        int facing_change = camaraFragment.getCameraView().getFacing() == CameraKit.Constants.FACING_BACK
                ? CameraKit.Constants.FACING_FRONT : CameraKit.Constants.FACING_BACK;
        camaraFragment.getCameraView().setFacing(facing_change);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
