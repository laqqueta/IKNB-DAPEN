package id.go.ojk.pnjk.client.builder.field.lb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.ER3123PosLbPnju2900;

public class Lb2900 extends BaseMetadata {

	public Lb2900(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2900;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null, ER3123PosLbPnju2900.genFieldSave(), ER3123PosLbPnju2900.genFieldSave(), ER3123PosLbPnju2900.getRequiredPos());

        res.addSegmentValidations(ER3123PosLbPnju2900.genValidation1());
        res.addSegmentValidations(ER3123PosLbPnju2900.genValidation2());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLbUus.R3123_LB2900.getObject())));
		fs.add(sf(2, null, "Keterangan", sv(C, 1, 100, all)
                .confConditionalRequired(ER3123PosLbPnju2900.genConditionForTotal())));
		fs.add(sf(3, null, "Liabilitas Lancar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(4, null, "Liabilitas Tidak Lancar (Rp)", sv(M, 1, 16, numeric)));
		return res;
	}
}
