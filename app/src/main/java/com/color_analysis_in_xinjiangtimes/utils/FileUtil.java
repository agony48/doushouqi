package com.color_analysis_in_xinjiangtimes.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    public static final String PROJECT_NAME = "ThirdCity";
    public static final String TEMP = "temp";
    public static final String TEMP_FILE = "temp";
    public static final String DOWNLOAD = "download";
    public static final String ROOTPATH = Environment
            .getExternalStorageDirectory().getAbsolutePath()
            + File.separator
            + PROJECT_NAME;

    public static boolean isDirExist(String dirPath) {
        File dir = new File(dirPath);
        return dir.exists() && dir.isDirectory();
    }

    /**
     * 判断SD卡上的文件是否存在
     *
     * @param filePath
     * @return
     */
    public static boolean isFileExist(String filePath) {

        File file;
        try {
            file = new File(filePath);
            return file.exists();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void checkRoot() {
        if (!isDirExist(ROOTPATH)) {
            createDir(ROOTPATH);
        }
    }

    public static void createDir(String... dirPath) {
        File dir = null;
        for (int i = 0; i < dirPath.length; i++) {
            dir = new File(dirPath[i]);
            if (!dir.exists() && !dir.isDirectory()) {
                dir.mkdirs();
            }
        }
    }

    public static void initFolders() {
        createDir(ROOTPATH);
    }

    public static String getBaseFilePath() {
        return ROOTPATH;
    }

    public static String getImageFolder() {
        createDir(ROOTPATH + File.separator + "image");
        return ROOTPATH + File.separator + "image";
    }

    public static String getTmpFolder() {
        createDir(ROOTPATH + File.separator + TEMP);
        return ROOTPATH + File.separator + TEMP;
    }

    public static String getDownloadFolder() {
        createDir(ROOTPATH + File.separator + DOWNLOAD);
        return ROOTPATH + File.separator + DOWNLOAD;
    }

    public static String createTmpFile(String name) {
        return getTmpFolder() + File.separator + name;
    }

    public static String getFavImageFolder() {
        createDir(ROOTPATH + File.separator + "fav");
        return ROOTPATH + File.separator + "fav";
    }

    /**
     * 在SD卡上创建文件
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static File createSDFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists())
            file.createNewFile();

        return file;
    }

    /**
     * 在SD卡上创建目录
     *
     * @param dirName
     * @return
     */
    public static File createSDDir(String dirName) {
        File file = new File(dirName);
        if (!file.exists())
            file.mkdir();
        return file;
    }

    public static void createFileDir(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            parentFile = null;
        }
        file = null;
    }

    public static boolean deleteFile(String fileName) {
        try {
            if (fileName == null) {
                return false;
            }
            File f = new File(fileName);

            if (f == null || !f.exists() || f.isDirectory()) {
                return false;
            }

            return f.delete();
        } catch (Exception e) {
            // Log.d(FILE_TAG, e.getMessage());
            return false;
        }
    }

    public static boolean deleteFileOfDir(String dirName, boolean isRecurse) {
        boolean blret = false;
        try {
            File f = new File(dirName);
            if (f == null || !f.exists()) {
                // Log.d(FILE_TAG, "file" + dirName + "not isExist");
                return false;
            }

            if (f.isFile()) {
                blret = f.delete();
                return blret;
            } else {
                File[] flst = f.listFiles();
                if (flst == null || flst.length <= 0) {
                    return true;
                }

                int filenumber = flst.length;
                File[] fchilda = f.listFiles();
                for (int i = 0; i < filenumber; i++) {
                    File fchild = fchilda[i];
                    if (fchild.isFile()) {
                        blret = fchild.delete();
                        if (!blret) {
                            break;
                        }
                    } else if (isRecurse) {
                        blret = deleteFileDir(fchild.getAbsolutePath(), true);
                    }
                }
            }
        } catch (Exception e) {
            blret = false;
        }

        return blret;
    }

    public static boolean deleteFileDir(String dirName, boolean isRecurse) {
        boolean blret = false;
        try {
            File f = new File(dirName);
            if (f == null || !f.exists()) {
                // Log.d(FILE_TAG, "file" + dirName + "not isExist");
                return false;
            }
            if (f.isFile()) {
                blret = f.delete();
                return blret;
            } else {
                File[] flst = f.listFiles();
                if (flst == null || flst.length <= 0) {
                    f.delete();
                    return true;
                }
                int filenumber = flst.length;
                File[] fchilda = f.listFiles();
                for (int i = 0; i < filenumber; i++) {
                    File fchild = fchilda[i];
                    if (fchild.isFile()) {
                        blret = fchild.delete();
                        if (!blret) {
                            break;
                        }
                    } else if (isRecurse) {
                        blret = deleteFileDir(fchild.getAbsolutePath(), true);
                    }
                }

                // 删除当前文件夹
                blret = new File(dirName).delete();
            }
        } catch (Exception e) {
            // Log.d(FILE_TAG, e.getMessage());
            blret = false;
        }

        return blret;
    }

    public static void deleteTempFile() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                if (!Environment.getExternalStorageState().equals(
                        Environment.MEDIA_MOUNTED)) {
                    return;
                }
                File dir = new File(Environment.getExternalStorageDirectory(),
                        PROJECT_NAME);
                if (!dir.exists()) {
                    return;
                }
                try {
                    File f = new File(dir, TEMP_FILE);
                    if (f == null || !f.exists()) {
                        return;
                    }

                    File[] flst = f.listFiles();
                    int filenumber = flst.length;

                    if (flst == null || filenumber<= 0) {
                        f.delete();
                        return;
                    }
                    for (int i = 0; i < filenumber; i++) {
                        File fchild = flst[i];
                        if (fchild.isFile()) {
                            fchild.delete();
                        }
                    }

                    // 删除当前文件夹
                    f.delete();
                } catch (Exception e) {
                }
            }
        }).start();

    }

    // 删除临时文件夹
    public static void deleteTempDir() {
        File dir = new File(ROOTPATH + File.separator + TEMP);
        if (dir == null || !dir.exists() || !dir.isDirectory())
            return;

        for (File file : dir.listFiles()) {
            if (file.isFile())
                file.delete();
            else if (file.isDirectory())
                deleteTempDir();
        }
        // dir.address_delete_icon();
    }

    /**
     * 移动文件
     *
     * @param filePath
     */
    public static void removeToDir(String filePath, String toFilePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }
        file.renameTo(new File(toFilePath));
    }

    public static String getCache(String path) {
        String msg = null;
        try {
            FileInputStream in = new FileInputStream(path);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            in.close();
            msg = out.toString();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }

    public static void setCache(String msg, String path, String name) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            FileOutputStream out = new FileOutputStream(dir + File.separator
                    + name);
            out.write(msg.getBytes(), 0, msg.getBytes().length);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getFileName(String path) {
        return path.substring(path.lastIndexOf("/") + 1);
    }

    public static String saveBitmap(String filePath) {

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 3;
        Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);

        String path = String.valueOf(System.currentTimeMillis());
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return null;
        }
        File dir = new File(Environment.getExternalStorageDirectory(),
                PROJECT_NAME);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File tempFile = new File(dir, TEMP_FILE);
        if (!tempFile.exists()) {
            tempFile.mkdir();
        }
        File file = new File(tempFile, path + ".jpg");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream fOut = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 60, fOut);

            fOut.flush();
            fOut.close();
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
                System.gc();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.exists() ? file.getAbsolutePath().toString() : null;
    }

    public static String compressFileImage(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }
        return saveBitmap(filePath);
    }

    public static String saveBitmapToFile(File file, String newpath) {
        try {

            // BitmapFactory options to downsize the image
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            o.inSampleSize = 6;
            // factor of downsizing the image

            FileInputStream inputStream = new FileInputStream(file);
            //Bitmap selectedBitmap = null;
            BitmapFactory.decodeStream(inputStream, null, o);
            inputStream.close();

            // The new size we want to scale to
            final int REQUIRED_SIZE = 75;

            // Find the correct scale value. It should be the power of 2.
            int scale = 1;
            while (o.outWidth / scale / 2 >= REQUIRED_SIZE &&
                    o.outHeight / scale / 2 >= REQUIRED_SIZE) {
                scale *= 2;
            }

            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            inputStream = new FileInputStream(file);

            Bitmap selectedBitmap = BitmapFactory.decodeStream(inputStream, null, o2);
            inputStream.close();

            // here i override the original image file
//            file.createNewFile();
//
//
//            FileOutputStream outputStream = new FileOutputStream(file);
//
//            selectedBitmap.compress(Bitmap.CompressFormat.JPEG, 100 , outputStream);


            File aa = new File(newpath);

            FileOutputStream outputStream = new FileOutputStream(aa);

            //choose another format if PNG doesn't suit you

            selectedBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);


            String filepath = aa.getAbsolutePath();

            return filepath;
        } catch (Exception e) {
            return null;
        }
    }
}
