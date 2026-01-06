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
import id.go.ojk.pnjs.client.builder.field.lb.reference.ER3032PosLbPnjs3500A;

public class Lb3500A extends BaseMetadata {

	public Lb3500A(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_3500A;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 4, 4, ER3032PosLbPnjs3500A.genFieldSave(), ER3032PosLbPnjs3500A.genFieldSave(),
				ER3032PosLbPnjs3500A.getRequiredPos());
		res.addSegmentValidations(ER3032PosLbPnjs3500A.genValidation5());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3032_LB3500A.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kafalah Pembiayaan Produktif – Kafalah Pembiayaan UMKM (Non KUR)-Pengajuan Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(3, null, "Kafalah Pembiayaan Produktif – Kafalah Pembiayaan UMKM (Non KUR)-Klaim Diproses (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(4, null, "Kafalah Pembiayaan Produktif – Kafalah Pembiayaan UMKM (Non KUR)-Klaim Disetujui (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(5, null, "Kafalah Pembiayaan Produktif – Kafalah Pembiayaan UMKM (Non KUR)-Klaim Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(6, null, "Kafalah Pembiayaan Produktif – Kafalah Pembiayaan UMKM (Non KUR)-Klaim Ditolak (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(7, null,
				"Kafalah Pembiayaan Produktif – Kafalah Pembiayaan UMKM (Non KUR)-Klaim Disetujui Namun Belum Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(8, null,
				"Kafalah Pembiayaan Produktif – Kafalah Pembiayaan Usaha Mikro Non UMKM-Pengajuan Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(9, null, "Kafalah Pembiayaan Produktif – Kafalah Pembiayaan Usaha Mikro Non UMKM-Klaim Diproses (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(10, null,
				"Kafalah Pembiayaan Produktif – Kafalah Pembiayaan Usaha Mikro Non UMKM-Klaim Disetujui (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(11, null, "Kafalah Pembiayaan Produktif – Kafalah Pembiayaan Usaha Mikro Non UMKM-Klaim Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(12, null, "Kafalah Pembiayaan Produktif – Kafalah Pembiayaan Usaha Mikro Non UMKM-Klaim Ditolak (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(13, null,
				"Kafalah Pembiayaan Produktif – Kafalah Pembiayaan Usaha Mikro Non UMKM-Klaim Disetujui Namun Belum Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(14, null, "Kafalah Pembiayaan Non Produktif-Pengajuan Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(15, null, "Kafalah Pembiayaan Non Produktif-Klaim Diproses (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(16, null, "Kafalah Pembiayaan Non Produktif-Klaim Disetujui (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(17, null, "Kafalah Pembiayaan Non Produktif-Klaim Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(18, null, "Kafalah Pembiayaan Non Produktif-Klaim Ditolak (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(19, null, "Kafalah Pembiayaan Non Produktif-Klaim Disetujui Namun Belum Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(20, null, "Kafalah KUR - Mikro-Pengajuan Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(21, null, "Kafalah KUR - Mikro-Klaim Diproses (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(22, null, "Kafalah KUR - Mikro-Klaim Disetujui (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(23, null, "Kafalah KUR - Mikro-Klaim Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(24, null, "Kafalah KUR - Mikro-Klaim Ditolak (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(25, null, "Kafalah KUR - Mikro-Klaim Disetujui Namun Belum Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(26, null, "Kafalah KUR - Non Mikro-Pengajuan Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(27, null, "Kafalah KUR - Non Mikro-Klaim Diproses (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(28, null, "Kafalah KUR - Non Mikro-Klaim Disetujui (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(29, null, "Kafalah KUR - Non Mikro-Klaim Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(30, null, "Kafalah KUR - Non Mikro-Klaim Ditolak (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(31, null, "Kafalah KUR - Non Mikro-Klaim Disetujui Namun Belum Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(32, null, "Total-Pengajuan Klaim (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3032PosLbPnjs3500A.genFieldValidation32()));
		fs.add(sf(33, null, "Total-Klaim Diproses (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3032PosLbPnjs3500A.genFieldValidation33()));
		fs.add(sf(34, null, "Total-Klaim Disetujui (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3032PosLbPnjs3500A.genFieldValidation34()));
		fs.add(sf(35, null, "Total-Klaim Dibayar (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3032PosLbPnjs3500A.genFieldValidation35()));
		fs.add(sf(36, null, "Total-Klaim Ditolak (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3032PosLbPnjs3500A.genFieldValidation36()));
		fs.add(sf(37, null, "Total-Klaim Disetujui Namun Belum Dibayar (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3032PosLbPnjs3500A.genFieldValidation37()));
		return res;
	}
}
