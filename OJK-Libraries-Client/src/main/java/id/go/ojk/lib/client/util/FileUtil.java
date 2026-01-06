package id.go.ojk.lib.client.util;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.zip.ZipFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	public static String getCurrentPath() {
		return new File("").getAbsolutePath();
	}

	public static boolean deleteDirContent(File dir){
		if ( !dir.isDirectory() )
			return false;

		boolean result = true;
		File[] files = dir.listFiles();
		for (File file : files) {
			if(!file.delete()){
				result = false;
			}
		}
		
		return result;
	}

	public static boolean forceDeleteDirContent(File dir){
		if ( !dir.isDirectory() )
			return false;

		boolean result = true;
		File[] files = dir.listFiles();
		for (File file : files) {
			try {
				FileUtils.forceDelete(file);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
				result = false;
				break;
			}
		}
		
		return result;
	}

	public static boolean forceDeleteDirContent(String dir){
		return forceDeleteDirContent(new File(dir));
	}
	
	public static boolean deleteDir(File dir, boolean deleteFile){
		if ( !dir.isDirectory() )
			return false;

		if (deleteFile){
			File[] files = dir.listFiles();
			for (File file : files) {
				file.delete();
			}
		}

		return dir.delete();
	}
	
	public static String formatFileSize(long size) {
	    if(size <= 0) return "0";
	    final String[] units = new String[] { "B", "kB", "MB", "GB", "TB" };
	    int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
	    return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
	}
	
	public static String getNormalizedFullPath(String path) {
		String res = path;
		File file = new File(res);
		String fullPath = file.getAbsolutePath();
		if (file.isDirectory()) {
			res = FilenameUtils.normalizeNoEndSeparator(fullPath);
		} else {
			res = FilenameUtils.getFullPathNoEndSeparator(fullPath);
		}
		return res;
	}
	
	public String genFileName(String folder, String filename) {
		StringBuilder res = new StringBuilder(folder);
		if (!filename.startsWith(File.separator)) {
			res.append(File.separator);
		}
		res.append(filename);
		File file = new File(folder);
		if (!file.exists()) {
			file.mkdirs();
		}
		return res.toString();
	}
	
	public static String concat(String... folders) {
		StringBuilder res = new StringBuilder();
		if (folders != null) {
			int length = folders.length;
			for (int i = 0; i < folders.length; i++) {
				res.append(folders[i]);
				if (i + 1 < length) {
					res.append(File.separator);
				}
			}
		}
		return res.toString();
	}
	
	public static boolean copyFile(String source, String destination) {
		boolean res = false;
		try {
			FileUtils.copyFile(new File(source), new File(destination));
			res = true;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return res;
	}
	
	public static boolean copyFileToFolder(String source, String destination) {
		boolean res = false;
		try {
			FileUtils.copyFileToDirectory(new File(source), new File(destination));
			res = true;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return res;
	}

	public static boolean isZipFile(File file) {
		try (ZipFile zipFile = new ZipFile(file)) {
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}
}
