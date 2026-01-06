package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb233 extends BaseMetadata {

	public Lb233(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_233;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3041_LB233.getObject())));
		fs.add(sf(2, null, "Lini Usaha", sv(M, 1, 4, refTable).confReference(EHeaderMetadataShared.R023.getObject())));
		fs.add(sf(3, null, "Lokasi", sv(M, 1, 4, refTable).confReference(EHeaderMetadataShared.R013.getObject())));
		fs.add(sf(4, null, "Mata Uang", sv(M, 1, 4, refTable).confReference(EHeaderMetadataShared.R017.getObject())));
		fs.add(sf(5, null, "Saluran Distribusi",
				sv(M, 1, 4, refTable).confReference(EHeaderMetadataShared.R024.getObject())));
		fs.add(sf(6, null, "Jumlah", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Jumlah Polis Inforce", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Jumlah Peserta", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Jumlah Polis Yang klaim", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Jumlah Peserta Yang Klaim", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(11, null, "Kontribusi Bruto Langsung - Alokasi Untuk Ujrah", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(12, null, "Kontribusi Bruto Langsung - Alokasi Untuk Tabarru", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(13, null, "Kontribusi Bruto Langsung - Alokasi Untuk Tanahud", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(14, null, "Kontribusi Bruto Langsung - Alokasi Untuk DIP - Akad Wakalah Bil Ujrah",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(15, null, "Kontribusi Bruto Langsung - Alokasi Untuk DIP - Akad Mudharabah",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(16, null, "Kontribusi Reasuransi/Retrosesi-Dana Perusahaan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(17, null, "Kontribusi Reasuransi/Retrosesi-Dana Tabarru", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(18, null, "Kontribusi Reasuransi/Retrosesi-Dana Tanahud", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(19, null, "Klaim Bruto-Dana Tabarru", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(20, null, "Klaim Bruto-Dana Tanahud", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(21, null, "Klaim Recovery - Dana Tabarru", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(22, null, "Klaim Recovery -  Dana Tanahud", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(23, null, "Penarikan Dana Investasi Peserta yang Jatuh Tempo-Akad Wakalah Bil Ujrah",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(24, null, "Penarikan Dana Investasi Peserta yang Jatuh Tempo-Akad Mudharabah",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(25, null,
				"Penarikan Dana Investasi Peserta Belum Jatuh Tempo (Akad Wakalah Bil Ujrah)-Penarikan Sebagian (Withdrawal)",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(26, null,
				"Penarikan Dana Investasi Peserta Belum Jatuh Tempo (Akad Wakalah Bil Ujrah)-Penarikan Seluruhnya (Surrender)",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(27, null,
				"Penarikan Dana Investasi Peserta Belum Jatuh Tempo (Akad Mudharabah)-Penarikan Sebagian (Withdrawal)",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(28, null,
				"Penarikan Dana Investasi Peserta Belum Jatuh Tempo (Akad Mudharabah)-Penarikan Seluruhnya (Surrender)",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(29, null, "Beban Adjuster - Dana Tabarru", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(30, null, "Beban Adjuster - Dana Tanahud", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(31, null, "Beban Adjuster - Beban Komisi", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
