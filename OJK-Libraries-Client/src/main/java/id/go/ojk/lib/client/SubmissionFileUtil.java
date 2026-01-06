package id.go.ojk.lib.client;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.compression.FileIntegrity;

public class SubmissionFileUtil {
	
	private static Logger logger = LoggerFactory.getLogger(SubmissionFileUtil.class);

	public static List<FileIntegrity> getZipChunkFileIntegrityOrdered(String submissionId, File dir){
		List<File> files = getZipChunkFileOrdered(submissionId, dir);
		List<FileIntegrity> fileIntegrities =  files.stream().map( e -> new FileIntegrity(e, null)).collect(Collectors.toList());
		return fileIntegrities;
	}
	
	public static List<File> getZipChunkFileOrdered(String submissionId, File dir){
		String prefix = submissionId + ".zip.part";
		File[] files = dir.listFiles(file -> file.getName().startsWith(prefix));
		logger.info("submissionId = " + submissionId + "; dir " + dir.getAbsolutePath() + "; files " + files);
		if ( files != null){
			for (File file2 : files) {
				logger.info("file : " + file2.getName());				
			}
		}
		Arrays.sort(files, new Comparator<File>(){

			@Override
			public int compare(File o1, File o2) {
				String fileName1 = o1.getName();
				String fileName2 = o2.getName();
				
				Tupple2<Integer, Integer> zipPart1 = getGetZipPartNumber(fileName1);
				int zip1 = zipPart1.getA();
				int part1= zipPart1.getB();

				Tupple2<Integer, Integer> zipPart2 = getGetZipPartNumber(fileName2);
				int zip2 = zipPart2.getA();
				int part2= zipPart2.getB();

//				int zip1 = Integer.parseInt(fileName1.substring( fileName1.indexOf(".zip.part") + 9 ,  fileName1.lastIndexOf(".")) );
//				int part1= Integer.parseInt(fileName1.substring(fileName1.lastIndexOf(".") + 1) );
//
//				int zip2 = Integer.parseInt(fileName2.substring( fileName2.indexOf(".zip.part") + 9 ,  fileName2.lastIndexOf(".")) );
//				int part2= Integer.parseInt(fileName2.substring(fileName2.lastIndexOf(".") + 1) );
				
				if ( zip1 > zip2 )
					return 1;
				else if ( zip1 < zip2 )
					return -1;
				else {
					if ( part1 > part2 )
						return 1;
					else if ( part1 < part2 )
						return -1;
					else 
						return 0;
				}
			}
		});
		return Arrays.asList(files);
	}	
	
	public static Tupple2<Integer, Integer> getGetZipPartNumber(String fileName){
		int indexZipPart = fileName.indexOf(".zip.part") + 9;
		int lastIndexOffDot = fileName.lastIndexOf(".");
		int fileNameLength = fileName.length();
		boolean isChunk = lastIndexOffDot > indexZipPart;
		
		int zip = Integer.parseInt(fileName.substring( indexZipPart , isChunk ? lastIndexOffDot : fileNameLength) );
		int part= isChunk ? Integer.parseInt(fileName.substring(lastIndexOffDot + 1) ) : 0;
		
		return Tupple2.<Integer, Integer>builder().a(zip).b(part).build();
	}
	

}
