package com.example.a8queenz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int queen_count;
    int q1_count;
    int q2_count;
    int y_count;
    char [] queen = new char [8];
    float [] queens = new float [8];
    float [] queenz = new float[8];
    char [] q1 = new char [4];
    float [] r1 = new float [4];
    float [] s1 = new float [4];
    ImageButton [] t1 = new ImageButton [4];
    char [] q2 = new char [4];
    float [] r2 = new float [4];
    float [] s2 = new float [4];
    ImageButton [] t2 = new ImageButton [4];
    int [] ids = new int[8];
    int [] buttons = new int [64];
    int [] illegal_buttons = new int[64];
    int a;
    int b;
    ImageButton [] button = new ImageButton[8];
    ImageButton previous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queen_count = 0;
        q1_count = 0;
        q2_count = 0;
        a = 0;
        b = 0;
        y_count = 0;
        previous = null;
    }

    public void queen(View view) {
        int pass = 0;
        Context context = getApplicationContext();
        ImageButton image = findViewById(view.getId());
        int id = image.getId();
        Toast bread = Toast.makeText(context, "" + (y_count + image.getContentDescription().length() - 10)/(queen_count + 1) + "", Toast.LENGTH_LONG);
        bread.show();
        if (image.getTag().toString().matches("brown") || image.getTag().toString().matches("white")) {
            if (image.getTag().toString().matches("brown")) {
                for (int i = 0; i < 8; i++) {
                    float x_diagonal = image.getX() - queens[i];
                    float y_diagonal = image.getY() - queenz[i];
                    float r_x_diagonal = queens[i] - image.getX();
                    float r_y_diagonal = queenz[i] - image.getY();
                    if (image.getX() == queens[i] && queen[i] == 'T') {
                        Toast row = Toast.makeText(context, "ILLEGAL MOVE: There is already a Queen in this column",
                                Toast.LENGTH_LONG);
                        row.show();
                        break;
                    } else if (image.getY() == queenz[i] && queen[i] == 'T') {
                        Toast column = Toast.makeText(context, "ILLEGAL MOVE: There is already a Queen in this row", Toast.LENGTH_LONG);
                        column.show();
                        break;
                    } else if (x_diagonal == y_diagonal && queen[i] == 'T' || x_diagonal == r_y_diagonal && queen[i] == 'T') {
                        Toast diagonal = Toast.makeText(context, "ILLEGAL MOVE: There is already a Queen along this diagonal", Toast.LENGTH_LONG);
                        diagonal.show();
                        break;
                    } else if (i != 7) {
                        pass = pass + 1;
                    } else if (i == 7 && pass == 7) {
                        image.setBackgroundResource(R.drawable.brownqueen);
                        image.setTag("yes brown");
                        y_count = y_count + image.getContentDescription().length() - 10;
                        queen[queen_count] = 'T';
                        queens[queen_count] = image.getX();
                        queenz[queen_count] = image.getY();
                        button[queen_count] = image;
                        ids[queen_count] = id;
                        queen_count = queen_count + 1;
                        if (queen_count == 8) {
                            Toast winner = Toast.makeText(context,
                                    "CONGRATULATIONS!!! YOU HAVE SUCCESSFULLY COMPLETED THE 8 QUEEN CHALLENGE!!!", Toast.LENGTH_LONG);
                            winner.show();
                            break;
                        }
                    }
                }

        } else if (image.getTag().toString().matches("white")) {
            for (int i = 0; i < 8; i++) {
                float x_diagonal = image.getX() - queens[i];
                float y_diagonal = image.getY() - queenz[i];
                float r_x_diagonal = queens[i] - image.getX();
                float r_y_diagonal = queenz[i] - image.getY();
                if (image.getX() == queens[i] && queen[i] == 'T') {
                    Toast row = Toast.makeText(context, "ILLEGAL MOVE: There is already a Queen in this column",
                            Toast.LENGTH_LONG);
                    row.show();
                    break;
                } else if (image.getY() == queenz[i] && queen[i] == 'T') {
                    Toast column = Toast.makeText(context, "ILLEGAL MOVE: There is already a Queen in this row", Toast.LENGTH_LONG);
                    column.show();
                    break;
                } else if (x_diagonal == y_diagonal && queen[i] == 'T' || x_diagonal == r_y_diagonal && queen[i] == 'T') {
                    Toast diagonal = Toast.makeText(context, "ILLEGAL MOVE: There is already a Queen along this diagonal", Toast.LENGTH_LONG);
                    diagonal.show();
                    break;
                } else if (i != 7) {
                    pass = pass + 1;
                } else if (i == 7 && pass == 7) {
                    image.setBackgroundResource(R.drawable.whitequeen);
                    image.setTag("yes white");
                    y_count = y_count + image.getContentDescription().length() - 10;
                    queen[queen_count] = 'T';
                    queens[queen_count] = image.getX();
                    queenz[queen_count] = image.getY();
                    button[queen_count] = image;
                    ids[queen_count] = id;
                    queen_count = queen_count + 1;
                    
                    if (queen_count == 8) {
                            Toast winner = Toast.makeText(context,
                                    "CONGRATULATIONS!!! YOU HAVE SUCCESSFULLY COMPLETED THE 8 QUEEN CHALLENGE!!!", Toast.LENGTH_LONG);
                            winner.show();
                            break;
                    }
                }
            }
        }
            
        } else if (image.getTag().toString().matches("yes brown") || image.getTag().toString().matches("yes white")) {
            if (image.getTag().toString().matches("yes brown")) {
                image.setBackgroundResource(R.color.BROWN);
                image.setTag("brown");
                y_count = y_count - image.getContentDescription().length() - 10;
                queen_count = queen_count - 1;
                q1_count = q1_count - 1;
                q2_count = q2_count - 1;
                for (int i = 0; i < 8; i++) {
                    if (image.getX() == queens[i] && image.getY() == queenz[i]) {
                        for (int j = i; j < 8; j++) {
                            if (j + 1 == 8) {
                                break;
                            } else {
                                queen[j] = queen[j + 1];
                                queens[j] = queens[j + 1];
                                queenz[j] = queenz[j + 1];
                                ids[j] = ids[j + 1];
                                button[j] = button[j + 1];
                            }
                        }
                    }
                }
            } else if (image.getTag().toString().matches("yes white")) {
                if (image.getTag().toString().matches("yes white")) {
                    image.setBackgroundResource(R.color.WHITE);
                    image.setTag("white");
                    y_count = y_count - image.getContentDescription().length() - 10;
                    queen_count = queen_count - 1;
                    q1_count = q1_count - 1;
                    q2_count = q2_count - 1;
                    for (int i = 0; i < 8; i++) {
                        if (image.getX() == queens[i] && image.getY() == queenz[i]) {
                            for (int j = i; j < 8; j++) {
                                if (j + 1 == 8) {
                                    break;
                                } else {
                                    queen[j] = queen[j + 1];
                                    queens[j] = queens[j + 1];
                                    queenz[j] = queenz[j + 1];
                                    ids[j] = ids[j + 1];
                                    button[j] = button[j + 1];

                                }
                            }
                        }
                    }

                }
            }
            // each button now has its own individual x and y

        }
    }
    
    public void find(int [] a, int [] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                if (findViewById(a[i]).getTag() == "brown") {
                    findViewById(a[i]).setBackgroundResource(R.drawable.brownqueen);
                    findViewById(a[i]).setTag("yes brown");
                } else if (findViewById(a[i]).getTag() == "white") {
                    findViewById(a[i]).setBackgroundResource(R.drawable.whitequeen);
                    findViewById(a[i]).setTag("yes white");
                }
            }
        }
    }
    
    public void reset(View view) {
        Context c = getApplicationContext();
        queen_count = 0;
        q1_count = 0;
        q2_count = 0;
        y_count = 0;
        for (int x = 0; x < 8; x++) {
            queens[x] = 0;
            queenz[x] = 0;
            queen[x] = ' ';
            ids[x] = 0;
            button[x] = null;
        }

        for (int i = findViewById(R.id.a1).getId(); i < (int) findViewById(R.id.a9).getId() + 1; i++) {
            ImageButton picture = findViewById(i);
            if (picture.getTag() == "yes brown") {
                picture.setBackgroundResource(R.color.BROWN);
                picture.setTag("brown");
            } else if (picture.getTag() == "yes white") {
                picture.setBackgroundResource(R.color.WHITE);
                picture.setTag("white");
            }
        }
    }
}



