package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3020PosLbAsrjk103;
import id.go.ojk.asrjk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb103 extends BaseMetadata {

	public Lb103(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_103;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3020PosLbAsrjk103.genFieldSave(), null,
				ER3020PosLbAsrjk103.getRequiredPos());
		res.addSegmentValidations(ER3020PosLbAsrjk103.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3020_LB103.getObject())));
		fs.add(sf(2, null, "Penempatan Pada Perusahaan-Nama Perusahaan",
				sv(C, 1, 100, all).confConditionalRequired(ER3020PosLbAsrjk103.genConditionalMustEmpty2())));
		fs.add(sf(3, null, "Penempatan Pada Perusahaan-Jenis Investasi",
				sv(C, 1, 3, refTable).confReference(EHeaderMetadataShared.R000.getObject())
						.confConditionalRequired(ER3020PosLbAsrjk103.genConditionalField3())));
		fs.add(sf(4, null, "Tradisional-AYD Setelah Batasan Per Jenis Investasi dan Investasi di Luar negeri",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3020PosLbAsrjk103.genConditionalField())));
		fs.add(sf(5, null, "Tradisional-Aset Yang Tidak Diperkenankan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3020PosLbAsrjk103.genConditionalField())));
		fs.add(sf(6, null, "Tradisional-AYD",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3020PosLbAsrjk103.genConditionalField())));
		fs.add(sf(7, null, "PAYDI",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3020PosLbAsrjk103.genConditionalField())));
		return res;
	}
}
