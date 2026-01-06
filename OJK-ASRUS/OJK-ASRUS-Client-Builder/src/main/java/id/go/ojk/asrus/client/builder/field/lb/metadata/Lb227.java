package id.go.ojk.asrus.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrus.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrus.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrus.client.builder.field.lb.reference.ER3035PosLbAsrus227;
import id.go.ojk.asrus.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb227 extends BaseMetadata {

	public Lb227(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_227;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3035_LB227.getObject())));
		fs.add(sf(2, null, "Nama", sv(O, 1, 100, all)));
		fs.add(sf(3, null, "Jenis Utang", sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R021.getObject())
				.confConditionalRequired(ER3035PosLbAsrus227.genConditional())));
		fs.add(sf(4, null, "Jenis Dana", sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R006.getObject())
				.confConditionalRequired(ER3035PosLbAsrus227.genConditional())));
		fs.add(sf(5, null, "Periode Mulai",
				sv(C, 1, 8, date).confConditionalRequired(ER3035PosLbAsrus227.genConditional())));
		fs.add(sf(6, null, "Negara", sv(C, 1, 3, refTable).confReference(EHeaderMetadataShared.R014.getObject())
				.confConditionalRequired(ER3035PosLbAsrus227.genConditional())));
		fs.add(sf(7, null, "Mata Uang", sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R017.getObject())
				.confConditionalRequired(ER3035PosLbAsrus227.genConditional())));
		fs.add(sf(8, null, "Saldo Buku",
				sv(C, 1, 10, numericNegatif).confConditionalRequired(ER3035PosLbAsrus227.genConditional())));
		fs.add(sf(9, null, "Saldo Penilaian SAP",
				sv(C, 1, 10, numericNegatif).confConditionalRequired(ER3035PosLbAsrus227.genConditional())));
		return res;
	}
}
