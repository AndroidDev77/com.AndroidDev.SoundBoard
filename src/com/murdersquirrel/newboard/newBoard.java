package com.murdersquirrel.newboard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.google.ads.AdRequest;
import com.google.ads.AdView;
import com.murdersquirrel.newboard.R;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class newBoard extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        
        Toast.makeText(this, "Long touch to save as Ringtones.", Toast.LENGTH_LONG).show();
        
        // ads - load request to display
       // AdView layout = (AdView)this.findViewById(R.id.accesskey);
        
        // ads - load display with an ad
        //AdRequest adRequest = new AdRequest();
        //adRequest.setTesting(true);
        
       //layout.loadAd(adRequest);
        
        // import sound files
        final MediaPlayer sound01 = MediaPlayer.create(this, R.raw.molly);
        final MediaPlayer sound02 = MediaPlayer.create(this, R.raw.justwatch);
        final MediaPlayer sound03 = MediaPlayer.create(this, R.raw.freshmen);
        final MediaPlayer sound04 = MediaPlayer.create(this, R.raw.snitches);
        final MediaPlayer sound05 = MediaPlayer.create(this, R.raw.spellmen);
        
        
     
		// play sound files on clicks
        Button s01 = (Button) findViewById(R.id.button01); 
        s01.setText(this.getString(R.string.molly1));
        s01.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					sound01.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sound01.start();				
				}
			
		});
		registerForContextMenu(s01);
		
        Button s02 = (Button) findViewById(R.id.button02); 
        s02.setText(this.getString(R.string.justwatch1));
        s02.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					sound02.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sound02.start();
			}
		});
		registerForContextMenu(s02);
    
        Button s03 = (Button) findViewById(R.id.button03); 
        s03.setText(this.getString(R.string.freshmen1));
        s03.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					sound03.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sound03.start();
			}
		});
		registerForContextMenu(s03);
		
		Button s04 = (Button) findViewById(R.id.button04); 
        s04.setText(this.getString(R.string.snitches1));
        s04.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					sound04.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sound04.start();
			}
		});
		registerForContextMenu(s04);
		
		Button s05 = (Button) findViewById(R.id.button05); 
        s05.setText(this.getString(R.string.spelmen1));
        s05.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					sound05.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sound05.start();
			}
		});
		registerForContextMenu(s05);

        
        
		//WebView webview;
		//webview = (WebView) findViewById(R.id.accesskey);
		//webview.getSettings().setJavaScriptEnabled(true);
		//String webaccesskey = getString(R.string.accesskey);
		//webview.loadUrl(webaccesskey);
		
    }
    
    // perform save functions on long press
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {  
        super.onCreateContextMenu(menu, v, menuInfo);  
            menu.setHeaderTitle("Save as...");  
            menu.add(0, v.getId(), 0, "Ringtone/Notification");    
        }  
    
    @Override  
    public boolean onContextItemSelected(MenuItem item) {  
        if(item.getTitle()=="Ringtone/Notification"){function1(item.getItemId());}  
        else {return false;}  
    return true;  
    }  
      
    // detect which button was clicked, save as a ringtone with strings.xml
    public boolean function1(int ressound){  
        
    	//----
        	  String soundname = "";
        	  
        	   switch(ressound){
        	case R.id.button01:
        	ressound = R.raw.molly;
        	soundname = (this.getString(R.string.app_name)) + " - " + (this.getString(R.string.molly1));
        	break;
        	}
        	  
        	   switch(ressound){
        	case R.id.button02:
        	ressound = R.raw.justwatch;
        	soundname = (this.getString(R.string.app_name)) + " - " + (this.getString(R.string.justwatch1));
        	break;
        	}
        	   switch(ressound){
           	case R.id.button03:
           	ressound = R.raw.freshmen;
           	soundname = (this.getString(R.string.app_name)) + " - " + (this.getString(R.string.freshmen1));
           	break;
           	}
        	   
    	   switch(ressound){
          	case R.id.button04:
          	ressound = R.raw.snitches;
          	soundname = (this.getString(R.string.app_name)) + " - " + (this.getString(R.string.snitches1));
          	break;
          	}
    	   switch(ressound){
          	case R.id.button05:
          	ressound = R.raw.spellmen;
          	soundname = (this.getString(R.string.app_name)) + " - " + (this.getString(R.string.spelmen1));
          	break;
          	}
    	   
        	   
        	  //and so on and so on.....
        	  byte[] buffer=null;
        	   InputStream fIn = getBaseContext().getResources().openRawResource(ressound);
        	   int size=0;

        	   try {
        	   size = fIn.available();
        	   buffer = new byte[size];
        	   fIn.read(buffer);
        	   fIn.close();
        	   } catch (IOException e) {
        	   // TODO Auto-generated catch block
        	   return false;
        	   }

        	   String path="/sdcard/media/audio/ringtones/";
        	   String filename=soundname+".ogg";

        	   boolean exists = (new File(path)).exists();
        	   if (!exists){new File(path).mkdirs();}

        	   FileOutputStream save;
        	   try {
        	   save = new FileOutputStream(path+filename);
        	   save.write(buffer);
        	   save.flush();
        	   save.close();
        	   } catch (FileNotFoundException e) {
        	   // TODO Auto-generated catch block
        	   return false;
        	   } catch (IOException e) {
        	   // TODO Auto-generated catch block
        	   return false;
        	   }

        	   sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://"+path+filename)));

        	   File k = new File(path, filename);

        	   ContentValues values = new ContentValues();
        	   values.put(MediaStore.MediaColumns.DATA, k.getAbsolutePath());
        	   values.put(MediaStore.MediaColumns.TITLE, soundname);
        	   values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/ogg");
        	   values.put(MediaStore.Audio.Media.ARTIST, "FRIDAY");
        	   values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
        	   values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
        	   values.put(MediaStore.Audio.Media.IS_ALARM, true);
        	   values.put(MediaStore.Audio.Media.IS_MUSIC, false);

        	   //Insert it into the database
        	  this.getContentResolver().insert(MediaStore.Audio.Media.getContentUriForPath(k.getAbsolutePath()), values);


        	  String i = "Saved as Ringtone.";
        	   Toast.makeText(getApplicationContext(), i,
        	   Toast.LENGTH_LONG).show();
        	  
        	 return true;
        	  
        	  
        	  }
    	
    	//----
    

}
    





