package id.go.ojk.asruk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3064PosLbAsruk622;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb622 extends BaseMetadata {

	public Lb622(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_622;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 9, 9, ER3064PosLbAsruk622.genFieldSave(), null,
				ER3064PosLbAsruk622.getRequiredPos());
		res.addSegmentValidations(ER3064PosLbAsruk622.genValidationBadanUsahaSelainBank());
		res.addSegmentValidations(ER3064PosLbAsruk622.genValidationTenagaPemasar());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3064_LB622.getObject())));
		fs.add(sf(2, null, "Wilayah Pemasaran", sv(O, 1, 50, all)));
		fs.add(sf(3, null, "Kategori Pemasar Badan Hukum",
				sv(C, 1, 50, all).confConditionalRequired(ER3064PosLbAsruk622.genConditionField3())));
		fs.add(sf(4, null, "Jumlah Pemasar Badan Hukum",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3064PosLbAsruk622.genConditionField4())));
		fs.add(sf(5, null, "Jumlah Pemasar Perorangan", sv(O, 1, 16, numeric)));
		fs.add(sf(6, null, "Nama Produk yang Dipasarkan", sv(O, 1, 50, all)));
		fs.add(sf(7, null, "Jumlah Peserta/Tertanggung", sv(O, 1, 16, numeric)));
		fs.add(sf(8, null, "Premi/Kontribusi Bruto (Rp)", sv(O, 1, 16, numeric)));
		return res;
	}
}
