package id.go.ojk.fins.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_ALL_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.fins.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.fins.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.fins.client.builder.field.lb.reference.ER3025PosLbFins2119;

public class Lb2119 extends BaseMetadata {

	public Lb2119(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2119;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER3025PosLbFins2119.genFieldSave(), ER3025PosLbFins2119.genFieldSave(),
				ER3025PosLbFins2119.getRequiredPos());
		res.addSegmentValidations(ER3025PosLbFins2119.genRowValidation2());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R3025_LB2119.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama Pendapatan Non Operasional",
				sv(C, 1, 1000, all).confConditionalRequired(ER3025PosLbFins2119.genConditional())));
		fs.add(sf(3, null, "Jumlah", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Keterangan", sv(C, 1, 1000, all).confRegex(PATTERN_ALL_1)
				.confConditionalRequired(ER3025PosLbFins2119.genConditional())));
		return res;
	}
}
