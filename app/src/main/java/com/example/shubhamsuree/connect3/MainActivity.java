package com.example.shubhamsuree.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int activeplayer=0;  //yellow=0 and red=1

    int[] gameState= {2,2,2,2,2,2,2,2,2};
    int cnt=0;

    public void dropin(View view) {

        ImageView counter = (ImageView) view;
        int tapcounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tapcounter] == 2) {
            gameState[tapcounter]=activeplayer;
            if((gameState[0]==1 && gameState[1]==1 && gameState[2]==1) || (gameState[3]==1 && gameState[4]==1 && gameState[5]==1) || (gameState[6]==1 && gameState[7]==1 && gameState[8]==1)
                    || (gameState[0]==1 && gameState[3]==1 && gameState[6]==1) || (gameState[1]==1 && gameState[4]==1 && gameState[7]==1) || (gameState[2]==1 && gameState[5]==1 && gameState[8]==1)
                    || (gameState[0]==1 && gameState[4]==1 && gameState[8]==1) || (gameState[2]==1 && gameState[4]==1 && gameState[6]==1)){
                Toast.makeText(this,"Red Wins",Toast.LENGTH_LONG).show();
                GridLayout grid=(GridLayout)findViewById(R.id.grid);
                activeplayer=0;
                for(int i=0;i<grid.getChildCount();i++){
                    ((ImageView)grid.getChildAt(i)).setImageResource(0);
                    gameState[i]=2;
                }
                cnt=0;
                return;
            }
            else if((gameState[0]==0 && gameState[1]==0 && gameState[2]==0) || (gameState[3]==0 && gameState[4]==0 && gameState[5]==0) || (gameState[6]==0 && gameState[7]==0 && gameState[8]==0)
                    || (gameState[0]==0 && gameState[3]==0 && gameState[6]==0) || (gameState[1]==0 && gameState[4]==0 && gameState[7]==0) || (gameState[2]==0 && gameState[5]==0 && gameState[8]==0)
                    || (gameState[0]==0 && gameState[4]==0 && gameState[8]==0) || (gameState[2]==0 && gameState[4]==0 && gameState[6]==0)){
                Toast.makeText(this,"Yellow Wins",Toast.LENGTH_LONG).show();
                activeplayer=1;
                GridLayout grid=(GridLayout)findViewById(R.id.grid);
                for(int i=0;i<grid.getChildCount();i++){
                    gameState[i]=2;
                    ((ImageView)grid.getChildAt(i)).setImageResource(0);
                }
                cnt=0;
                return;
                //setContentView(R.layout.activity_main);
            }else if(cnt==8){
                Toast.makeText(this,"Game Draw",Toast.LENGTH_LONG).show();
                activeplayer=1;
                GridLayout grid=(GridLayout)findViewById(R.id.grid);
                for(int i=0;i<grid.getChildCount();i++){
                    gameState[i]=2;
                    ((ImageView)grid.getChildAt(i)).setImageResource(0);
                }
                cnt=0;
                return;
            }
                counter.setTranslationY(-1000f);
                if (activeplayer == 0) {
                    counter.setImageResource(R.drawable.yellow);
                    activeplayer = 1;
                    cnt++;
                } else {
                    counter.setImageResource(R.drawable.red);
                    activeplayer = 0;
                    cnt++;
                }
                counter.animate().translationYBy(1000f).setDuration(300);
        }
    }
}
