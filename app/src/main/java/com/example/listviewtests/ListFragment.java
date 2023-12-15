package com.example.listviewtests;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    public ListFragment(){
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.list_fragment, container, false);
        ListView listView = rootView.findViewById(R.id.listView);

        ArrayList<String> lista = new ArrayList<>();
        lista.add("Horas");
        lista.add("Checkboxes");

        Log.d("tilin", lista.get(0));

        MyAdapter myAdapter = new MyAdapter(lista, requireContext());

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = lista.get(position);
                // Call a method to handle item click and navigate to AnotherFragment
                handleItemClickAndNavigate(selectedItem);
            }
        });

        return rootView;
    }

    public void handleItemClickAndNavigate(String item_seleccionado){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Pass any data you want to AnotherFragment using arguments
        //Bundle bundle = new Bundle();
        //bundle.putString("selectedItem", item_seleccionado);


        //frag_info.setArguments(bundle);

        if (item_seleccionado.equals("Horas")){
            NowRedux reduxFragment = new NowRedux();
            // Replace the current fragment with AnotherFragment
            fragmentTransaction.replace(R.id.fragmentContainerView, reduxFragment);
            // Add the transaction to the back stack to allow back navigation
            fragmentTransaction.addToBackStack(null);
            // Commit the transaction
            fragmentTransaction.commit();

        }


    }
}
