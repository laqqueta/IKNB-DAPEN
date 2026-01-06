package id.go.ojk.reask.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reask.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reask.client.builder.field.lb.reference.ER3023PosLbReask106;

public class Lb106 extends BaseMetadata {

	public Lb106(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_106;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER3023PosLbReask106.genFieldSave(), null, ER3023PosLbReask106.getRequiredPos());
		res.addSegmentValidations(ER3023PosLbReask106.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3023_LB106.getObject())));
		fs.add(sf(2, null, "I. Penempatan Investasi Pada Pihak Terafiliasi Dengan Perusahaan - Nama Perusahaan",
				sv(C, 1, 100, all).confConditionalRequired(ER3023PosLbReask106.genConditional2())));
		fs.add(sf(3, null, "I. Penempatan Investasi Pada Pihak Terafiliasi Dengan Perusahaan - Hubungan Kepemilikan",
				sv(C, 1, 100, all).confConditionalRequired(ER3023PosLbReask106.genConditionalField345())));
		fs.add(sf(4, null, "I. Penempatan Investasi Pada Pihak Terafiliasi Dengan Perusahaan - Bidang Usaha",
				sv(C, 1, 100, all).confConditionalRequired(ER3023PosLbReask106.genConditionalField345())));
		fs.add(sf(5, null, "I. Penempatan Investasi Pada Pihak Terafiliasi Dengan Perusahaan - Persentase Kepemilikan",
				sv(C, 1, 6, numericDotNegatif).confConditionalRequired(ER3023PosLbReask106.genConditionalField345())));
		fs.add(sf(6, null,
				"I. Penempatan Investasi Pada Pihak Terafiliasi Dengan Perusahaan - Nilai Kepemilikan (dalam Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3023PosLbReask106.genConditionalField6())));
		fs.add(sf(7, null, "II. Penempatan Investasi Pada Pihak Terafiliasi Tidak Dengan Perusahaan - Nama Perusahaan",
				sv(C, 1, 100, all).confConditionalRequired(ER3023PosLbReask106.genConditionalField789())));
		fs.add(sf(8, null, "II. Penempatan Investasi Pada Pihak Terafiliasi Tidak Dengan Perusahaan - Nama Grup	",
				sv(C, 1, 100, all).confConditionalRequired(ER3023PosLbReask106.genConditionalField789())));
		fs.add(sf(9, null, "II. Penempatan Investasi Pada Pihak Terafiliasi Tidak Dengan Perusahaan - Bidang Usaha",
				sv(C, 1, 100, all).confConditionalRequired(ER3023PosLbReask106.genConditionalField789())));
		return res;
	}
}
