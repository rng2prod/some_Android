package com.rngproduction.capslock;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.Gravity;
import android.widget.Toast;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

public class Utils {

    public static void showToast(Context context, String text) {
        Spannable centeredText = new SpannableString((CharSequence) text);
        centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                0, ((CharSequence) text).length() - 1,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        Toast toast = Toast.makeText(context, centeredText, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 270);
        toast.show();
    }

// Проверка доступности модулей //
    static int hostBookingOur=1;
    public static void checkHostBookingOur() {
        Thread checkHostThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (isHostAvailable("https://**********/app_check_booking_online.html"))
                {hostBookingOur=1;} else hostBookingOur=0;
            }
        });
        checkHostThread.setPriority(2);
        checkHostThread.start();
    }
    static int hostBookingAlien=1;
    public static void checkHostBookingAlien() {
        Thread checkHostThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (isHostAvailable("https://**********"))
                {hostBookingAlien=1;} else hostBookingAlien=0;
            }
        });
        checkHostThread.setPriority(2);
        checkHostThread.start();
    }

    static int hostExcursionOur=1;
    public static void checkHostExcursionOur() {
        Thread checkHostThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (isHostAvailable("https://**********/app_check_excursion_online.html"))
                {hostExcursionOur=1;} else hostExcursionOur=0;
            }
        });
        checkHostThread.setPriority(2);
        checkHostThread.start();
    }
    static int hostExcursionAlien=1;
    public static void checkHostExcursionAlien() {
        Thread checkHostThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (isHostAvailable("https://**********"))
                {hostExcursionAlien=1;} else hostExcursionAlien=0;
            }
        });
        checkHostThread.setPriority(2);
        checkHostThread.start();
    }

    static int hostVisaSupportOur=1;
    public static void checkHostVisaSupportOur() {
        Thread checkHostThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (isHostAvailable("https://**********/app_check_support_online.html"))
                {hostVisaSupportOur=1;} else hostVisaSupportOur=0;
            }
        });
        checkHostThread.setPriority(2);
        checkHostThread.start();
    }
    static int hostVisaSupportAlien=1;
    public static void checkHostVisaSupportAlien() {
        Thread checkHostThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (isHostAvailable("https://**********"))
                {hostVisaSupportAlien=1;} else hostVisaSupportAlien=0;
            }
        });
        checkHostThread.setPriority(2);
        checkHostThread.start();
    }
// Проверка доступности хоста //
    static int hostA=1;
    public static void checkHost() {
        Thread checkHostThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (isHostAvailable("https://**********/app_check_server_online.html"))
                {hostA=1;} else hostA=0;
            }
        });
        checkHostThread.setPriority(2);
        checkHostThread.start();
    }

    public static boolean isHostAvailable(String chechUrl) {
        try {
            URL myUrl = new URL(chechUrl);
            HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
            connection.connect();
            int statusCode = connection.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
// Конец проверки доступности //


// Проверка интернет подключения //
    public static boolean hasInetConnection(final Context context) {
        ConnectivityManager connman = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = connman.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        wifiInfo = connman.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        wifiInfo = connman.getActiveNetworkInfo();
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        return false;
    }
// Конец проверки интернет подключения //

// Очистка кэша //
    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) { e.printStackTrace();}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }

    /*public static void rotateR(int isRotate) {
        final int[] i = {0};

        final Thread threadR = new Thread() {
            @Override
            public void run() {
                while (true) {
                    //CapsFirstFragment.tvImgR.setImageResource(CapsFirstFragment.drawableR[i[0]]);
                    i[0]++;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i[0] == 3) i[0] = 0;
                    System.out.println(i[0]);
                }
            }
        };

        if (isRotate == 1) {threadR.setPriority(5);threadR.start();}
        if (threadR != null && isRotate == 0) {
            try {
                threadR.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    } */

}


