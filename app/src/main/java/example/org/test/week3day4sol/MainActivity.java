package example.org.test.week3day4sol;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        DynamicFragment.OnFragmentInteractionListener, Output.OnFragmentInteractionListener {

    ArrayList<String> returnItems;

    DynamicFragment dynamicFragment;
    Output outputFragment;
    FragmentManager fragmentManager;

    private static final String DYNAMIC_FRAG_ONE_TAG = "dynamic_frag_one";
    private static final String OUTPUT_FRAG_ONE_TAG = "output_frag_one";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dynamicFragment = DynamicFragment.newInstance();
        outputFragment = Output.newInstance();
        returnItems = new ArrayList<>();

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frgDynamic, dynamicFragment)
                .addToBackStack(DYNAMIC_FRAG_ONE_TAG)
                .commit();
        fragmentManager.beginTransaction()
                .replace(R.id.frmOutput, outputFragment)
                .addToBackStack(OUTPUT_FRAG_ONE_TAG)
                .commit();
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onFragmentInteraction(ArrayList<String> dynamicFragments) {
        returnItems = dynamicFragments;
        for (String str : dynamicFragments){
            Log.d("Log.d", str);
        }

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
