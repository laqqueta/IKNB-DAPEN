package id.go.ojk.reask.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reask.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reask.client.builder.field.lb.reference.ER3060PosLbReask120;
import id.go.ojk.reask.client.builder.field.reference.EHeaderMetadataShared;

public class Lb120 extends BaseMetadata {

	public Lb120(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_120;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER3060PosLbReask120.genFieldSave(), null, ER3060PosLbReask120.getRequiredPos());
		res.addSegmentValidations(ER3060PosLbReask120.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3060_LB120.getObject())));
		fs.add(sf(2, null, "Nama Subdana",
				sv(C, 1, 50, all).confConditionalRequired(ER3060PosLbReask120.genConditionField2())));
		fs.add(sf(3, null, "Status Aset", sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R038.getObject())
				.confConditionalRequired(ER3060PosLbReask120.genConditionField3())));
		fs.add(sf(4, null, "Jenis Investasi",
				sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R003.getObject())
						.confConditionalRequired(ER3060PosLbReask120.genConditionField4())));
		fs.add(sf(5, null, "Dalam Negeri/Luar Negeri",
				sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R007.getObject())
						.confConditionalRequired(ER3060PosLbReask120.genConditionField5())));
		fs.add(sf(6, null, "Mata Uang", sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R016.getObject())
				.confConditionalRequired(ER3060PosLbReask120.genConditionField6())));
		fs.add(sf(7, null, "Kurs",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3060PosLbReask120.genConditionField7())));
		fs.add(sf(8, null, "Kode (Counterparty)",
				sv(C, 1, 50, all).confConditionalRequired(ER3060PosLbReask120.genConditionField8()))
				.addFieldValidations(ER3060PosLbReask120.genFieldValidation8a())
				.addFieldValidations(ER3060PosLbReask120.genFieldValidation8b())
				.addFieldValidations(ER3060PosLbReask120.genFieldValidation8c()));
		fs.add(sf(9, null, "Nama (Counterparty)",
				sv(C, 1, 100, all).confConditionalRequired(ER3060PosLbReask120.genConditionField9())));
		fs.add(sf(10, null, "Apakah Counterparty Terafiliasi dengan Perusahaan? (Ya/Tidak)",
				sv(C, 1, 5, all).confConditionalRequired(ER3060PosLbReask120.genConditionField10())));
		fs.add(sf(11, null, "Nomor Seri",
				sv(C, 1, 50, all).confConditionalRequired(ER3060PosLbReask120.genConditionField11())));
		fs.add(sf(12, null, "Kategori",
				sv(C, 1, 50, refTable).confReference(EHeaderMetadataShared.R002.getObject())
						.confConditionalRequired(ER3060PosLbReask120.genConditionField12()))
				.addFieldValidations(ER3060PosLbReask120.genFieldValidation12()));
		fs.add(sf(13, null, "Sektor Ekonomi",
				sv(C, 1, 50, refTable).confReference(EHeaderMetadataShared.R010.getObject())
						.confConditionalRequired(ER3060PosLbReask120.genConditionalField13()))
				.addFieldValidations(ER3060PosLbReask120.genFieldValidation13()));
		fs.add(sf(14, null, "Nama Manager Investasi",
				sv(C, 1, 100, all).confConditionalRequired(ER3060PosLbReask120.genConditionField14())));
		fs.add(sf(15, null, "Peringkat",
				sv(C, 1, 50, all).confConditionalRequired(ER3060PosLbReask120.genConditionField15())));
		fs.add(sf(16, null, "Klaster", sv(C, 1, 1, refTable).confReference(EHeaderMetadataShared.R008.getObject())
				.confConditionalRequired(ER3060PosLbReask120.genConditionField16())));
		fs.add(sf(17, null, "Jenis Jaminan", sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R009.getObject())
				.confConditionalRequired(ER3060PosLbReask120.genConditionField17())));
		fs.add(sf(18, null, "Jangka Waktu",
				sv(C, 1, 16, all).confConditionalRequired(ER3060PosLbReask120.genConditionField18())));
		fs.add(sf(19, null, "Nilai Pasar Jaminan Saat Penempatan",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3060PosLbReask120.genConditionField19())));
		fs.add(sf(20, null, "Saldo Saat Penempatan",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3060PosLbReask120.genConditionField20())));
		fs.add(sf(21, null, "Jumlah",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3060PosLbReask120.genConditionField21())));
		fs.add(sf(22, null, "Saldo",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3060PosLbReask120.genConditionField22())));
		fs.add(sf(23, null, "% NAB Subdana",
				sv(C, 1, 16, numericDotNegatif).confConditionalRequired(ER3060PosLbReask120.genConditionField23())));
		fs.add(sf(24, null, "Saldo Lancar (Kurang dari Satu Tahun)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3060PosLbReask120.genConditionField24())));
		fs.add(sf(25, null, "Target Tingkat Hasil Investasi",
				sv(C, 1, 16, numericDotNegatif).confConditionalRequired(ER3060PosLbReask120.genConditionField25())));
		fs.add(sf(26, null, "Tingkat Hasil Investasi",
				sv(C, 1, 16, numericDotNegatif).confConditionalRequired(ER3060PosLbReask120.genConditionField26())));
		fs.add(sf(27, null, "Keterangan", sv(O, 1, 100, all)));
		return res;
	}
}
