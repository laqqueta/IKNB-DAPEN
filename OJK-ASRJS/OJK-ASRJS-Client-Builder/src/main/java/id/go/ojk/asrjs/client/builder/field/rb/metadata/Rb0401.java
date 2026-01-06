package id.go.ojk.asrjs.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.asrjs.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrjs.client.builder.field.rb.reference.ER2009PosRbAsrjs0401;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb0401 extends BaseMetadata {

	public Rb0401(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0401;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2009_RB0401.getObject())));
		fs.add(sf(2, null, "Usulan Nama Produk Baru", sv(O, 0, 1000, all)));
		fs.add(sf(3, null, "Lini Usaha/ Cabang Asuransi",
				sv(C, 0, 1000, all).confConditionalRequired(ER2009PosRbAsrjs0401.genConditionalField())));
		fs.add(sf(4, null, "Saluran Pemasaran",
				sv(C, 0, 1000, all).confConditionalRequired(ER2009PosRbAsrjs0401.genConditionalField())));
		fs.add(sf(5, null, "Rencana Penerbitan/Waktu Pelaksanaan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2009PosRbAsrjs0401.genConditionalField())));
		return res;
	}
}
