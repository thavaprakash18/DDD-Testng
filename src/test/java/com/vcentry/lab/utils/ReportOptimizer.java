package com.vcentry.lab.utils;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class ReportOptimizer {
	public static void optimizeReport() throws IOException {
		Date date=new Date();
		//dd-M-yyyy hh:mm:ss
		SimpleDateFormat sf=new SimpleDateFormat("dd-M-yyyy_hh-mm-ss");
		String folderName=sf.format(date);
		
		File src=new File("C:/Batch251/K1_DDDTest/screenshot");
		File dst=new File("C:/Batch251/K1_DDDTest/oldscreenshot/"+folderName);
	
		FileUtils.copyDirectory(src, dst);
		FileUtils.cleanDirectory(src);

    	
}
}