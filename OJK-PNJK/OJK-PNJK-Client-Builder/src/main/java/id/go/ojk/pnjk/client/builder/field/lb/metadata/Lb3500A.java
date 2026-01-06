package id.go.ojk.pnjk.client.builder.field.lb.metadata;

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
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjk.client.builder.field.lb.reference.ER3032PosLbPnjk3500A;

public class Lb3500A extends BaseMetadata {

	public Lb3500A(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_3500A;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 4, 4, ER3032PosLbPnjk3500A.genFieldSave(), ER3032PosLbPnjk3500A.genFieldSave(),
				ER3032PosLbPnjk3500A.getRequiredPos());
		res.addSegmentValidations(ER3032PosLbPnjk3500A.genValidation5());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3032_LB3500A.getObject())).confUnique(U));
		fs.add(sf(2, null, "Penjaminan Kredit Produktif – Penjaminan Kredit UMKM (Non KUR)-Pengajuan Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(3, null, "Penjaminan Kredit Produktif – Penjaminan Kredit UMKM (Non KUR)-Klaim Diproses (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(4, null, "Penjaminan Kredit Produktif – Penjaminan Kredit UMKM (Non KUR)-Klaim Disetujui (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(5, null, "Penjaminan Kredit Produktif – Penjaminan Kredit UMKM (Non KUR)-Klaim Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(6, null, "Penjaminan Kredit Produktif – Penjaminan Kredit UMKM (Non KUR)-Klaim Ditolak (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(7, null,
				"Penjaminan Kredit Produktif – Penjaminan Kredit UMKM (Non KUR)-Klaim Disetujui Namun Belum Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(8, null, "Penjaminan Kredit Produktif – Penjaminan Kredit Usaha Mikro Non UMKM-Pengajuan Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(9, null, "Penjaminan Kredit Produktif – Penjaminan Kredit Usaha Mikro Non UMKM-Klaim Diproses (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(10, null, "Penjaminan Kredit Produktif – Penjaminan Kredit Usaha Mikro Non UMKM-Klaim Disetujui (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(11, null, "Penjaminan Kredit Produktif – Penjaminan Kredit Usaha Mikro Non UMKM-Klaim Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(12, null, "Penjaminan Kredit Produktif – Penjaminan Kredit Usaha Mikro Non UMKM-Klaim Ditolak (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(13, null,
				"Penjaminan Kredit Produktif – Penjaminan Kredit Usaha Mikro Non UMKM-Klaim Disetujui Namun Belum Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(14, null, "Penjaminan Kredit Non Produktif-Pengajuan Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(15, null, "Penjaminan Kredit Non Produktif-Klaim Diproses (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(16, null, "Penjaminan Kredit Non Produktif-Klaim Disetujui (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(17, null, "Penjaminan Kredit Non Produktif-Klaim Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(18, null, "Penjaminan Kredit Non Produktif-Klaim Ditolak (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(19, null, "Penjaminan Kredit Non Produktif-Klaim Disetujui Namun Belum Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(20, null, "Penjaminan KUR - Mikro-Pengajuan Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(21, null, "Penjaminan KUR - Mikro-Klaim Diproses (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(22, null, "Penjaminan KUR - Mikro-Klaim Disetujui (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(23, null, "Penjaminan KUR - Mikro-Klaim Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(24, null, "Penjaminan KUR - Mikro-Klaim Ditolak (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(25, null, "Penjaminan KUR - Mikro-Klaim Disetujui Namun Belum Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(26, null, "Penjaminan KUR - Non Mikro-Pengajuan Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(27, null, "Penjaminan KUR - Non Mikro-Klaim Diproses (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(28, null, "Penjaminan KUR - Non Mikro-Klaim Disetujui (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(29, null, "Penjaminan KUR - Non Mikro-Klaim Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(30, null, "Penjaminan KUR - Non Mikro-Klaim Ditolak (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(31, null, "Penjaminan KUR - Non Mikro-Klaim Disetujui Namun Belum Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(32, null, "Total-Pengajuan Klaim (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3032PosLbPnjk3500A.genFieldValidation32()));
		fs.add(sf(33, null, "Total-Klaim Diproses (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3032PosLbPnjk3500A.genFieldValidation33()));
		fs.add(sf(34, null, "Total-Klaim Disetujui (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3032PosLbPnjk3500A.genFieldValidation34()));
		fs.add(sf(35, null, "Total-Klaim Dibayar (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3032PosLbPnjk3500A.genFieldValidation35()));
		fs.add(sf(36, null, "Total-Klaim Ditolak (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3032PosLbPnjk3500A.genFieldValidation36()));
		fs.add(sf(37, null, "Total-Klaim Disetujui Namun Belum Dibayar (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3032PosLbPnjk3500A.genFieldValidation37()));
		return res;
	}
}
