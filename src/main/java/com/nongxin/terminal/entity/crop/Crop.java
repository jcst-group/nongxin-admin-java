package com.nongxin.terminal.entity.crop;

import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.plant.CalculateUnit;
import com.nongxin.terminal.entity.product.Products;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Crop {
    private Integer id;

    @NotEmpty(message = "拼音码不能为空")
    private String pinyinCode;

    @NotEmpty(message = "药材名称")
    private String cropName;

    private String cropCode;

    private String describe;

    private String edibleValue;

    private String medicinalValue;

    private List<PictureInfo> cropPicList;

    private List<PictureInfo> ediblePicList;

    private List<PictureInfo> medicinalPicList;

    //private List<Products> productsList;
    @NotNull(message = "计量单位不能为空")
    private Integer calId;

    private CalculateUnit calculateUnit;

    private List<HarvestedProduct> harvestedProductList;

    public CalculateUnit getCalculateUnit() {
        return calculateUnit;
    }

    public void setCalculateUnit(CalculateUnit calculateUnit) {
        this.calculateUnit = calculateUnit;
    }

    public Integer getCalId() {
        return calId;
    }

    public void setCalId(Integer calId) {
        this.calId = calId;
    }

    public List<HarvestedProduct> getHarvestedProductList() {
        return harvestedProductList;
    }

    public void setHarvestedProductList(List<HarvestedProduct> harvestedProductList) {
        this.harvestedProductList = harvestedProductList;
    }

    public List<PictureInfo> getCropPicList() {
        return cropPicList;
    }

    public void setCropPicList(List<PictureInfo> cropPicList) {
        this.cropPicList = cropPicList;
    }

    public List<PictureInfo> getEdiblePicList() {
        return ediblePicList;
    }

    public void setEdiblePicList(List<PictureInfo> ediblePicList) {
        this.ediblePicList = ediblePicList;
    }

    public List<PictureInfo> getMedicinalPicList() {
        return medicinalPicList;
    }

    public void setMedicinalPicList(List<PictureInfo> medicinalPicList) {
        this.medicinalPicList = medicinalPicList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode == null ? null : pinyinCode.trim();
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName == null ? null : cropName.trim();
    }

    public String getCropCode() {
        return cropCode;
    }

    public void setCropCode(String cropCode) {
        this.cropCode = cropCode == null ? null : cropCode.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getEdibleValue() {
        return edibleValue;
    }

    public void setEdibleValue(String edibleValue) {
        this.edibleValue = edibleValue == null ? null : edibleValue.trim();
    }

    public String getMedicinalValue() {
        return medicinalValue;
    }

    public void setMedicinalValue(String medicinalValue) {
        this.medicinalValue = medicinalValue == null ? null : medicinalValue.trim();
    }
}