package id.go.ojk.pmvk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pmvk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.pmvk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.pmvk.client.builder.field.rb.uus.reference.ER2504PosRbPmvu050101;
import id.go.ojk.pmvk.client.builder.field.reference.EHeaderMetadataShared;

public class Rb050101 extends BaseMetadata {

	public Rb050101(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_050101;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2504_RB050101.getObject())));
		fs.add(sf(2, null, "Jenis Kegiatan Usaha",
				sv(O, 0, 10, refTable).confReference(EHeaderMetadataShared.R003.getObject())));
		fs.add(sf(3, null, "Deskripsi Umum Kegiatan Usaha",
				sv(C, 0, 1000, all).confConditionalRequired(ER2504PosRbPmvu050101.genConditionalField())));
		fs.add(sf(4, null, "Waktu Pelaksanaan Kegiatan Usaha Baru",
				sv(C, 0, 8, date).confConditionalRequired(ER2504PosRbPmvu050101.genConditionalField())));
		fs.add(sf(5, null, "Tujuan Kegiatan Usaha Baru Bagi Perusahaan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2504PosRbPmvu050101.genConditionalField())));
		fs.add(sf(6, null, "Tujuan Kegiatan Usaha Baru Bagi Debitur/Pasangan Usaha",
				sv(C, 0, 1000, all).confConditionalRequired(ER2504PosRbPmvu050101.genConditionalField())));
		fs.add(sf(7, null, "Keterkaitan Kegiatan Usaha Baru dengan Strategi Bisnis Perusahaan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2504PosRbPmvu050101.genConditionalField())));
		fs.add(sf(8, null, "Risiko atas Pelaksanaan Kegiatan Usaha Baru",
				sv(C, 0, 1000, all).confConditionalRequired(ER2504PosRbPmvu050101.genConditionalField())));
		fs.add(sf(9, null, "Mitigasi Risiko atas Pelaksanaan Kegiatan Usaha Baru",
				sv(C, 0, 1000, all).confConditionalRequired(ER2504PosRbPmvu050101.genConditionalField())));
		return res;
	}
}
