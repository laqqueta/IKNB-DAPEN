package id.go.ojk.pnjk.client.builder.field.lb.metadata;

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
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjk.client.builder.field.lb.reference.ER3018PosLbPnjk2400;

public class Lb2400 extends BaseMetadata {

	public Lb2400(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2400;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null, ER3018PosLbPnjk2400.genFieldSave(), ER3018PosLbPnjk2400.genFieldSave(), ER3018PosLbPnjk2400.getRequiredPos());

        res.addSegmentValidations(ER3018PosLbPnjk2400.genValidation1());
        res.addSegmentValidations(ER3018PosLbPnjk2400.genValidation2());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3018_LB2400.getObject())));
		fs.add(sf(2, null, "Keterangan", sv(C, 1, 200, all)
                .confConditionalRequired(ER3018PosLbPnjk2400.genConditionForTotal())));
		fs.add(sf(3, null, "Aset Lancar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(4, null, "Aset Tidak Lancar (Rp)", sv(M, 1, 16, numeric)));
		return res;
	}
}
