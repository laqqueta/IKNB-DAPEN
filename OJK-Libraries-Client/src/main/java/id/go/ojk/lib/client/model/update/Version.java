package id.go.ojk.lib.client.model.update;

import id.go.ojk.lib.client.CollectionUtil;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
public class Version implements Comparable<Version> {

	private int major;
	private int minor;
	private int revision;

	@Tolerate
	public Version(){
	}

	public static Version valueOf(String value){
		int[] values = CollectionUtil.toIntArray(value, "[.]");
		return Version.builder().major(values[0]).minor(values[1]).revision(values[2]).build();
	}

	public static int compare(String version1, String version2) {
		return valueOf(version1).compareTo(valueOf(version2));
	}

	@Override
	public String toString() {
		return major + "." + minor + "." + revision;
	}

	@Override
	public int compareTo(Version o) {
		if ( major > o.major ){
			return 1;
		} else if ( major < o.major ){
			return -1;
		} else {
			if ( minor > o.minor ){
				return 1;
			} else if ( minor < o.minor ){
				return -1;
			} else {
				if ( revision > o.revision ){
					return 1;
				} else if ( revision < o.revision ){
					return -1;
				} else {
					return 0;
				}
			}
		}
	}

}
