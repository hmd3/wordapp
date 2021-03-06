//package cn.edu.bistu.cs.se.mywordsapp;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//
//import android.os.Bundle;
//
//import android.content.ContentResolver;
//import android.content.ContentValues;
//import android.database.Cursor;
//import android.net.Uri;
//import android.util.Log;
//import android.view.View;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.Button;
//import android.widget.Toast;
//
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.snackbar.Snackbar;
//
//import cn.edu.bistu.cs.se.mywordsapp.R;
//import cn.edu.bistu.cs.se.mywordsapp.wordcontract.Words;
//
//public class MainActivity2 extends AppCompatActivity {
//
//    private static final String TAG="MyWordsTag";
//    private ContentResolver resolver;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        resolver = this.getContentResolver();
//
//        Button buttonAll=(Button)findViewById(R.id.buttonAll);
//        Button buttonInsert=(Button)findViewById(R.id.buttonInsert);
//        Button buttonDelete=(Button)findViewById(R.id.buttonDelete);
//        Button buttonDeleteAll=(Button)findViewById(R.id.buttonDeleteAll);
//        Button buttonUpdate=(Button)findViewById(R.id.buttonUpdate);
//        Button buttonQuery=(Button)findViewById(R.id.buttonQuery);
//
//        //????????????
//        buttonAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Cursor cursor = resolver.query(Words.Word.CONTENT_URI,
//                        new String[] { Words.Word._ID, Words.Word.COLUMN_NAME_WORD,Words.Word.COLUMN_NAME_MEANING,Words.Word.COLUMN_NAME_SAMPLE},
//                        null, null, null);
//                if (cursor == null){
//                    Toast.makeText(MainActivity2.this,"??????????????????",Toast.LENGTH_LONG).show();
//                    return;
//                }
//
//                //??????????????????????????????????????????Log??????
//
//                String msg = "";
//                if (cursor.moveToFirst()){
//                    do{
//                        msg += "ID:" + cursor.getInt(cursor.getColumnIndex(Words.Word._ID)) + ",";
//                        msg += "?????????" + cursor.getString(cursor.getColumnIndex(Words.Word.COLUMN_NAME_WORD))+ ",";
//                        msg += "?????????" + cursor.getInt(cursor.getColumnIndex(Words.Word.COLUMN_NAME_MEANING)) + ",";
//                        msg += "??????" + cursor.getFloat(cursor.getColumnIndex(Words.Word.COLUMN_NAME_SAMPLE)) + "\n";
//                    }while(cursor.moveToNext());
//                }
//
//                Log.v(TAG,msg);
//
//
//            }
//        });
//
//        //??????
//        buttonInsert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String strWord="Banana";
//                String strMeaning="banana";
//                String strSample="This banana is very nice.";
//                ContentValues values = new ContentValues();
//
//                values.put(Words.Word.COLUMN_NAME_WORD, strWord);
//                values.put(Words.Word.COLUMN_NAME_MEANING, strMeaning);
//                values.put(Words.Word.COLUMN_NAME_SAMPLE, strSample);
//
//                Uri newUri = resolver.insert(Words.Word.CONTENT_URI, values);
//            }
//        });
//
//        //??????
//        buttonDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String id="3";//???????????????????????????ID??????????????????????????????id????????????
//                Uri uri = Uri.parse(Words.Word.CONTENT_URI_STRING + "/" + id);
//                int result = resolver.delete(uri, null, null);
//            }
//        });
//
//        //????????????
//        buttonDeleteAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                resolver.delete(Words.Word.CONTENT_URI, null, null);
//            }
//        });
//
//        //??????
//        buttonUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String id="3";
//                String strWord="Banana";
//                String strMeaning="banana";
//                String strSample="This banana is very nice.";
//                ContentValues values = new ContentValues();
//
//                values.put(Words.Word.COLUMN_NAME_WORD, strWord);
//                values.put(Words.Word.COLUMN_NAME_MEANING, strMeaning);
//                values.put(Words.Word.COLUMN_NAME_SAMPLE, strSample);
//
//                Uri uri = Uri.parse(Words.Word.CONTENT_URI_STRING + "/" + id);
//                int result = resolver.update(uri, values, null, null);
//
//            }
//        });
//
//        //??????id??????
//        buttonQuery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String id="3";
//                Uri uri = Uri.parse(Words.Word.CONTENT_URI_STRING + "/" + id);
//                Cursor cursor = resolver.query(Words.Word.CONTENT_URI,
//                        new String[] { Words.Word._ID, Words.Word.COLUMN_NAME_WORD, Words.Word.COLUMN_NAME_MEANING,Words.Word.COLUMN_NAME_SAMPLE},
//                        null, null, null);
//                if (cursor == null){
//                    Toast.makeText(MainActivity2.this,"??????????????????",Toast.LENGTH_LONG).show();
//                    return;
//                }
//
//                //??????????????????????????????????????????Log??????
//
//                String msg = "";
//                if (cursor.moveToFirst()){
//                    do{
//                        msg += "ID:" + cursor.getInt(cursor.getColumnIndex(Words.Word._ID)) + ",";
//                        msg += "?????????" + cursor.getString(cursor.getColumnIndex(Words.Word.COLUMN_NAME_WORD))+ ",";
//                        msg += "?????????" + cursor.getInt(cursor.getColumnIndex(Words.Word.COLUMN_NAME_MEANING)) + ",";
//                        msg += "??????" + cursor.getFloat(cursor.getColumnIndex(Words.Word.COLUMN_NAME_SAMPLE)) + "\n";
//                    }while(cursor.moveToNext());
//                }
//
//                Log.v(TAG,msg);
//            }
//        });
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//
////        if (id == R.id.action_settings) {
////            return true;
////        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
//
