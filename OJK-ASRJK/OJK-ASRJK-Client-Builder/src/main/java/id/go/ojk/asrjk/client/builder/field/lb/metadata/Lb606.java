package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3054PosLbAsrjk606;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb606 extends BaseMetadata {

	public Lb606(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_606;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 13, 13, ER3054PosLbAsrjk606.genFieldSave(), null,
				ER3054PosLbAsrjk606.getRequiredPos());
		res.addSegmentValidations(ER3054PosLbAsrjk606.genValidationTotal1());
		res.addSegmentValidations(ER3054PosLbAsrjk606.genValidationTotal2());
		res.addSegmentValidations(ER3054PosLbAsrjk606.genValidationPertanggunganPadaAkhirTahun());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3054_LB606.getObject())).confUnique(U));
		fs.add(sf(2, null, "Ekawarsa - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Ekawarsa - Jml Peserta", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Ekawarsa - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Kematian Berjangka - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Kematian Berjangka - Jml Peserta", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Kematian Berjangka - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Dwiguna - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Dwiguna - Jml Peserta", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Dwiguna - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(11, null, "Dwiguna Kombinasi - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(12, null, "Dwiguna Kombinasi - Jml Peserta", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(13, null, "Dwiguna Kombinasi - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(14, null, "Seumur Hidup - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(15, null, "Seumur Hidup - Jml Peserta", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(16, null, "Seumur Hidup - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(17, null, "Seumur Hidup Kombinasi - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(18, null, "Seumur Hidup Kombinasi - Jml Peserta", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(19, null, "Seumur Hidup Kombinasi - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(20, null, "Anuitas Umum - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(21, null, "Anuitas Umum - Jml Peserta", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(22, null, "Anuitas Umum - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(23, null, "Anuitas Dana Pensiun - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(24, null, "Anuitas Dana Pensiun - Jml Peserta", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(25, null, "Anuitas Dana Pensiun - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(26, null, "Kecelakaan Diri - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(27, null, "Kecelakaan Diri - Jml Peserta", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(28, null, "Kecelakaan Diri - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(29, null, "Kesehatan - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(30, null, "Kesehatan - Jml Peserta", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(31, null, "Kesehatan - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(32, null, "Produk Investasi - Jml Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(33, null, "Produk Investasi - Jml Peserta", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(34, null, "Produk Investasi - JUP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(35, null, "Total - Jml Polis", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3054PosLbAsrjk606.genFieldValidation35()));
		fs.add(sf(36, null, "Total - Jml Peserta", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3054PosLbAsrjk606.genFieldValidation36()));
		fs.add(sf(37, null, "Total - JUP", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3054PosLbAsrjk606.genFieldValidation37()));
		return res;
	}
}
