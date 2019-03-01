package example.org.test.week3day4sol;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class DynamicFragment extends Fragment implements View.OnClickListener {
    EditText etUserName;
    EditText etUserEmail;
    EditText etUserPassword;
    Button btnAddTheUser;
    User user ;
    ArrayList<String> dynamicFragments;

    private OnFragmentInteractionListener mListener;

    public DynamicFragment() {
        // Required empty public constructor
    }
    public static DynamicFragment newInstance() {
        DynamicFragment fragment = new DynamicFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dynamic, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etUserName = view.findViewById(R.id.etUserName);
        dynamicFragments= new ArrayList<>();
        etUserEmail = view.findViewById(R.id.etUserEmail);
        etUserPassword = view.findViewById(R.id.etUserPassword);
        btnAddTheUser = view.findViewById(R.id.btnAddTheUser);
        btnAddTheUser.setOnClickListener(this);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(dynamicFragments);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        if (mListener!= null){
            String name = etUserName.getText().toString();
            String email = etUserEmail.getText().toString();
            String password = etUserPassword.getText().toString();
            dynamicFragments.add(name);
            dynamicFragments.add(email);
            dynamicFragments.add(password);
            mListener.onFragmentInteraction(dynamicFragments);


        }

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(ArrayList<String> dynamicFragments);
    }
}
