package id.go.ojk.pmvk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pmvk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.pmvk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.pmvk.client.builder.field.rb.uus.reference.ER2500PosRbPmvu010402;

public class Rb010402 extends BaseMetadata {

	public Rb010402(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_010402;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 24, 24, ER2500PosRbPmvu010402.genFieldSave(), null, ER2500PosRbPmvu010402.getRequiredPos());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationNumericNegative());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationNumericDotNegative());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationTotalInvestasiModalVentura());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationPenyaluranPembiayaanBersamaPorsiPihakKetiga());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationFormTotalAset());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationFormTotalInvestasiModalVentura());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationFormPenerbitanSuratBerharga());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationFormEkuitas());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationFormLaba());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationFormPembiayaanPenerusan());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationFormRasioNpifBruto());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationFormRasioNpifNeto());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationFormRoa());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationFormRoe());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationFormBopo());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationFormCurrentRatio());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationFormCashRatio());
		res.addSegmentValidations(ER2500PosRbPmvu010402.genValidationFormNilaiDanaVenturaYangdikelola());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2500_RB010402.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Proyeksi - Juni xx", sv(M, 1, 16, all)));
		fs.add(sf(5, null, "Proyeksi - Desember xx", sv(M, 1, 16, all)));
		return res;
	}
}
