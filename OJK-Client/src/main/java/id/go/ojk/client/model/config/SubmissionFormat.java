package id.go.ojk.client.model.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.lib.client.model.config.UniqueCombineField;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToBigDecimal;
import org.apache.commons.net.util.ToStringList;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@XStreamAlias("format")
public class SubmissionFormat {
    @XStreamAsAttribute
    private String code;
    @XStreamAsAttribute
    private String name;
    @XStreamAsAttribute
    private String reportCode;
    @XStreamAsAttribute
    private String extension;
    @XStreamAsAttribute
    private String valMIDelimiter;
    @XStreamAsAttribute
    private Integer minRow;
    @XStreamAsAttribute
    private Integer maxRow;
    @XStreamAsAttribute
    private String savePos;
    @XStreamAsAttribute
    private String savePosForm;
    @XStreamAsAttribute
    private String requiredPos;
    @XStreamAsAttribute
    private String uniquePos;
    @XStreamAsAttribute
    private boolean F01;//Footer alasan atau pertimbangan
    @XStreamAsAttribute
    private boolean F02;//Footer strategi
    @XStreamAsAttribute
    private boolean filterYearMI;//Validasi berdasarkan Periode RBB dan Modal Inti
    @XStreamAsAttribute
    private Integer minYear1;
    @XStreamAsAttribute
    private Integer maxYear1;
    @XStreamAsAttribute
    private Integer minModalInti1;
    @XStreamAsAttribute
    private Integer maxModalInti1;
    @XStreamAsAttribute
    private Integer minYear2;
    @XStreamAsAttribute
    private Integer maxYear2;
    @XStreamAsAttribute
    private Integer minModalInti2;
    @XStreamAsAttribute
    private Integer maxModalInti2;
    @XStreamAsAttribute
    private boolean skipValidationIfNotChange;
    @XStreamAsAttribute
    private boolean havePosCode;
    @XStreamAsAttribute
    private boolean haveOfficeCode;
    @XStreamAsAttribute
    private String fieldSavePos;
    @XStreamAsAttribute
    private Boolean saveFormCode;
    @XStreamAsAttribute
    private String savePosFormDb;

    private Integer totalRow;
    private Integer reportFormGroupCode;
    private List<SubmissionField> fields = new ArrayList<>();
    private List<FooterField> footer01;
    private List<FooterField> footer02;

    public static List<String> modalInti = new ArrayList<String>();
    public static List<String> noSurat = new ArrayList<String>();
    public static List<String> listRincianKantor = new ArrayList<String>();
    public static List<String> officeCodeErrorChecker = new ArrayList<String>();
    public static List<String> tempOtherValueList = new ArrayList<String>();
    public static List<String> checkUniqueCustom = new ArrayList<String>();
    public static Map<String, Map<String, String>> mapPosValue = new HashMap<>();
    public static Map<String, List<String>> mapPosValueLBBPRK = new HashMap<String, List<String>>();
    public static Map<String, Map<String, String>> mapPosValueForm = new HashMap<>();
    public static TreeMap<String, Map<String, String>> treeMapPosValueForm = new TreeMap<>();
    public static Boolean tempOtherCondition;
    private static String[] headers;
    public static LocalDate reportPeriod;
    private List<UniqueCombineField> uniqueCombineFields;
    private List<ConditionalRequired> conditionalRequireds;
    private List<SegmentValidation> segmentValidations = new ArrayList<>();


    public SubmissionFormat() {
    }

    public SubmissionFormat(String code, String name, List<SubmissionField> fields) {
        setCode(code);
        setName(name);
        setFields(fields);
    }

    public SubmissionFormat(String code, String name, List<SubmissionField> fields, String extention) {
        setCode(code);
        setName(name);
        setFields(fields);
        setExtention(extention);
    }

    public SubmissionFormat(String code, String name, String reportCode, String extention) {
        setCode(code);
        setName(name);
        setReportCode(reportCode);
        setExtention(extention);
    }

    public SubmissionFormat(String code, String name, String reportCode, List<SubmissionField> fields, String extention, Integer minRow, Integer maxRow) {
        setCode(code);
        setName(name);
        setReportCode(reportCode);
        setFields(fields);
        setExtention(extention);
        setMinRow(minRow);
        setMaxRow(maxRow);
    }

    public SubmissionFormat(SubmissionFormatBuilder builder) {
        setCode(builder.getCode());
        setName(builder.getName());
        setReportCode(builder.getReportCode());
        setFields(builder.getFields());
        setExtention(builder.getExtension().getType());
        setMinRow(builder.getMinRow());
        setMaxRow(builder.getMaxRow());
    }

    public SubmissionFormat(String code, String name, String reportCode, List<SubmissionField> fields, String extention, Integer minRow, Integer maxRow, boolean haveOfficeCode, boolean havePosCode, String fieldSavePos) {
        setCode(code);
        setName(name);
        setReportCode(reportCode);
        setFields(fields);
        setExtention(extention);
        setMinRow(minRow);
        setMaxRow(maxRow);
        setHaveOfficeCode(haveOfficeCode);
        setHavePosCode(havePosCode);
        setFieldSavePos(fieldSavePos);
    }

    public SubmissionFormat(String code, String name, String reportCode, List<SubmissionField> fields, String extention, Integer minRow, Integer maxRow, String savePos) {
        setCode(code);
        setName(name);
        setReportCode(reportCode);
        setFields(fields);
        setExtention(extention);
        setMinRow(minRow);
        setMaxRow(maxRow);
        setSavePos(savePos);
    }

    public SubmissionFormat(String code, String name, String reportCode, List<SubmissionField> fields, String extention, Integer minRow, Integer maxRow, String savePos, String savePosForm) {
        setCode(code);
        setName(name);
        setReportCode(reportCode);
        setFields(fields);
        setExtention(extention);
        setMinRow(minRow);
        setMaxRow(maxRow);
        setSavePos(savePos);
        setSavePosForm(savePosForm);
    }

    public SubmissionFormat(String code, String name, String reportCode, List<SubmissionField> fields, String extention, Integer minRow, Integer maxRow, String savePos, String savePosForm, String requiredPos) {
        setCode(code);
        setName(name);
        setReportCode(reportCode);
        setFields(fields);
        setExtention(extention);
        setMinRow(minRow);
        setMaxRow(maxRow);
        setSavePos(savePos);
        setSavePosForm(savePosForm);
        setRequiredPos(requiredPos);
        setUniquePos(requiredPos);
    }

    public SubmissionFormat(String code, String name, String reportCode, List<SubmissionField> fields, String extention, Integer minRow, Integer maxRow, String requiredPos, boolean F01) {
        setCode(code);
        setName(name);
        setReportCode(reportCode);
        setFields(fields);
        setExtention(extention);
        setMinRow(minRow);
        setMaxRow(maxRow);
        setRequiredPos(requiredPos);
        setF01(F01);
    }

    public SubmissionFormat(String code, String name, List<SubmissionField> fields, String valMIDelimiter, String extention) {
        setCode(code);
        setName(name);
        setFields(fields);
        setValMIDelimiter(valMIDelimiter);
        setExtention(extention);
    }

    public SubmissionFormat(String code, String name, List<SubmissionField> fields, String valMIDelimiter, String extention, Integer minRow, Integer maxRow) {
        setCode(code);
        setName(name);
        setFields(fields);
        setValMIDelimiter(valMIDelimiter);
        setExtention(extention);
        setMinRow(minRow);
        setMaxRow(maxRow);
    }

    public SubmissionFormat(String code, String name, List<SubmissionField> fields, String valMIDelimiter, String extention, Integer minRow, Integer maxRow, String savePos) {
        setCode(code);
        setName(name);
        setFields(fields);
        setValMIDelimiter(valMIDelimiter);
        setExtention(extention);
        setMinRow(minRow);
        setMaxRow(maxRow);
        setSavePos(savePos);
    }

    public SubmissionFormat(String code, String name, List<SubmissionField> fields, String valMIDelimiter, String extention, Integer minRow, Integer maxRow, String savePos, boolean F01, boolean F02) {
        setCode(code);
        setName(name);
        setFields(fields);
        setValMIDelimiter(valMIDelimiter);
        setExtention(extention);
        setMinRow(minRow);
        setMaxRow(maxRow);
        setSavePos(savePos);
        setF01(F01);
        setF02(F02);
    }

    public SubmissionFormat(String code, String name, List<SubmissionField> fields, String valMIDelimiter, String extention, Integer minRow, Integer maxRow,
                            String savePos, boolean F01, boolean F02, Integer minYear1, Integer maxYear1, Integer minModalInti1, Integer maxModalInti1,
                            Integer minYear2, Integer maxYear2, Integer minModalInti2, Integer maxModalInti2, boolean filterYearMI) {
        setCode(code);
        setName(name);
        setFields(fields);
        setValMIDelimiter(valMIDelimiter);
        setExtention(extention);
        setMinRow(minRow);
        setMaxRow(maxRow);
        setSavePos(savePos);
        setF01(F01);
        setF02(F02);
        setMinYear1(minYear1);
        setMaxYear1(maxYear1);
        setMinYear2(minYear2);
        setMaxYear2(maxYear2);
        setMinModalInti1(minModalInti1);
        setMaxModalInti1(maxModalInti1);
        setMinModalInti2(minModalInti2);
        setMaxModalInti2(maxModalInti2);
        setFilterYearMI(filterYearMI);
    }

    public String getValMIDelimiter() {
        return valMIDelimiter;
    }

    public void setValMIDelimiter(String valMIDelimiter) {
        this.valMIDelimiter = valMIDelimiter;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public String getExtention() {
        return extension;
    }

    public void setExtention(String extension) {
        this.extension = extension;
    }

    public String getSavePos() {
        return savePos;
    }

    public void setSavePos(String savePos) {
        this.savePos = savePos;
    }

    public void setSavePos(ReferenceConfig referenceConfig) {
        this.savePos = referenceConfig.savePos();
    }

    public String getSavePosForm() {
        return savePosForm;
    }

    public void setSavePosForm(String savePosForm) {
        this.savePosForm = savePosForm;
    }

    public void setSavePosForm(ReferenceConfig referenceConfig) {
        this.savePosForm = referenceConfig.savePosForm();
    }

    public String getRequiredPos() {
        return requiredPos;
    }

    public void setRequiredPos(String requiredPos) {
        this.requiredPos = requiredPos;
    }

    public void setRequiredPos(ReferenceConfig referenceConfig) {
        this.requiredPos = referenceConfig.requiredPos();
    }

    public String getFieldSavePos() {
        return fieldSavePos;
    }

    public void setFieldSavePos(String fieldSavePos) {
        this.fieldSavePos = fieldSavePos;
    }

    public void setFieldSavePos(ReferenceConfig referenceConfig) {
        this.fieldSavePos = referenceConfig.saveFieldPos();
    }

    public Integer getMinRow() {
        return minRow;
    }

    public void setMinRow(Integer minRow) {
        this.minRow = minRow;
    }

    public Integer getMaxRow() {
        return maxRow;
    }

    public void setMaxRow(Integer maxRow) {
        this.maxRow = maxRow;
    }

    public Integer getReportFormGroupCode() {
        return reportFormGroupCode;
    }

    public void setReportFormGroupCode(Integer reportFormGroupCode) {
        this.reportFormGroupCode = reportFormGroupCode;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public boolean getF01() {
        return F01;
    }

    private void setF01(boolean F01) {
        this.F01 = F01;
    }

    public boolean getF02() {
        return F02;
    }

    private void setF02(boolean F02) {
        this.F02 = F02;
    }

    public boolean getHaveOfficeCode() {
        return haveOfficeCode;
    }

    private void setHaveOfficeCode(boolean haveOfficeCode) {
        this.haveOfficeCode = haveOfficeCode;
    }

    public boolean getHavePosCode() {
        return havePosCode;
    }

    private void setHavePosCode(boolean havePosCode) {
        this.havePosCode = havePosCode;
    }

    public Boolean getSaveFormCode() {
        return saveFormCode;
    }

    private void setSaveFormCode(Boolean saveFormCode) {
        this.saveFormCode = saveFormCode;
    }

    public String getSavePosFormDb() {
        return savePosFormDb;
    }

    public void setSavePosFormDb(String savePosFormDb) {
        this.savePosFormDb = savePosFormDb;
    }

    public boolean getFilterYearMI() {
        return filterYearMI;
    }

    public void setFilterYearMI(boolean filterYearMI) {
        this.filterYearMI = filterYearMI;
    }

    public Integer getMinYear1() {
        return minYear1;
    }

    public void setMinYear1(Integer minYear1) {
        this.minYear1 = minYear1;
    }

    public Integer getMaxYear1() {
        return maxYear1;
    }

    public void setMaxYear1(Integer maxYear1) {
        this.maxYear1 = maxYear1;
    }

    public Integer getMinYear2() {
        return minYear2;
    }

    public void setMinYear2(Integer minYear2) {
        this.minYear2 = minYear2;
    }

    public Integer getMaxYear2() {
        return maxYear2;
    }

    public void setMaxYear2(Integer maxYear2) {
        this.maxYear2 = maxYear2;
    }

    public Integer getMinModalInti1() {
        return minModalInti1;
    }

    public void setMinModalInti1(Integer minModalInti1) {
        this.minModalInti1 = minModalInti1;
    }

    public Integer getMaxModalInti1() {
        return maxModalInti1;
    }

    public void setMaxModalInti1(Integer maxModalInti1) {
        this.maxModalInti1 = maxModalInti1;
    }

    public Integer getMinModalInti2() {
        return minModalInti2;
    }

    public void setMinModalInti2(Integer minModalInti2) {
        this.minModalInti2 = minModalInti2;
    }

    public Integer getMaxModalInti2() {
        return maxModalInti2;
    }

    public void setMaxModalInti2(Integer maxModalInti2) {
        this.maxModalInti2 = maxModalInti2;
    }

    public boolean isSkipValidationIfNotChange() {
        return skipValidationIfNotChange;
    }

    public void setSkipValidationIfNotChange(boolean skipValidationIfNotChange) {
        this.skipValidationIfNotChange = skipValidationIfNotChange;
    }

    public List<SubmissionField> getFields() {
        return fields;
    }

    public void setFields(List<SubmissionField> fields) {
        this.fields = fields;
    }

    public List<String> getModalInti() {
        return modalInti;
    }

    public void setModalInti(String modalInti) {
        this.modalInti.add(modalInti);
    }

    public String getFieldName(int fieldNumber) {
        return this.fields.get(fieldNumber).getName();
    }

    public String[] getFieldNames(int... fieldNumbers) {
        String[] names = new String[fieldNumbers.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = getFieldName(i);
        }
        return names;
    }

    //~ uniqueCombineFields

    public List<UniqueCombineField> getUniqueCombineFields() {
        return uniqueCombineFields;
    }

    ;

    public void setUniqueCombineFields(List<UniqueCombineField> uniqueCombineFields) {
        this.uniqueCombineFields = uniqueCombineFields;
    }

    ;

    public void addUniqueCombineFields(UniqueCombineField uniqueCombineField) {
        if (uniqueCombineFields == null)
            this.uniqueCombineFields = new ArrayList<>();
        uniqueCombineFields.add(uniqueCombineField);
    }

    ;

    //~ conditionalRequireds

    public List<ConditionalRequired> getConditionalRequireds() {
        return conditionalRequireds;
    }

    public void setConditionalRequireds(List<ConditionalRequired> conditionalRequireds) {
        this.conditionalRequireds = conditionalRequireds;
    }

    public void addConditionalRequireds(ConditionalRequired conditionalRequired) {
        if (conditionalRequireds == null)
            conditionalRequireds = new ArrayList<ConditionalRequired>();
        conditionalRequireds.add(conditionalRequired);
    }

    //~ segmentValidations

    public List<SegmentValidation> getSegmentValidations() {
        return segmentValidations;
    }

    public void setSegmentValidations(List<SegmentValidation> segmentValidations) {
        this.segmentValidations = segmentValidations;
    }

    public void addSegmentValidations(SegmentValidation segmentValidation) {
        this.segmentValidations.add(segmentValidation);
    }

    public static BigDecimal getSumMapPosFormValue(String form, String pos, String field) {
        return getSum(SubmissionFormat.mapPosValueForm, form + pos, field);
    }

    public static BigDecimal getSumMapPosFormValueFilterByReference(String form, String pos, String field, String referenceField, List<String> referenceKeys) {
        return getSumFilterByReference(SubmissionFormat.mapPosValueForm, form + pos, field, referenceField, referenceKeys);
    }

    public static int getFormTotalRow(String form) {
        return getFormRow(SubmissionFormat.mapPosValueForm, form).size();
    }

    public static int getFormTotalRowExpectPos(String form, String expectPos) {
        return getFormRowExpectPos(SubmissionFormat.mapPosValueForm, form, expectPos).size();
    }

    public static int getFormTotalRow(String form, String filterField, String filterValue) {
        return getFormRow(SubmissionFormat.mapPosValueForm, form, filterField, filterValue).size();
    }

    public static int getFormTotalRowNotIn(String form, String filterField, String filterValue) {
        return getFormRowNotIn(SubmissionFormat.mapPosValueForm, form, filterField, filterValue).size();
    }

    public static int getFormTotalRowNotInExpectPos(String form, String filterField, String filterValue, String expectPos) {
        return getFormRowNotInExpectPos(SubmissionFormat.mapPosValueForm, form, filterField, filterValue, expectPos).size();
    }

    public static String getPosFormValue(String form, String pos, String field) {
        return getFirst(SubmissionFormat.mapPosValueForm, form + pos, field);
    }

    public static BigDecimal getSumMapPosFormValue(String pos, String field) {
        return getSum(SubmissionFormat.mapPosValueForm, pos, field);
    }

    public static BigDecimal getSumMapPosFormValue(String form, String pos, String field, String fieldFilter, String valueFilter) {
        return getSum(SubmissionFormat.mapPosValueForm, form + pos, field, fieldFilter, valueFilter);
    }

    public static BigDecimal getSumMapPosFormValueMultiFilter(String pos, String field, String fieldFilter, String valueFilter) {
        return getSumMultiFilter(SubmissionFormat.mapPosValueForm, pos, field, fieldFilter, valueFilter);
    }

    public static BigDecimal getSumMapPosFormValueMultiFilterNotEquals(String pos, String field, String fieldFilter, String valueFilter, String fieldFilterNotEquals, String valueFilterNotEquals) {
        return getSumMultiFilter(SubmissionFormat.mapPosValueForm, pos, field, fieldFilter, valueFilter, fieldFilterNotEquals, valueFilterNotEquals);
    }

    public static BigDecimal getSumMapPosFormValue(String pos, String field, String fieldFilter, String valueFilter) {
        return getSum(SubmissionFormat.mapPosValueForm, pos, field, fieldFilter, valueFilter);
    }

    public static BigDecimal getSumMapPosFormValueFilterNotEquals(String pos, String field, String fieldFilter, String valueFilter) {
        return getSumFilterNotEquals(SubmissionFormat.mapPosValueForm, pos, field, fieldFilter, valueFilter);
    }

    public static Map<String, String> getFormValue(String prefix) {
        Map<String, String> result = new HashMap<>();

        Map.Entry<String, Map<String, String>> entry = treeMapPosValueForm.ceilingEntry(prefix);

        if (entry != null && entry.getKey().startsWith(prefix)) {
            result = entry.getValue();
        }

        return result;
    }

    public static String getFormValue(String prefix, String field) {
        Map<String, String> result = getFormValue(prefix);

        if (result != null && !result.isEmpty()) return result.get(field);

        return null;
    }

    public static SortedMap<String, Map<String, String>> getFormValues(String prefix, char ranges) {
        return treeMapPosValueForm
                .subMap(prefix, true, prefix + ranges, true);
    }

    public static Stream<Entry<String, Map<String, String>>> getStreamOfFormSubMap(String prefix, char ranges) {
        return treeMapPosValueForm
                .subMap(prefix, true, prefix + ranges, true).entrySet()
                .stream();
    }

    public static Stream<Entry<String, Map<String, String>>> getStreamOfFormsSubMap(List<String> prefix, List<Character> ranges) {

        if (prefix.size() != ranges.size())
            throw new IllegalArgumentException("Form prefix and ranges should have same length.");

        return IntStream.range(0, prefix.size())
                .mapToObj(i -> treeMapPosValueForm
                        .subMap(prefix.get(i), true, prefix.get(i) + ranges.get(i), true)
                        .entrySet()
                        .stream())
                .flatMap(s -> s);
    }

    public static String getMapPosValue(String pos, String field) {
        String res = "";
        Iterator<Entry<String, Map<String, String>>> iterator = SubmissionFormat.mapPosValue.entrySet().iterator();
        String key = pos + "-";
        while (iterator.hasNext()) {
            Entry<String, Map<String, String>> entry = iterator.next();
            if (entry.getKey().startsWith(key)) {
                res = entry.getValue().get(field);
                break;
            }
        }
        return res;
    }

    public static BigDecimal getSumMapPosValue(String posCode, String field) {
        return getSum(SubmissionFormat.mapPosValue, posCode, field);
    }

    public static List<String> getAllMapPosValue(String pos, String field) {
        List<String> res = new ArrayList<>();
        Iterator<Entry<String, Map<String, String>>> iterator = SubmissionFormat.mapPosValue.entrySet().iterator();
        String key = pos + "-";
        while (iterator.hasNext()) {
            Entry<String, Map<String, String>> entry = iterator.next();
            if (entry.getKey().startsWith(key)) {
                res.add(entry.getValue().get(field));
            }
        }
        return res;
    }

    public static BigDecimal getSum(Map<String, Map<String, String>> map, String pos, String field) {
        BigDecimal res = BigDecimal.ZERO;
        String key = pos + "-";
        for (Entry<String, Map<String, String>> entry : map.entrySet()) {
            if (entry.getKey().startsWith(key)) {
                String colValue = entry.getValue().get(field);
                BigDecimal tmp = BigDecimal.ZERO;
                try {
                    tmp = new BigDecimal(colValue);
                } catch (Exception e) {
                    // silent
                } finally {
                    res = res.add(tmp);
                }
            }
        }
        return res;
    }

    public static Map<String, Map<String, String>> getFormRow(Map<String, Map<String, String>> map, String form) {
        Map<String, Map<String, String>> res = new HashMap<>();
        for (Entry<String, Map<String, String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(form)) {
                res.put(key, entry.getValue());
            }
        }
        return res;
    }

    public static Map<String, Map<String, String>> getFormRowExpectPos(Map<String, Map<String, String>> map, String form, String expectPos) {
        Map<String, Map<String, String>> res = new HashMap<>();
        String pos = form + expectPos;
        for (Entry<String, Map<String, String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!key.startsWith(pos) && key.startsWith(form)) {
                res.put(key, entry.getValue());
            }
        }
        return res;
    }

    public static Map<String, Map<String, String>> getFormRow(Map<String, Map<String, String>> map, String form, String filterField, String filterValue) {
        Map<String, Map<String, String>> res = new HashMap<>();
        List<String> listFieldValue = ToStringList.convert(filterValue, "|");
        for (Entry<String, Map<String, String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(form)) {
                Map<String, String> value = entry.getValue();
                if (listFieldValue.contains(value.get(filterField))) {
                    res.put(key, value);
                }
            }
        }
        return res;
    }

    public static Map<String, Map<String, String>> getFormRowExpectPos(Map<String, Map<String, String>> map, String form, String filterField, String filterValue, String expectPos) {
        Map<String, Map<String, String>> res = new HashMap<>();
        List<String> listFieldValue = ToStringList.convert(filterValue, "|");
        String exPos = form + expectPos;
        for (Entry<String, Map<String, String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(form)) {
                Map<String, String> value = entry.getValue();
                if (listFieldValue.contains(value.get(filterField))) {
                    res.put(key, value);
                }
            }
        }
        return res;
    }

    public static Map<String, Map<String, String>> getFormRowNotIn(Map<String, Map<String, String>> map, String form, String filterField, String filterValue) {
        Map<String, Map<String, String>> res = new HashMap<>();
        List<String> listFieldValue = ToStringList.convert(filterValue, "|");
        for (Entry<String, Map<String, String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(form)) {
                Map<String, String> value = entry.getValue();
                if (!listFieldValue.contains(value.get(filterField))) {
                    res.put(key, value);
                }
            }
        }
        return res;
    }

    public static Map<String, Map<String, String>> getFormRowNotInExpectPos(Map<String, Map<String, String>> map, String form, String filterField, String filterValue, String expectPos) {
        Map<String, Map<String, String>> res = new HashMap<>();
        String exPos = form + expectPos;
        List<String> listFieldValue = ToStringList.convert(filterValue, "|");
        for (Entry<String, Map<String, String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!key.startsWith(exPos) && key.startsWith(form)) {
                Map<String, String> value = entry.getValue();
                if (!listFieldValue.contains(value.get(filterField))) {
                    res.put(key, value);
                }
            }
        }
        return res;
    }

    public static String getFirst(Map<String, Map<String, String>> map, String pos, String field) {
        String res = "";
        String key = pos + "-";
        for (Entry<String, Map<String, String>> entry : map.entrySet()) {
            if (entry.getKey().startsWith(key)) {
                res = entry.getValue().get(field);
                break;
            }
        }
        return res;
    }

    public static BigDecimal getSum(Map<String, Map<String, String>> map, String pos, String field, String fieldFilter, String valueFilter) {
        BigDecimal res = BigDecimal.ZERO;
        String key = pos + "-";
        for (Entry<String, Map<String, String>> entry : map.entrySet()) {
            if (entry.getKey().startsWith(key)) {
                Map<String, String> values = entry.getValue();
                String realFilterValue = values.get(fieldFilter);
                if (StringUtils.isNotEmpty(realFilterValue) && realFilterValue.equals(valueFilter)) {
                    res = res.add(ToBigDecimal.convert(values.get(field)));
                }
            }
        }
        return res;
    }

    public static BigDecimal getSumFilterByReference(Map<String, Map<String, String>> map, String pos, String field, String referenceField, List<String> referenceKeys) {
        BigDecimal res = BigDecimal.ZERO;
        String key = pos + "-";
        for (Entry<String, Map<String, String>> entry : map.entrySet()) {
            if (entry.getKey().startsWith(key)) {
                String refValue = entry.getValue().get(referenceField);
                if (referenceKeys.contains(refValue)) {
                    String colValue = entry.getValue().get(field);
                    BigDecimal tmp = BigDecimal.ZERO;
                    try {
                        tmp = new BigDecimal(colValue);
                    } catch (Exception e) {
                        // silent
                    } finally {
                        res = res.add(tmp);
                    }
                }
            }
        }
        return res;
    }

    public static BigDecimal getSumMultiFilter(Map<String, Map<String, String>> map, String pos, String field, String fieldFilter, String valueFilter) {
        BigDecimal res = BigDecimal.ZERO;
        String key = pos + "-";
        String[] arrFieldFilter = StringUtils.split(fieldFilter, '|');
        String[] arrValueFilter = StringUtils.split(valueFilter, '|');
        for (Entry<String, Map<String, String>> entry : map.entrySet()) {
            if (entry.getKey().startsWith(key)) {
                Map<String, String> values = entry.getValue();
                boolean isAllCorrect = checkEquals(arrFieldFilter, arrValueFilter, values);
                if (isAllCorrect) {
                    res = res.add(ToBigDecimal.convert(values.get(field)));
                }
            }
        }
        return res;
    }

    public static BigDecimal getSumMultiFilter(Map<String, Map<String, String>> map, String pos, String field, String fieldFilter, String valueFilter, String notEqualsFieldFilter, String notEqualsValueFilter) {
        BigDecimal res = BigDecimal.ZERO;
        String key = pos + "-";
        String[] arrFieldFilter = StringUtils.split(fieldFilter, '|');
        String[] arrValueFilter = StringUtils.split(valueFilter, '|');
        String[] arrNotEqualsFieldFilter = StringUtils.split(notEqualsFieldFilter, '|');
        String[] arrNotEqualsValueFilter = StringUtils.split(notEqualsValueFilter, '|');
        for (Entry<String, Map<String, String>> entry : map.entrySet()) {
            if (entry.getKey().startsWith(key)) {
                Map<String, String> values = entry.getValue();
                boolean isAllCorrect = checkEquals(arrFieldFilter, arrValueFilter, values);
                if (isAllCorrect) {
                    isAllCorrect = checkNotEquals(arrNotEqualsFieldFilter, arrNotEqualsValueFilter, values);
                }
                if (isAllCorrect) {
                    res = res.add(ToBigDecimal.convert(values.get(field)));
                }
            }
        }
        return res;
    }

    private static boolean checkEquals(String[] arrFieldFilter, String[] arrValueFilter, Map<String, String> values) {
        boolean res = true;
        for (int i = 0; i < arrFieldFilter.length; i++) {
            String filterField = arrFieldFilter[i];
            String filterValue = arrValueFilter[i];
            String realFilterValue = values.get(filterField);
            List<String> listValue = Arrays.asList(StringUtils.split(filterValue, '$'));
            if (StringUtils.isEmpty(realFilterValue) || !listValue.contains(realFilterValue)) {
                res = false;
                break;
            }
        }
        return res;
    }

    private static boolean checkNotEquals(String[] arrFieldFilter, String[] arrValueFilter, Map<String, String> values) {
        boolean res = true;
        for (int i = 0; i < arrFieldFilter.length; i++) {
            String filterField = arrFieldFilter[i];
            String filterValue = arrValueFilter[i];
            String realFilterValue = values.get(filterField);
            if (StringUtils.isEmpty(realFilterValue) || realFilterValue.equals(filterValue)) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static BigDecimal getSumFilterNotEquals(Map<String, Map<String, String>> map, String pos, String field, String fieldFilter, String valueFilter) {
        BigDecimal res = BigDecimal.ZERO;
        String key = pos + "-";
        for (Entry<String, Map<String, String>> entry : map.entrySet()) {
            if (entry.getKey().startsWith(key)) {
                Map<String, String> values = entry.getValue();
                String realFilterValue = values.get(fieldFilter);
                if (StringUtils.isNotEmpty(realFilterValue) && !realFilterValue.equals(valueFilter)) {
                    res = res.add(ToBigDecimal.convert(values.get(field)));
                }
            }
        }
        return res;
    }

    public List<FooterField> getFooter01() {
        return footer01;
    }

    public void setFooter01(List<FooterField> footer01) {
        this.footer01 = footer01;
    }

    public List<FooterField> getFooter02() {
        return footer02;
    }

    public void setFooter02(List<FooterField> footer02) {
        this.footer02 = footer02;
    }

    public int getFooterCount() {
        int res = 0;
        if (getF01()) {
            res++;
        }
        if (getF02()) {
            res++;
        }
        return res;
    }

    public String getUniquePos() {
        return uniquePos;
    }

    public void setUniquePos(String uniquePos) {
        this.uniquePos = uniquePos;
    }

    public void setUniquePos(ReferenceConfig referenceConfig) {
        this.uniquePos = referenceConfig.uniquePos();
    }

    public static void setHeaders(String[] headers) {
        SubmissionFormat.headers = headers;
    }

    public static String getHeader(int idx) {
        return headers != null && (headers.length - 1) > idx ? headers[idx] : "";
    }
}