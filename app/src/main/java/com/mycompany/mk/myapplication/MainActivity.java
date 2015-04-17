package com.mycompany.mk.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    private final int SHUFFLE_COUNT = 10;

    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;
    private ImageView iv5;
    private ImageView iv6;
    private ImageView iv7;
    private ImageView iv8;
    private ImageView iv9;

    private ArrayList<ImageView> imageViewArrayList = new ArrayList<ImageView>();
    private ArrayList<Integer> numberArrayList = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();

        Button loadButton = (Button) findViewById(R.id.loadButton);
        loadButton.setOnClickListener(this);
        Button shuffleButton = (Button) findViewById(R.id.shuffleButton);
        shuffleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.loadButton:
                loadImages();
                break;
            case R.id.shuffleButton:
                shuffleImages(SHUFFLE_COUNT);
                break;
        }
    }

    private void setUp() {
        iv1 = (ImageView) findViewById(R.id.imageView1);
        iv2 = (ImageView) findViewById(R.id.imageView2);
        iv3 = (ImageView) findViewById(R.id.imageView3);
        iv4 = (ImageView) findViewById(R.id.imageView4);
        iv5 = (ImageView) findViewById(R.id.imageView5);
        iv6 = (ImageView) findViewById(R.id.imageView6);
        iv7 = (ImageView) findViewById(R.id.imageView7);
        iv8 = (ImageView) findViewById(R.id.imageView8);
        iv9 = (ImageView) findViewById(R.id.imageView9);

        imageViewArrayList.add(iv1);
        imageViewArrayList.add(iv2);
        imageViewArrayList.add(iv3);
        imageViewArrayList.add(iv4);
        imageViewArrayList.add(iv5);
        imageViewArrayList.add(iv6);
        imageViewArrayList.add(iv7);
        imageViewArrayList.add(iv8);
        imageViewArrayList.add(iv9);


        numberArrayList.add(R.drawable.num1);
        numberArrayList.add(R.drawable.num2);
        numberArrayList.add(R.drawable.num3);
        numberArrayList.add(R.drawable.num4);
        numberArrayList.add(R.drawable.num5);
        numberArrayList.add(R.drawable.num6);
        numberArrayList.add(R.drawable.num7);
        numberArrayList.add(R.drawable.num8);
        numberArrayList.add(R.drawable.num9);
    }

    public void loadImages() {
        for (int i = 0; i < imageViewArrayList.size(); i++) {
            imageViewArrayList.get(i).setImageResource(numberArrayList.get(i));
            imageViewArrayList.get(i).setTag(numberArrayList.get(i));
        }
    }

    public void shuffleImages(int shuffleCount) {
        for (int i = 0; i < shuffleCount; i++) {
            shuffle(imageViewArrayList);
            loadImages();
        }
    }

    private int getImageResource(ImageView iv) {
        return (Integer) iv.getTag();
    }

    void shuffle(ArrayList<ImageView> imageViewArrayList) {
        Random rnd = new Random();
        int index1 = rnd.nextInt(imageViewArrayList.size());
        Log.d("Random 1", "" + index1);
        int index2 = rnd.nextInt(imageViewArrayList.size());
        Log.d("Random 2", "" + index2);

        ImageView ivTemp1 = imageViewArrayList.get(index1);
        ImageView ivTemp2 = imageViewArrayList.get(index2);
        imageViewArrayList.set(index1, ivTemp2);
        imageViewArrayList.set(index2, ivTemp1);

        Log.d("Switch", "" + index1 + " switched with " + index2);

        // PUT FANCY SWITCH ANIMATION HERE
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
