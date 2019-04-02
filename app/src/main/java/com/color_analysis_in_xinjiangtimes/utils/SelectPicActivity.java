package com.color_analysis_in_xinjiangtimes.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;

/**
 * @author spring sky<br>
 *         Email :vipa1888@163.com<br>
 *         QQ: 840950105<br>
 * @version 创建时间：2012-11-22 上午9:20:03 说明：主要用于选择文件操作
 */

@SuppressLint({ "NewApi", "NewApi" })
public class SelectPicActivity extends Activity{

	public static final String KEY_PHOTO_PATH = "photo_path";

	private Intent lastIntent;

	private static final int PHOTO_REQUEST_TAKEPHOTO = 1;// 拍照
	private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
	private static final int PHOTO_REQUEST_CUT = 3;// 结果
	// 创建一个以当前时间为名称的文件
	File tempFile = new File(Environment.getExternalStorageDirectory(),
			getPhotoFileName());

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		lastIntent = getIntent();
		showDialog();
	}
	private boolean DialogBs=true;
	// 提示对话框方法
	private void showDialog() {
		final AlertDialog sDialog = new AlertDialog.Builder(this)
				.setTitle("请选择")
				.setPositiveButton("拍照", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub//第二个参数是需要申请的权限
//						if (ContextCompat.checkSelfPermission(SelectPicActivity.this,
//								Manifest.permission.WRITE_EXTERNAL_STORAGE)
//								!= PackageManager.PERMISSION_GRANTED){
//							ActivityCompat.requestPermissions(SelectPicActivity.this,
//									new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//									7);
//							//权限还没有授予，需要在这里写申请权限的代码
//						}else {
							DialogBs = false;
							dialog.dismiss();
							// 调用系统的拍照功能
							Intent intent = new Intent(
									MediaStore.ACTION_IMAGE_CAPTURE);
							// 指定调用相机拍照后照片的储存路径
							intent.putExtra(MediaStore.EXTRA_OUTPUT,
									Uri.fromFile(tempFile));
							startActivityForResult(intent, PHOTO_REQUEST_TAKEPHOTO);
//						}

					}
				}).setNegativeButton("相册", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						DialogBs = false;
						dialog.dismiss();
						Intent intent = new Intent(Intent.ACTION_PICK, null);
						intent.setDataAndType(
								MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
								"image/*");
						startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
					}
				}).show();
//		sDialog.setCancelable(false);
		sDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
					@Override
					public void onDismiss(DialogInterface dialog) {
						if(DialogBs){
							if(!sDialog.isShowing()){
								finish();
							}
						}
					}
				});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode != Activity.RESULT_OK) {// result is not correct
			finish();
			return;
		}
		switch (requestCode) {
		case PHOTO_REQUEST_TAKEPHOTO:
			startPhotoZoom(Uri.fromFile(tempFile), 150);
			break;
		case PHOTO_REQUEST_GALLERY:
			if (data != null)
				startPhotoZoom(data.getData(), 150);
			else
				finish();
			break;
		case PHOTO_REQUEST_CUT:
			if (data != null) {
				Bundle bundle = data.getExtras();
				if (bundle != null) {
					Bitmap photo = bundle.getParcelable("data");
					String picPath = saveCroppedImage(photo);
					if (picPath != null) {
						Intent intent = new Intent();
						intent.putExtra(KEY_PHOTO_PATH, picPath);
						setResult(RESULT_OK, intent);
						finish();
					}else{
						finish();
					}
				}else{
					finish();
				}
			}else{
				finish();
			}
			break;
		}

	}
	private Uri imageUri;
	private void startPhotoZoom(Uri uri, int size) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		// crop为true是设置在开启的intent中设置显示的view可以剪裁
		intent.putExtra("crop", "true");

		// aspectX aspectY 是宽高的比例
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);

		// outputX,outputY 是剪裁图片的宽高
		intent.putExtra("outputX", size);
		intent.putExtra("outputY", size);
		intent.putExtra("return-data", true);
		// 上面设为false的时候将MediaStore.EXTRA_OUTPUT即"output"关联一个Uri
		intent.putExtra("output", imageUri);

		startActivityForResult(intent, PHOTO_REQUEST_CUT);
	}

	// 使用系统当前日期加以调整作为照片的名称
	private String getPhotoFileName() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"'IMG'_yyyyMMdd_HHmmss");
		return dateFormat.format(date) + ".jpg";
	}
	private String saveCroppedImage(Bitmap bmp) {
		File file = new File("/sdcard/myFolder");
		if (!file.exists())
			file.mkdir();
		file = new File("/sdcard/temp.jpg".trim());
		String fileName = file.getName();
		String mName = fileName.substring(0, fileName.lastIndexOf("."));
		String sName = fileName.substring(fileName.lastIndexOf("."));

		// /sdcard/myFolder/temp_cropped.jpg
		String newFilePath = "/sdcard/myFolder" + "/" + mName + "_cropped"
				+ sName;
		file = new File(newFilePath);
		try {
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			bmp.compress(CompressFormat.JPEG, 50, fos);
			fos.flush();
			fos.close();
			return newFilePath;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newFilePath;

	}

}
