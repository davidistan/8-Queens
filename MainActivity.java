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
//                        if ((image.getContentDescription().length() - 10) <= 31) {
//                            q1[q1_count] = 'T';
//                            r1[q1_count] = image.getX();
//                            s1[q1_count] = image.getY();
//                            t1[q1_count] = image;
//                            q1_count = q1_count + 1;
                        if (queen_count == 8) {
                            Toast winner = Toast.makeText(context,
                                    "CONGRATULATIONS!!! YOU HAVE SUCCESSFULLY COMPLETED THE 8 QUEEN CHALLENGE!!!", Toast.LENGTH_LONG);
                            winner.show();
                            break;
                        }
//                        } else if ((image.getContentDescription().length() - 10) > 31) {
//                            q2[q2_count] = 'T';
//                            r2[q2_count] = image.getX();
//                            s2[q2_count] = image.getY();
//                            t2[q2_count] = image;
//                            q2_count = q2_count + 1;
//                            if (queen_count == 8) {
//                                Toast winner = Toast.makeText(context,
//                                        "CONGRATULATIONS!!! YOU HAVE SUCCESSFULLY COMPLETED THE 8 QUEEN CHALLENGE!!!", Toast.LENGTH_LONG);
//                                winner.show();
//                                break;
//                            }

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
//                    if ((image.getContentDescription().length() - 10) <= 31) {
//                        q1[q1_count] = 'T';
//                        r1[q1_count] = image.getX();
//                        s1[q1_count] = image.getY();
//                        t1[q1_count] = image;
//                        q1_count = q1_count + 1;
                    if (queen_count == 8) {
                            Toast winner = Toast.makeText(context,
                                    "CONGRATULATIONS!!! YOU HAVE SUCCESSFULLY COMPLETED THE 8 QUEEN CHALLENGE!!!", Toast.LENGTH_LONG);
                            winner.show();
                            break;
                    }
//                    } else if ((image.getContentDescription().length() - 10) > 31) {
//                        q2[q2_count] = 'T';
//                        r2[q2_count] = image.getX();
//                        s2[q2_count] = image.getY();
//                        t2[q2_count] = image;
//                        q2_count = q2_count + 1;
//                        if (queen_count == 8) {
//                            Toast winner = Toast.makeText(context,
//                                    "CONGRATULATIONS!!! YOU HAVE SUCCESSFULLY COMPLETED THE 8 QUEEN CHALLENGE!!!", Toast.LENGTH_LONG);
//                            winner.show();
//                            break;
//                        }
//
//                    }
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
//                                if ((image.getContentDescription().length() - 10) <= 31) {
//                                    for (int h = 0; h < 4; h++) {
//                                        if (h + 1 == 4) {
//                                            break;
//                                        } else {
//                                            q1[h] = q1[h + 1];
//                                            r1[h] = r1[h + 1];
//                                            s1[h] = s1[h + 1];
//                                            t1[h] = t1[h + 1];
//                                        }
//                                    }
//
//                                } else if ((image.getContentDescription().length() - 10) > 31) {
//                                    for (int h = 0; h < 4; h++) {
//                                        if (h + 1 == 4) {
//                                            break;
//                                        } else {
//                                            q2[h] = q2[h + 1];
//                                            r2[h] = r2[h + 1];
//                                            s2[h] = s2[h + 1];
//                                            t2[h] = t2[h + 1];
//                                        }
//                                    }
//
//                                }
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
//                                    if ((image.getContentDescription().length() - 10) <= 31) {
//                                        for (int h = 0; h < 4; h++) {
//                                            if (h + 1 == 4) {
//                                                break;
//                                            } else {
//                                                q1[h] = q1[h + 1];
//                                                r1[h] = r1[h + 1];
//                                                s1[h] = s1[h + 1];
//                                                t1[h] = t1[h + 1];
//                                            }
//                                        }
//
//                                    } else if ((image.getContentDescription().length() - 10) > 31) {
//                                        for (int h = 0; h < 4; h++) {
//                                            if (h + 1 == 4) {
//                                                break;
//                                            } else {
//                                                q2[h] = q2[h + 1];
//                                                r2[h] = r2[h + 1];
//                                                s2[h] = s2[h + 1];
//                                                t2[h] = t2[h + 1];
//                                            }
//                                        }
//
//                                    }
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

//     public void finished(View view, int q) {
//        Context ctext = getApplicationContext();
//        Toast finished = Toast.makeText(ctext, "Solution has been found", Toast.LENGTH_LONG);
//        if (button[q].getTag().toString().matches("yes brown")) {
//            button[q].setBackgroundResource(R.color.BROWN);
//            button[q].setTag("brown");
//            queens[q] = 0;
//            queenz[q] = 0;
//            queen[q] = ' ';
//            queen_count = queen_count - 1;
//            ImageButton end = findViewById(R.id.solved);
//            end.performClick();
//        } else if (button[q].getTag().toString().matches("yes white")) {
//            button[q].setBackgroundResource(R.color.WHITE);
//            button[q].setTag("yes white");
//            queens[q] = 0;
//            queenz[q] = 0;
//            queen[q] = ' ';
//            queen_count = queen_count - 1;
//            ImageButton end = findViewById(R.id.solved);
//            end.performClick();
//        }
//
//     }
//
//
//
//    public void solution(View view) {
//        Context text = getApplicationContext();
//        int q = queen_count;
//        int u_q = queen_count;
//        int a = 0;
//        int cases = 0;
//        int it = 0;
//        int z = 0;
//        int error = 0;
//        int minus = 0;
//        Toast count = Toast.makeText(text, "" + it, Toast.LENGTH_LONG);
//        count.show();
//        int h = (int) findViewById(R.id.a9).getId() + 1;
//        for (int i = findViewById(R.id.a1).getId(); i < (int) findViewById(R.id.a9).getId() + 1; i++) {
////            ImageButton p = findViewById(h - minus);
//            ImageButton picture = findViewById(i);
//            it = 0;
//            for (int j = 0; j < 8; j++) {
//                float x_diagonal = picture.getX() - queens[j];
//                float y_diagonal = picture.getY() - queenz[j];
//                float r_x_diagonal = queens[j] - picture.getX();
//                float r_y_diagonal = queenz[j] - picture.getY();
////                float x1_diagonal = p.getX() - queens[j];
////                float y1_diagonal = p.getY() - queenz[j];
////                float r1_x_diagonal = queens[j] - p.getX();
////                float r1_y_diagonal = queenz[j] - p.getY();
//                if ((picture.getX() != queens[j] && picture.getY() != queenz[j] && x_diagonal != y_diagonal &&
//                        x_diagonal != r_y_diagonal) && queen[j] == 'T' || (queen[j] != 'T')) {
//                    it = it + 1;
////                } else if ((p.getX() != queens[j] && p.getY() != queenz[j] && x1_diagonal != y1_diagonal &&
////                        x1_diagonal != r1_y_diagonal) && queen[j] == 'T' && picture != button[j] || (queen[j] != 'T')) {
////                    z = z + 1;
//////                    if (q < 2) {
//////                        it = it + 1;
//////                    } else if (q > 1 && q < 3 && ((picture.getContentDescription().length() - 10 + y_count)/(q)) >= 3) {
//////                        it = it + 1;
//////                    } else if (q > 2 && q <= 7 && ((picture.getContentDescription().length() - 10 + y_count)/(q)) >= 4.5) {
//////                        it = it + 1;
//////                    } else {
//////                        it = 0;
//////                        break;
//////                    }
//
//                } else {
////                    if (j >= u_q && j < 8) {
////                        queen[j] = ' ';
////                        queens[j] = 0;
////                        queenz[j] = 0;
////                        queen_count = queen_count - 1;
////                        solution(view);
//////                    if (j >= queen_count && q <= 8) {
//////                        queens[j] = 0;
//////                        queenz[j] = 0;
//////                        queen[j] = ' ';
//////                        button[j].setBackgroundResource(R.color.BROWN);
//////                        error = j;
//////                    }
//////                        it = 0;
//////                        break;
////                    }
//                    it = 0;
//                    break;
//                }
//            }
//
//            if (it == 8) {
//                q = q + 1;
//                button[q - 1] = picture;
//                if (picture.getTag().toString().matches("brown")) {
//                    picture.setBackgroundResource(R.drawable.brownqueen);
//                    picture.setTag("yes brown");
//                    previous = picture;
//                    queens[q - 1] = picture.getX();
//                    queenz[q - 1] = picture.getY();
//                    queen[q - 1] = 'T';
//                    it = 0;
//                    y_count = y_count + (picture.getContentDescription().length() - 10);
//                    queen_count = queen_count + 1;
//                } else if (picture.getTag().toString().matches("white")) {
//                    picture.setBackgroundResource(R.drawable.whitequeen);
//                    picture.setTag("yes white");
//                    previous = picture;
//                    queens[q - 1] = picture.getX();
//                    queenz[q - 1] = picture.getY();
//                    queen[q - 1] = 'T';
//                    it = 0;
//                    y_count = y_count + (picture.getContentDescription().length() - 10);
//                    queen_count = queen_count + 1;
//
////            } else if (it != 8) {
////                queen[error] = ' ';
////                queens[error] = 0;
////                queenz[error] = 0;
////                if (button[error].getTag().toString().matches("brown")) {
////                    button[error].setBackgroundResource(R.drawable.brownqueen);
////                    button[error] = null;
////                    queen_count = queen_count - 1;
////                } else if (button[error].getTag().toString().matches("white")) {
////                    button[error].setBackgroundResource(R.drawable.whitequeen);
////                    button[error] = null;
////                    queen_count = queen_count - 1;
////                }
//////                this.solution(view);
//////            }
////
////
//                }
////            } else if (z == 8) {
////                q = q + 1;
////                button[q - 1] = picture;
////                if (picture.getTag().toString().matches("brown")) {
////                    picture.setBackgroundResource(R.drawable.brownqueen);
////                    picture.setTag("yes brown");
////                    previous = picture;
////                    queens[q - 1] = picture.getX();
////                    queenz[q - 1] = picture.getY();
////                    queen[q - 1] = 'T';
////                    it = 0;
////                    y_count = y_count + (picture.getContentDescription().length() - 10);
////                } else if (picture.getTag().toString().matches("white")) {
////                    picture.setBackgroundResource(R.drawable.whitequeen);
////                    picture.setTag("yes white");
////                    previous = picture;
////                    queens[q - 1] = picture.getX();
////                    queenz[q - 1] = picture.getY();
////                    queen[q - 1] = 'T';
////                    it = 0;
////                    y_count = y_count + (picture.getContentDescription().length() - 10);
////
////                }
//            }
//            if (i == h - 1 && queen_count < 8) {
//                finished(view, q - 1);
//
//
//            }
////            minus = minus + 1;
//        }
//    }
////    }
//
//    public void solution(View view, int num) {
//        Context text = getApplicationContext();
//        int q = queen_count;
//        int u_q = queen_count;
//        int a = 0;
//        int cases = 0;
//        int it = 0;
//        int z = 0;
//        int error = 0;
//        int minus = 0;
//        Toast count = Toast.makeText(text, "" + it, Toast.LENGTH_LONG);
//        count.show();
//        int h = (int) findViewById(R.id.a9).getId() + 1;
//        for (int i = findViewById(R.id.a1).getId(); i < (int) findViewById(R.id.a9).getId() + 1; i++) {
////            ImageButton p = findViewById(h - minus);
//            ImageButton picture = findViewById(i);
//            it = 0;
//            for (int j = 0; j < 8; j++) {
//                float x_diagonal = picture.getX() - queens[j];
//                float y_diagonal = picture.getY() - queenz[j];
//                float r_x_diagonal = queens[j] - picture.getX();
//                float r_y_diagonal = queenz[j] - picture.getY();
////                float x1_diagonal = p.getX() - queens[j];
////                float y1_diagonal = p.getY() - queenz[j];
////                float r1_x_diagonal = queens[j] - p.getX();
////                float r1_y_diagonal = queenz[j] - p.getY();
//                if ((picture.getX() != queens[j] && picture.getY() != queenz[j] && x_diagonal != y_diagonal &&
//                        x_diagonal != r_y_diagonal) && queen[j] == 'T' && picture != button[j] || (queen[j] != 'T')) {
//                    it = it + 1;
////                } else if ((p.getX() != queens[j] && p.getY() != queenz[j] && x1_diagonal != y1_diagonal &&
////                        x1_diagonal != r1_y_diagonal) && queen[j] == 'T' && picture != button[j] || (queen[j] != 'T')) {
////                    z = z + 1;
//////                    if (q < 2) {
//////                        it = it + 1;
//////                    } else if (q > 1 && q < 3 && ((picture.getContentDescription().length() - 10 + y_count)/(q)) >= 3) {
//////                        it = it + 1;
//////                    } else if (q > 2 && q <= 7 && ((picture.getContentDescription().length() - 10 + y_count)/(q)) >= 4.5) {
//////                        it = it + 1;
//////                    } else {
//////                        it = 0;
//////                        break;
//////                    }
//
//                } else {
////                    if (j >= u_q && j < 8) {
////                        queen[j] = ' ';
////                        queens[j] = 0;
////                        queenz[j] = 0;
////                        queen_count = queen_count - 1;
////                        solution(view);
//////                    if (j >= queen_count && q <= 8) {
//////                        queens[j] = 0;
//////                        queenz[j] = 0;
//////                        queen[j] = ' ';
//////                        button[j].setBackgroundResource(R.color.BROWN);
//////                        error = j;
//////                    }
//////                        it = 0;
//////                        break;
////                    }
//                    it = 0;
//                    break;
//                }
//            }
//
//            if (it == 8) {
//                q = q + 1;
//                button[q - 1] = picture;
//                if (picture.getTag().toString().matches("brown")) {
//                    picture.setBackgroundResource(R.drawable.brownqueen);
//                    picture.setTag("yes brown");
//                    previous = picture;
//                    queens[q - 1] = picture.getX();
//                    queenz[q - 1] = picture.getY();
//                    queen[q - 1] = 'T';
//                    it = 0;
//                    queen_count = queen_count + 1;
//                    y_count = y_count + (picture.getContentDescription().length() - 10);
//                } else if (picture.getTag().toString().matches("white")) {
//                    picture.setBackgroundResource(R.drawable.whitequeen);
//                    picture.setTag("yes white");
//                    previous = picture;
//                    queens[q - 1] = picture.getX();
//                    queenz[q - 1] = picture.getY();
//                    queen[q - 1] = 'T';
//                    it = 0;
//                    queen_count = queen_count + 1;
//                    y_count = y_count + (picture.getContentDescription().length() - 10);
//
////            } else if (it != 8) {
////                queen[error] = ' ';
////                queens[error] = 0;
////                queenz[error] = 0;
////                if (button[error].getTag().toString().matches("brown")) {
////                    button[error].setBackgroundResource(R.drawable.brownqueen);
////                    button[error] = null;
////                    queen_count = queen_count - 1;
////                } else if (button[error].getTag().toString().matches("white")) {
////                    button[error].setBackgroundResource(R.drawable.whitequeen);
////                    button[error] = null;
////                    queen_count = queen_count - 1;
////                }
//////                this.solution(view);
//////            }
////
////
//                }
////            } else if (z == 8) {
////                q = q + 1;
////                button[q - 1] = picture;
////                if (picture.getTag().toString().matches("brown")) {
////                    picture.setBackgroundResource(R.drawable.brownqueen);
////                    picture.setTag("yes brown");
////                    previous = picture;
////                    queens[q - 1] = picture.getX();
////                    queenz[q - 1] = picture.getY();
////                    queen[q - 1] = 'T';
////                    it = 0;
////                    y_count = y_count + (picture.getContentDescription().length() - 10);
////                } else if (picture.getTag().toString().matches("white")) {
////                    picture.setBackgroundResource(R.drawable.whitequeen);
////                    picture.setTag("yes white");
////                    previous = picture;
////                    queens[q - 1] = picture.getX();
////                    queenz[q - 1] = picture.getY();
////                    queen[q - 1] = 'T';
////                    it = 0;
////                    y_count = y_count + (picture.getContentDescription().length() - 10);
////
////                }
//            }
////            if (i == h - 1 && q < 8) {
////                finished(view, q - 1);
////
////
////            }
////            minus = minus + 1;
//
//            if (queen_count == 8) {
//                Toast win = Toast.makeText(text, "YOU WIN!!!", Toast.LENGTH_LONG);
//                win.show();
//            } else {
//                Toast lose = Toast.makeText(text, "STILL QUEENS TO BE FOUND", Toast.LENGTH_LONG);
//                lose.show();
//
//
//            }
//        }
////        if (queen_count < 8) {
////            finished(view, queen_count - 1);
////        }
//    }
//            Toast t = Toast.makeText(text, "" + cases, Toast.LENGTH_LONG);
//            t.show();
//
//
// if (cases == queen_count + 1) {
//                        Toast t = Toast.makeText(text, "" + queen_count, Toast.LENGTH_LONG);
//                        t.show();
//                        if (queen_count == 0) {
//                            queens[queen_count] = picture.getX();
//                            queenz[queen_count] = picture.getY();
//                            queen[queen_count] = 'T';
////                            ids[queen_count] = picture.getId();
//                            cases = 0;
//                            if (picture.getTag().toString().matches("brown")) {
//                                picture.setBackgroundResource(R.drawable.brownqueen);
//                                picture.setTag("yes brown");
//                                queen_count = queen_count + 1;
//                            } else if (picture.getTag().toString().matches("white")) {
//                                picture.setBackgroundResource(R.drawable.whitequeen);
//                                picture.setTag("yes white");
//                                queen_count = queen_count + 1;
//                            }
//
//                        } else if (queen_count > 0) {
//                            queens[queen_count - 1] = picture.getX();
//                            queenz[queen_count - 1] = picture.getY();
//                            queen[queen_count - 1] = 'T';
////                            ids[queen_count - 1] = picture.getId();
//                            cases = 0;
//                            if (picture.getTag().toString().matches("brown")) {
//                                picture.setBackgroundResource(R.drawable.brownqueen);
//                                picture.setTag("yes brown");
//                                queen_count = queen_count + 1;
//                            } else if (picture.getTag().toString().matches("white")) {
//                                picture.setBackgroundResource(R.drawable.whitequeen);
//                                picture.setTag("yes white");
//                                queen_count = queen_count + 1;
//                            }
//                        }
//                } else {
//                    add_button = 0;
//                    if (add_button == 0 && queen_count < 8) {
//                        if (queen_count > 0) {
//                            queen[queen_count - 1] = ' ';
//                            queens[queen_count - 1] = 0;
//                            queenz[queen_count - 1] = 0;
//                            ImageButton button = findViewById(ids[queen_count - 1]);
//                            queen_count = queen_count - 1;
//                            if (button.getTag().toString().matches("yes brown")) {
//                                button.setBackgroundResource(R.color.BROWN);
//                                button.setTag("brown");
//                                break;
//                            } else if (button.getTag().toString().matches("yes white")) {
//                                button.setBackgroundResource(R.color.WHITE);
//                                button.setTag("white");
//                                break;
//                            }
//
////                    if (cases == queen_count) {
////                        queens[queen_count] = picture.getX();
////                        queenz[queen_count] = picture.getY();
////                        queen[queen_count] = 'T';
////                        cases = 0;
////                        queen_count = queen_count + 1;
////                        if (picture.getTag().toString().matches("brown")) {
////                            picture.setBackgroundResource(R.drawable.brownqueen);
////                            picture.setTag("yes brown");
////                        } else if (picture.getTag().toString().matches("white")) {
////                            picture.setBackgroundResource(R.drawable.whitequeen);
////                            picture.setTag("yes white");
////                        }
////                    }
////                } else {
////                    cases = cases;
////                    if (cases == q) {
////                        queen_count = queen_count + 1;
////                        queen[q-1] = 'T';
////                        queens[q-1] = picture.getX();
////                        queenz[q-1] = picture.getY();
////                        picture.setBackgroundResource(R.color.BLACK);
//                        }
//                    }
//                }


//    }








//                if (picture.getX() != queens[j] && picture.getY() != queenz[j] && x_diagonal != y_diagonal &&
//                x_diagonal != r_y_diagonal && pass < 7) {
//                    pass = j;
//                } else if (picture.getX() != queens[j] && picture.getY() != queenz[j] && x_diagonal != y_diagonal &&
//                        x_diagonal != r_y_diagonal && pass == 7) {
//                    if (picture.getTag() == "brown") {
//                        queens[remainder] = picture.getX();
//                        queenz[remainder] = picture.getY();
//                        queen[remainder] = 'T';
//                        pass = 0;
//                        picture.setBackgroundResource(R.drawable.brownqueen);
//                        queen_count = queen_count + 1;
//                        picture.setTag("yes brown");
//                    } else if (picture.getTag() == "white") {
//                        queens[remainder] = picture.getX();
//                        queenz[remainder] = picture.getY();
//                        queen[remainder] = 'T';
//                        pass = 0;
//                        picture.setBackgroundResource(R.drawable.whitequeen);
//                        queen_count = queen_count + 1;
//                        picture.setTag("yes white");
//                    }
//                }
//
////                } else if (picture.getX() == queens[j] || picture.getY() == queenz[j] || x_diagonal == y_diagonal ||
////                x_diagonal == r_y_diagonal) {
////                }
////                break;
//
//
//            }
//
//        }
//    }

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
//        for (int y = 0; y < 4; y++) {
//            q1[y] = ' ';
//            r1[y] = 0;
//            s1[y] = 0;
//            t1[y] = null;
//            q2[y] = ' ';
//            r2[y] = 0;
//            s2[y] = 0;
//            t2[y] = null;
//        }

        //Toast reset = Toast.makeText(c, "" + findViewById(R.id.a9).getId(), Toast.LENGTH_LONG);
        //reset.show();
//        int first_image = findViewById(R.id.a9).getId();
//        int last_image = findViewById(R.id.a1).getId();
//        Toast reset = Toast.makeText(c, "" + R.id.a9 + "",  Toast.LENGTH_LONG);
//        reset.show();
//        for (int i = R.id.a9; i < R.id.a1; i++) {
//
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



//            if (image.getTag().toString().matches("yes brown")) {
//                image.setBackgroundResource(R.color.BROWN);
//                image.setTag("brown");
//            } else if (image.getTag().toString().matches("yes white")) {
//                image.setBackgroundResource(R.color.WHITE);
//                image.setTag("white");
//            }

        }

        //Context context = getApplicationContext();
        //Toast reset = Toast.makeText(context, "Reset is in Progress", Toast.LENGTH_LONG);
        //reset.show();
        //for (int i = 0; i < (R.id.a9); i++) {
        //    int number = i;
        //    ImageButton reset_image = findViewById(R.id.a11 - i);
         //   if (reset_image.getTag().toString().matches("yes brown")) {
         //       reset_image.setBackgroundResource(R.color.BROWN);
         //       reset_image.setTag("brown");
         //   } else if (reset_image.getTag().toString().matches("yes white")) {
          //      reset_image.setBackgroundResource(R.color.WHITE);
          //      reset_image.setTag("white");
            }



