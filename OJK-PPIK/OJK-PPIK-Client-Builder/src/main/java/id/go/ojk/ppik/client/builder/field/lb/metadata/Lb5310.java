package id.go.ojk.ppik.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.ppik.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.ppik.client.builder.field.lb.reference.ER3024PosLbPpik5310;

public class Lb5310 extends BaseMetadata {

	public Lb5310(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_5310;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 39, 39, ER3024PosLbPpik5310.genFieldSave(), ER3024PosLbPpik5310.genFieldSave(),
				ER3024PosLbPpik5310.getRequiredPos());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation02());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation03());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation06());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation09());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation12());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation15());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation18());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation19());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation22());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation25());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation28());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation31());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation34A());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation34B());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation35());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation38A());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation38B());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation39A());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation39B());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation39C());
		res.addSegmentValidations(ER3024PosLbPpik5310.genRowValidation40());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataLb.R3024_LB5310.getObject())
						.confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Rupiah, Jatuh Tempo Sampai Dengan <=3 bulan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Rupiah, Jatuh Tempo Sampai Dengan, 3 Bulan < umur <= 6 Bulan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Rupiah, Jatuh Tempo Sampai Dengan, 6 Bulan < umur <= 1 Tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Rupiah, Jatuh Tempo Sampai Dengan, 1 Tahun < umur <= 5 Tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Rupiah, Jatuh Tempo Sampai Dengan, 5 Tahun < umur <= 10 Tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Rupiah, Jatuh Tempo Sampai Dengan, > 10 Tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Rupiah, Jumlah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3024PosLbPpik5310.genFieldValidation8()));
		fs.add(sf(9, null, "Valas, Jatuh Tempo Sampai Dengan, <=3 bulan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Valas, Jatuh Tempo Sampai Dengan, 3 Bulan < umur <= 6 Bulan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(11, null, "Valas, Jatuh Tempo Sampai Dengan, 6 Bulan < umur <= 1 Tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(12, null, "Valas, Jatuh Tempo Sampai Dengan, 1 Tahun < umur <= 5 Tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(13, null, "Valas, Jatuh Tempo Sampai Dengan, 5 Tahun < umur <= 10 Tahun ", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(14, null, "Valas, Jatuh Tempo Sampai Dengan, > 10 Tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(15, null, "Valas, Jumlah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3024PosLbPpik5310.genFieldValidation15()));
		fs.add(sf(16, null, "Total", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3024PosLbPpik5310.genFieldValidation16()));
		return res;
	}
}
