package com.example.new_serveasy.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.new_serveasy.R;
import com.example.new_serveasy.models.Garage;

import java.util.ArrayList;

public class GarageAdapter extends RecyclerView.Adapter<GarageAdapter.GarageViewHolder> {

    private ArrayList<Garage> Garage;

    public GarageAdapter(ArrayList<Garage> garages) {
        Garage = garages;
    }


    @NonNull
    @Override
    public GarageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.garage_item, parent, false);
        return new GarageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GarageViewHolder holder, int position) {
        Garage garages = Garage.get(position);

        holder.garageNameTextView.setText(garages.getgName());
        holder.garageContactTextView.setText(garages.getgContact());
        holder.garageAreaTextView.setText(garages.getgArea());
        Log.d("name", garages.getgArea() + "");
        holder.garageCityTextView.setText(garages.getgCity());
        holder.garageFullAddressTextView.setText(garages.getgFullAddress());
        holder.garageOwnerTextView.setText(garages.getgOwner());

        holder.viewServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CLICK", "View Services Button Clicked");
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.d("itemcount", Garage.size() + "");
        return Garage.size();

    }

    public class GarageViewHolder extends RecyclerView.ViewHolder {

        private TextView garageNameTextView, garageAreaTextView, garageCityTextView, garageContactTextView, garageOwnerTextView, garageFullAddressTextView;
        private Button viewServiceButton;

        public GarageViewHolder(@NonNull View itemView) {
            super(itemView);
            garageNameTextView = itemView.findViewById(R.id.garage_name);
            garageAreaTextView = itemView.findViewById(R.id.garage_area);
            garageCityTextView = itemView.findViewById(R.id.garage_city);
            garageContactTextView = itemView.findViewById(R.id.garage_contact);
            garageOwnerTextView = itemView.findViewById(R.id.garage_owner);
            garageFullAddressTextView = itemView.findViewById(R.id.garage_full_address);
            viewServiceButton = itemView.findViewById(R.id.book_button);
        }
    }
}