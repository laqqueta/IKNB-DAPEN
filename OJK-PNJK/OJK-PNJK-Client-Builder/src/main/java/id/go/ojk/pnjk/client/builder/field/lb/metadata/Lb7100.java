package id.go.ojk.pnjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjk.client.builder.field.lb.reference.ER3037PosLbPnjk7100;

public class Lb7100 extends BaseMetadata {

	public Lb7100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_7100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 3, 3, ER3037PosLbPnjk7100.genFieldSave(), ER3037PosLbPnjk7100.genFieldSave(),
				ER3037PosLbPnjk7100.getRequiredPos());
		res.addSegmentValidations(ER3037PosLbPnjk7100.genValidationNumeric());
        res.addSegmentValidations(ER3037PosLbPnjk7100.genValidationNumeric2());
		res.addSegmentValidations(ER3037PosLbPnjk7100.genValidationNumericDot());
		res.addSegmentValidations(ER3037PosLbPnjk7100.genValidation4());
        res.addSegmentValidations(ER3037PosLbPnjk7100.genValidation5());
        res.addSegmentValidations(ER3037PosLbPnjk7100.genValidation6());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3037_LB7100.getObject())).confUnique(U));
		fs.add(sf(2, null, "Usaha Produktif", sv(C, 1, 16, all)
                .confConditionalRequired(ER3037PosLbPnjk7100.genValidationMustEmpty1())));
		fs.add(sf(3, null, "Usaha Non-Produktif", sv(C, 1, 16, all)
                .confConditionalRequired(ER3037PosLbPnjk7100.genValidationMustEmpty2())));
		fs.add(sf(4, null, "Jumlah", sv(M, 1, 16, all))
				.addFieldValidations(ER3037PosLbPnjk7100.genFieldValidation4()));
		return res;
	}
}
