package id.go.ojk.client.model.config.validation.segmen.v2.util;

import lombok.Getter;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// [TESTED] work with this case :: (ROW[1+2+3]+ROW[1-2-3]-ROW[1*2*3]) * (ROW[1+2+3]+ROW[1-2-3]-ROW[1*2*3])
// use UtilMetadata.genFormulaFormatter(....) to format the formula
// Example usage on E7017Ras1ValidationsConfig.java :: OJK-METADATA package
public class FormulaParser {

    /*
    * Penggunaan pada validasi RAS1 Dapen 2026
    *
    * SUM'(ROW[1+2+3...] + ROW[1+2+3...]) + SUM'(ROW[1+2+3...] + ROW[1+2+3...]) - SUM'(ROW[1+2+3...] + ROW[1+2+3...])
    * SUM'(ROW[1+2+3...] + ROW[1+2+3...]) - SUM'(ROW[1+2+3...] + ROW[1+2+3...])
    * ROW[1+2+3...] + ROW[1+2+3...]
    * */

    @Getter
    public static class Operand {
        private final String operator;
        private final String field;

        Operand(String operator, String field) {
            this.operator = operator;
            this.field = field;
        }
    }

    @Getter
    public static class RowToken {
        private final String operator;
        private final String rowCode;
        private final String rowPrefix;
        private final String raw;
        private final List<Operand> operands;
        private final Map<String, String> mapOperands;

        RowToken(String operator, String rowCode, String rowPrefix, String raw, List<Operand> operands) {
            this.operator = operator;
            this.rowCode = rowCode;
            this.rowPrefix = rowPrefix;
            this.raw = raw;
            this.operands = operands;
            this.mapOperands = this.operands.stream()
                    .collect(Collectors.toMap(Operand::getField, Operand::getOperator,
                            (ex, dup) -> ex, LinkedHashMap::new
                    ));
        }
    }

    @Getter
    public static class Group {
        private final int index;
        private final String operator;
        private final String raw;
        private final List<RowToken> tokens;

        Group(int index, String operator, String raw, List<RowToken> tokens) {
            this.index = index;
            this.operator = operator;
            this.raw = raw;
            this.tokens = tokens;
        }
    }

    @Getter
    public static class ParsedFormula {
        private final List<Group> groups;

        ParsedFormula(List<Group> groups) {
            this.groups = groups;
        }
    }

    private static final Pattern P_GROUP =
            Pattern.compile("([+\\-*]?)\\s*\\(([^)]+)\\)");

    private static final Pattern P_ROW_TOKEN =
            Pattern.compile("([+\\-*]?)\\s*(([\\w#]+)\\[([^]]+)])");

    private static final Pattern P_OPERAND =
            Pattern.compile("([+\\-*]?)\\s*(\\w+)");

    public static List<Operand> parseInner(String inner) {
        List<Operand> result = new ArrayList<>();
        Matcher m = P_OPERAND.matcher(inner);
        while (m.find()) {
            result.add(new Operand(m.group(1), m.group(2)));
        }
        return result;
    }

    public static List<RowToken> parseGroup(String groupContent) {
        List<RowToken> result = new ArrayList<>();
        Matcher m = P_ROW_TOKEN.matcher(groupContent);
        while (m.find()) {
            String op         = m.group(1);              // "+", "-", "*", or ""
            String raw        = m.group(2);              // "AASD#ASSD000002[1+2+3]"
            String identifier = m.group(3);              // "AASD#ASSD000002"
            String inner      = m.group(4);

            String prefix;
            String rowCode;
            if (identifier.contains("#")) {
                String[] parts = identifier.split("#", 2);
                prefix  = parts[0]; // "AASD"
                rowCode = parts[1]; // "ASSD000002"
            } else {
                prefix  = "";
                rowCode = identifier;
            }

            result.add(new RowToken(op, rowCode, prefix, raw, parseInner(inner)));
        }
        return result;
    }

    public static ParsedFormula parse(String formula) {
        List<Group> groups = new ArrayList<Group>();
        Matcher m = P_GROUP.matcher(formula);
        int idx = 1;
        while (m.find()) {
            String op = m.group(1);
            String content = m.group(2);
            groups.add(new Group(idx++, op, content, parseGroup(content)));
        }
        return new ParsedFormula(groups);
    }
}

