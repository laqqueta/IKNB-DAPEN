package id.go.ojk.lkk.client.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.pnmk.client.builder.field.lb.metadata.MetadataLb;
import id.go.ojk.pnmk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnmk.client.builder.field.lb.uus.metadata.MetadataLbUus;
import id.go.ojk.pnmk.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.pnmk.client.builder.field.reference.EHeaderMetadataShared;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PnmkConfiguration {
	
	public static Map<String, List<KeyValueString>> getReferences() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		res.putAll(EHeaderMetadataLb.getMap());
		res.putAll(EHeaderMetadataLbUus.getMap());
		res.putAll(EHeaderMetadataShared.getMap());
		return res;
	}
	
	public static List<ReferenceMetadata> getReferenceMetadata() {
		List<ReferenceMetadata> res = new ArrayList<>();
		res.addAll(EHeaderMetadataLb.getObjects());
		res.addAll(EHeaderMetadataLbUus.getObjects());
		res.addAll(EHeaderMetadataShared.getObjects());
		return res;
	}

	public static List<SubmissionFormat> getMetadata() {
		List<SubmissionFormat> res = new ArrayList<>();
		res.addAll(MetadataLb.getMetadata());
		res.addAll(MetadataLbUus.getMetadata());
		return res;
	}

}
