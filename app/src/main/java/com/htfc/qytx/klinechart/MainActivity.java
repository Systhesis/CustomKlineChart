package com.htfc.qytx.klinechart;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.content.ContextCompat;

import com.htfc.qytx.common.view.klinechart.DataHelper;
import com.htfc.qytx.common.view.klinechart.KLineChartAdapter;
import com.htfc.qytx.common.view.klinechart.KLineEntity;
import com.htfc.qytx.common.view.klinechart.draw.Status;
import com.htfc.qytx.common.view.klinechart.formatter.DateFormatter;
import com.htfc.qytx.klinechart.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private KLineChartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new KLineChartAdapter();
        binding.kLineChartView.setAdapter(adapter);
        binding.kLineChartView.setDateTimeFormatter(new DateFormatter());
        binding.kLineChartView.setGridRows(4);
        binding.kLineChartView.setGridXLineColor(ContextCompat.getColor(this,R.color.chart_line_gray));
        binding.kLineChartView.setGridYLineColor(ContextCompat.getColor(this,R.color.chart_trans));
        binding.kLineChartView.changeMainDrawType(Status.NONE);
        binding.kLineChartView.setGridColumns(4);
        binding.kLineChartView.hideVolDraw();
        binding.kLineChartView.hideMaxAndMin();
        initData();

    }

    private void initData() {
        binding.kLineChartView.justShowLoading();

        List<KLineEntity> datas = DataRequest.getALL(this);
        DataHelper.calculate(datas);
        adapter.addFooterData(datas);
        adapter.notifyDataSetChanged();
        binding.kLineChartView.startAnimation();
        binding.kLineChartView.refreshEnd();
    }

}