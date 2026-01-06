package id.go.ojk.pnjk.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjk.client.builder.field.lb.reference.ER3016PosLbPnjk2200;
import id.go.ojk.pnjk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2200 extends BaseMetadata {

	public Lb2200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null, null, ER3016PosLbPnjk2200.genFieldSave(), null);

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3016_LB2200.getObject())));
		fs.add(sf(2, null, "Nama Penerima Jaminan", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Jenis Penjaminan", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R042.getObject())));
		fs.add(sf(4, null, "Produk Penjaminan", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R043.getObject())));
		fs.add(sf(5, null, "Jumlah Terjamin (Satuan)", sv(M, 1, 10, numeric)));
		fs.add(sf(6, null, "Nilai Kredit/Proyek (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(7, null, "Nilai Penjaminan (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(8, null, "Outstanding Penjaminan (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(9, null, "Nilai Piutang IJP (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(10, null, "CKPN (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(11, null, "Jumlah Netto (Rp)", sv(M, 1, 16, numericNegatif))
                .addFieldValidations(ER3016PosLbPnjk2200.genFieldValidation()));
		return res;
	}
}
