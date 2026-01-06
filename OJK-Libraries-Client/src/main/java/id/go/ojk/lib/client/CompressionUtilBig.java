package id.go.ojk.lib.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.apache.commons.compress.compressors.deflate.DeflateCompressorInputStream;
import org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream;
import org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;
import org.apache.commons.io.IOUtils;

public class CompressionUtilBig {

	//private static Logger logger = LoggerFactory.getLogger(CompressionUtilBig.class);

    public static final String BZIP2 	= "bzip2";
    public static final String GZIP 	= "gz";
    public static final String Deflate 	= "deflate";
    public static final String Pack200 	= "pack200";
    public static final String XZ 		= "xz";

	public static void compress(String algoritm, InputStream input , OutputStream output, MeteredIOCopyersPararel ioCopyers) throws CompressorException, IOException{
		try (
				CompressorOutputStream compressorOutput = createCompressorOutputStream(algoritm, output);
			){
			if ( ioCopyers != null ) {
				ioCopyers.copy(input, compressorOutput);
			} else {
				IOUtils.copy(input, compressorOutput);
			}
		}
	}

	public static void deCompress(String algoritm, InputStream input , OutputStream output, MeteredIOCopyers ioCopyers) throws CompressorException, IOException{
		CompressorStreamFactory compressorStreamFactory = new CompressorStreamFactory();
		try (
				CompressorInputStream compressorInput = compressorStreamFactory.createCompressorInputStream(algoritm, input);
			){
			if ( ioCopyers != null ) {
				ioCopyers.copy(compressorInput, output);
			} else {
				IOUtils.copy(compressorInput, output);
			}
		}
	}

    public static CompressorInputStream createCompressorInputStream(final String name,
            final InputStream in) throws CompressorException {
        if (name == null || in == null) {
            throw new IllegalArgumentException(
                    "Compressor name and stream must not be null.");
        }

        try {

            if (GZIP.equalsIgnoreCase(name)) {
                return new GzipCompressorInputStream(in);
            }

            if (BZIP2.equalsIgnoreCase(name)) {
                return new BZip2CompressorInputStream(in);
            }

            if (Deflate.equalsIgnoreCase(name)) {
                return new DeflateCompressorInputStream(in);
            }

            if (Pack200.equalsIgnoreCase(name)) {
                return new Pack200CompressorInputStream(in);
            }

            if (XZ.equalsIgnoreCase(name)) {
                return new BZip2CompressorInputStream(in);
            }


        } catch (IOException e) {
            throw new CompressorException(
                    "Could not create CompressorInputStream.", e);
        }
        throw new CompressorException("Compressor: " + name + " not found.");
    }

    public static CompressorOutputStream createCompressorOutputStream(
            final String name, final OutputStream out)
            throws CompressorException {
        if (name == null || out == null) {
            throw new IllegalArgumentException(
                    "Compressor name and stream must not be null.");
        }

        try {

            if (GZIP.equalsIgnoreCase(name)) {
                return new GzipCompressorOutputStream(out);
            }

            if (BZIP2.equalsIgnoreCase(name)) {
                return new BZip2CompressorOutputStream(out);
            }

            if (Deflate.equalsIgnoreCase(name)) {
                return new DeflateCompressorOutputStream(out);
            }

            if (Pack200.equalsIgnoreCase(name)) {
                return new Pack200CompressorOutputStream(out);
            }

            if (XZ.equalsIgnoreCase(name)) {
                return new XZCompressorOutputStream(out);
            }


        } catch (IOException e) {
            throw new CompressorException(
                    "Could not create CompressorOutputStream", e);
        }
        throw new CompressorException("Compressor: " + name + " not found.");
    }

}
