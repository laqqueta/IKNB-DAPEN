package id.go.ojk.pnjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjs.client.builder.field.lb.reference.ER3002PosLbPnjs0030;

public class Lb0030 extends BaseMetadata {

	public Lb0030(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_0030;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 4, 4, ER3002PosLbPnjs0030.genFieldSave(), ER3002PosLbPnjs0030.genFieldSave(), 
				ER3002PosLbPnjs0030.getRequiredPos());
		res.addSegmentValidations(ER3002PosLbPnjs0030.genValidation5());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3002_LB0030.getObject())).confUnique(U));
		fs.add(sf(2, null, "Syariah-Laki-Laki", sv(M, 1, 10, numeric)));
		fs.add(sf(3, null, "Syariah-Perempuan", sv(M, 1, 10, numeric)));
		return res;
	}
}
