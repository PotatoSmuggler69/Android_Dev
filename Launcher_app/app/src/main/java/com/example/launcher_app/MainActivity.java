
package com.example.launcher_app;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.health.connect.datatypes.AppInfo;
import android.os.Build;
import android.os.Bundle;
import com.example.launcher_app.*;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AppAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new AppAdapter();
        recyclerView.setAdapter(adapter);

        List<AppInfo> apps = getInstalledApps();
        adapter.setApps(apps);
    }

    @RequiresApi(api = Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    private List<AppInfo> getInstalledApps() {
        List<AppInfo> apps = new ArrayList<>();

        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> resolveInfos = packageManager.queryIntentActivities(intent, 0);
        for (ResolveInfo resolveInfo : resolveInfos) {
            com.example.launcher_app.AppInfo appInfo = new AppInfo();
            appInfo.label = resolveInfo.loadLabel(packageManager).toString();
            appInfo.packageName = resolveInfo.activityInfo.packageName;
            appInfo.icon = resolveInfo.activityInfo.loadIcon(packageManager);
            apps.add(appInfo);
        }

        return apps;
    }
}
