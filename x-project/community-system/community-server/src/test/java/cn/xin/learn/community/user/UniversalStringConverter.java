package cn.xin.learn.community.user;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.ReadCellData;

public class UniversalStringConverter implements Converter<String> {

    @Override
    public Class<String> supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.EMPTY; // 支持所有类型
    }

    @Override
    public String convertToJavaData(ReadConverterContext<?> context) {
        ReadCellData<?> cellData = context.getReadCellData();

        // ✅ 优先拿“格式化后”的显示值（就是你肉眼看到的值）
        String formattedValue = cellData.getStringValue();
        if (formattedValue != null && !formattedValue.isEmpty()) {
            return formattedValue;
        }

        // Fallback 到原始值
        Object raw = cellData.getData();
        return raw != null ? raw.toString() : "";
    }
}