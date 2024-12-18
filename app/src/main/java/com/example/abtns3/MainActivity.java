package com.example.abtns3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.btns_layout);
        ConstraintLayout layout = findViewById(R.id.btns101);
        ViewCompat.setOnApplyWindowInsetsListener(layout, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        View backGroundView1 = new View(this);
        backGroundView1.setId(View.generateViewId());
        backGroundView1.setBackgroundColor(Color.GREEN);
        layout.addView(backGroundView1, new ConstraintLayout.LayoutParams(392, 426));
        View backGroundView2 = new View(this);
        backGroundView2.setId(View.generateViewId());
        backGroundView2.setBackgroundColor(Color.RED);
        layout.addView(backGroundView2, new ConstraintLayout.LayoutParams(392, 426));
        Button[] buttons = new Button[8];
        String[] buttonTexts = {"Button1", "Button2", "Button4", "Button3"};
        for (int i = 0; i < 8; i++)
        {
            buttons[i] = new Button(this);
            buttons[i].setId(View.generateViewId());
            buttons[i].setText(buttonTexts[i % 4]);
            layout.addView(buttons[i]);
        }
        ConstraintSet set = new ConstraintSet();
        set.clone(layout);
        set.connect(backGroundView1.getId(), ConstraintSet.TOP, layout.getId(), ConstraintSet.TOP);
        set.connect(backGroundView1.getId(), ConstraintSet.START, layout.getId(), ConstraintSet.START);
        set.connect(backGroundView1.getId(), ConstraintSet.END, layout.getId(), ConstraintSet.END);
        set.connect(backGroundView2.getId(), ConstraintSet.BOTTOM, layout.getId(), ConstraintSet.BOTTOM);
        set.connect(backGroundView2.getId(), ConstraintSet.START, layout.getId(), ConstraintSet.START);
        set.connect(backGroundView2.getId(), ConstraintSet.END, layout.getId(), ConstraintSet.END);
        float[][] buttonPositions = {
                {0.3f, 0.25f}, {0.7f, 0.25f},
                {0.3f, 0.32f}, {0.7f, 0.32f},
                {0.3f, 0.65f}, {0.7f, 0.65f},
                {0.3f, 0.72f}, {0.7f, 0.72f},
        };
        for (int i = 0; i < buttons.length; i++)
        {
            set.connect(buttons[i].getId(), ConstraintSet.START, layout.getId(), ConstraintSet.START);
            set.connect(buttons[i].getId(), ConstraintSet.END, layout.getId(), ConstraintSet.END);
            set.connect(buttons[i].getId(), ConstraintSet.TOP, layout.getId(), ConstraintSet.TOP);
            set.connect(buttons[i].getId(), ConstraintSet.BOTTOM, layout.getId(), ConstraintSet.BOTTOM);
            set.setHorizontalBias(buttons[i].getId(), buttonPositions[i][0]);
            set.setVerticalBias(buttons[i].getId(), buttonPositions[i][1]);
        }
        set.applyTo(layout);
    }
}
