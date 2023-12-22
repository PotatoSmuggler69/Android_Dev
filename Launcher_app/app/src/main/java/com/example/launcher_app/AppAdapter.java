package com.example.launcher_app;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppViewHolder> {

    private static List<AppInfo> apps;

    public void setApps(List<AppInfo> apps) {
        this.apps = apps;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_item, parent, false);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder holder, int position) {
        AppInfo appInfo = apps.get(position);
        holder.appNameTextView.setText(appInfo.label);
        holder.appIconImageView.setImageDrawable(appInfo.icon);
    }

    @Override
    public int getItemCount() {
        return apps == null ? 0 : apps.size();
    }

    static class AppViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView appNameTextView;
        ImageView appIconImageView;

        public AppViewHolder(@NonNull View itemView) {
            super(itemView);
            appNameTextView = itemView.findViewById(R.id.app_name);
            appIconImageView = itemView.findViewById(R.id.app_icon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            AppInfo appInfo = apps.get(position);

            startActivity(launchIntent);
        }
    }
}
