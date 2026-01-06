package id.go.ojk.reask.client.builder.field.lb.metadata;

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
import id.go.ojk.reask.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reask.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reask.client.builder.field.lb.reference.ER3053PosLbReask216;

public class Lb216 extends BaseMetadata {

	public Lb216(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_216;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 7, 7, ER3053PosLbReask216.genFieldSave(), null, ER3053PosLbReask216.getRequiredPos());
		res.addSegmentValidations(ER3053PosLbReask216.genValidationPremiBruto());
		res.addSegmentValidations(ER3053PosLbReask216.genValidationBebanKlaim());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3053_LB216.getObject())).confUnique(U));
		fs.add(sf(2, null, "Direct Marketing - FtF", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Direct Marketing - Telemarketing", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Direct Marketing -al", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Agen Asuransi - FtF", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Agen Asuransi - Telemarketing", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Agen Asuransi -al", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Bancassurance - FtF", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Bancassurance - Telemarketing", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Bancassurance -al", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(11, null, "BUSB (Perusahaan Pembiayaan) - FtF", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(12, null, "BUSB (Perusahaan Pembiayaan) - Telemarketing", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(13, null, "BUSB (Perusahaan Pembiayaan) -al", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(14, null, "BUSB (Lainnya) - FtF", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(15, null, "BUSB (Lainnya) - Telemarketing", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(16, null, "BUSB (Lainnya) -al", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(17, null, "Tenaga Pemasar - FtF", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(18, null, "Tenaga Pemasar - Telemarketing", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(19, null, "Tenaga Pemasar -al", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(20, null, "Pialang Asuransi - FtF", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(21, null, "Pialang Asuransi - Telemarketing", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(22, null, "Pialang Asuransi -al", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(23, null, "Jumlah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3053PosLbReask216.genFieldValidation23()));
		return res;
	}
}
