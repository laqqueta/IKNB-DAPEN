package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1067KategoriBadanHukum implements IObject<KeyValueString> {
	R_1601 ("1601", "Penduduk-Pemerintah--Pusat"),
	R_1602 ("1602", "Penduduk-Pemerintah--Daerah"),
	R_1603 ("1603", "Penduduk-Pemerintah--Badan dan Lembaga Pemerintah"),
	R_1611 ("1611", "Penduduk-Pemerintah-BUMN-Bank"),
	R_1612 ("1612", "Penduduk-Pemerintah-BUMN-IKNB-Perusahaan Asuransi "),
	R_1613 ("1613", "Penduduk-Pemerintah-BUMN-IKNB-Dana Pensiun"),
	R_1614 ("1614", "Penduduk-Pemerintah-BUMN-IKNB-Modal Ventura"),
	R_1615 ("1615", "Penduduk-Pemerintah-BUMN-IKNB-Perusahaan Pembiayaan"),
	R_1616 ("1616", "Penduduk-Pemerintah-BUMN-Perusahaan Sekuritas dan Reksa Dana"),
	R_1617 ("1617", "Penduduk-Pemerintah-BUMN-Lembaga Keuangan Bukan Bank Lainnya"),
	R_1618 ("1618", "Penduduk-Pemerintah-BUMN-Bukan Lembaga Keuangan"),
	R_1621 ("1621", "Penduduk-Pemerintah-BUMD-BUMD Lembaga Keuangan Bukan Bank"),
	R_1622 ("1622", "Penduduk-Pemerintah-BUMD-BUMD Perusahaan Asuransi"),
	R_1623 ("1623", "Penduduk-Pemerintah-BUMD-BUMD Dana Pensiun"),
	R_1624 ("1624", "Penduduk-Pemerintah-BUMD-BUMD Modal Ventura"),
	R_1625 ("1625", "Penduduk-Pemerintah-BUMD-BUMD Perusahaan Pembiayaan"),
	R_1626 ("1626", "Penduduk-Pemerintah-BUMD-BUMD Perusahaan Sekuritas dan Reksa Dana"),
	R_1627 ("1627", "Penduduk-Pemerintah-BUMD-BUMD Lembaga Keuangan Lainnya"),
	R_1628 ("1628", "Penduduk-Pemerintah-BUMD-BUMD Bukan Lembaga Keuangan"),
	R_1631 ("1631", "Penduduk-Swasta-Nasional--Bank Umum Konvensional"),
	R_1632 ("1632", "Penduduk-Swasta-Nasional--Bank Umum Syariah"),
	R_1633 ("1633", "Penduduk-Swasta-Nasional--BPR Konvensional"),
	R_1634 ("1634", "Penduduk-Swasta-Nasional--BPR Syariah"),
	R_1635 ("1635", "Penduduk-Swasta-Nasional--Perusahaan Asuransi"),
	R_1636 ("1636", "Penduduk-Swasta-Nasional--Dana Pensiun"),
	R_1637 ("1637", "Penduduk-Swasta-Nasional--Modal Ventura"),
	R_1638 ("1638", "Penduduk-Swasta-Nasional--Perusahaan Pembiayaan"),
	R_1639 ("1639", "Penduduk-Swasta-Nasional--Perusahaan Sekuritas dan Reksadana"),
	R_1640 ("1640", "Penduduk-Swasta-Nasional-Lembaga Keuangan-Non Bank-Lainnya"),
	R_1651 ("1651", "Penduduk-Swasta-Campuran--Perusahaan Asuransi "),
	R_1652 ("1652", "Penduduk-Swasta-Campuran--Dana Pensiun "),
	R_1653 ("1653", "Penduduk-Swasta-Campuran--Modal Ventura "),
	R_1654 ("1654", "Penduduk-Swasta-Campuran--Perusahaan Pembiayaan "),
	R_1655 ("1655", "Penduduk-Swasta-Campuran--Perusahaan Sekuritas dan Reksa Dana "),
	R_1656 ("1656", "Penduduk-Swasta-Campuran-Lembaga Keuangan-Non Bank-Lainnya"),
	R_1661 ("1661", "Penduduk-Swasta-Asing--Perusahaan Asuransi"),
	R_1662 ("1662", "Penduduk-Swasta-Asing--Dana Pensiun "),
	R_1663 ("1663", "Penduduk-Swasta-Asing--Modal Ventura "),
	R_1664 ("1664", "Penduduk-Swasta-Asing--Perusahaan Pembiayaan "),
	R_1665 ("1665", "Penduduk-Swasta-Asing--Perusahaan Sekuritas dan Reksa Dana "),
	R_1666 ("1666", "Penduduk-Swasta-Asing-Lembaga Keuangan-Non Bank-Lainnya"),
	R_1671 ("1671", "Penduduk-Swasta-Nasional-Bukan Lembaga Keuangan-Perusahaan"),
	R_1672 ("1672", "Penduduk-Swasta-Nasional-Bukan Lembaga Keuangan-Koperasi Bukan Simpan Pinjam"),
	R_1673 ("1673", "Penduduk-Swasta-Nasional-Bukan Lembaga Keuangan-Yayasan, Badan Sosial dan Organisasi Kemasyarakatan Swasta Nasional"),
	R_1681 ("1681", "Penduduk-Swasta-Campuran-Bukan Lembaga Keuangan-Perusahaan"),
	R_1682 ("1682", "Penduduk-Swasta-Campuran-Bukan Lembaga Keuangan-Yayasan, Badan Sosial dan Organisasi Kemasyarakatan Campuran"),
	R_1683 ("1683", "Penduduk-Swasta-Campuran-Bukan Lembaga Keuangan-Kantor Perwakilan Lembaga Milik Asing di Indonesia yang Dimiliki Campuran"),
	R_1684 ("1684", "Penduduk-Swasta-Asing-Bukan Lembaga Keuangan-Perusahaan"),
	R_1685 ("1685", "Penduduk-Swasta-Asing-Bukan Lembaga Keuangan-Yayasan, Badan Sosial dan Organisasi Kemasyarakatan Asing"),
	R_1686 ("1686", "Penduduk-Swasta-Asing-Bukan Lembaga Keuangan-Kantor Perwakilan Lembaga Milik Asing di Indonesia yang Dimiliki Asing"),
	R_1687 ("1687", "Penduduk-Swasta--Lainnya "),
	R_1688 ("1688", "Penduduk-Swasta--Perseorangan "),
	R_1691 ("1691", "Nonpenduduk---Pemerintah pusat Negara Asing"),
	R_1692 ("1692", "Nonpenduduk---Bank Luar Negeri"),
	R_1693 ("1693", "Nonpenduduk---Lembaga Keuangan Bukan Bank yang Beroperasi di Luar Indonesia"),
	R_1694 ("1694", "Nonpenduduk---Swasta Bukan Penduduk Bukan Lembaga Keuangan"),
	R_1695 ("1695", "Nonpenduduk---Lembaga-Lembaga Internasional"),
	R_1696 ("1696", "Nonpenduduk---Perseorangan Bukan Penduduk"),
	R_0000 ("0000", "(tidak usah mengisi)"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1067KategoriBadanHukum eEnum : ER1067KategoriBadanHukum.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1067KategoriBadanHukum.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1067KategoriBadanHukum.class.getSimpleName().substring(2, 6));
	}
}
