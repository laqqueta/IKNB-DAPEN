package id.go.ojk.reass.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
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
import id.go.ojk.reass.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reass.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reass.client.builder.field.lb.reference.ER3041PosLbReass233;
import id.go.ojk.reass.client.builder.field.reference.EHeaderMetadataShared;

public class Lb233 extends BaseMetadata {

	public Lb233(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_233;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3041_LB233.getObject())));
		fs.add(sf(2, null, "Lini Usaha", sv(O, 1, 4, refTable).confReference(EHeaderMetadataShared.R025.getObject())));
		fs.add(sf(3, null, "Lokasi", sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R013.getObject())
				.confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(4, null, "Mata Uang", sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R017.getObject())
				.confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(5, null, "Saluran Distribusi",
				sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R022.getObject())
						.confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(6, null, "Jumlah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(7, null, "Jumlah Polis Inforce",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(8, null, "Jumlah Peserta",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(9, null, "Jumlah Polis Yang klaim",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(10, null, "Jumlah Peserta Yang Klaim",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(11, null, "Kontribusi Bruto Langsung - Alokasi Untuk Ujrah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(12, null, "Kontribusi Bruto Langsung - Alokasi Untuk Tabarru",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(13, null, "Kontribusi Bruto Langsung - Alokasi Untuk DIP - Akad Wakalah Bil Ujrah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(14, null, "Kontribusi Bruto Langsung - Alokasi Untuk DIP - Akad Mudharabah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(15, null, "Kontribusi Bruto Tidak Langsung - Alokasi Untuk Ujrah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(16, null, "Kontribusi Bruto Tidak Langsung - Alokasi Untuk Tabarru",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(17, null, "Kontribusi Reasuransi/Retrosesi-Dana Perusahaan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(18, null, "Kontribusi Reasuransi/Retrosesi-Dana Tabarru",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(19, null, "Klaim Bruto-Penutupan Langsung",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(20, null, "Klaim Bruto-Penutupan Tidak Langsung",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(21, null, "Klaim Recovery",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(22, null, "Penarikan Dana Investasi Peserta yang Jatuh Tempo-Akad Wakalah Bil Ujrah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(23, null, "Penarikan Dana Investasi Peserta yang Jatuh Tempo-Akad Mudharabah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(24, null,
				"Penarikan Dana Investasi Peserta Belum Jatuh Tempo (Akad Wakalah Bil Ujrah)-Penarikan Sebagian (Withdrawal)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(25, null,
				"Penarikan Dana Investasi Peserta Belum Jatuh Tempo (Akad Wakalah Bil Ujrah)-Penarikan Seluruhnya (Surrender)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(26, null,
				"Penarikan Dana Investasi Peserta Belum Jatuh Tempo (Akad Mudharabah)-Penarikan Sebagian (Withdrawal)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(27, null,
				"Penarikan Dana Investasi Peserta Belum Jatuh Tempo (Akad Mudharabah)-Penarikan Seluruhnya (Surrender)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(28, null, "Beban Adjuster",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(29, null, "Beban Komisi - Penutupan Langsung",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		fs.add(sf(30, null, "Beban Komisi - Penutupan Tidak Langsung",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3041PosLbReass233.genConditional())));
		return res;
	}
}
