package id.go.ojk.lpei.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lpei.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5004PosLbLpeig0043;

public class Lb0043 extends BaseMetadata {

	public Lb0043(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_0043;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 12, 12);
		res.setRequiredPos(ER5004PosLbLpeig0043.getRequiredPos());
		res.setUniquePos(ER5004PosLbLpeig0043.getUniquePos());
		res.setSavePos(ER5004PosLbLpeig0043.genFieldSave());
		res.setSavePosForm(ER5004PosLbLpeig0043.genFieldSave());

		res.addSegmentValidations(ER5004PosLbLpeig0043.genRowValidation13());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R5004_LB0043.getObject())
				.confRegex(SimpleValidation.patternNumeric))
				.confUniqueType(UniqueType.U));
		fs.add(sf(2, null, "Tenaga Kerja Tetap - Tenaga Manajerial sampai satu level di bawah SEVP", sv(M, 1, 5, numeric)));
		fs.add(sf(3, null, "Tenaga Kerja Tetap - Staf dan Tingkat Tenaga Kerja Lainnya", sv(M, 1, 5, numeric)));
		fs.add(sf(4, null, "Tenaga Kerja Kontrak - Tenaga Manajerial sampai satu level di bawah SEVP", sv(M, 1, 5, numeric)));
		fs.add(sf(5, null, "Tenaga Kerja Kontrak - Staf dan Tingkat Tenaga Kerja Lainnya", sv(M, 1, 5, numeric)));
		fs.add(sf(6, null, "Tenaga Kerja Alih Daya - Tenaga Manajerial sampai satu level di bawah SEVP", sv(M, 1, 5, numeric)));
		fs.add(sf(7, null, "Tenaga Kerja Alih Daya - Staf dan Tingkat Tenaga Kerja Lainnya", sv(M, 1, 5, numeric)));
		fs.add(sf(8, null, "Total Tenaga Kerja - Tenaga Manajerial sampai satu level di bawah SEVP", sv(M, 1, 5, numeric))
				.addFieldValidations(ER5004PosLbLpeig0043.genFieldValidation8()));
		fs.add(sf(9, null, "Total Tenaga Kerja - Staf dan Tingkat Tenaga Kerja Lainnya", sv(M, 1, 5, numeric))
				.addFieldValidations(ER5004PosLbLpeig0043.genFieldValidation9()));
		fs.add(sf(10, null, "Keterangan Rangkap Jabatan", sv(O, 1, 4000, all)));
		return res;
	}
}
