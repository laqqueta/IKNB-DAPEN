package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3031PosLbAsrjs223;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb223 extends BaseMetadata {

	public Lb223(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_223;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 10, 10, ER3031PosLbAsrjs223.genFieldSave(), null,
				ER3031PosLbAsrjs223.getRequiredPos());
		res.addSegmentValidations(ER3031PosLbAsrjs223.genValidationNumericNegative());
		res.addSegmentValidations(ER3031PosLbAsrjs223.genValidationNumericDotNegative());
		res.addSegmentValidations(ER3031PosLbAsrjs223.genValidationRisikoOperasional1());
		res.addSegmentValidations(ER3031PosLbAsrjs223.genValidationRisikoOperasional2());
		res.addSegmentValidations(ER3031PosLbAsrjs223.genValidationSubTotalRisikoOperasionalPerusahaan());
		res.addSegmentValidations(ER3031PosLbAsrjs223.genValidationSubTotalRisikoOperasionalPAYDI());
		res.addSegmentValidations(ER3031PosLbAsrjs223.genValidationSubTotalRODT());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3031_LB223.getObject())).confUnique(U));
		fs.add(sf(2, null, "Dana Tabarru' dan Dana Tanahud",
				sv(C, 1, 16, all).confConditionalRequired(ER3031PosLbAsrjs223.genConditional2())));
		fs.add(sf(3, null, "Dana Perusahaan",
				sv(C, 1, 16, all).confConditionalRequired(ER3031PosLbAsrjs223.genConditional3())));
		return res;
	}
}
